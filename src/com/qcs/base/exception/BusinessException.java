package com.qcs.base.exception;

/**
 * 
 * @ClassName: BusinessException 
 * @Description: 业务逻辑异常。业务异常。业务出错时候可以跑出此异常
 *
 */
public class BusinessException extends Exception {
	public BusinessException(){
		super();
	}
	
	public BusinessException(Exception e){
		super(e);
	}
	
	public BusinessException(String something){
		super(something);
	}
}
