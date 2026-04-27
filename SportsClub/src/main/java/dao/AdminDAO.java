package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


//import com.model.EditModel;

import modal.AdminModal;
import modal.MatchesModal;
import modal.Playermodal;
import modal.SportModal;
import utility.DBConnection;

public class AdminDAO implements AdminDAOInterface {
	boolean status=false;
	String status1="fail";

	List<Playermodal> list=new ArrayList<>();
	static Connection con=null;


	@Override
	public boolean Validate(AdminModal am) {
		try {
			DBConnection db=new DBConnection();
			Connection con=db.getConnection();
			System.out.println(am);
			PreparedStatement ps=con.prepareStatement("select count(*) from admins where username=? and password=?");
			ps.setString(1, am.getUsername());
			ps.setString(2, am.getPassword());
			ResultSet rs=ps.executeQuery();
			int c=0;
			while(rs.next()) {
				c++;
			}
			if(c>0) {
				status=true;
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}







	public List<Playermodal> getAllPlayers(){
		try {
			DBConnection db=new DBConnection();
			con=db.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from players");
			ResultSet rs=ps.executeQuery();

			while(rs.next()) {
				Playermodal pm=new Playermodal();
				pm.setUsername(rs.getString("username"));
				pm.setFullname(rs.getString("fullname"));
				pm.setEmail(rs.getString("email"));
				pm.setPassword(rs.getNString("password"));
				pm.setPhone(rs.getString("phone"));
				list.add(pm);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return list;	
	}


	public String Playerdelete(String username) {
		try {
			DBConnection db=new DBConnection();
			con=db.getConnection();
			PreparedStatement ps1=con.prepareStatement("select playerid from players where username=? ");
			ps1.setString(1, username);
	        ResultSet rs = ps1.executeQuery();
	       int  playerid=0;
            if(rs.next()) {
            	playerid=rs.getInt("playerid");
             }
            
			PreparedStatement ps2=con.prepareStatement("delete from playersports where playerid=? ");
             ps2.setInt(1,playerid );
             ps2.executeLargeUpdate();
             
             
             PreparedStatement ps3=con.prepareStatement("delete from players where username=?");
             ps3.setString(1, username);
 	        int n = ps3.executeUpdate();
 	       if(n > 0) status = true;

	        con.close();
			
		}catch(Exception e) {
			System.out.println(e);

		}
		return status1;

	}

	
	
	
	public  Playermodal Playeredit(String uname) {
		Playermodal p=null;
		try {
			DBConnection db=new DBConnection();
			con=db.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from players where username=? ");
			ps.setString(1, uname);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				p=new	Playermodal();
				p.setUsername(rs.getString("username"));
				p.setFullname(rs.getString("fullname"));
				p.setPassword(rs.getString("password"));
				p.setEmail(rs.getString("email"));
				p.setPhone(rs.getString("phone"));
			}


		}catch(Exception e) {
			System.out.println(e);
		}

		return p;

	}
	public String Playerupdate(Playermodal p) {
		
		try {
			DBConnection db=new DBConnection();
			con=db.getConnection();
			PreparedStatement ps=con.prepareStatement("update  players set  fullname=? ,password=?,email=?, phone=? where username=?");
			ps.setString(1, p.getFullname());
			ps.setString(2, p.getPassword());
			ps.setString(3, p.getEmail());
			ps.setString(4, p.getPhone());
			ps.setString(5, p.getUsername());
			int n=ps.executeUpdate();
			if(n>0) {
				status1="success";
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return status1;
		
	}
	
	public String Playerinsert(Playermodal p) {
		try {
		DBConnection db=new DBConnection();
		con=db.getConnection();
		PreparedStatement ps=con.prepareStatement("insert into players(username,fullname,password,email,phone) values(?,?,?,?,?)");
		ps.setString(1, p.getUsername());
		ps.setString(2, p.getFullname());
		ps.setString(3, p.getPassword());
		ps.setString(4, p.getEmail());
		ps.setString(5, p.getPhone());
		
		int n=ps.executeUpdate();
		if(n>0) {
			status1="success";
		}

		}catch(Exception e) {
			System.out.println(e);
		}
		return status1;
		
	}


	
	
	
	
	public List<MatchesModal> getAllDetails() {
		List<MatchesModal> list=new ArrayList<>();
		try {
			DBConnection db = new DBConnection();
			Connection con = db.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from internalmatches;");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				MatchesModal mm = new MatchesModal();
				mm.setMatchid(rs.getInt("matchid"));
				mm.setSportname(rs.getString("sportname"));
				mm.setTeam1(rs.getString("team1"));
				mm.setTeam2(rs.getString("team2"));
				mm.setMatchdate(rs.getString("matchdate"));
				mm.setMatchtime(rs.getString("matchtime"));
				mm.setVenue(rs.getString("venue"));
				mm.setStatus(rs.getString("status"));

				list.add(mm);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	@Override
	public boolean deleteMatches(int matchid) {
		try {
			DBConnection db = new DBConnection();
			Connection con = db.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from internalmatches where matchid=?");
			ps.setInt(1, matchid);
			int n = ps.executeUpdate();
			if (n > 0) {
				status = true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	@Override
	public MatchesModal getMatchByID(int matchid) {
		MatchesModal mm = new MatchesModal();
		try {
			DBConnection db = new DBConnection();
			Connection con = db.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from internalmatches where matchid=?");
			ps.setInt(1, matchid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				mm.setMatchid(rs.getInt("matchid"));
				mm.setSportname(rs.getString("sportname"));
				mm.setTeam1(rs.getString("Team1"));
				mm.setTeam2(rs.getString("Team2"));
				mm.setMatchdate(rs.getString("matchdate"));
				mm.setMatchtime(rs.getString("matchtime"));
				mm.setVenue(rs.getString("venue"));
				mm.setStatus(rs.getString("status"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return mm;
	}

	@Override
	public boolean updateMatches(MatchesModal mm) {
		try {
			DBConnection db = new DBConnection();
			Connection con = db.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"update internalmatches set sportname=?,team1=?,team2=?,matchdate=?,matchtime=?,venue=?,status=? where matchid=?");
			ps.setString(1, mm.getSportname());
			ps.setString(2, mm.getTeam1());
			ps.setString(3, mm.getTeam2());
			ps.setString(4, mm.getMatchdate());
			ps.setString(5, mm.getMatchtime());
			ps.setString(6, mm.getVenue());
			ps.setString(7, mm.getStatus());
			ps.setInt(8, mm.getMatchid());
			int n = ps.executeUpdate();
			if (n > 0) {
				status = true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	@Override
	public boolean registerMatches(MatchesModal mm) {
		try {
			DBConnection db = new DBConnection();
			Connection con = db.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into internalmatches (sportname, team1, team2, matchdate, matchtime, venue, status) values(?,?,?,?,?,?,?)");
			ps.setString(1, mm.getSportname());
			ps.setString(2, mm.getTeam1());
			ps.setString(3, mm.getTeam2());
			ps.setString(4, mm.getMatchdate());
			ps.setString(5, mm.getMatchtime());
			ps.setString(6, mm.getVenue());
			ps.setString(7, mm.getStatus());
			int n = ps.executeUpdate();
			if (n > 0) {
				status = true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}	  
}


