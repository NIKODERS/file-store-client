package nikheel.rh.fsc.exception;

public class FSCRuntimeException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private String errorCode;
	private String errorDetails;

	public FSCRuntimeException() {
		super();
	}

	public FSCRuntimeException(String message) {
		super(message);
	}

	public FSCRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public FSCRuntimeException(String errorCode, String message, String errorDetails) {
		super(message);
		this.errorCode = errorCode;
		this.errorDetails = errorDetails;
	}

	public FSCRuntimeException(String errorCode, String message, String errorDetails, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
		this.errorDetails = errorDetails;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorDetails() {
		return errorDetails;
	}

	@Override
	public String toString() {
		return "FSCException{" + "errorCode='" + errorCode + '\'' + ", errorDetails='" + errorDetails + '\''
				+ ", message='" + getMessage() + '\'' + '}';
	}
}
