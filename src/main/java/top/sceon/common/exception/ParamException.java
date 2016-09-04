package top.sceon.common.exception;

/**
 * @author zhou_wei
 * @date 9/4/2016
 */
public class ParamException extends Exception {

    private static final long serialVersionUID = 4356713523675528116L;

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

}
