package subway.service.line;

import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.service.abstraction.validation.NameAddingValidationInterface;
import subway.type.BoundaryType;
import subway.type.CheckType;
import subway.view.output.line.LineExceptionView;

import java.util.List;

public class LineNameAddingValidation implements NameAddingValidationInterface {
    @Override
    public boolean checkNameDuplication(String lineName) {
        List<String> lineNames = LineRepository.lineNames();
        return lineNames.contains(lineName);
    }

    @Override
    public boolean checkNameLength(String lineName) {
        return lineName.length() >= BoundaryType.NAME_LENGTH_BOUNDARY.getBoundary();
    }

    @Override
    public boolean checkNameLastCharacter(String lineName) {
        String lastCharacter = lineName.substring(lineName.length() - 1);
        return lastCharacter.equals(CheckType.LINE_CHECK.getCheck());
    }

    @Override
    public boolean checkAddingValidation(String lineName) {
        if (checkNameDuplication(lineName)) {
            LineExceptionView.printInvalidLineNameException();
            return false;
        }
        if (!checkNameLength(lineName)) {
            LineExceptionView.printInvalidLineNameLengthException();
            return false;
        }
        if (!checkNameLastCharacter(lineName)) {
            LineExceptionView.printInvalidLineNameLastCharacterException();
            return false;
        }
        return true;
    }

    public static boolean checkExistingStationNames(String upStationName, String downStationName) {
        List<String> stationNames = StationRepository.stationNames();
        return (stationNames.contains(upStationName)) && (stationNames.contains(downStationName));
    }

    public static boolean checkSameStationNames(String upStationName, String downStationName) {
        return upStationName.equals(downStationName);
    }

    public boolean checkStationNamesAddingValidation(String upStationName, String downStationName) {
        if (!checkExistingStationNames(upStationName, downStationName)) {
            LineExceptionView.printInvalidLineExistingStationNamesException();
            return false;
        }
        if (checkSameStationNames(upStationName, downStationName)) {
            LineExceptionView.printInvalidLineSameStationNamesException();
            return false;
        }
        return true;
    }
}
