package com.newsoft.shop.exception;

/**
 * 系统异常
 * @author lmy
 *
 */
public class SysException extends RuntimeException {
	static final long serialVersionUID = -703489719045666939L;

    public SysException() {
        super();
    }

    public SysException(String message) {
        super(message);
    }

    public SysException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public SysException(Throwable cause) {
        super(cause);
    }

    protected SysException(String message, Throwable cause,
                               boolean enableSuppression,
                               boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
