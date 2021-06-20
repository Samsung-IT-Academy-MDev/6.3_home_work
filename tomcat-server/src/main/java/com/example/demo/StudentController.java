package com.example.demo;

import java.util.LinkedList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	List<Student> list=new LinkedList<Student>();

	@RequestMapping(method = RequestMethod.GET,value = "/student")
	public List<Student> get() {
		list.add(new Student("Vasya","Ivanov"));
		return list;
	}

}
