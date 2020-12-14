package subway.service.abstraction;

public interface DeletionValidationInterface {
    boolean checkNameInTransitMap(String name);
    boolean checkDeletionValidation(String name);
}
