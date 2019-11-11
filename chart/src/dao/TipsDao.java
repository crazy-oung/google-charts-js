package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DBHelper;
import vo.Tips;

public class TipsDao {
	
	public List<Object> getTipAndBills(){
		System.out.println("tips 조회해서 여자만 가져오기 실행");
		List<Object> list = new ArrayList<Object>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection conn = null;
		String sql = "";
		
		try {
			conn = DBHelper.getConncetion();
			sql = "SELECT day, ROUND(SUM(total_bill)), ROUND(SUM(tip)) " + 
					"FROM tips " + 
					"GROUP BY day";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				List<Object> temp = new ArrayList<Object>();
				temp.add(rs.getString(1));
				temp.add(rs.getInt(2));
				temp.add(rs.getInt(3));
				
				list.add(temp);
			}
			System.out.println(list);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;		

	}
	
	public List<Tips> getTipsFemale() {
		System.out.println("tips 조회해서 여자만 가져오기 실행");
		List<Tips> list = new ArrayList<Tips>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection conn = null;
		String sql = "";
		
		try {
			conn = DBHelper.getConncetion();
			sql = "SELECT tip FROM tips WHERE sex = 'female'";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Tips tips = new Tips();
				tips.setTip(rs.getDouble("tip")); 
				list.add(tips);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
		
	}
	
	public List<Tips> getTipsMale() {
		System.out.println("tips 조회해서 남자만 가져오기 실행");
		List<Tips> list = new ArrayList<Tips>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection conn = null;
		String sql = "";
		
		try {
			conn = DBHelper.getConncetion();
			sql = "SELECT tip FROM tips WHERE sex = 'male'";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			 
			while(rs.next()) {
				Tips tips = new Tips();
				System.out.println(rs.getDouble("tip"));
				tips.setTip(rs.getDouble("tip"));		 
				list.add(tips);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			return list;
	 }
	
	public List<Tips> getDayCount(){
		System.out.println("tips 조회해서 남자만 가져오기 실행");
		List<Tips> list = new ArrayList<Tips>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection conn = null;
		String sql = "";
		
		try {
			conn = DBHelper.getConncetion();
			sql = "SELECT day, count(*) FROM tips group by day";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			 
			while(rs.next()) {
				Tips tips = new Tips();
				tips.setDay(rs.getString("day"));	
				tips.setSize(rs.getInt("count(*)"));
				list.add(tips);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			return list;
	}
}
