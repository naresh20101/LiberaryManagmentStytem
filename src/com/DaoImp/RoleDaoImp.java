package com.DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Dao.RoleDao;
import com.DbManager.DbConnection;
import com.Model.Role;

public class RoleDaoImp implements RoleDao{
	Connection conn= DbConnection.getConnection();
	@Override
	public Integer addRole(Role role) {
		int row=0;
		PreparedStatement pst=null;
		try {
		pst=(PreparedStatement)conn.prepareStatement("insert into role(role) values(?) ");
		if(role.getRole()!=null)
		pst.setString(1,role.getRole());
	
		row=pst.executeUpdate();
	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public List<Role> getAllRoles() {
		List<Role> list=new ArrayList<>(); 
		try
        {
            String query="select * from role"; 
            
            PreparedStatement ps=conn.prepareStatement(query);
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next())
            {
            Role role=new Role();
            role.setRoleId(rs.getInt("role_id"));
            role.setRole(rs.getString("role"));
            list.add(role);
               
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
		return list;
	}

	@Override
	public Integer deleteRole(Integer id) {
		Integer row=null;
        try {
            String delete = "delete from role where role_id=?";
            PreparedStatement smt = conn.prepareStatement(delete);
            smt.setInt(1, id);
            smt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		return row;
	}

	@Override
	public Integer getIdByRole(String role) {
		 Integer Id = 0;
	        try {
	            String delete = "select role_id from role where role=?";
	            PreparedStatement smt = conn.prepareStatement(delete);
	            smt.setString(1, role);
	            ResultSet rst = smt.executeQuery();
	            while (rst.next()) {
	             Id = rst.getInt("role_id");
	            }
	        }
	       
	            catch (Exception ex) {
	            ex.printStackTrace();
	        }
		return Id;
	}

	@Override
	public Role getRoleById(int id) {
		Role role=new Role();
		try
        {
            String query="select * from role where role_id=?"; 
            
            PreparedStatement ps=conn.prepareStatement(query);
           ps.setInt(1, id);
          
            ResultSet rs=ps.executeQuery();
            
            while(rs.next())
            {
            	role.setRoleId(rs.getInt("role_id"));
                role.setRole(rs.getString("role"));   
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
		
		return role;
	}

	@Override
	public Integer updateRole(Role role) {
		int status=0;
		try{
			
			PreparedStatement ps=conn.prepareStatement("update role set role=? where role_id=?");
			ps.setString(1, role.getRole());
	        ps.setInt(2,role.getRoleId());
			
			status=ps.executeUpdate();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}

}
