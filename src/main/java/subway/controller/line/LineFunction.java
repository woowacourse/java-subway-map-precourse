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
    public static boolean add() {
        try {
            String line = inputAddLine();
            LineRepository.addLine(inputStations(line));
            LineOutputView.successAdd();
        } catch (NullPointerException e) {
            return false;
        }
        return true;
    }

    private static String inputAddLine() {
        try {
            LineOutputView.registerLineName();
            String line = InputView.input();
            InputValidator.validLineName(line);
            LineRepository.duplicateLineName(line);
            return line;
        } catch (InvalidLineNameException | DuplicateLineNameException e) {
            throw new NullPointerException();
        }
    }

    private static Line inputStations(String line) {
        try {
            String firstStation = inputFirstStation(line);
            String lastStation = inputLastStation(line);
            isDuplicateStations(firstStation, lastStation);
            return new Line(line, new ArrayList<>(Arrays.asList(firstStation, lastStation)));
        } catch (NullPointerException | DuplicateFirstLastStationException e) {
            throw new NullPointerException();
        }
    }

    private static String inputFirstStation(String line) {
        try {
            LineOutputView.firstLineName();
            String firstStation = InputView.input();
            InputValidator.validStationName(firstStation);
            StationRepository.notExistStationName(firstStation);
            LineRepository.duplicateStationSelectLine(firstStation, line);
            return firstStation;
        } catch (DuplicateStationOfLineException |
                NotExistStationException | InvalidStationNameException e) {
            throw new NullPointerException();
        }
    }

    private static String inputLastStation(String line) {
        try {
            LineOutputView.lastLineName();
            String lastStation = InputView.input();
            InputValidator.validStationName(lastStation);
            StationRepository.notExistStationName(lastStation);
            LineRepository.duplicateStationSelectLine(lastStation, line);
            return lastStation;
        } catch (DuplicateStationOfLineException |
                NotExistStationException | InvalidStationNameException e) {
            throw new NullPointerException();
        }
    }

    private static void isDuplicateStations(String firstStation, String lastStation) {
        if (Objects.equals(firstStation, lastStation)) {
            throw new DuplicateFirstLastStationException();
        }
    }

    public static boolean delete() {
        try {
            LineOutputView.deleteLineName();
            String line = InputView.input();
            InputValidator.validLineName(line);
            LineRepository.deleteLineByName(line);
            LineOutputView.successDelete();
        } catch (InvalidLineNameException | NotExistLineException e ){
            return false;
        }
        return true;
    }

    public static LineRepository printAll() {
        LineOutputView.showAllLines(LineRepository.lines());
        return null;
    }
}