package io.nftips.kunpeng.exception;

/**
 * 自定义异常
 *
 * @author joyven
 * @email joyven888@163.com
 * @date 2022-10-21 10:02:23
 */
public class KpException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
    private String msg;
    private int code = 500;
    
    public KpException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	public KpException(String msg, Throwable e) {
		super(msg, e);
		this.msg = msg;
	}
	
	public KpException(String msg, int code) {
		super(msg);
		this.msg = msg;
		this.code = code;
	}
	
	public KpException(String msg, int code, Throwable e) {
		super(msg, e);
		this.msg = msg;
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	
}
