package com.guods.springboot.common.core;

public class AjaxResponseError extends AjaxResponse {

	private static final long serialVersionUID = -8143014511050540672L;

	public AjaxResponseError(String message) {
		super(ResultStatus.ERROR.getResultCode(), message);
	}

}
