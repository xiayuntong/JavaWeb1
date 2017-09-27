package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDao_city {
	Connection con = null;
	Statement stat = null;
	PreparedStatement pstat = null;
	ResultSet rs = null;

	public void getConnection() {
		// 2��������

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/shengshi?characterEncoding=utf-8",
							"root", "123456");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 3��������
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void getStatement() {
		getConnection();
		// 4����SQLִ���� ��ΪSQLֻ��SQL���

		try {
			stat = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 5ִ��sql���

	}

	public void getPrepareStatement(String sql) {
		getConnection();
		// 4����SQLִ���� ��ΪSQLֻ��SQL���

		try {
			pstat = con.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 5ִ��sql���

	}

	public void closeAll() {

		try {
			if (con != null) {
				con.close();
			}
			if (stat != null) {
				stat.close();
			}
			if (rs != null) {
				rs.close();
			}
			if (pstat != null) {
				pstat.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
