package com.DaoImp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.Dao.StudentDao;
import com.Model.Student;
import com.DbManager.*;

public class StudentDaoImp implements StudentDao{
	Connection conn= DbConnection.getConnection();
	 
	@Override
	public Integer addStudent(Student student) {
		  int row=0;
			
			PreparedStatement pst=null;
			try {
				java.sql.Date sqlDate = new java.sql.Date(student.getDateOfBirth().getTime());
	            
			pst=(PreparedStatement)conn.prepareStatement("insert into student(roll_no,name,date_of_birth,contact) values(?,?,?,?) ");
			if(student.getRollNo()!=null)
			pst.setString(1, student.getRollNo());
			if(student.getName()!=null)
			pst.setString(2, student.getName());
		    if(student.getDateOfBirth()!=null)
			pst.setDate(3,sqlDate);
			if(student.getContact()!=null)
			pst.setString(4, student.getContact());
			
			row=pst.executeUpdate();
		
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return row;
	}

	@Override
	public List<Student> getStudents() {
		List<Student> list=new ArrayList<>(); 
		try
        {
            String query="select * from student"; 
            
            PreparedStatement ps=conn.prepareStatement(query);
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next())
            {
               Student student=new Student();
             student.setId(rs.getInt("std_id"));
             student.setRollNo(rs.getString("roll_no"));
             student.setName(rs.getString("name"));
             student.setDateOfBirth(rs.getDate("date_of_birth"));
             student.setContact(rs.getString("contact"));
             list.add(student);
               
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
		return list;
	}

	@Override
	public Integer deleteStudent(Integer id) {
		Integer row=null;
        try {
            String delete = "delete from student where std_id=?";
            PreparedStatement smt = conn.prepareStatement(delete);
            smt.setInt(1, id);
            smt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		return row;
	}

	@Override
	public Student getStudentById(int id) {
		Student student=new Student();
		try
        {
            String query="select * from student where std_id=?"; 
            
            PreparedStatement ps=conn.prepareStatement(query);
           ps.setInt(1, id);
          
            ResultSet rs=ps.executeQuery();
            
            while(rs.next())
            {
            	
            	student.setId(rs.getInt("std_id"));
            	student.setRollNo(rs.getString("roll_no"));
            	student.setName(rs.getString("name"));
            	student.setDateOfBirth(rs.getDate("date_of_birth"));
            	student.setContact(rs.getString("contact"));    
               
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
		return student;
	}

	@Override
	public Integer updateStudent(Student student) {
		int status=0;
		try{
				
		 PreparedStatement ps=conn.prepareStatement("update student set  roll_no=?,name=?, date_of_birth=?,contact=? where std_id=?");
		        ps.setString(1, student.getRollNo());
		        ps.setString(2, student.getName());
                ps.setDate(3, student.getDateOfBirth());
		        ps.setString(4, student.getContact());
		        ps.setInt(5, student.getId());
				status=ps.executeUpdate();
			}catch(Exception ex){
				ex.printStackTrace();
				}
			
			return status;
	}

	@Override
	public Integer getIdByStudent(String name) {
		Integer Id = 0;
        try {
            String delete = "select  std_id from student where name=?";
            PreparedStatement smt = conn.prepareStatement(delete);
            smt.setString(1, name);
            ResultSet rst = smt.executeQuery();
            while (rst.next()) {
             Id = rst.getInt("std_id");
            }
        }
       
            catch (Exception ex) {
            ex.printStackTrace();
        }
	return Id;
	}

}
