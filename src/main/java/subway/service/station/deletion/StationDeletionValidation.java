package subway.service.station.deletion;

import subway.repository.StationRepository;
import subway.repository.TransitMapRepository;
import subway.view.output.station.StationExceptionView;

import java.util.LinkedList;
import java.util.List;

/**
 * StationDeletionValidation.java : 지하철 역 삭제 로직 검증에 대한 클래스
 *
 * @author Daeun Lee
 * @version 1.0
 */
public class StationDeletionValidation implements StationDeletionValidationInterface {
    @Override
    public boolean checkNameDeletionValidation(String stationName) {
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
}
