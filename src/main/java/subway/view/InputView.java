package subway.view;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.StationRepository;
import subway.tool.InputTool;

import java.util.Scanner;

public class InputView {
    final static Scanner scanner = new Scanner(System.in);
    public static String mainInput() {
        System.out.println("## 원하는 기능을 선택하세요.");
        String user_input = scanner.nextLine();
        return user_input;
    }

    public static String stationInsertInput() {
        System.out.println("## 등록할 역 이름을 입력하세요.");
        String user_input = scanner.nextLine();
        return user_input;
    }
    public static String stationDeleteInput() {
        System.out.println("## 삭제할 역 이름을 입력하세요.");
        String user_input = scanner.nextLine();
        return user_input;
    }

    public static String LineNameInsertInput() {
        System.out.println("## 등록할 노선 이름을 입력하세요.");
        String user_input = scanner.nextLine();
        return user_input;
    }

    public static String LineStartInput() {
        System.out.println("## 등록할 노선의 상행 종점역 이름을 입력하세요.");
        String user_input = scanner.nextLine();
        return user_input;
    }

    public static String LineEndInput() {
        System.out.println("## 등록할 노선의 하행 종점역 이름을 입력하세요.");
        String user_input = scanner.nextLine();
        return user_input;
    }
    public static String LineDeleteInput() {
        System.out.println("## 삭제할 노선 이름을 입력하세요.");
        String user_input = scanner.nextLine();
        return user_input;
    }
    public static boolean SectionInsertLineInput() {
        System.out.println("## 노선을 입력하세요");
        String lineName = scanner.nextLine();
        System.out.println("## 역이름을 입력하세요.");
        String stationName = scanner.nextLine();
        System.out.println("## 순서를 입력하세요.");
        String order = scanner.nextLine();
        if(LineRepository.isExistLine(lineName) == false){
            OutputView.printError("노선 이름이 존재하지 않습니다.");
            return false;
        }
        if(LineRepository.isContainStationInTargetLine(lineName, stationName)){
            OutputView.printError("추가하려는 노선에 이미 해당 역이 존재합니다.");
            return false;
        }
        if(InputTool.isNumber(order) == false){
            OutputView.printError("순서는 숫자여야합니다.");
            return false;
        }
        if(InputTool.isPossibleInsertLineSize(lineName,order) == false){
            OutputView.printError("노선의 길이보다 작거나 같은 숫자를 입력해야합니다");
            return false;
        }
        LineRepository.addStationInLine(lineName,stationName,order);
        return true;
    }

}
