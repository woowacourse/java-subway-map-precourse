package subway.model;

public class ResultDto {

    public static final String RESULT_OK_PREFIX = "[INFO] ";
    public static final String RESULT_BAD_PREFIX = "[ERROR] ";

    private final Status status;
    private final String message;
    private String content;

    private ResultDto(Status status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Status getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public static ResultDto ok(String message) {
        return new ResultDto(Status.OK, RESULT_OK_PREFIX + message);
    }

    public static ResultDto bad(Exception e) {
        return new ResultDto(Status.BAD, RESULT_BAD_PREFIX + e.getMessage());
    }
}
