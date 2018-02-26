package cn.itlaobing.exception;
/**
 * 
 * @author is me
 *
 */
public class BusinessException extends Exception {
	public BusinessException(String message,Throwable cause){
		super(message,cause);
	}
}
