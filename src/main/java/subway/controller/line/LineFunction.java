package subway.controller.line;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.domain.exception.*;
import subway.utils.InputValidator;
import subway.view.InputView;
import subway.view.outputview.LineOutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class LineFunction {
    public static LineRepository add(LineRepository lineRepository) {
        try {
            String line = inputLine(lineRepository);
            lineRepository.addLine(inputStations(line, lineRepository));
        } catch (NullPointerException e) {
            return null;
        }
        return lineRepository;
    }

    private static String inputLine(LineRepository lineRepository) {
        try {
            LineOutputView.registerLineName();
            String line = InputView.input();
            InputValidator.validLineName(line);
            lineRepository.duplicateLineName(line);
            return line;
        } catch (InvalidLineNameException | DuplicateLineNameException e) {
            throw new NullPointerException();
        }
    }

    private static Line inputStations(String line, LineRepository lineRepository) {
        try {
            String firstStation = inputFirstStation(line, lineRepository);
            String lastStation = inputLastStation(line, lineRepository);


            isDuplicateStations(firstStation, lastStation);
            return new Line(line, new ArrayList<>(Arrays.asList(firstStation, lastStation)));
        } catch (NullPointerException e) {
            throw new NullPointerException();
        }
    }

    private static String inputFirstStation(String line, LineRepository lineRepository) {
        try {
            LineOutputView.firstLineName();
            String firstStation = InputView.input();
            InputValidator.validStationName(firstStation);
            StationRepository.notExistStationName(firstStation);
            lineRepository.duplicateStationSelectLine(firstStation, line);
            return firstStation;
        } catch (DuplicateFirstLastStationException | DuplicateStationOfLineException |
                NotExistStationException | InvalidStationNameException e) {
            throw new NullPointerException();
        }
    }

    private static String inputLastStation(String line, LineRepository lineRepository) {
        try {
            LineOutputView.lastLineName();
            String lastStation = InputView.input();
            InputValidator.validStationName(lastStation);
            StationRepository.notExistStationName(lastStation);
            lineRepository.duplicateStationSelectLine(lastStation, line);
            return lastStation;
        } catch (DuplicateFirstLastStationException | DuplicateStationOfLineException |
                NotExistStationException | InvalidStationNameException e) {
            throw new NullPointerException();
        }
    }

    private static void isDuplicateStations(String firstStation, String lastStation) {
        if (Objects.equals(firstStation, lastStation)) {
            throw new DuplicateFirstLastStationException();
        }
    }

    public static LineRepository delete(LineRepository lineRepository) {
        return null;
    }

    public static LineRepository printAll(LineRepository lineRepository) {
        LineOutputView.showAllLines(lineRepository.lines());
        return null;
    }
}
