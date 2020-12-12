package subway.service.validation;

import subway.repository.StationRepository;
import subway.service.abstraction.exception.ExceptionInterface;
import subway.type.BoundaryType;

import java.util.List;

public class StationValidation implements ExceptionInterface {
    @Override
    public boolean checkNameDuplication(String stationName) {
        List<String> stationNames = StationRepository.getStationNames();
        return stationNames.contains(stationName);
    }

    @Override
    public boolean checkNameLength(String stationName) {
        return stationName.length() < BoundaryType.NAME_LENGTH_BOUNDARY.getBoundary();
    }
}
