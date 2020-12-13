package management;

import exception.AlreadyExistNameException;
import exception.NoneFunctionException;
import exception.NullRepositoryException;
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
        }else if(answer.equals("2")){
            delete(input);
        } else if(answer.equals("3")){
            allList();
        } else if(answer.equals("B")){
            //
        } else{
            makeException();
        }
    }

    private static void insert(Input input){
        System.out.println(ENROLL_LINE_NAME);
        Line line = new Line(input.inputLineName());
        line.makeLine(input);
    }

    private static void delete(Input input){
        System.out.println(DELETE_LINE_NAME);
        String lineName = input.inputLineName();
        LineRepository.deleteLineInStation(lineName);
        if(!LineRepository.deleteLineByName(lineName)){
            throw new NullRepositoryException();
        }
    }

    private static void allList(){
        System.out.println(LINE_LIST);
        if(LineRepository.lines().size() == 0){
            throw new NullRepositoryException();
        }
        for(Line line : LineRepository.lines()){
            System.out.println(INFO + line.getName());
        }
    }

    private static void makeException(){
        throw new NoneFunctionException();
    }
}