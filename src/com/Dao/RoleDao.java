package com.Dao;

import java.util.List;

import com.Model.Role;

public interface RoleDao {
	public Integer addRole(Role role);
	public List<Role> getAllRoles();
	public Integer deleteRole(Integer id);
	public Integer getIdByRole(String role);
    public Role getRoleById(int id);
    public Integer updateRole(Role role);


}
