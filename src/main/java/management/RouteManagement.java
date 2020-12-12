package management;

import input.Input;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;

public class RouteManagement {
    public final static String INPUT_LINE_NAME = "## 노선을 입력하세요.";
    public final static String INPUT_STATION_NAME = "## 역이름을 입력하세요.";
    public final static String INPUT_ORDER = "## 순서를 입력하세요.";
    public final static String INPUT_DELETE_LINE_NAME = "## 삭제할 구간의 노선을 입력하세요.";
    public final static String INPUT_DELETE_STATION_NAME = "## 삭제할 구간의 역을 입력하세요.";

    private static Line line;

    public static void RouteManagement(String answer, Input input){
        if(answer.equals("1")){
            insert(input);
        }
        if(answer.equals("2")){
            delete(input);
        }
        if(answer.equals("B")){
            //
        }
    }
    private static void insert(Input input){
        findLine(input);
        inputLine(input);
    }

    private static void delete(Input input){
        System.out.println(INPUT_DELETE_LINE_NAME);
        line = LineRepository.getLine(input.inputLineName());
        System.out.println(INPUT_DELETE_STATION_NAME);
        line.deleteLineStation(input.inputStationName());
    }

    private static void findLine(Input input){
        System.out.println(INPUT_LINE_NAME);
        line = LineRepository.getLine(input.inputLineName());
    }

    private static void inputLine(Input input){
        String name;
        int order;
        System.out.println(INPUT_STATION_NAME);
        name = input.inputStationName();
        System.out.println(INPUT_ORDER);
        order = Integer.parseInt(input.inputOrder());
        line.addLineStation(order, new Station(name));//station 있어야 넣는거니까 오류 발생 가능
    }
}
