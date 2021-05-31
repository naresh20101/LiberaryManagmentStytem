package com.Dao;

import java.util.List;

import com.Model.Student;

public interface StudentDao {
	public Integer addStudent(Student student);
	public List<Student> getStudents();
	public Integer deleteStudent(Integer id);
	public Student getStudentById(int id);
    public Integer updateStudent(Student student);
    public Integer getIdByStudent(String name);
    

}
