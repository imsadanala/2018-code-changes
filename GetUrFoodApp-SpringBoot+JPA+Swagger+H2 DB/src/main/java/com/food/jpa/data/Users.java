package com.food.jpa.data;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Suresh Sadanala
 */
@Data
@NoArgsConstructor
@Table(name = "USERS")
@Entity
@EqualsAndHashCode
public class Users implements Serializable {

	private static final long serialVersionUID = 1258813791766592443L;
	@Id
	@Column(name = "USER_ID")
	private Long userId;
	@Column(name = "FISRT_NAME")
	private String firstName;
	@Column(name = "MIDDLE_NAME")
	private String middleName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "LOGIN_NAME")
	private String loginName;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "PHONE")
	private Long phoneNumber;
	@Column(name = "STATUS")
	private String status;
	@Column(name = "ADDRESS")
	private String address;
	@Column(name = "CREATED_ON")
	private Date createdOn;
}
