package com.example.genshinstart_backend.exception;

/**
 * @version 1.0.0
 * @description: The type Business exception.
 * @author feixia0g
 * @date 2024/7/9 20:00
 */
public class BusinessException extends RuntimeException {

    /**
     * The constant UNKNOWN_EXCEPTION.
     */
    public static final int UNKNOWN_EXCEPTION = 0;

    private int code;

    /**
     * Instantiates a new Business exception.
     */
    public BusinessException() {
        super();
    }

    /**
     * Instantiates a new Business exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Business exception.
     *
     * @param message the message
     */
    public BusinessException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Business exception.
     *
     * @param cause the cause
     */
    public BusinessException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Business exception.
     *
     * @param code the code
     */
    public BusinessException(int code) {
        super();
        this.code = code;
    }

    /**
     * Instantiates a new Business exception.
     *
     * @param code    the code
     * @param message the message
     * @param cause   the cause
     */
    public BusinessException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    /**
     * Instantiates a new Business exception.
     *
     * @param code    the code
     * @param message the message
     */
    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * Instantiates a new Business exception.
     *
     * @param code  the code
     * @param cause the cause
     */
    public BusinessException(int code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * Sets code.
     *
     * @param code the code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Is unknown boolean.
     *
     * @return the boolean
     */
    public boolean isUnknown() {
        return code == UNKNOWN_EXCEPTION;
    }


}

