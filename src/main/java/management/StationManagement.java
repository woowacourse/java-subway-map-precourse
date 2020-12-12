package management;

import input.Input;
import subway.domain.Station;
import subway.domain.StationRepository;

public class StationManagement {
    public final static String ENROLL_STATION_NAME = "등록할 역 이름을 입력하세요.";
    public final static String DELETE_STATION_NAME = "삭제할 역 이름을 입력하세요.";
    public final static String INFO = "[INFO] ";

    public static void stationManagement(String answer, Input input){
        if(answer.equals("1")){
            insert(input);
        }
        if(answer.equals("2")){
            delete(input);
        }
        if(answer.equals("3")){
            allList();
        }
        if(answer.equals("B")){
            //
        }
        //나머지면은 오류 발생.
    }

    private static void insert(Input input){
        System.out.println(ENROLL_STATION_NAME);
        StationRepository.addStation(new Station(input.inputStationName()));
    }

    private static void delete(Input input){
        System.out.println(DELETE_STATION_NAME);
        StationRepository.deleteStation(input.inputStationName());
    }

    private static void allList(){
        //리스트가 없으면 말해주기
        for(Station station : StationRepository.stations()){
            System.out.println(INFO + station.getName());
        }
        System.out.println();
    }
}
