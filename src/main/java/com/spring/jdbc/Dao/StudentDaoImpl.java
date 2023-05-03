package com.spring.jdbc.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.springcore.jdbc.entites.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int insert() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int change() {
		return 0;
	}

	public int insert(Student student) {
		// insert query
		String query = "insert into student(id,name,city) values(?,?,?)";
		int r = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());

		// TODO Auto-generated method stub
		return r;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int change(Student student) {
		// update query
		String query = "update student set name=? , city=?  where id=?";
		int r = this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
		return r;
		// TODO Auto-generated method stub

	}

	// delete operation
	public int delete(int studentId) {
		String queryString = "delete from student where id=?";
		int r = this.jdbcTemplate.update(queryString, studentId);

		// TODO Auto-generated method stub
		return r;
	}

	// select single student data
	public Student getStudent(int studentId) {
		String query = "select * from student where id = ?";
		RowMapper<Student> rowMapper = new RowMapperImpl();

		Student student = this.jdbcTemplate.queryForObject(query, rowMapper, studentId);
		// TODO Auto-generated method stub
		return student;
	}

	public List<Student> getAllStudents() {

		String query = "Select * from student";
		List<Student> students = this.jdbcTemplate.query(query, new RowMapperImpl());

		return students;
	}

}
