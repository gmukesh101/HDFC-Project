package com.mukesh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mukesh.service.EmailService;

@RestController
public class EmailController
{

	@Autowired
	private EmailService emailService;
	
	@RequestMapping(value ="/sendemail")
	public String sendEmail()
	{
		emailService.sendEmail();
		return "Email sent successfully";
	}

}