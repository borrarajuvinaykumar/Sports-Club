package modal;

public class MatchesModal {
	private int matchid;
	private String sportname;
	private String team1;
	private String team2;
	private String matchdate;
	private String matchtime;
	private String venue;
	private String status;

	public MatchesModal() {

	}

	public MatchesModal(int matchid, String sportname, String team1, String team2, String matchdate, String matchtime,
			String venue, String status) {
		super();
		this.matchid = matchid;
		this.sportname = sportname;
		this.team1 = team1;
		this.team2 = team2;
		this.matchdate = matchdate;
		this.matchtime = matchtime;
		this.venue = venue;
		this.status = status;
	}

	public int getMatchid() {
		return matchid;
	}

	public void setMatchid(int matchid) {
		this.matchid = matchid;
	}

	public String getSportname() {
		return sportname;
	}

	public void setSportname(String sportname) {
		this.sportname = sportname;
	}

	public String getTeam1() {
		return team1;
	}

	public void setTeam1(String team1) {
		this.team1 = team1;
	}

	public String getTeam2() {
		return team2;
	}

	public void setTeam2(String team2) {
		this.team2 = team2;
	}

	public String getMatchdate() {
		return matchdate;
	}

	public void setMatchdate(String matchdate) {
		this.matchdate = matchdate;
	}

	public String getMatchtime() {
		return matchtime;
	}

	public void setMatchtime(String matchtime) {
		this.matchtime = matchtime;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}