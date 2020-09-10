package repository;

import models.User;
import util.DbUtil;

import java.sql.*;
import java.util.Vector;

public class UserRepository {
    private Connection dbConnection;
    public  UserRepository() {
        dbConnection = DbUtil.getConnection();
    }
    public void addUser(String fname,String lname) {
        try {
            PreparedStatement prep = dbConnection.prepareStatement("INSERT INTO Users(first_name,last_name) VALUES ('"+ fname +"','"+ lname +"');");
            prep.executeUpdate();
            System.out.println("User added to database");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Vector<User> getUsers() {
        Vector<User> users = new Vector<User>();
        try {
            Statement get = dbConnection.createStatement();
            ResultSet userResult = get.executeQuery("SELECT * FROM Users");

            while (userResult.next()) {
                User temp = new User(userResult.getString(1),userResult.getString(2),userResult.getString(3));
                users.add(temp);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return users;
    }
    public int getUserCount() throws SQLException {
        Statement get = dbConnection.createStatement();
        ResultSet getCount = get.executeQuery("SELECT COUNT(*) FROM Users");
        int count = 0;
        while (getCount.next())
            count = getCount.getInt(1);
        return count;
    }
}
