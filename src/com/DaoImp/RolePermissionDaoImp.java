package com.DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.Dao.RolePermissionDao;
import com.DbManager.DbConnection;
import com.Model.Permission;
import com.Model.Role;
import com.Model.RolePermission;

public class RolePermissionDaoImp implements RolePermissionDao{
	Connection conn= DbConnection.getConnection();
	@Override
	public Integer addRolePermission(RolePermission rolePermission) {
		
			int row=0;
			PreparedStatement pst=null;
			try {
			pst=(PreparedStatement)conn.prepareStatement("insert into role_permission(role_id,permission_id) values(?,?) ");
			if(rolePermission.getRole().getRoleId()!=null)
			pst.setInt(1,rolePermission.getRole().getRoleId());
			if(rolePermission.getPermission().getPermissionId()!=null)
			pst.setInt(2, rolePermission.getPermission().getPermissionId());
		
			row=pst.executeUpdate();
		
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return row;
	}

	@Override
	public List<RolePermission> getAllRolePermission() {
		List<RolePermission> list=new ArrayList<>(); 
		try
        {
            String query="select * from role_permission"; 
            
            PreparedStatement ps=conn.prepareStatement(query);
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next())
            {
              RolePermission permission=new RolePermission();
             permission.setRolePermissionId(rs.getInt("role_permission_id"));
             Role role=new Role();
             role.setRoleId(rs.getInt("role_id"));
             permission.setRole(role);
             Permission p=new Permission();
             p.setPermissionId(rs.getInt("permission_id"));
             permission.setPermission(p);
             list.add(permission);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
		return list;
	}

	@Override
	public Integer deleteRolePermission(Integer id) {
		Integer row=null;
        try {
            String delete = "delete from role_permission where role_permission_id=?";
            PreparedStatement smt = conn.prepareStatement(delete);
            smt.setInt(1, id);
            smt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		return row;
	}

	@Override
	public RolePermission getRolePermissionById(int id) {
		RolePermission permission=new RolePermission();
		try
        {
            String query="select * from role_permission where role_permission_id=?"; 
            
            PreparedStatement ps=conn.prepareStatement(query);
           ps.setInt(1, id);
          
            ResultSet rs=ps.executeQuery();
            
            while(rs.next())
            {
            	 permission.setRolePermissionId(rs.getInt("role_permission_id"));
                 Role role=new Role();
                 role.setRoleId(rs.getInt("role_id"));
                 permission.setRole(role);
                 Permission p=new Permission();
                 p.setPermissionId(rs.getInt("permission_id"));
                 permission.setPermission(p); 
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
		
		return permission;
	}

	@Override
	public Integer updateRolePermission(RolePermission rolePermission) {
		int status=0;
		try{
			
			PreparedStatement ps=conn.prepareStatement("update role_permission set role_id=? permission_id=? where role_permission_id=?");
			ps.setInt(1, rolePermission.getRole().getRoleId());
			ps.setInt(2, rolePermission.getPermission().getPermissionId());
			ps.setInt(3, rolePermission.getRolePermissionId());
			
			status=ps.executeUpdate();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return status;
	}

}
