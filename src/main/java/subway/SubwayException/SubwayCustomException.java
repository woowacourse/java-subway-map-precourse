package subway.SubwayException;

public class SubwayCustomException extends Exception {

    private static final String EXCEPTION_PREFIX = "[ERROR] ";

    public SubwayCustomException(String message){
        super(EXCEPTION_PREFIX + message);
    }
}
