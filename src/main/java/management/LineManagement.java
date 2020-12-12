package management;

import input.Input;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;

public class LineManagement {
    public final static String ENROLL_LINE_NAME = "## 등록할 노선 이름을 입력하세요.";
    public final static String UP_LINE_NAME = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    public final static String DOWN_LINE_NAME = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    public final static String DELETE_LINE_NAME = "## 삭제할 노선 이름을 입력하세요.";
    public final static String LINE_LIST = "## 노선 목록";
    public final static String INFO = "[INFO] ";
    public final static String ENROLL_COMPLETE = "지하철 노선이 등록되었습니다.";

    public static void lineManagement(String answer, Input input){
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
        //여기 포함 안되면 오류 발생
    }

    private static void insert(Input input){
        System.out.println(ENROLL_LINE_NAME);
        Line line = new Line(input.inputLineName());
        System.out.println(UP_LINE_NAME);
        line.addLineStation(new Station(input.inputStationName())); // 있는 역에서 넣어야하기 때문에 변경이 필요함.
        System.out.println(DOWN_LINE_NAME);
        line.addLineStation(new Station(input.inputStationName())); // 있는 역에서 넣어야하기 때문에 변경이 필요함.
        LineRepository.addLine(line);
        System.out.println(INFO+ENROLL_COMPLETE);
    }

    private static void delete(Input input){
        System.out.println(DELETE_LINE_NAME);
        LineRepository.deleteLineByName(input.inputLineName());
    }

    private static void allList(){
        System.out.println(LINE_LIST);
        for(Line line : LineRepository.lines()){
            System.out.println(INFO + line.getName());
        }
    }
}