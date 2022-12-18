package smart.ix.exception;

import javax.ws.rs.ClientErrorException;

public class BadRequestException extends ClientErrorException {
    public BadRequestException() {
        super(400);
    }

    public BadRequestException(String reason) {
        super(reason,400);
    }

    public BadRequestException(String reason, Throwable cause) {
        super(reason, 400, cause);
    }
}

