package main.java.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="V_CUSTOMER")
public class v_customer implements Serializable{

	
	@Override
	public String toString() {
		return "v_customer [cid=" + cid + ", account=" + account + ", name=" + name + ", sex=" + sex + ", birthday="
				+ birthday + ", email=" + email + ", create_time=" + create_time + ", update_time=" + update_time + "]";
	}



	private  static  final  long serialVersionUID = 1L ;
	
	@Id
	private int cid;
	private String account;
	private String name;
	private int sex;
	private Date birthday;
	private String email;
	private String create_time;
	private String update_time;
	
	

	public int getCid() {
		return cid;
	}



	public void setCid(int cid) {
		this.cid = cid;
	}



	public String getAccount() {
		return account;
	}



	public void setAccount(String account) {
		this.account = account;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getSex() {
		return sex;
	}



	public void setSex(int sex) {
		this.sex = sex;
	}



	public Date getBirthday() {
		return birthday;
	}



	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getCreate_time() {
		return create_time;
	}



	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}



	public String getUpdate_time() {
		return update_time;
	}



	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
