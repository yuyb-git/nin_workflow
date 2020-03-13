package cn.netinnet.workflow.common.exception;

public class CustomException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String message;
    private int errorCode;

    public CustomException(String message, int errorCode) {
        super(message);
        this.message = message;
        this.errorCode = errorCode;
    }

    public CustomException(Throwable cause) {
        super(cause);
    }

    public CustomException(String message, int errorCode, Throwable cause) {
        super(message, cause);
        this.message = message;
        this.errorCode = errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }


}
