package com.cert.chortke;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebRestController {

	
	@GetMapping("/api/hi")
	public String sayHi() {

		return "hi";

	}

}
