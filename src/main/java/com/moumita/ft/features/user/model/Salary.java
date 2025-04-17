package com.moumita.ft.features.user.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_salary")
public class Salary {

	@Id
	@Column(name = "fld_ai_id")
	private int id;
	@Column(name = "fld_user_id")
	private int userId;
	@Column(name = "fld_amount")
	private long amount;
	@Column(name = "fld_month")
	private String month;
	@Column(name = "fld_hike")
	private double hike;
}
