package com.moumita.ft.features.investment.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_investment")
public class Investment {
	
	@Id
	@Column(name = "fld_ai_id")
	private int id;
	@Column(name = "fld_user_id")
	private int userId;
	@Column(name = "fld_amount")
	private long amount;
	@Column(name = "fld_category")
	private String category;
	@Column(name = "fld_month")
	private String month;
	@Column(name = "fld_date")
	private LocalDateTime date;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Investment [id=" + id + ", userId=" + userId + ", amount=" + amount + ", category=" + category
				+ ", month=" + month + ", date=" + date + "]";
	}
	
}
