package jsg.house.exception;

public class MemberFailException extends RuntimeException {
    public MemberFailException() {
        super();
    }

    public MemberFailException(String message) {
        super(message);
    }

    public MemberFailException(String message, Throwable cause) {
        super(message, cause);
    }

    public MemberFailException(Throwable cause) {
        super(cause);
    }

    protected MemberFailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
