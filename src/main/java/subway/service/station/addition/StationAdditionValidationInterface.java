package subway.service.station.addition;

/**
 * StationAdditionValidationInterface.java : 지하철 역 추가 로직 검증에 대한 인터페이스
 *
 * @author Daeun Lee
 * @version 1.0
 */
public interface StationAdditionValidationInterface {
    boolean checkNameAdditionValidation(String name);
    boolean checkNameDuplication(String name);
    boolean checkNameLength(String name);
    boolean checkNameLastCharacter(String name);
}
