package subway.domain.program;

import subway.domain.input.MainInput;

import java.util.Scanner;

public class Program {

    static final String FUNCTION_ONE = "1";
    static final String FUNCTION_TWO = "2";
    static final String FUNCTION_THREE = "3";
    static final String FUNCTION_FOUR = "4";
    static final String FUNCTION_QUIT = "Q";
    static final String MAIN_SCREEN = "## 메인 화면";
    static final String STATION_MANAGE = "1. 역 관리";
    static final String LINE_MANAGE = "2. 노선 관리";
    static final String SECTION_MANAGE = "3. 구간 관리";
    static final String PRINT_SUBWAY = "4. 지하철 노선도 출력";
    static final String QUIT = "Q. 종료";
    static final String SELECT_FUNCTION = "## 원하는 기능을 선택하세요.";


    private boolean quit = false;

    MainInput input = new MainInput();
    StationManageProgram stationManageProgram = new StationManageProgram();
    LineManageProgram lineManageProgram = new LineManageProgram();
    SectionManageProgram sectionManageProgram = new SectionManageProgram();
    subwayRouteMapProgram subwayRouteMapProgram = new subwayRouteMapProgram();

    public String getSelectFunction(Scanner scanner) {
        System.out.println(MAIN_SCREEN);
        System.out.println(STATION_MANAGE);
        System.out.println(LINE_MANAGE);
        System.out.println(SECTION_MANAGE);
        System.out.println(PRINT_SUBWAY);
        System.out.println(QUIT);
        System.out.println(SELECT_FUNCTION);
        return input.inputMainScreen(scanner);
    }

    public void printStationManage(Scanner scanner, String function) {
        if (function.equals(FUNCTION_ONE)) {
            stationManageProgram.printStationManageProgram(scanner);
        }
    }

    public void printLineManage(Scanner scanner, String function) {
        if (function.equals(FUNCTION_TWO)) {
            lineManageProgram.printLineManageProgram(scanner);
        }
    }

    public void printSectionManage(Scanner scanner, String function) {
        if (function.equals(FUNCTION_THREE)) {
            sectionManageProgram.printSectionManageProgram(scanner);
        }
    }

    public void printSubway(String function) {
        if (function.equals(FUNCTION_FOUR)) {
            subwayRouteMapProgram.printLineAndStation();
        }
    }

    public void quitProgram(String function) {
        if (function.equals(FUNCTION_QUIT)) {
            this.quit = true;
        }
    }

    public void run(Scanner scanner) {
        this.quit = false;
        while (!quit) {
            try {
                String function = getSelectFunction(scanner);
                printStationManage(scanner, function);
                printLineManage(scanner, function);
                printSectionManage(scanner, function);
                printSubway(function);
                quitProgram(function);
            } catch (IllegalArgumentException illegalArgumentException) {
            }
        }
    }

}
