package main.java.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="V_TICKET")
public class v_ticket implements Serializable{
	
	@Override
	public String toString() {
		return "v_ticket [ticket_no=" + ticket_no + ", cid=" + cid + ", store_no=" + store_no + ", ticket_date="
				+ ticket_date + ", final_price=" + final_price + "]";
	}
	
	private  static  final  long serialVersionUID = 1L ;
	
	@Id
	private int ticket_no;
	private int cid;
	private int store_no;
	private Date ticket_date;
	private int final_price;
	
	public int getTicket_no() {
		return ticket_no;
	}
	public void setTicket_no(int ticket_no) {
		this.ticket_no = ticket_no;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getStore_no() {
		return store_no;
	}
	public void setStore_no(int store_no) {
		this.store_no = store_no;
	}
	public Date getTicket_date() {
		return ticket_date;
	}
	public void setTicket_date(Date ticket_date) {
		this.ticket_date = ticket_date;
	}
	public int getFinal_price() {
		return final_price;
	}
	public void setFinal_price(int final_price) {
		this.final_price = final_price;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
