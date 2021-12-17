package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Call;
import com.service.CallService;

@RestController
@CrossOrigin
@RequestMapping(path="/api")

public class CallController {
	@Autowired
	CallService callservice;
	
	@PostMapping("/addCall")
	public ResponseEntity<Boolean> addCall(@RequestBody Call call)
	{
		 callservice.addCall(call);
		ResponseEntity re = new ResponseEntity<Boolean>(true,HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/getCalls")
	public ResponseEntity<List<Call>> getCalls()
	{
		List<Call> ca1 = callservice.getCalls();
		ResponseEntity re = new ResponseEntity<List<Call>>(ca1,HttpStatus.OK);
		return re;
	}
	
	@PutMapping(path= "/updateCall")
	public ResponseEntity<Call> updateCall(@RequestBody Call call) throws Throwable
	{
		Call c11 = callservice.updateCall(call);
		ResponseEntity re = new ResponseEntity<Call>(c11,HttpStatus.OK);
		return re;
	}
	
	
	
	@DeleteMapping(path = "/removeCall/{callId}")
	public ResponseEntity<Call> removeCall(@PathVariable int callId) {
		Call c = callservice.removeCall(callId);
		return new ResponseEntity<>(c, HttpStatus.OK);
	}

}
