package subway.domain.function.line;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.function.Function;
import subway.view.InputView;
import subway.view.OutputView;

public class LineCreateFunction extends Function {
    @Override
    public void operateFunction(Scanner scanner) {
        String lineName = InputView.inputLineName(scanner);
        String UpwardTerminalStationName = InputView.inputUpwardTerminalStationName(scanner);
        String DownwardTerminalStationName = InputView.inputDownwardTerminalStationName(scanner);
        LineRepository.addLine(new Line(lineName, new ArrayList<Station>(Arrays.asList(
            new Station(UpwardTerminalStationName),
            new Station(DownwardTerminalStationName))
        )));
        OutputView.printSuccessToCreateLine();
    }
}
