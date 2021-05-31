package com.DaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Dao.CategoryDao;
import com.DbManager.DbConnection;
import com.Model.Category;

public class CategoryDaoImp implements CategoryDao {
	Connection conn= DbConnection.getConnection();
	@Override
	public Integer addCategory(Category category) {
		 int row=0;
			PreparedStatement pst=null;
			try {
			pst=(PreparedStatement)conn.prepareStatement("insert into category(category) values(?) ");
			if(category.getCategory()!=null)
			pst.setString(1,category.getCategory());
		
			row=pst.executeUpdate();
		
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return row;
	}

	@Override
	public List<Category> getCategory() {
		List<Category> list=new ArrayList<>(); 
		try
        {
            String query="select * from category"; 
            
            PreparedStatement ps=conn.prepareStatement(query);
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next())
            {
            Category category=new Category();
            category.setId(rs.getInt("id"));
            category.setCategory(rs.getString("category"));
            list.add(category);
               
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
		return list;
	}

	@Override
	public Integer deleteCategory(Integer id) {
		Integer row=null;
        try {
            String delete = "delete from category where id=?";
            PreparedStatement smt = conn.prepareStatement(delete);
            smt.setInt(1, id);
            smt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		return row;
	}

	@Override
	public Integer getIdByCategory(String name) {
		 Integer Id = 0;
	        try {
	            String delete = "select id from category where category=?";
	            PreparedStatement smt = conn.prepareStatement(delete);
	            smt.setString(1, name);
	            ResultSet rst = smt.executeQuery();
	            while (rst.next()) {
	             Id = rst.getInt("id");
	            }
	        }
	       
	            catch (Exception ex) {
	            ex.printStackTrace();
	        }
		return Id;
	}

	@Override
	public Category getCategoryById(int id) {
	Category category=new Category();
		try
        {
            String query="select * from category where id=?"; 
            
            PreparedStatement ps=conn.prepareStatement(query);
           ps.setInt(1, id);
          
            ResultSet rs=ps.executeQuery();
            
            while(rs.next())
            {
            	 category.setId(rs.getInt("id"));
                 category.setCategory(rs.getString("category"));    
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
		
		return category;
		
	}

	@Override
	public Integer updateCategory(Category category) {
		int status=0;
		try{
			
			PreparedStatement ps=conn.prepareStatement("update category set category=? where id=?");
			ps.setString(1, category.getCategory());
	        ps.setInt(2,category.getId());
			
			status=ps.executeUpdate();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;

	}

}
