package subway.service.station.addition;

public interface StationAdditionValidationInterface {
    boolean checkNameAdditionValidation(String name);
    boolean checkNameDuplication(String name);
    boolean checkNameLength(String name);
    boolean checkNameLastCharacter(String name);
}
