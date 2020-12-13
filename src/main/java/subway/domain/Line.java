package subway.domain;

import exception.AlreadyExistNameException;
import exception.DownLineStationException;
import exception.NoExistStationNameException;
import exception.UpLineStationException;
import input.Input;

import java.util.ArrayList;
import java.util.List;

public class Line {
    public final static String UP_LINE_NAME = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    public final static String DOWN_LINE_NAME = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";

    private String name;

    private final List<Station> lineStations = new ArrayList<>();

    public Line(String name) {
        if (!LineRepository.isLine(name)) {
            throw new AlreadyExistNameException();
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Station> getLineStations() {
        return lineStations;
    }

    // 추가 기능 구현
    public void addLineStation(Station station) {
        if (StationRepository.isStation(station.getName())) {
            throw new NoExistStationNameException();
        }
        if (!checkLineStation(station.getName())) {
            throw new AlreadyExistNameException();
        }
        station.setLines(this.name);
        lineStations.add(station);
    }

    public void addLineStation(int index, Station station) {
        if (StationRepository.isStation(station.getName())) {
            throw new NoExistStationNameException();
        }
        if (!checkLineStation(station.getName())) {
            throw new AlreadyExistNameException();
        }
        if (index == lineStations.size()) {
            throw new DownLineStationException();
        }
        if (index == 0) {
            throw new UpLineStationException();
        }
        station.setLines(this.name);
        lineStations.add(index, station);
    }

    public void deleteLineStation(String name) {
        Station deleteStation = StationRepository.getStation(name);

        if (checkLineStation(name))
            throw new NoExistStationNameException();
        deleteStation.deleteLines(this.name);
        lineStations.remove(deleteStation);
    }

    public void deleteLineNameInStation(String name) {
        for (Station station : lineStations) {
            station.deleteLines(name);
        }
    }


    public void makeLine(Input input) {
        System.out.println(UP_LINE_NAME);
        this.addLineStation(StationRepository.getStation(input.inputStationName()));
        System.out.println(DOWN_LINE_NAME);
        this.addLineStation(StationRepository.getStation(input.inputStationName()));
        LineRepository.addLine(this);
    }

    private boolean checkLineStation(String name) {
        for (Station station : lineStations) {
            if (station.getName().equals(name))
                return false;
        }
        return true;
    }
}
