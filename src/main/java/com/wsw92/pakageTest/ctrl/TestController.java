package com.wsw92.pakageTest.ctrl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@ResponseBody
	@GetMapping("/hello")
	public String hello() {
		return "hello world!";
	}

}
