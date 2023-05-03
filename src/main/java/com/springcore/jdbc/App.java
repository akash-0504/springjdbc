package com.springcore.jdbc;

import java.util.List;
import java.util.Scanner;

import javax.xml.XMLConstants;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.Dao.StudentDao;
import com.springcore.jdbc.entites.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Program is started ");

		// spring jdbc=> jdbcTemplate
		
		
		//for XML File configartion
		//ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/jdbc/Config.xml");
          
		//for Annotaion configration
		ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

		
		  //insert
		  
//		  Student student = new Student(); student.setId(999);
//		  student.setName("Rakesh Roshan "); student.setCity("Pune");
//		  
//		  int result =studentDao.insert(student);
//		  
//		  System.out.println("number added.." + result);
//		 
		  
		  
		 
		// update
		/*
		 * Student student = new Student(); student.setId(779);
		 * student.setCity("shrinagar"); student.setName("vijay kumar");
		 * 
		 * int result = studentDao.change(student); System.out.println("data changed " +
		 * result);
		 */

		// delete
		/*
		 * Scanner scanner = new Scanner(System.in); System.out.println("enter the id");
		 * // int i= scanner.nextInt(); int result =
		 * studentDao.delete(scanner.nextInt()); System.out.println("delete" + result);
		 */
//	     Student student =  studentDao.getStudent(101);
//	     System.out.println(student);
//		
		List<Student> students = studentDao.getAllStudents();
		for (Student s : students) {
			System.out.println(s);
		}
	}
}


