package com.cg.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.demo.entities.Student;
import com.cg.demo.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class StudentController {
	@Autowired
	StudentService ss;
	
	@Operation(summary = "Add Student")
	@PostMapping("/students")
	public ResponseEntity<String> addStudent(@Valid@RequestBody Student stu) {
		String msg=ss.insertStudent(stu);
		ResponseEntity<String> rEntity=new ResponseEntity<String>(msg,HttpStatus.CREATED);
		return rEntity;
	}
	@Operation(summary = "Update Student Profile")
	@PutMapping("/students/{id}")
	public ResponseEntity<String> modifyStudent(@PathVariable ("id") int id, @Valid@RequestBody Student stu) {
		String msg=ss.updateStudent(id,stu);
		ResponseEntity<String> rEntity=new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);
		return rEntity;
	}
	@Operation(summary = "Get Student By Id")
	@GetMapping("/students/{id}")
	public ResponseEntity<Student> findStudentById(@PathVariable("id") int id){
		Student dr =ss.findByStudentId(id);
		ResponseEntity<Student> rEntity=new ResponseEntity<Student>(dr,HttpStatus.OK);
		return rEntity;
	}
	@Operation(summary = "Remove Student")
	@DeleteMapping("/students/{id}")
	public ResponseEntity<String> deleteStudentById(@PathVariable ("id")int id) {
		String msg=ss.deleteById(id);
		ResponseEntity<String> rEntity=new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);
		return rEntity;
	}
	
}
