package dao;

import java.util.List;

import modal.Cochmodal;
import modal.Playermodal;
import modal.SportsModal;

public interface CochInterface {
public boolean Validate(Cochmodal c);
public Cochmodal getbyUsername(String uname);
public List<SportsModal> getrecord(String uname);
public List<Playermodal> getPlayers(String uname);
}