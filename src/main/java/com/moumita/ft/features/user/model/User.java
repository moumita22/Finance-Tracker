package com.moumita.ft.features.user.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class User {

	@Id
	@Column(name = "fld_ai_id")
	private int id;
	@Column(name = "fld_user_id")
	private int userId;
	@Column(name = "fld_amount")
	private long amount;
	@Column(name = "fld_month")
	private String month;
	@Column(name = "fld_date")
	private LocalDateTime date;
}
