package subway.service.validation;

import subway.repository.StationRepository;
import subway.service.abstraction.validation.NameAddingValidationInterface;
import subway.type.BoundaryType;
import subway.type.CheckType;
import subway.view.output.ExceptionView;

import java.util.List;

public class NameAddingValidation implements NameAddingValidationInterface {
    @Override
    public boolean checkNameDuplication(String stationName) {
        List<String> stationNames = StationRepository.getStationNames();
        return stationNames.contains(stationName);
    }

    @Override
    public boolean checkNameLength(String stationName) {
        return stationName.length() >= BoundaryType.NAME_LENGTH_BOUNDARY.getBoundary();
    }

    @Override
    public boolean checkNameLastCharacter(String stationName) {
        String lastCharacter = stationName.substring(stationName.length() - 1);
        return lastCharacter.equals(CheckType.STATION_CHECK.getCheck());
    }

    @Override
    public boolean checkValidation(String stationName) {
        if (checkNameDuplication(stationName)) {
            ExceptionView.printInvalidStationNameException();
            return false;
        }
        if (!checkNameLength(stationName)) {
            ExceptionView.printInvalidStationNameLengthException();
            return false;
        }
        if (!checkNameLastCharacter(stationName)) {
            ExceptionView.printInvalidStationNameLastCharacter();
            return false;
        }
        return true;
    }
}
