package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBcon {
	static Connection con;
	public DBcon() throws Exception {
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String user="video";
		String pass="123456";
		Class.forName("oracle.jdbc.driver.OracleDriver");
	
		con=DriverManager.getConnection(url,user,pass);
		System.out.println("����");
	}
	
	public static Connection getConnection() throws Exception{
		
		if (con==null) {  //con�� null�϶��� ȣ��
			new DBcon();
		}
		
		return con; //null���� con���� �ٲ��ֱ�
	}
}
