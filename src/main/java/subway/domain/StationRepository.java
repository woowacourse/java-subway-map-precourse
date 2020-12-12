package subway.domain;

import subway.view.OutputView;

import java.util.*;

public class StationRepository {
    private static final String DUPLICATE_ERROR="이미 등록된 역 이름입니다.";
    private static final String NAME_LENGTH_ERROR="지하철 역 이름은 2글자 이상이어야 한다.";
    private static final List<Station> stations = new LinkedList<>();
    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static boolean addStation(Station station) {
        if(!station.isValidStationName()){
            OutputView.printError(NAME_LENGTH_ERROR);
            return false;
        }
        if(isDuplicate(station.getName())){
            OutputView.printError(DUPLICATE_ERROR);
            return false;
        }
        stations.add(station);
        return true;
    }

    private static boolean isDuplicate(String name){
        return stations.stream().anyMatch(station -> station.getName().equals(name));
    }

    public static boolean deleteStation(String name) {
        boolean hasStation=LineRepository.lines()
                .stream()
                .anyMatch(line -> line.hasStation(name));
        if(hasStation){
            return false;
        }
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static void deleteAll(){
        stations.clear();
    }

    public static void printAllStation(){
        stations.forEach(station -> OutputView.printInfo(station.getName()));
    }
}
