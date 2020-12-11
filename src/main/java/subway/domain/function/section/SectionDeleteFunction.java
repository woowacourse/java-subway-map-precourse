package subway.domain.function.section;

import java.util.Scanner;
import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.domain.function.Function;
import subway.view.InputView;
import subway.view.OutputView;

public class SectionDeleteFunction extends Function {
    @Override
    public void operateFunction(Scanner scanner) {
        String lineName = InputView.inputLineNameToDeleteSection(scanner);
        String stationName = InputView.inputStationNameInLineToDelete(scanner);
        LineRepository.deleteStation(lineName, stationName);
        OutputView.printSuccessToDeleteSection();
    }
}
