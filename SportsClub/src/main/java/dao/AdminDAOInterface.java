package dao;

import java.util.List;

import modal.AdminModal;
import modal.MatchesModal;
import modal.Playermodal;

public interface AdminDAOInterface {
     public boolean Validate(AdminModal am);
     public String Playerdelete(String username);
     public  Playermodal Playeredit(String uname);
     public String Playerupdate(Playermodal p);
     public String Playerinsert(Playermodal p);
     public List<MatchesModal> getAllDetails();
     public boolean deleteMatches(int matchid);
     public MatchesModal getMatchByID(int matchid);
     public boolean updateMatches(MatchesModal mm);
     public boolean registerMatches(MatchesModal mm);
     
}