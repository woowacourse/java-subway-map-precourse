package subway.domain;

import exception.AlreadyExistNameException;
import exception.DownLineStationException;
import exception.NoExistStationNameException;
import exception.UpLineStationException;
import input.Input;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    public final static String ENROLL_LINE_NAME = "## 등록할 노선 이름을 입력하세요.";
    public final static String UP_LINE_NAME = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    public final static String DOWN_LINE_NAME = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";

    private String name;

    private static final List<Station> lineStations = new ArrayList<>();

    public Line(String name) {
        if(!LineRepository.isLine(name)){
            throw new AlreadyExistNameException();
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Station> getLineStations(){
        return lineStations;
    }

    // 추가 기능 구현
    public void addLineStation(Station station){
        if (StationRepository.isStation(station.getName())){
            throw new NoExistStationNameException();
        }if(!checkLineStation(station.getName())){
            throw new AlreadyExistNameException();
        }
        lineStations.add(station);
    }

    public void addLineStation(int index, Station station){
        if (!StationRepository.isStation(station.getName())){
            throw new NoExistStationNameException();
        }
        if(checkLineStation(station.getName())){
            throw new AlreadyExistNameException();
        }
        if(index == lineStations.size()){
            throw new DownLineStationException();
        }
        if(index == 0){
            throw new UpLineStationException();
        }
        lineStations.add(index, station);
    }

    public boolean deleteLineStation(String name){
        if(checkLineStation(name))
            throw new NoExistStationNameException();
        return lineStations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public void makeLine(Input input){
        System.out.println(UP_LINE_NAME);
        this.addLineStation(new Station(input.inputStationName())); // 있는 역에서 넣어야하기 때문에 변경이 필요함.
        System.out.println(DOWN_LINE_NAME);
        this.addLineStation(new Station(input.inputStationName())); // 있는 역에서 넣어야하기 때문에 변경이 필요함.
        LineRepository.addLine(this);
    }

    private boolean checkLineStation(String name){
        for(Station station : lineStations){
            if(station.getName().equals(name))
                return false;
        }
        return true;
    }
}
