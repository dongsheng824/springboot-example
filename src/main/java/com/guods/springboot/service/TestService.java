package com.guods.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guods.springboot.mapper.BookItemMapper;
import com.guods.springboot.model.BookItem;

@Service
public class TestService {

	@Autowired
	private BookItemMapper bookItemMapper;
	
	public BookItem getById(Long id){
		return bookItemMapper.selectByPrimaryKey(id);
	}
}
