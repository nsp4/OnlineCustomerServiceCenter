package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CallDao;
import com.model.Call;

@Service
public class CallService {
	@Autowired
	CallDao dao;
	
	// add call
	public boolean addCall(Call call)
	{
		dao.save(call);
		return true;
	
	}
	
	// Get  all Calls
	public List<Call> getCalls()
	{
		List<Call> co=dao.findAll();
		return co;
	}
	
	// update call
		public Call updateCall(Call call) {
			int callId = call.getCallId();
			Optional<Call> optional = dao.findById(callId);
			if (optional.isPresent()) {
				Call c = optional.get();
				c.setCallDate(call.getCallDate());
				c.setCallId(call.getCallId());
				c.setCallDuration(call.getCallDuration());
				c.setPhoneNumber(call.getPhoneNumber());
				c.setCustomer(call.getCustomer());
				c.setIssue(call.getIssue());
				c.setReceivedBy(call.getReceivedBy());
				
				return dao.save(c);
			}
			return call;

		}
		
		
		// Delete Call
		public Call removeCall(int callId) {
			Call c = dao.findById(callId).get();
			dao.deleteById(callId);
			return c;
}}
