package me.debugjoker.exception;

/**
 * 重复选课异常
 */
public class RepeatChooseException extends ChooseException{

    public RepeatChooseException(String message) {
        super(message);
    }

    public RepeatChooseException(String message, Throwable cause) {
        super(message, cause);
    }
}
