package subway.service.abstraction.validation;

public interface NameValidationInterface {
    boolean checkNameDuplication(String name);
    boolean checkNameLength(String name);
    boolean checkNameLastCharacter(String name);
    boolean checkValidation(String name);
}
