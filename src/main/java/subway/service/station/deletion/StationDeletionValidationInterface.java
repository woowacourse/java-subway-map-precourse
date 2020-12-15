package subway.service.station.deletion;

/**
 * StationDeletionValidationInterface.java : 지하철 역 삭제 로직 검증에 대한 인터페이스
 *
 * @author Daeun Lee
 * @version 1.0
 */
public interface StationDeletionValidationInterface {
    boolean checkNameDeletionValidation(String name);
    boolean checkNameInTransitMap(String name);
}
