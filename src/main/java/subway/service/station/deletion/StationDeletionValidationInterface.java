package subway.service.station.deletion;

public interface StationDeletionValidationInterface {
    boolean checkNameDeletionValidation(String name);
    boolean checkNameInTransitMap(String name);
}
