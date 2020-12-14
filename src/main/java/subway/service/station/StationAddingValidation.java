package subway.service.station;

import subway.repository.StationRepository;
import subway.service.abstraction.validation.NameAddingValidationInterface;
import subway.type.BoundaryType;
import subway.type.CheckType;
import subway.view.output.station.StationExceptionView;

import java.util.List;

public class StationAddingValidation implements NameAddingValidationInterface {
    @Override
    public boolean checkNameDuplication(String stationName) {
        List<String> stationNames = StationRepository.stationNames();
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
    public boolean checkAddingValidation(String stationName) {
        if (checkNameDuplication(stationName)) {
            StationExceptionView.printInvalidStationNameException();
            return false;
        }
        if (!checkNameLength(stationName)) {
            StationExceptionView.printInvalidStationNameLengthException();
            return false;
        }
        if (!checkNameLastCharacter(stationName)) {
            StationExceptionView.printInvalidStationNameLastCharacterException();
            return false;
        }
        return true;
    }
}
