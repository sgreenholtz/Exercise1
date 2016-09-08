package com.matc.controller;

import com.matc.entity.User;
import com.matc.persistence.UserData;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */

@WebServlet(
        urlPatterns = {"/searchUser"}
)

public class SearchUser extends HttpServlet {

    private final Logger logger = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String search = req.getParameter("s");
        UserData userData = new UserData();

        if (search.equals("all")) {
            req.setAttribute("users", userData.getAllUsers());
        } else if (search.equals("last")) {
            req.setAttribute("users", userData.searchForUserByLastName(req.getParameter("last")));
        } else if (search.equals("first")) {
            req.setAttribute("users", userData.searchForUserByFirstName(req.getParameter("first")));
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);
    }
}