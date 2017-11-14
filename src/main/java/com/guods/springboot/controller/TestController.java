package com.guods.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.guods.springboot.common.core.AjaxResponse;
import com.guods.springboot.common.core.AjaxResponseError;
import com.guods.springboot.model.BookItem;
import com.guods.springboot.service.TestService;
import com.guods.springboot.test.SecondKill;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	private TestService testService;
	
	@Autowired
	private SecondKill secondKill;
	
	@GetMapping("/test/{id}")
	public BookItem test(@PathVariable Long id){
		return testService.getById(id);
	}
	
	@GetMapping(value = "/put/{num}")
	public @ResponseBody AjaxResponse put(@PathVariable String num) {
		try {
			secondKill.multiThreadAdd2Redis("productId", num);
			return new AjaxResponse();
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResponseError("错误：" + e.getMessage());
		}
	}
	
	@GetMapping(value = "/get/{num}")
	public @ResponseBody AjaxResponse get(@PathVariable Long num) {
		try {
			secondKill.multiThreadSecKill("productId", -num);
			return new AjaxResponse();
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResponseError("错误：" + e.getMessage());
		}
	}
}
