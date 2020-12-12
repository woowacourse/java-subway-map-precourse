package subway.domain.input;

import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.*;

public class StationManageInput {

    final String FUNCTION_ONE = "1";
    static final String FUNCTION_TWO = "2";
    static final String FUNCTION_THREE = "3";
    static final String FUNCTION_BACK = "B";
    static final int MIN_STATION_NAME_LENGTH = 2;
    static final String STATION_NAME_SUFFIX = "역";

    List<String> functionList = new ArrayList<>();

    public List<String> functionList() {
        functionList.add(FUNCTION_ONE);
        functionList.add(FUNCTION_TWO);
        functionList.add(FUNCTION_THREE);
        functionList.add(FUNCTION_BACK);
        return Collections.unmodifiableList(functionList);
    }

    public String inputStationManageScreen(Scanner scanner) throws IllegalArgumentException{
        String stationManageChoice = scanner.next();
        if (functionList().contains(stationManageChoice)) {
            return stationManageChoice;
        }
        // 정해진 것만 입력하라는 메시지
        throw new IllegalArgumentException();
    }

    public String validateStationName(String stationName) {
        if (stationName.length() < MIN_STATION_NAME_LENGTH) {
            //2자 이상 입력하라는 메시지
            throw new IllegalArgumentException();
        }
        if (!stationName.endsWith(STATION_NAME_SUFFIX)) {
            //마지막 글자는 "역" 으로 입력하라는 메시지
            throw new IllegalArgumentException();
        }
        return stationName;
    }

    public String inputEnrollStation(Scanner scanner) throws IllegalArgumentException{
        String stationName = scanner.next();
        Optional<Station> newStation = StationRepository.stations()
                .stream().filter(station -> station.getName().equals(stationName)).findAny();
        if (newStation.isPresent()) {
            //해당 역 이름이 존재한다는 메시지
            throw new IllegalArgumentException();
        }
        validateStationName(stationName);
        return stationName;
    }

    public boolean isFixedStation(String stationName) {
        Optional<Station> fixedStation = StationRepository.fixedStations()
                .stream().filter(station -> station.getName().equals(stationName)).findAny();
        return fixedStation.isPresent();
    }

    public String inputDeleteStation(Scanner scanner) throws IllegalArgumentException{
        String stationName = scanner.next();
        Optional<Station> searchedStation = StationRepository.stations()
                .stream().filter(station -> station.getName().equals(stationName)).findAny();
        if (searchedStation.isPresent()) {
            if (isFixedStation(stationName)) {
                //삭제할 수 없는 역이라는 메시지
                throw new IllegalArgumentException();
            }
            return stationName;
        }
        //해당 역은 존재하지 않는다는 메시지
        throw new IllegalArgumentException();
    }

}
