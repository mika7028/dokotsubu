package model;

public class Account {
	private String userId, pass, mail, name;
	private int age;
	
	public Account(String userId, String pass, String mail, String name, int age){
		this.userId = userId;
		this.pass = pass;
		this.mail = mail;
		this.name = name;
		this.age = age;
	}

	public String getUserId() {
		return userId;
	}

	public String getPass() {
		return pass;
	}

	public String getMail() {
		return mail;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
	

}
