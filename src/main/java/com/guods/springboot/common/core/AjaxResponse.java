package com.guods.springboot.common.core;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AjaxResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	private int resultCode;
	private String message;
	private Map<String, Object> data;

	public AjaxResponse() {
		super();
		this.resultCode = ResultStatus.OK.getResultCode();
		this.message = ResultStatus.OK.getMessage();
	}

	public AjaxResponse(int resultCode, String message) {
		super();
		this.resultCode = resultCode;
		this.message = message;
	}

	public AjaxResponse(ResultStatus resultStatus) {
		this.resultCode = resultStatus.getResultCode();
		this.message = resultStatus.getMessage();
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void addData(String key, Object value) {
		if (this.data == null) {
			data = new HashMap<String, Object>();
		}
		data.put(key, value);
	}

	public Object getData(String key) {
		if (this.data == null) {
			return null;
		}
		return this.data.get(key);
	}
	@JsonIgnore
	public boolean isSuccess(){
		if (resultCode == ResultStatus.OK.getResultCode()) {
			return true;
		}
		return false;
	}
}
