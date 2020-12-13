package subway.service.validation;

import subway.repository.StationRepository;
import subway.repository.TransitMapRepository;
import subway.service.abstraction.validation.NameDeletionValidationInterface;
import subway.view.output.station.StationExceptionView;

import java.util.LinkedList;
import java.util.List;

public class NameDeletionValidation implements NameDeletionValidationInterface {
    @Override
    public boolean checkNameInTransitMap(String stationName) {
        List<LinkedList<String>> transitMapsStationsNames
                = TransitMapRepository.transitMapsStationNames();

        for (LinkedList<String> transitMapStationNames : transitMapsStationsNames) {
            if (transitMapStationNames.contains(stationName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkDeletionValidation(String stationName) {
        if (checkNameInTransitMap(stationName)) {
            StationExceptionView.printInvalidStationNameInTransitMapException();
            return false;
        }
        if (!StationRepository.deleteStation(stationName)) {
            StationExceptionView.printInvalidStationNameExistenceException();
            return false;
        }
        return true;
    }
}
