package subway.service.line.deletion;

import subway.repository.LineRepository;
import subway.service.station.deletion.StationDeletionValidation;
import subway.view.output.line.LineExceptionView;

/**
 * LineDeletionValidation.java : 지하철 노선 삭제 로직 검증에 대한 클래스
 *
 * @author Daeun Lee
 * @version 1.0
 */
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
