package com.matc.entity;

import java.time.*;

/**
 * A class to represent a user.
 *
 * @author pwaite
 */
public class User {
    private String firstName;
    private String lastName;
    private String userid;
    private LocalDate DOB;

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param userid    the userid
     * @param DOB       date of birth in MM-DD-YYYY format
     */
    public User(String firstName, String lastName, String userid, String DOB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userid = userid;
        this.DOB = LocalDate.parse(DOB);
    }

    /**
     * Calculates and then returns user's age
     * @return integer age of user
     */
    public Integer getAge() {
        return LocalDate.now().getYear() - DOB.getYear();
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets userid.
     *
     * @return the userid
     */
    public String getUserid() {
        return userid;
    }

    /**
     * Sets userid.
     *
     * @param userid the userid
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * Gets the value of DOB.
     *
     * @return DOB
     */
    public LocalDate getDOB() {
        return DOB;
    }

    /**
     * Sets DOB to given value
     *
     * @param DOB value to set instance variable to
     */
    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    /**
     * Overriding setter to use for string YYYY-MM-DD
     * @param DOB Date of birth in string format
     */
    public void setDOB(String DOB) {
        this.DOB = LocalDate.parse(DOB);
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userid='" + userid + '\'' +
                ", age='" + getAge() + '\'' +
                '}';
    }


}
