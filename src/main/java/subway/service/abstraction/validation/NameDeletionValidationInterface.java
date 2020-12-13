package subway.service.abstraction.validation;

public interface NameDeletionValidationInterface {
    boolean checkNameInTransitMap(String name);
    boolean checkDeletionValidation(String name);
}
