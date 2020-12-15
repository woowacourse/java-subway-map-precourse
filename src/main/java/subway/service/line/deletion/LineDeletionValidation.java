package subway.service.line.deletion;

import subway.repository.LineRepository;
import subway.service.station.deletion.StationDeletionValidation;
import subway.view.output.line.LineExceptionView;

public class LineDeletionValidation extends StationDeletionValidation {
    @Override
    public boolean checkNameDeletionValidation(String lineName) {
        if (!LineRepository.deleteLineByName(lineName)) {
            LineExceptionView.printInvalidLineNameExistenceException();
            return false;
        }
        return true;
    }
}
