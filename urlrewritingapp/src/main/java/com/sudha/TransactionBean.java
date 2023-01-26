package com.sudha;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TransactionBean {

	Connection connection;
	Statement statement;
	ResultSet resultSet;
	String status = "";
	int totalAvailableAmount;

	TransactionBean() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/commondb", "root", "Sudha@7878");
			statement = connection.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String deposit(String accNo, int depAmount) {
		try {
			int rowCount = statement.executeUpdate(
					"update acc_details set balance = balance+" + depAmount + " where accNo='" + accNo + "'");
			if (rowCount == 1) {
				status = "SUCCESS";
			} else {
				status = "FAILURE";
			}
		} catch (Exception e) {
			status = "FAILURE";
			e.printStackTrace();
		}
		return status;
	}

	public int getTotalAvailableAmount() {
		try {
			resultSet = statement.executeQuery("select * from acc_details");
			resultSet.next();
			totalAvailableAmount = resultSet.getInt(4);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalAvailableAmount;
	}

}
