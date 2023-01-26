package com.sudha;

import java.sql.ResultSet;

public interface CustomerDAO {

	public String add(int cid, String cname, String cemail, String cmobile);

	public ResultSet search(int cid);

	public ResultSet getCustomer(int cid);

	public String update(int cid, String cname, String ceamil, String cmobile);

	public String delete(int cid);
}
