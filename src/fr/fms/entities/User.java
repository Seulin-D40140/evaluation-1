package fr.fms.entities;

import java.util.ArrayList;

public class User 
{
	private int idUser;
	private String login;
	private String password;
	public ArrayList<User> users = new ArrayList<User>();
	
	public User ( int id , String login , String password)
	{
		this.idUser = id;
		this.login = login;
		this.password = password;
	}
	public User ( String login , String password)
	{
		this.login = login;
		this.password = password;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int id) {
		this.idUser = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	
}
