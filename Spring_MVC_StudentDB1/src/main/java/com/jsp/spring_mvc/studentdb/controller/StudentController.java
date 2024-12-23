package com.jsp.spring_mvc.studentdb.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.spring_mvc.studentdb.entity.Student;
import com.jsp.spring_mvc.studentdb.sevice.StudentService;
@Controller
public class StudentController {
	@Autowired
	private  StudentService ss;
	@RequestMapping(value="/add-student", method=RequestMethod.POST)
	public ModelAndView addStudent(Student s) {
		return ss.addStudent(s);
	}
	
	@RequestMapping(value="/display-All-Students", method=RequestMethod.GET)
	public  ModelAndView displayAllStudent() {
		return ss.displayAllStudent();
	}
	
	@RequestMapping(value="/find-student-by-id", method=RequestMethod.GET)
	public ModelAndView findStudentById(@RequestParam int  studentId) {
		return ss.findStudentById(studentId);
	}
	@RequestMapping(value="/update-student", method=RequestMethod.POST)
	public ModelAndView updateStudent(Student student) {
		return ss.updateStudent(student);
	}
	@RequestMapping(value="/delete-student-by-id", method=RequestMethod.GET)
	public ModelAndView deleteStudent(@RequestParam int studentId) {
		return ss.deleteStudent(studentId);
	}

}
