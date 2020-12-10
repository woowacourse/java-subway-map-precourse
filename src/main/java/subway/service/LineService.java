package subway.service;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class LineService {
    private static final String SELECT_STATION_TEXT="## 노선 목록";
    private static final String DELETE_STATION_ERROR_TEXT="삭제할 수 없습니다.";
    private static final String INSERT_SUCCESS="지하철 노선이 등록되었습니다.";
    private static final String DELETE_SUCCESS="지하철 노선이 삭제되었습니다.";
    private static final String SECTION_INSERT_SUCCESS="구간이 등록되었습니다.";
    private static final String SECTION_DELETE_SUCCESS="구간이 삭제되었습니다.";
    private static LineService lineService;

    private LineService(){}

    public static LineService getInstance(){
        if(lineService==null){
            lineService=new LineService();
        }
        return lineService;
    }

    public boolean insert(){
        String name= InputView.getLineName();
        String upwardLineName=InputView.getUpwardStationName();
        String downLineName=InputView.getDownStationName();

        Line line=new Line(name);
        line.addAllStation(upwardLineName,downLineName);
        boolean result= LineRepository.addLine(line);
        if(result){
            OutputView.printInfo(INSERT_SUCCESS);
            System.out.println();
        }
        return result;
    }

    public boolean delete(){
        String name=InputView.getDeleteLineName();
        boolean result=LineRepository.deleteLineByName(name);
        if(!result){
            OutputView.printError(DELETE_STATION_ERROR_TEXT);
        }
        if(result){
            OutputView.printInfo(DELETE_SUCCESS);
            System.out.println();
        }
        return result;
    }

    public boolean printAllStation(){
        System.out.println(SELECT_STATION_TEXT);
        LineRepository.printAllLine();
        System.out.println();
        return true;
    }

    public boolean sectionInsert(){
        String lineName=InputView.getLineName();
        String stationName=InputView.getStationName();
        Integer order=InputView.getSectionOrder();

        Line findLine=LineRepository.findByName(lineName);
        boolean result=findLine.addStation(order,stationName);
        if(result){
            OutputView.printInfo(SECTION_INSERT_SUCCESS);
            System.out.println();
        }
        return result;
    }

    public boolean sectionDelete(){
        String lineName=InputView.getDeleteLineName();
        String stationName=InputView.getDeleteStationName();
        Line findLine=LineRepository.findByName(lineName);
        boolean result=LineRepository.deleteStationByName(findLine,stationName);
        if(result){
            OutputView.printInfo(SECTION_DELETE_SUCCESS);
            System.out.println();
        }
        return result;
    }

    public boolean back(){
        return true;
    }
}
