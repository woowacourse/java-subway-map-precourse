package subway.exception;

public class AttemptToDeleteDependentObjectException extends RuntimeException {

    public AttemptToDeleteDependentObjectException(String message) {
        super(message);
    }

}
