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
    private static final String NAME_LENGTH_ERROR="노선 이름은 2글자 이상입니다.";
    private static final String STATION_NAME_LENGTH_ERROR="지하철 역 이름은 2글자 이상이어야 한다.";
    private static final String NOT_EXIST_LINE_NAME="존재하지 않는 노선 이름입니다.";
    private static final String INVALID_ORDER="잘못된 순서 입력입니다.";
    private static final Integer MIN_STATION_SIZE=2;
    private static final Integer MIN_LINE_SIZE=2;
    private static final int START_NUMBER=48;
    private static final int END_NUMBER=57;
    private static LineService lineService;
    private String lineName;
    private String stationName;
    private String order;
    private String upwardLineName;
    private String downLineName;
    private LineService(){}

    public static LineService getInstance(){
        if(lineService==null){
            lineService=new LineService();
        }
        return lineService;
    }

    public boolean insert(){
        if(!lineInsertInput()){
            return false;
        }
        Line line=new Line(lineName);
        line.addAllStation(upwardLineName,downLineName);
        boolean result=LineRepository.addLine(line);
        OutputView.printResult(result,INSERT_SUCCESS);
        return result;
    }

    private boolean lineInsertInput(){
        if((lineName=InputView.getLineName()).length()<MIN_LINE_SIZE){
            OutputView.printError(NAME_LENGTH_ERROR);
            return false;
        }
        if((upwardLineName=InputView.getUpwardStationName()).length()<MIN_STATION_SIZE){
            OutputView.printError(STATION_NAME_LENGTH_ERROR);
            return false;
        }
        if((downLineName=InputView.getDownStationName()).length()<MIN_STATION_SIZE){
            OutputView.printError(STATION_NAME_LENGTH_ERROR);
            return false;
        }
        return true;
    }

    public boolean delete(){
        String name=InputView.getDeleteLineName();
        boolean result=LineRepository.deleteLineByName(name);
        if(!result){
            OutputView.printError(DELETE_STATION_ERROR_TEXT);
        }
        OutputView.printResult(result,DELETE_SUCCESS);
        return result;
    }

    public boolean printAllStation(){
        System.out.println(SELECT_STATION_TEXT);
        LineRepository.printAllLine();
        System.out.println();
        return true;
    }

    public boolean sectionInsert(){
        if(!isExistLineByName()){
            return false;
        }
        if(!isValidStationNameLength()){
            return false;
        }
        if(!isValidOrder()){
            return false;
        }
        boolean result=LineRepository.findByName(lineName).addStation(Integer.parseInt(order),stationName);
        OutputView.printResult(result,SECTION_INSERT_SUCCESS);
        return result;
    }

    private boolean isExistLineByName(){
        lineName=InputView.getLineName();
        if(!LineRepository.isExistLineByName(lineName)){
            OutputView.printError(NOT_EXIST_LINE_NAME);
            return false;
        }
        return true;
    }

    private boolean isValidStationNameLength(){
        stationName=InputView.getStationName();
        if(stationName.length()<MIN_STATION_SIZE){
            OutputView.printError(STATION_NAME_LENGTH_ERROR);
            return false;
        }
        return true;
    }

    private boolean isValidOrder(){
        order=InputView.getSectionOrder();
        if(isNumber(order)&&Integer.parseInt(order)>0&&Integer.parseInt(order)<LineRepository.findByName(lineName).getStations().size()){
            return true;
        }
        OutputView.printError(INVALID_ORDER);
        return false;
    }

    private boolean isNumber(String number){
        return number.chars().allMatch(this::isDigit);
    }

    private boolean isDigit(int ch){
        return ch>=START_NUMBER&&ch<=END_NUMBER;
    }

    public boolean sectionDelete(){
        String lineName=InputView.getDeleteLineName();
        String stationName=InputView.getDeleteStationName();
        Line findLine=LineRepository.findByName(lineName);
        boolean result=LineRepository.deleteStationByName(findLine,stationName);
        OutputView.printResult(result,SECTION_DELETE_SUCCESS);
        return result;
    }

    public boolean back(){
        return true;
    }
}
