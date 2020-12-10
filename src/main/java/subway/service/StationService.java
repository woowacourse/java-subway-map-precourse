package subway.service;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class StationService {
    private static final String SELECT_STATION_TEXT="## 역 목록";
    private static final String DELETE_STATION_ERROR_TEXT="삭제할 수 없습니다.";
    private static final String INSERT_SUCCESS="지하철 역이 등록되었습니다.";
    private static final String DELETE_SUCCESS="지하철 역이 삭제되었습니다.";
    private static StationService stationService;

    private StationService(){}

    public static StationService getInstance(){
        if(stationService==null){
            stationService=new StationService();
        }
        return stationService;
    }

    public boolean insert(){
        String name=InputView.getStationName();
        Station station=new Station(name);
        boolean result=StationRepository.addStation(station);
        if(result){
            OutputView.printInfo(INSERT_SUCCESS);
            System.out.println();
        }
        return result;
    }

    public boolean delete(){
        String name=InputView.getDeleteStationName();
        boolean result=StationRepository.deleteStation(name);
        if(!result){
            OutputView.printError(DELETE_STATION_ERROR_TEXT);
        }
        if(result){
            OutputView.printInfo(DELETE_SUCCESS);
            System.out.println();
        }
        return result;
    }

    public boolean find(){
        System.out.println(SELECT_STATION_TEXT);
        StationRepository.printAllStation();
        System.out.println();
        return true;
    }

    public boolean back(){
        return true;
    }
}
