package com.bank.auth.model.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.bank.auth.model.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_roles")
public class UserRoles {

	@Id
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	private Users user;

	@Id
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "role_id", nullable = false)
	private Roles role;

	@CreationTimestamp
	@Column(name = "assigned_at", nullable = false)
	private LocalDateTime assignedAt;

	@Column(name = "assigned_by")
	private Long assignedBy;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false)
	private Status status;
	
	public UserRoles() {
		
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

	public LocalDateTime getAssignedAt() {
		return assignedAt;
	}

	public void setAssignedAt(LocalDateTime assignedAt) {
		this.assignedAt = assignedAt;
	}

	public Long getAssignedBy() {
		return assignedBy;
	}

	public void setAssignedBy(Long assignedBy) {
		this.assignedBy = assignedBy;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
