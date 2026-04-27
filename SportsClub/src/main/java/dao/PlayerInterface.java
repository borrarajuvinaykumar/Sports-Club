package dao;

import java.util.List;

import modal.Cochmodal;
import modal.Playermodal;
import modal.SportModal;

public interface PlayerInterface {
	public String Login(Playermodal pm);
	public Playermodal  getPlayerByUserName(String username);
	public List<SportModal> getMySports(String uname);
	public List<Cochmodal> getMyCoach(String uname);
}
