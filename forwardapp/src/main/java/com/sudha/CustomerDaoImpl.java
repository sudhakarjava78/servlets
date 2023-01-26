package com.sudha;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomerDaoImpl {

	Connection con;
	Statement st;
	ResultSet rs;
	String status = "";

	CustomerDaoImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/commondb", "root", "Sudha@7878");
			st = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ResultSet getCustomer(int cid) {
		try {
			rs = st.executeQuery("select * from customer where cid=" + cid + "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	public String add(int cid, String cname, String cemail, String cmobile) {
		try {
			rs = getCustomer(cid);
			boolean b = rs.next();
			if (b == true) {
				status = "existed";
			} else {
				int rowCount = st.executeUpdate(
						"insert into customer values(" + cid + ",'" + cname + "','" + cemail + "','" + cmobile + "')");
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

	public ResultSet search(int cid) {
		return getCustomer(cid);
	}

	public String update(int cid, String cname, String cemail, String cmobile) {
		try {
			int rowCount = st.executeUpdate(
					"update customer set cname='" + cname + "',cemail='" + cemail + "',cmobile='" + cmobile + "'");
			if (rowCount == 1) {
				status = "success";
			} else {
				status = "failure";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public String delete(int cid) {
		try {
			rs = getCustomer(cid);
			boolean b = rs.next();
			if (b == true) {
				int rowCount = st.executeUpdate("delete from customer where cid=" + cid + "");
				if (rowCount == 1) {
					status = "success";
				} else {
					status = "failure";
				}
			} else {
				status = "not existed";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
