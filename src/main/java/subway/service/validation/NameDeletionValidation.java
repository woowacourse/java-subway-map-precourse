package subway.service.validation;

import subway.repository.StationRepository;
import subway.service.abstraction.validation.NameDeletionValidationInterface;
import subway.view.output.station.StationExceptionView;

public class NameDeletionValidation implements NameDeletionValidationInterface {
    @Override
    public boolean checkNameInTransitMap(String stationName) {

        return false;
    }

    @Override
    public boolean checkDeletionValidation(String stationName) {
        if (!StationRepository.deleteStation(stationName)) {
            StationExceptionView.printInvalidStationNameExistenceException();
            return false;
        }
        return true;
    }
}
