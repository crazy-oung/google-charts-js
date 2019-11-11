package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DBHelper;
import vo.Flight;

public class FlightsDao {
	
	public List<List> getPassengersByMonths() {
		System.out.println("Flights 조회해서 가져오기 실행");
		 
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection conn = null;
		String sql = "";
		List<List> list = new ArrayList<List>();
		
		try {
			conn = DBHelper.getConncetion();
			sql = "SELECT " +
					"YEAR,"+
					"SUM(CASE WHEN MONTH IN ('january','february','march') THEN passengers ELSE 0 END) 'q1',"+
					"SUM(CASE WHEN MONTH IN('april', 'may', 'june') THEN passengers ELSE 0 END) 'q2',"+
					"SUM(CASE WHEN month IN ('july','august','september') THEN passengers ELSE 0 END) 'q3',"+
					"SUM(CASE WHEN month IN ('october', 'november','december') THEN passengers ELSE 0 END) 'q4' "+
				"FROM flights "+
				"GROUP BY year";
			
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery(); 
			
			while(rs.next()) {
				List temp = new ArrayList();
				
				temp.add(rs.getInt("year"));
				temp.add(rs.getInt("q1"));
				temp.add(rs.getInt("q2"));
				temp.add(rs.getInt("q3"));
				temp.add(rs.getInt("q4"));
				
				list.add(temp);
				System.out.println(temp);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;		
		
	}
	
}
