package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBHelper;
import vo.Plot1;

public class graphDAO {
	public List<Plot1> getYearTempList() {
		System.out.println("조회해서 가져오기 실행");
		List<Plot1> list = new ArrayList<Plot1>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection conn = null;
		String sql = "";
		
		try {
			conn = DBHelper.getConncetion();
			sql = "SELECT year, temp FROM plot1";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Plot1 plot1 = new Plot1();
				plot1.setTemp(rs.getInt("temp"));
				plot1.setYear(rs.getInt("year"));
				
				list.add(plot1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				DBHelper.close(rs, stmt, conn);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			return list;
		}
		
		
	}
}
