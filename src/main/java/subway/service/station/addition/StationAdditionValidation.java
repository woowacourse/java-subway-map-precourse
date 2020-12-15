package subway.service.station.addition;

import subway.repository.StationRepository;
import subway.type.BoundaryType;
import subway.type.CheckType;
import subway.view.output.station.StationExceptionView;

import java.util.List;

/**
 * StationAdditionValidation.java : 지하철 역 추가 로직 검증에 대한 클래스
 *
 * @author Daeun Lee
 * @version 1.0
 */
public class StationAdditionValidation implements StationAdditionValidationInterface {
    @Override
    public boolean checkNameAdditionValidation(String stationName) {
        if (checkNameDuplication(stationName)) {
            StationExceptionView.printInvalidStationNameException();
            return false;
        }
        if (checkNameLength(stationName)) {
            StationExceptionView.printInvalidStationNameLengthException();
            return false;
        }
        if (checkNameLastCharacter(stationName)) {
            StationExceptionView.printInvalidStationNameLastCharacterException();
            return false;
        }
        return true;
    }

    @Override
    public boolean checkNameDuplication(String stationName) {
        List<String> stationNames = StationRepository.stationNames();
        return stationNames.contains(stationName);
    }

    @Override
    public boolean checkNameLength(String stationName) {
        return stationName.length() < BoundaryType.NAME_LENGTH_BOUNDARY.getBoundary();
    }

    @Override
    public boolean checkNameLastCharacter(String stationName) {
        String lastCharacter = stationName.substring(stationName.length() - 1);
        return !lastCharacter.equals(CheckType.STATION_CHECK.getCheck());
    }
}
