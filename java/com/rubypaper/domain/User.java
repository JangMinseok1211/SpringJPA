package com.rubypaper.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "USERS")
public class User {
	@Id
	private String id;
	private String password;
	private String name;
	private String role;
}
