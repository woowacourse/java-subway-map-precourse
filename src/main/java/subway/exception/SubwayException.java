package subway.exception;

import subway.view.TextCollection;

public class SubwayException extends IllegalArgumentException {
    public SubwayException(String message) {
        super(TextCollection.ERROR_TAG + message);
    }
}
