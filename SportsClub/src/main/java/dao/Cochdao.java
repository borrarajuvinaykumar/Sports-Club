package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import modal.Cochmodal;
import modal.Playermodal;
import modal.SportsModal;
import utility.DBConnection;

public class Cochdao implements CochInterface {

	static Connection  con=null;
	@Override
	public boolean Validate(Cochmodal n) {
		boolean status=false;
//		Cochmodal m=new Cochmodal();
	
		
		try {
			DBConnection db=new DBConnection();
			con=db.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from coaches where username=? And password=?");
			ps.setString(1,n.getUsername());
			ps.setString(2,n.getPassword());
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
			status=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	@Override
	public Cochmodal getbyUsername(String uname) {
		Cochmodal m=new Cochmodal();
		try {
			DBConnection db=new DBConnection();
			con=db.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from coaches where username=?");
			ps.setString(1,uname);
		
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				m.setEmail(rs.getString("email"));
				m.setFullname(rs.getString("fullname"));
				m.setPassword(rs.getString("password"));
				m.setPhone(rs.getString("phone"));
				m.setUsername(rs.getString("username"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return m ;
		
	}
	@Override
	public List<SportsModal>getrecord(String uname) {
		System.out.println("Username received: " + uname);

		ArrayList<SportsModal> a=new ArrayList<>();
		try {
			DBConnection db=new DBConnection();
			con=db.getConnection();
			
			PreparedStatement ps1=con.prepareStatement("select coachid from c"
					+ "oaches where username=?");
			ps1.setString(1,uname);
			ResultSet rs=ps1.executeQuery();
			int cochid=0;
			while(rs.next()) {
				cochid=rs.getInt("coachid");
			}
			PreparedStatement ps=con.prepareStatement("select s.sportname from sports as s join "
					+" coachsports as c on s.sportid = c.sportid where c.coachid=?");
			ps.setInt(1,cochid);
		
			ResultSet rs1=ps.executeQuery();
			
			while(rs1.next()) {
				SportsModal m=new SportsModal();
				m.setSportname(rs1.getString("sportname"));
				a.add(m);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a ;
	}
  
	
	public List<Playermodal> getPlayers(String uname) {
		System.out.println("Username received: " + uname);

		ArrayList<Playermodal> a=new ArrayList<>();
		
		try {
			DBConnection db=new DBConnection();
			con=db.getConnection();
			
			PreparedStatement ps1=con.prepareStatement("select coachid from c"
					+ "oaches where username=?");
			ps1.setString(1,uname);
			ResultSet rs=ps1.executeQuery();
			int cochid=0;
			while(rs.next()) {
				cochid=rs.getInt("coachid");
			}
			System.out.println(cochid);
			PreparedStatement ps=con.prepareStatement("SELECT p.fullname, s.sportname "
					+ "FROM players p "
					+ "JOIN playersports ps ON p.playerid = ps.playerid "
					 + "JOIN sports s ON ps.sportid = s.sportid " 
					
					+ "JOIN coachsports cs ON s.sportid = cs.sportid "
					+ "WHERE cs.coachid = ? "
					+ "");
			ps.setInt(1,2);
		
			ResultSet rs1=ps.executeQuery();
			  
			while(rs1.next()) {
				Playermodal m=new Playermodal();
				SportsModal s=new SportsModal();
				m.setFullname(rs1.getString("fullname"));
				m.setSportsname(rs1.getString("sportname"));;
				a.add(m);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}
}