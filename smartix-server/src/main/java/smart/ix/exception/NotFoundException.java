package smart.ix.exception;

import javax.ws.rs.ClientErrorException;

public class NotFoundException extends ClientErrorException {
    public NotFoundException() {
        super(404);
    }

    public NotFoundException(String reason) {
        super(reason,404);
    }

    public NotFoundException(String reason, Throwable cause) {
        super(reason,404,cause);
    }
}

