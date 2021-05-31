package com.Dao;

import java.util.List;
import com.Model.RolePermission;

public interface RolePermissionDao {
	public Integer addRolePermission(RolePermission rolePermission);
	public List<RolePermission> getAllRolePermission();
	public Integer deleteRolePermission(Integer id);
	public RolePermission getRolePermissionById(int id);
    public Integer updateRolePermission(RolePermission rolePermission);


}
