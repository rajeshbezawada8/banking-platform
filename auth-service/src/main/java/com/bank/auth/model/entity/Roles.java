package com.bank.auth.model.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.bank.auth.model.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Roles {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private Long id;

	@Column(name = "role_code", nullable = false, unique = true, length = 50)
	private String roleCode;

	@Column(name = "role_name", nullable = false, unique = true, length = 100)
	private String roleName;

	@Column(name = "description", length = 255)
	private String description;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false)
	private Status roleStatus;

	@CreationTimestamp
	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt;

	@UpdateTimestamp
	@Column(name = "updated_at", nullable = false)
	private LocalDateTime updatedAt;

	@OneToMany(mappedBy = "role")
	private List<UserRoles> userRoles;

	@OneToMany(mappedBy = "role")
	private List<RolePermissions> rolePermissions;
	
	public Roles() {
		
	}

	public Long getId() {
		return id;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Status getRoleStatus() {
		return roleStatus;
	}

	public void setRoleStatus(Status roleStatus) {
		this.roleStatus = roleStatus;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<UserRoles> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRoles> userRoles) {
		this.userRoles = userRoles;
	}

	public List<RolePermissions> getRolePermissions() {
		return rolePermissions;
	}

	public void setRolePermissions(List<RolePermissions> rolePermissions) {
		this.rolePermissions = rolePermissions;
	}
	
}
