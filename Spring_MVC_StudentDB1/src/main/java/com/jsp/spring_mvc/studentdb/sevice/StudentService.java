package com.jsp.spring_mvc.studentdb.sevice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.spring_mvc.studentdb.entity.Student;
import com.jsp.spring_mvc.studentdb.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository sp;


	public ModelAndView addStudent(Student s) {
		sp.addStudent(s);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("index.jsp");
		return mav;
	}


	public ModelAndView displayAllStudent() {
		//fetching all details of student from the database table
		List<Student>students=sp.findAllStudents();
		ModelAndView mav=new ModelAndView();
		mav.setViewName("display.jsp");
		mav.addObject("studentList", students);
		return mav;
	}


	public ModelAndView findStudentById(int studentId) {
		//fetching the student object based on ID
		Student student=sp.findStudentById(studentId);
		ModelAndView mav=new ModelAndView();
//		mav.setViewName("UpdateStudent.jsp");
//		mav.addObject("studentObject", student);
//		return mav;
		return new ModelAndView("UpdateStudent.jsp").addObject("studentObject", student);
	}
	


	public ModelAndView updateStudent(Student student) {
		//update the student record in the database
		sp.updateStudent(student);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("redirect:display-All-Students");
		return mav;
	}


	public ModelAndView deleteStudent(int studentId) {
		sp.deleteStudentById(studentId);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("redirect:display-All-Students");
		return mav;
		
	}

}
