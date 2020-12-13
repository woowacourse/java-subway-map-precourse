package subway.service.abstraction.validation;

public interface NameAddingValidationInterface {
    boolean checkNameDuplication(String name);
    boolean checkNameLength(String name);
    boolean checkNameLastCharacter(String name);
    boolean checkAddingValidation(String name);
}
