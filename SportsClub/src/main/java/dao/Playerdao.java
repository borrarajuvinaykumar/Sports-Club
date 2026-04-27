package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modal.Cochmodal;
import modal.Playermodal;
import modal.SportModal;
import utility.DBConnection;

public class Playerdao implements PlayerInterface{
	static Connection con=null;
	String status="fail";

public String Login(Playermodal pm)  {
	try {
	DBConnection db=new DBConnection();
	con=db.getConnection();
	PreparedStatement ps=con.prepareStatement("select * from players where username=? and password=? ");
	ps.setString(1, pm.getUsername());
	ps.setString(2, pm.getPassword());
	ResultSet rs=ps.executeQuery();
	int c=0;
	while(rs.next()) {
		c++;
	}
	if(c>0) {
		status="success";
	}
	}catch(Exception e) {
		System.out.println(e);
	}
	
	return status ;
	
}

public Playermodal  getPlayerByUserName(String username){
	Playermodal pm=new Playermodal();
	try {
		DBConnection db=new DBConnection();
		con=db.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from players where username=?");
		ps.setString(1, username);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			pm.setUsername(rs.getString("username"));
			pm.setFullname(rs.getString("fullname"));
			pm.setPassword(rs.getString("password"));
			pm.setEmail(rs.getString("email"));
			pm.setPhone(rs.getString("phone"));
		}
	}catch(Exception e) {
		System.out.println(e);
		
	}
	
	return pm;
}


public List<SportModal> getMySports(String uname) {
    List<SportModal> list = new ArrayList<>();

    try {
    	
    	DBConnection db=new DBConnection();
		con=db.getConnection();
		
		PreparedStatement ps1=con.prepareStatement("select playerid from players where username=?");
ps1.setString(1, uname);
ResultSet rs=ps1.executeQuery();
int playerid=0;
while(rs.next()) {
	playerid=rs.getInt("playerid");
}

        String sql =
          "SELECT s.sportname " +
          "FROM players as p " +
          "JOIN playersports  ps ON p.playerid = ps.playerid " +
          "JOIN sports s ON ps.sportid = s.sportid " +
          "WHERE p.playerid = ?";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, playerid);

        ResultSet rs1 = ps.executeQuery();

        while (rs1.next()) {
            SportModal sm = new SportModal();
            sm.setSportname(rs1.getString("sportname"));
            list.add(sm);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return list;
}



public List<Cochmodal> getMyCoach(String uname) {
    List<Cochmodal> list = new ArrayList<>();

    try {
    	
    	DBConnection db=new DBConnection();
		con=db.getConnection();
		
		PreparedStatement ps1=con.prepareStatement("select playerid from players where username=?");
ps1.setString(1, uname);
ResultSet rs=ps1.executeQuery();
int playerid=0;
while(rs.next()) {
	playerid=rs.getInt("playerid");
}

        String sql =
        		
        		"SELECT c.fullname, s.sportname "
        		+ "FROM coaches c "
        		+ "JOIN coachsports cs "
        		+ "ON c.coachid = cs.coachid "
        		+ "JOIN sports s "
        		+ "ON cs.sportid = s.sportid "
        		+ "JOIN playersports ps "
        		+ "ON s.sportid = ps.sportid "
        		+ "WHERE ps.playerid = ?";
     
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, playerid);

        ResultSet rs1 = ps.executeQuery();

        while (rs1.next()) {
            Cochmodal sm = new Cochmodal();
            sm.setFullname(rs1.getString("fullname"));
            sm.setSportname(rs1.getString("sportname"));
            list.add(sm);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return list;
}









}

