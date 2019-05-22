package top.r2ys.strategydemo.exception;

/**
 * @program: strategy-demo
 * @description:
 * @author: HU
 * @create: 2019-05-22 23:06
 */
public class ValidationFailException extends RuntimeException {

    public ValidationFailException(String message) {
        super(message);
    }
}
