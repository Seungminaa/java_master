package com.yedam.student.mapper;

import java.util.*;

import com.yedam.student.vo.Student;

public interface StudentMapper {
	//CRUD
	List<Student> studentList();
	int addStudent(Student std); //#{studNo}
	int remStudent(String sno); //#{sno}
}
