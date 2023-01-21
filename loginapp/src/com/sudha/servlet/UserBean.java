package com.sudha.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserBean {

	Connection con;
	Statement st;
	ResultSet rs;
	String status = "";

	public UserBean() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Sudha7878");
			st = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String checkLogin(String uname, String upwd) {
		try {
			rs = st.executeQuery("select * from register_users where uname='" + uname + "' and upwd='" + upwd + "'");
			boolean b = rs.next();
			if (b == true) {
				status = "success";
			} else {
				status = "failure";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public String registration(String uname, String upwd, String email, String mobile) {
		try {
			rs = st.executeQuery("select * from register_users where uname='" + uname + "'");
			boolean b = rs.next();
			if (b == true) {
				status = "existed";
			} else {
				int rowCount = st.executeUpdate("insert into register_users values('" + uname + "','" + upwd + "','"
						+ email + "','" + mobile + "')");
				if (rowCount == 1) {
					status = "success";
				} else {
					status = "failure";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
