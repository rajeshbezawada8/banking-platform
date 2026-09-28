package com.bank.auth.model.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "role_permissions")
public class RolePermissions {

	@Id
	@ManyToOne
	@JoinColumn(name = "role_id")
	private Roles role;

	@Id
	@ManyToOne
	@JoinColumn(name = "permission_id")
	private Permissions permission;

	@CreationTimestamp
	@Column(name = "assigned_at", nullable = false)
	private LocalDateTime assignedAt;

	@Column(name = "assigned_by")
	private Long assignedBy;
	
	public RolePermissions() {
		
	}

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

	public Permissions getPermission() {
		return permission;
	}

	public void setPermission(Permissions permission) {
		this.permission = permission;
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
}
