package repository;

import models.Expense;
import util.DbUtil;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class ExpenseRepository {
    private Connection dbConnection;
    public ExpenseRepository() {
        dbConnection = DbUtil.getConnection();
    }

    public void addExpense(String remark,float amt,String userPaid) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
            Date date = new Date();
            PreparedStatement addExpense = dbConnection.prepareStatement("INSERT INTO Expenses(remark,amount,user_id,date_added) VALUES ('"+ remark +"'," + amt + "," + Integer.parseInt(userPaid) +",'" + formatter.format(date) +"');");
            addExpense.executeUpdate();
            System.out.println("Expense added!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Vector<Expense> getExpenses() throws SQLException {
        Statement get = dbConnection.createStatement();
        ResultSet exps = get.executeQuery("SELECT * FROM Expenses");
        Vector<Expense> expenses = new Vector<>();
        while (exps.next()) {
            Expense temp = new Expense(exps.getString(1),exps.getFloat(3),exps.getDate(5),exps.getString(2),exps.getString(4));
            expenses.add(temp);
        }
        return expenses;
    }

}
