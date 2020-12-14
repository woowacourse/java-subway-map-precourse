package subway.domain;

import subway.controller.Controller;
import subway.view.ErrorView;
import subway.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Line {
    private static final int MINIMUM_LENGTH = 2;
    private static final int ERROR = -1;
    private String name;
    private List<Station> stations = new ArrayList<>();

    public Line(String name) {
        if(name.length() < MINIMUM_LENGTH){
            return;
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

// 추가 기능 구현
    public void addStations(String[] stationNames){
        for(String station : stationNames){
            stations.add(new Station(station));
        }
    }

    public List<Station> getStations() {
        return stations;
    }

    public boolean existStation(String name) {
        for(Station station : stations){
            if(station.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    public boolean addStation(String stationName) {
        if(stationName.length() < MINIMUM_LENGTH){
            ErrorView.nameLengthError();
            return false;
        }
        stations.add(StationRepository.ifNotExistRegister(stationName));
        return true;
    }

    public void status() {
        for(Station station : stations){
            OutputView.status(station.getName());
        }
        OutputView.space();
    }

    public boolean addStationByIndex(String stationName, Scanner scanner) {
        if(stationName.length() < MINIMUM_LENGTH){
            ErrorView.nameLengthError();
            return false;
        }
        if(duplicateName(stationName)){
            return false;
        }
        OutputView.writeOrderNumber();
        int orderNumber = orderNumber(scanner.next());
        if(orderNumber == ERROR){
            return false;
        }
        stations.add(orderNumber,StationRepository.ifNotExistRegister(stationName));
        return true;
    }

    private boolean duplicateName(String name) {
        for(Station station : stations){
            if(station.getName().equals(name)){
                ErrorView.duplicateName();
                return true;
            }
        }
        return false;
    }

    private int orderNumber(String stringNumber) {
        if(!isDigit(stringNumber)){
            return ERROR;
        }
        int orderNumber = Integer.parseInt(stringNumber);
        if(orderNumber == 0 || orderNumber > stations.size()){
            return ERROR;
        }
        return orderNumber-1;
    }

    private boolean isDigit(String stringNumber) {
        int length = stringNumber.length();
        for(int i=0;i<length;i++){
            if(!Character.isDigit(stringNumber.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public boolean deleteStation(String stationName) {
        int length = stations.size();
        for(int i=0;i<length;i++){
            if(stations.get(i).getName().equals(stationName)){
                stations.remove(i);
                return true;
            }
        }
        ErrorView.notExistName();
        return false;
    }
}
