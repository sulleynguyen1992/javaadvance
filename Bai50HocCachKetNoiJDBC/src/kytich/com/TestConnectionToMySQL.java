package kytich.com;

import java.sql.Connection;
import java.util.Properties;


import com.mysql.jdbc.Driver;

public class TestConnectionToMySQL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String strConn = "jdbc:mysql://localhost:8889/dbtaisan";
			Properties pro = new Properties();
			pro.put("user", "root"); //la account cai dat phpadmin
			pro.put("password", "root");
			Driver driver = new Driver();
			Connection conn = driver.connect(strConn, pro);
			if(conn!=null) {
				System.out.println("ket noi thanh cong");
			}else {
				System.out.println("ket noi that bai");
			}	
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
