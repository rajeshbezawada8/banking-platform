package com.bank.auth.model.entity.id;

import java.io.Serializable;
import java.util.Objects;

public class RolePermissionsId implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long role;
	private Long permission;

	public RolePermissionsId() {
	}

	public RolePermissionsId(Long role, Long permission) {
		this.role = role;
		this.permission = permission;
	}

	public Long getRole() {
		return role;
	}

	public void setRole(Long role) {
		this.role = role;
	}

	public Long getPermission() {
		return permission;
	}

	public void setPermission(Long permission) {
		this.permission = permission;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;

		if (!(o instanceof RolePermissionsId))
			return false;

		RolePermissionsId that = (RolePermissionsId) o;

		return Objects.equals(role, that.role) && Objects.equals(permission, that.permission);
	}

	@Override
	public int hashCode() {
		return Objects.hash(role, permission);
	}
}