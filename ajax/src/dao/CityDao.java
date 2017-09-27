package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Sheng;
import entity.Shi;

public class CityDao extends BaseDao_city {

	public List<Sheng> searchSheng() {
		List<Sheng> list = new ArrayList<Sheng>();
		try {

			getStatement();

			String sql = "select * from sheng";

			rs = stat.executeQuery(sql);
			while (rs.next()) {
				Sheng s = new Sheng();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));

				list.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public List<Shi> searchShiBySheng(int sId) {
		List<Shi> list = new ArrayList<Shi>();
		try {

			getStatement();

			String sql = "select * from shi where s_id = '" + sId + "'";

			rs = stat.executeQuery(sql);
			while (rs.next()) {
				Shi s = new Shi();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));

				list.add(s);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
}
