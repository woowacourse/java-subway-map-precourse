package subway.domain;

import subway.view.ErrorView;

import java.util.LinkedList;
import java.util.Objects;
import java.util.regex.Pattern;

public class Line {

    public static final int LINE_NAME_LENGTH_MINIMUM = 2;
    private String name;
    private LinkedList<Station> line = new LinkedList<>();

    public Line(String name) {
        validateLine(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Line addTerminus(String upBoundTerminus, String downBoundTerminus) {
        validateTerminus(upBoundTerminus);
        validateTerminus(downBoundTerminus);
        line.addFirst(StationRepository.findStation(upBoundTerminus));
        line.addLast(StationRepository.findStation(downBoundTerminus));
        return this;
    }

    public void addSection(int sequence, Station station) {
        stations().add(sequence, station);
    }

    public boolean removeSection(String stationName) {
        return line.removeIf(station -> Objects.equals(station.getName(), stationName));
    }

    public boolean sectionExists(String name) {
        return stations().stream()
                .filter(station -> station.getName().equals(name))
                .findFirst()
                .isPresent();
    }

    public int lineLength() {
        return line.size();
    }

    public LinkedList<Station> stations() {
        return line;
    }

    public void validateLine(String name) {
        String regExp = "^[a-zA-Z가-힣0-9]*[선|line|Line|LINE]$";

        if (LineRepository.exists(name)) {
            throw new IllegalArgumentException(ErrorView.ALREADY_EXIST_LINE);
        }
        if (name.length() < LINE_NAME_LENGTH_MINIMUM) {
            throw new IllegalArgumentException(ErrorView.AT_LEAST_TWO_LETTERS_LINE);
        }
        if (!Pattern.matches(regExp, name)) {
            throw new IllegalArgumentException(ErrorView.NAME_FORM_LINE);
        }
    }

    public void validateTerminus(String name) {
        String regExp = "^[a-zA-Z가-힣0-9]*[역|station|Station|STATION]$";

        if (!StationRepository.exists(name)) {
            throw new IllegalArgumentException(ErrorView.NO_EXIST_STATION);
        }
        if (name.length() < LINE_NAME_LENGTH_MINIMUM) {
            throw new IllegalArgumentException(ErrorView.AT_LEAST_TWO_LETTERS_STATION);
        }
        if (!Pattern.matches(regExp, name)) {
            throw new IllegalArgumentException(ErrorView.NAME_FORM_STATION);
        }
    }
}
