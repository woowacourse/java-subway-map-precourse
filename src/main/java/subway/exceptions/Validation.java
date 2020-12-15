package subway.exceptions;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.List;

public class Validation {
    private final String NAMING_RULE = "이름은 두 글자 이상 입력해야 합니다.";
    private final String LINE_CHECKER = "호선";
    private final String LINE_NAMING_RULE = "OO호선 형태로 입력해야 합니다.";
    private final String NULL_STATION = "등록되지 않은 역입니다.";
    private final String NULL_LINE = "등록되지 않은 노선입니다.";
    private final String STATION_DUPLICATION = "이미 등록된 역입니다.";
    private final String LINE_DUPLICATION = "이미 등록된 노선입니다.";
    private final String SECTION_DUPLICATION = "이미 등록된 구간입니다.";
    private final String ORDER_NUMBER_RULE = "1 이상의 숫자만 입력할 수 있습니다.";
    private final String OPTION_RULE = "올바른 번호를 입력해 주세요.";
    private final String[] OPTION_INPUT_MAIN = {"1", "2", "3", "Q", "q"};
    private final String[] OPTION_INPUT_STATION_LINE = {"1", "2", "3", "B", "b"};
    private final String[] OPTION_INPUT_SECTION = {"1", "2", "B", "b"};



    public void stationNameValidation(String name) throws SubwayException {
        if (name.length() < 2) {
            throw new SubwayException(NAMING_RULE);
        }
    }

    public void lineNameValidation(String name) throws SubwayException {
        if (!name.substring(name.length() - 2, name.length()).equals(LINE_CHECKER)) {
            throw new SubwayException(LINE_NAMING_RULE);
        }
        if (name.length()-2 < 2) {
            throw new SubwayException(NAMING_RULE);
        }
    }

    public Station isExistStation(String name) throws SubwayException {
        List<Station> stations = StationRepository.getStations();
        return stations.stream()
                .filter(station -> station.getName().equals(name))
                .findFirst().orElseThrow(() -> new SubwayException(NULL_STATION));
    }

    public Line isExistLine(String name) throws SubwayException {
        List<Line> lines = LineRepository.getLines();
        return lines.stream()
            .filter(line -> line.getName().equals(name))
            .findFirst().orElseThrow(() -> new SubwayException(NULL_LINE));
    }

    public void stationDuplication(String name) {

    }

    public void orderIsNumber(String input) throws SubwayException {
        for (int i=0; i<input.length(); i++) {
            char temp = input.charAt(i);
            if (!Character.isDigit(temp)) {
                throw new SubwayException(ORDER_NUMBER_RULE);
            }
        }
        if (Integer.parseInt(input) < 0) {
            throw new SubwayException(ORDER_NUMBER_RULE);
        }
    }

    public void mainOptionValidation(String input) throws SubwayException {
        if (Arrays.stream(OPTION_INPUT_MAIN).noneMatch(input::equals)) {
            throw new SubwayException(OPTION_RULE);
        }
    }

    public void stationLineOptionValidation(String input) throws SubwayException {
        if (Arrays.stream(OPTION_INPUT_STATION_LINE).noneMatch(input::equals)) {
            throw new SubwayException(OPTION_RULE);
        }
    }

    public void sectionOptionValidation(String input) throws SubwayException {
        if (Arrays.stream(OPTION_INPUT_SECTION).noneMatch(input::equals)) {
            throw new SubwayException(OPTION_RULE);
        }
    }
}
