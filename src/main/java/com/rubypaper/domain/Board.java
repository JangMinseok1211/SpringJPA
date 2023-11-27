package com.rubypaper.domain;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Board {
	@Id
	@GeneratedValue
	private int seq;
	private String title;
	private String writer;
	private String content;
	@Column(insertable = false,updatable = false,
			columnDefinition = "date default current_date")
	private Date createDate;
	@Column(columnDefinition = "number default 0")
	private int cnt;
}
