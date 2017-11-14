package com.guods.springboot.common.core;

public enum ResultStatus {

	OK(0, "成功"),
	ERROR(1000, ""),
	PIC_TYPE_ERROR(1001, "图片格式错误！"),
	PIC_UPLOAD_ERROR(1002, "图片上传错误！"),
	SMS_ERROR(2000, "发送短信错误！"),
	TOKEN_AUTHOR_ERROR(2001, "无权限访问该接口！"),
	TOKEN_NULL_ERROR(2002, "token为空！"),
	TOKEN_ERROR(2003, "token错误，请重新登录！");

	private int resultCode;
	private String message;

	private ResultStatus(int resultCode, String message) {
		this.resultCode = resultCode;
		this.message = message;
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

	
}
