package com.sudha;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductBean {

	Connection con;
	Statement st;
	ResultSet rs;
	String status = "";

	public ProductBean() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/commondb", "root", "Sudha@7878");
			st = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String register(String pid, String pname, int pcost, int pquantity, String man_date, String exp_date) {
		try {
			rs = st.executeQuery("select * from product where pid = '" + pid + "'");
			boolean b = rs.next();
			if (b == true) {
				status = "Product Existed Already";
			} else {
				int rowCount = st.executeUpdate("insert into product values('" + pid + "','" + pname + "'," + pcost
						+ "," + pquantity + ",'" + man_date + "','" + exp_date + "')");
				if (rowCount == 1) {
					status = "SUCCESS";
				} else {
					status = "FAILURE";
				}
			}
		} catch (Exception e) {
			status = "FAILURE";
			e.printStackTrace();
		}
		return status;
	}
}
