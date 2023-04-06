package com.llr.im.mem.exception;

public class DuplicateException extends Exception {
    private static final long serialVersionUID = 3289201087559203157L;

    public DuplicateException() {}

    public DuplicateException(String msg) {
        super(msg);
    }

    public DuplicateException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
