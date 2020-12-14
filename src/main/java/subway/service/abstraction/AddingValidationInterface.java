package subway.service.abstraction;

public interface AddingValidationInterface {
    boolean checkAddingValidation(String name);
    boolean checkNameDuplication(String name);
    boolean checkNameLength(String name);
    boolean checkNameLastCharacter(String name);
}
