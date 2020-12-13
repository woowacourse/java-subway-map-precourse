package subway.service.line;

import subway.repository.LineRepository;
import subway.service.station.StationNameDeletionValidation;
import subway.view.output.line.LineExceptionView;

public class LineNameDeletionValidation extends StationNameDeletionValidation {
    @Override
    public boolean checkDeletionValidation(String lineName) {
        if (!LineRepository.deleteLineByName(lineName)) {
            LineExceptionView.printInvalidLineNameExistenceException();
            return false;
        }
        return true;
    }
}
