package com.DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Dao.UserDao;
import com.Model.User;
import com.DbManager.*;

public class UserDaoImp implements UserDao{
	Connection conn= DbConnection.getConnection();
	@Override
	public Integer addUser(User user) {
		  int row=0;
			PreparedStatement pst=null;
			try {
			pst=(PreparedStatement)conn.prepareStatement("insert into user(name,email,password) values(?,?,?) ");
			if(user.getName()!=null)
			pst.setString(1,user.getName());
			if(user.getEmail()!=null)
			pst.setString(2,user.getEmail());
			if(user.getPassword()!=null)
			pst.setString(3, user.getPassword());
			row=pst.executeUpdate();
		
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return row;
	}

	@Override
	public List<User> getUsers() {
		List<User> list=new ArrayList<>(); 
		try
        {
            String query="select * from user"; 
            
            PreparedStatement ps=conn.prepareStatement(query);
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next())
            {
            	User user=new User();
             user.setUser_id(rs.getInt("id"));
             user.setName(rs.getString("name"));
             user.setEmail(rs.getString("email"));
             user.setPassword(rs.getString("password"));
             list.add(user);
               
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
		return list;
	}

	@Override
	public Integer deleteUser(Integer id) {
		Integer row=null;
        try {
            String delete = "delete from user where id=?";
            PreparedStatement smt = conn.prepareStatement(delete);
            smt.setInt(1, id);
            smt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		return row;
	}

	@Override
	public Integer getIdByUser(String user_name) {
		 Integer user_Id = 0;
	        try {
	            String delete = "select id from user where name=?";
	            PreparedStatement smt = conn.prepareStatement(delete);
	            smt.setString(1, user_name);
	            ResultSet rst = smt.executeQuery();
	            while (rst.next()) {
	             user_Id = rst.getInt("id");
	            }
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
		return user_Id;
	}

	@Override
	public User getUserById(int id) {
		User user=new User();
		try
        {
            String query="select * from user where id=?"; 
            
            PreparedStatement ps=conn.prepareStatement(query);
           ps.setInt(1, id);
          
            ResultSet rs=ps.executeQuery();
            
            while(rs.next())
            {
            	
            	 user.setUser_id(rs.getInt("id"));
                 user.setName(rs.getString("name"));
                 user.setEmail(rs.getString("email"));
                 user.setPassword(rs.getString("password"));
            	
               
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
		
		return user;
		
	}

	@Override
	public Integer updateUser(User user) {
		int status=0;
		try{
			
			PreparedStatement ps=conn.prepareStatement("update user set name=?, email=?, password=? where id=?");
			ps.setString(1,user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3,user.getPassword());
	        ps.setInt(4,user.getUser_id());
		   status=ps.executeUpdate();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;

}
}
