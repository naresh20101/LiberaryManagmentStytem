package com.DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Dao.PermisionDao;
import com.DbManager.DbConnection;
import com.Model.Permission;

public class PermissionDaoImp implements PermisionDao{
	Connection conn= DbConnection.getConnection();
	@Override
	public Integer addPermission(Permission permission) {
		int row=0;
		PreparedStatement pst=null;
		try {
		pst=(PreparedStatement)conn.prepareStatement("insert into permission(permission) values(?) ");
		if(permission.getPermission()!=null)
		pst.setString(1,permission.getPermission());
	
		row=pst.executeUpdate();
	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public List<Permission> getAllPermission() {
		List<Permission> list=new ArrayList<>(); 
		try
        {
            String query="select * from permission"; 
            
            PreparedStatement ps=conn.prepareStatement(query);
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next())
            {
              Permission permission=new Permission();
              permission.setPermissionId(rs.getInt("permission_id"));
              permission.setPermission(rs.getString("permission"));
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
	public Integer deletePermission(Integer id) {
		Integer row=null;
        try {
            String delete = "delete from permission where permission_id=?";
            PreparedStatement smt = conn.prepareStatement(delete);
            smt.setInt(1, id);
            smt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		return row;
	}

	@Override
	public Integer getIdByPermission(String permission) {
		 Integer Id = 0;
	        try {
	            String delete = "select permission_id from permission where permission=?";
	            PreparedStatement smt = conn.prepareStatement(delete);
	            smt.setString(1,permission);
	            ResultSet rst = smt.executeQuery();
	            while (rst.next()) {
	             Id = rst.getInt("permission_id");
	            }
	        }
	       
	            catch (Exception ex) {
	            ex.printStackTrace();
	        }
		return Id;
	}

	@Override
	public Permission getPermissionById(int id) {
		Permission permission=new Permission();
		try
        {
            String query="select * from permission where permission_id=?"; 
            
            PreparedStatement ps=conn.prepareStatement(query);
           ps.setInt(1, id);
          
            ResultSet rs=ps.executeQuery();
            
            while(rs.next())
            {
            	 permission.setPermissionId(rs.getInt("permission_id"));
                 permission.setPermission(rs.getString("permission"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
		
		return permission;
	}

	@Override
	public Integer updatePermission(Permission permission) {
		int status=0;
		try{
			
			PreparedStatement ps=conn.prepareStatement("update permission set permission=? where permission_id=?");
			ps.setString(1, permission.getPermission());
	        ps.setInt(2,permission.getPermissionId());
			
			status=ps.executeUpdate();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return status;
	}

}
