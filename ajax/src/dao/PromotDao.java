package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PromotDao extends BaseDao_promot {

	public List<String> search(String s) {
		List<String> list = new ArrayList<String>();
		try {
		
			getStatement();

			String sql = "select content from promotbiao where content like '" + s + "%'";
			System.out.println(sql);
			rs = stat.executeQuery(sql);
			while(rs.next()){
			String  s1="";
				s1+=rs.getString("content");
				
				list.add(s1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

}
