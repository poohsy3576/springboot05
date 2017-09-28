package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.java.Log;

@Controller
@RequestMapping("/bootstrap")
@Log
public class BootstrapController {
   
	@GetMapping("/merge")
	public String htmlMerge() {
		log.info("/bootstrap/merge htmlMerge()...");
		
		return "jsp/bootstrap/merge";
	}
	
	@GetMapping("/gridsample")
	public String gridSample() {
		log.info("/bootstrap/gridsample gridSample()...");
		
		return "jsp/bootstrap/gridsample";
	}
}