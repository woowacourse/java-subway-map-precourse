package subway.service.line;

import subway.repository.LineRepository;
import subway.service.station.StationDeletionValidation;
import subway.view.output.line.LineExceptionView;

public class LineDeletionValidation extends StationDeletionValidation {
    @Override
    public boolean checkDeletionValidation(String lineName) {
        if (!LineRepository.deleteLineByName(lineName)) {
            LineExceptionView.printInvalidLineNameExistenceException();
            return false;
        }
        return true;
    }
}
