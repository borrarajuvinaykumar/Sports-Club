package modal;

public class Playermodal  {
private String fullname;
private String username;
private String password;
private String email;
private String  phone;
private String sportsname;
public Playermodal(){
	
}


public String getSportsname() {
	return sportsname;
}


public void setSportsname(String sportsname) {
	this.sportsname = sportsname;
}


public String getFullname() {
	return fullname;
}
public void setFullname(String fullname) {
	this.fullname = fullname;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}



@Override
public String toString() {
	return "Playermodal [fullname=" + fullname + ", username=" + username + ", password=" + password + ", email="
			+ email + ", phone=" + phone + "]";
}


}
