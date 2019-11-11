package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import db.DBHelper;
import vo.Plot1;

@WebServlet("/GetPopList")
public class GetPopList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		System.out.println("서블릿 실행 pop!");
		
		List list = new ArrayList<List>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection conn = null;
		String sql = "";
		
		try {
			conn = DBHelper.getConncetion();
			sql = "SELECT * FROM pop";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				List temp = new ArrayList<Object>();
				temp.add(rs.getString("id"));
				temp.add(rs.getDouble("life_exp"));
				temp.add(rs.getDouble("fertility_rate"));
				temp.add(rs.getString("region"));
				temp.add(rs.getInt("population"));
				
				list.add(temp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				DBHelper.close(rs, stmt, conn);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			Gson gson = new Gson(); 
			String json = gson.toJson(list);
			
			System.out.println(list);
			System.out.println("back");
			
			response.getWriter().write(json);
			
		}
		

	}
}
