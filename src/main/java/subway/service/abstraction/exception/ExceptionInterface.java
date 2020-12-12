package subway.service.abstraction.exception;

public interface ExceptionInterface {
    boolean checkNameDuplication(String name);
    boolean checkNameLength(String name);
}
