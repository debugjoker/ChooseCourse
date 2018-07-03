package me.debugjoker.exception;

/**
 * 选课相关异常
 */
public class ChooseException extends RuntimeException {

    public ChooseException(String message) {
        super(message);
    }

    public ChooseException(String message, Throwable cause) {
        super(message, cause);
    }
}
