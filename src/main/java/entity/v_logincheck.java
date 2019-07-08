package main.java.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="V_LOGINCHECK")
public class v_logincheck implements Serializable{

	@Override
	public String toString() {
		return "v_logincheck [account=" + account + ", password=" + password + ", user_role=" + user_role
				+ ", getAccount()=" + getAccount() + ", getPassword()=" + getPassword() + ", getUser_role()="
				+ getUser_role() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}


	private  static  final  long serialVersionUID = 1L ;
	

	public String getAccount() {
		return account;
	}


	public void setAccount(String account) {
		this.account = account;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUser_role() {
		return user_role;
	}


	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}

	@Id
	private String account;
	private String password;
	private String user_role;
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
