package com.Dao;

import java.util.List;

import com.Model.Permission;

public interface PermisionDao {
	public Integer addPermission(Permission permission);
	public List<Permission> getAllPermission();
	public Integer deletePermission(Integer id);
	public Integer getIdByPermission(String  permission);
    public Permission getPermissionById(int id);
    public Integer updatePermission(Permission permission);

}
