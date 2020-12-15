package subway.service.line.addition;

import subway.domain.Stations;
import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.service.station.addition.StationAdditionValidation;
import subway.type.BoundaryType;
import subway.type.CheckType;
import subway.view.output.line.LineExceptionView;

import java.util.List;

/**
 * LineAdditionValidation.java : 지하철 노선 추가 로직 검증에 대한 클래스
 *
 * @author Daeun Lee
 * @version 1.0
 */
public class LineAdditionValidation extends StationAdditionValidation {
    public boolean checkNameAdditionValidation(String lineName, Stations stations) {
        if (!checkLineNameAdditionValidation(lineName)) {
            return false;
        }
        return checkStationNamesAdditionValidation(
                stations.getUpStationName(),stations.getDownStationName());
    }

    public boolean checkLineNameAdditionValidation(String lineName) {
        if (checkNameDuplication(lineName)) {
            LineExceptionView.printInvalidLineNameException();
            return false;
        }
        if (checkNameLength(lineName)) {
            LineExceptionView.printInvalidLineNameLengthException();
            return false;
        }
        if (checkNameLastCharacter(lineName)) {
            LineExceptionView.printInvalidLineNameLastCharacterException();
            return false;
        }
        return true;
    }

    @Override
    public boolean checkNameDuplication(String lineName) {
        List<String> lineNames = LineRepository.lineNames();
        return lineNames.contains(lineName);
    }

    @Override
    public boolean checkNameLength(String lineName) {
        return lineName.length() < BoundaryType.NAME_LENGTH_BOUNDARY.getBoundary();
    }

    @Override
    public boolean checkNameLastCharacter(String lineName) {
        String lastCharacter = lineName.substring(lineName.length() - 1);
        return !lastCharacter.equals(CheckType.LINE_CHECK.getCheck());
    }

    public boolean checkStationNamesAdditionValidation(String upStationName, String downStationName) {
        if (checkStationNamesExistence(upStationName, downStationName)) {
            LineExceptionView.printInvalidLineStationNamesExistenceException();
            return false;
        }
        if (checkSameStationNames(upStationName, downStationName)) {
            LineExceptionView.printInvalidLineSameStationNamesException();
            return false;
        }
        return true;
    }

    public static boolean checkStationNamesExistence(String upStationName, String downStationName) {
        List<String> stationNames = StationRepository.stationNames();
        return !((stationNames.contains(upStationName)) && (stationNames.contains(downStationName)));
    }

    public static boolean checkSameStationNames(String upStationName, String downStationName) {
        return upStationName.equals(downStationName);
    }
}
