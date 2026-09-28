package com.bank.auth.model.entity;

import java.time.LocalDateTime;

import com.bank.auth.model.enums.LoginStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "login_history")
public class LoginHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "login_id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	private Users user;

	@Column(name = "login_time", nullable = false)
	private LocalDateTime loginTime;

	@Column(name = "logout_time")
	private LocalDateTime logoutTime;

	@Enumerated(EnumType.STRING)
	@Column(name = "login_status", nullable = false)
	private LoginStatus loginStatus;

	@Column(name = "ip_address", length = 45)
	private String ipAddress;

	@Column(name = "user_agent", length = 500)
	private String userAgent;

	@Column(name = "failure_reason", length = 255)
	private String failureReason;
	
	public LoginHistory() {
		
	}

	public Long getId() {
		return id;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public LocalDateTime getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(LocalDateTime loginTime) {
		this.loginTime = loginTime;
	}

	public LocalDateTime getLogoutTime() {
		return logoutTime;
	}

	public void setLogoutTime(LocalDateTime logoutTime) {
		this.logoutTime = logoutTime;
	}

	public LoginStatus getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(LoginStatus loginStatus) {
		this.loginStatus = loginStatus;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getFailureReason() {
		return failureReason;
	}

	public void setFailureReason(String failureReason) {
		this.failureReason = failureReason;
	}
}
