package com.matc.persistence;

import com.matc.entity.User;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.time.*;

/**
 * Access users in the user table.
 *
 * @author pwaite
 */
public class UserData {

    Database database;
    private final Logger logger = Logger.getLogger(this.getClass());

    private Connection getConnection() {
        database = Database.getInstance();
        Connection connection = null;
        try {
            database.connect();
            connection = database.getConnection();
        } catch (Exception e) {
            logger.error("SearchUser.getConnection()...Exception: " + e);
        }
        return connection;
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        Connection connection = getConnection();
        String sql = "SELECT * FROM users";

        try {

            Statement selectStatement = connection.createStatement();
            ResultSet results = selectStatement.executeQuery(sql);
            users = createUserList(results);
            database.disconnect();
        } catch (SQLException e) {
            logger.error("SearchUser.getConnection()...SQL Exception: " + e);
        } catch (Exception e) {
            logger.error("SearchUser.getConnection()...Exception: " + e);
        }
        return users;
    }

    public List<User> searchForUserByLastName(String lastName) {
        return createUserList(performSearch("last_name", lastName));
    }

    public List<User> searchForUserByFirstName(String firstName) {
        return createUserList(performSearch("first_name", firstName));
    }

    private ResultSet performSearch(String field, String searchTerm) {
        ResultSet results = null;
        Connection conn = null;
        try {
            conn = getConnection();
            String sql = "SELECT * FROM users WHERE " + field + " = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, searchTerm);
            results = statement.executeQuery();
        } catch (SQLException e) {
            logger.error("SQL Exception: " + e);
        }
        return results;
    }

    private List<User> createUserList(ResultSet results) {
        List<User> list = new ArrayList<User>();
        try {
            while (results.next()) {
                User employee = createUserFromResults(results);
                list.add(employee);
            }
        } catch (SQLException e) {
            logger.error("SQL Exception: " + e);
        }
        return list;
    }

    private User createUserFromResults(ResultSet results) {
        User user = new User();
        try {
            user.setLastName(results.getString("last_name"));
            user.setFirstName(results.getString("first_name"));
            user.setUserid(results.getString("id"));
            user.setDOB(LocalDate.parse(results.getString("date_of_birth")));
        } catch (SQLException e) {
            logger.error("SQL Exception: " + e);
        }
        return user;
    }

}
