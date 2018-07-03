package me.debugjoker.exception;

/**
 * 选课关闭异常
 */
public class ChooseCloseException extends ChooseException {

    public ChooseCloseException(String message) {
        super(message);
    }

    public ChooseCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
