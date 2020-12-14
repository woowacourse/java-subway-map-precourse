package subway.view;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class OutputView {
    private static final String NEXT_LINE = "\n";
    private static final String GUIDE_MESSAGE_START= "##";
    private static final String GUIDE_MESSAGE_END_CHOOSE_FUNCTION = "원하는 기능을 선택하세요.";

    private static final String GUIDE_MESSAGE_END_ADD_STATION = "등록할 역 이름을 입력하세요.";
    private static final String GUIDE_MESSAGE_END_DELETE_STATION = "삭제할 역 이름을 입력하세요.";

    private static final String GUIDE_MESSAGE_END_ADD_LINE_NAME = "등록할 노선 이름을 입력하세요.";
    private static final String GUIDE_MESSAGE_END_ADD_LINE_UPWARD_TERMINAL = "등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String GUIDE_MESSAGE_END_ADD_LINE_DOWNWARD_TERMINAL = "둥록할 노선의 하행 종점역 이름을 입력하세요.";
    private static final String GUIDE_MESSAGE_END_DELETE_LINE = "삭제할 노선 이름을 입력하세요.";

    private static final String GUIDE_MESSAGE_END_ADD_ROUTE_LINE = "노선을 입력하세요.";
    private static final String GUIDE_MESSAGE_END_ADD_ROUTE_STATION = "역 이름을 입력하세요.";
    private static final String GUIDE_MESSAGE_END_ADD_ROUTE_ORDER = "순서를 입력하세요.";
    private static final String GUIDE_MESSAGE_END_DELETE_ROUTE_LINE = "삭제할 구간의 노선을 입력하세요.";
    private static final String GUIDE_MESSAGE_END_DELETE_ROUTE_STATION = "삭제할 구간의 역을 입력하세요.";
    //
    private static final String INFO_MESSAGE_START = "[INFO]";
    private static final String INFO_MESSAGE_END_ADD_STATION = "지하철 역이 등록되었습니다.";
    private static final String INFO_MESSAGE_END_DELETE_STATION = "지하철 역이 삭제되었습니다.";

    private static final String INFO_MESSAGE_END_ADD_LINE = "지하철 노선이 등록되었습니다.";
    private static final String INFO_MESSAGE_END_DELETE_LINE = "지하철 노선이 삭제되었습니다.";

    private static final String INFO_MESSAGE_END_ADD_ROUTE = "구간이 등록되었습니다.";
    private static final String INFO_MESSAGE_END_DELETE_ROUTE = "구간이 삭제되었습니다.";


    private static final String ERROR_MESSAGE_START = "[ERROR]";
    private static final String ERROR_MESSAGE_END_CHOOSE_FUNCTION = "선택할 수 없는 기능입니다.";
    private static final String ERROR_MESSAGE_END_ADD_STATION_DUPLICATE = "이미 등록된 역 이름입니다.";
//    private static final String ERROR_MESSAGE_END_DELETE_STATION = "지하철 역이 삭제되었습니다.";
//
//    private static final String ERROR_MESSAGE_END_ADD_LINE = "지하철 노선이 등록되었습니다.";
//    private static final String ERROR_MESSAGE_END_DELETE_LINE = "지하철 노선이 삭제되었습니다.";
//
//    private static final String ERROR_MESSAGE_END_ADD_ROUTE = "구간이 등록되었습니다.";
//    private static final String ERROR_MESSAGE_END_DELETE_ROUTE = "구간이 삭제되었습니다.";


    public void guideChooseFunction() {
        System.out.println(String.join(" ",GUIDE_MESSAGE_START,GUIDE_MESSAGE_END_CHOOSE_FUNCTION));
    }

    public void guideAddStation() {
        System.out.println(String.join(" ",GUIDE_MESSAGE_START,GUIDE_MESSAGE_END_ADD_STATION));
    }

    public void guideDeleteStation() {
        System.out.println(String.join(" ",GUIDE_MESSAGE_START,GUIDE_MESSAGE_END_DELETE_STATION));
    }

    public void guideAddLineName() {
        System.out.println(String.join(" ",GUIDE_MESSAGE_START,GUIDE_MESSAGE_END_ADD_LINE_NAME));
    }

    public void guideAddLineUpwardTerminal() {
        System.out.println(String.join(" ",GUIDE_MESSAGE_START,GUIDE_MESSAGE_END_ADD_LINE_UPWARD_TERMINAL));
    }

    public void guideAddLineDownwardTerminal() {
        System.out.println(String.join(" ",GUIDE_MESSAGE_START,GUIDE_MESSAGE_END_ADD_LINE_DOWNWARD_TERMINAL));
    }

    public void guideDeleteLine() {
        System.out.println(String.join(" ",GUIDE_MESSAGE_START,GUIDE_MESSAGE_END_DELETE_LINE));
    }

    public void guideAddRouteLine() {
        System.out.println(String.join(" ",GUIDE_MESSAGE_START,GUIDE_MESSAGE_END_ADD_ROUTE_LINE));
    }

    public void guideAddRouteStation() {
        System.out.println(String.join(" ",GUIDE_MESSAGE_START,GUIDE_MESSAGE_END_ADD_ROUTE_STATION));
    }

    public void guideAddRouteOrder() {
        System.out.println(String.join(" ",GUIDE_MESSAGE_START,GUIDE_MESSAGE_END_ADD_ROUTE_ORDER));
    }

    public void guideDeleteRouteLine() {
        System.out.println(String.join(" ",GUIDE_MESSAGE_START,GUIDE_MESSAGE_END_DELETE_ROUTE_LINE));
    }

    public void guideDeleteRouteStation() {
        System.out.println(String.join(" ",GUIDE_MESSAGE_START,GUIDE_MESSAGE_END_DELETE_ROUTE_STATION));
    }

    public void printStartMainError() {
        System.out.println(String.join(" ",ERROR_MESSAGE_START,ERROR_MESSAGE_END_CHOOSE_FUNCTION));
        System.out.println();
    }

    public void printMainScreen() {
        System.out.println("## 메인 화면");
        System.out.println("1. 역 관리");
        System.out.println("2. 노선 관리");
        System.out.println("3. 구간 관리");
        System.out.println("4. 지하철 노선도 출력");
        System.out.println("Q. 종료"+NEXT_LINE);
        guideChooseFunction();
    }

    public void printStationManagementScreen() {
        System.out.println("## 역 관리 화면");
        System.out.println("1. 역 등록");
        System.out.println("2. 역 삭제");
        System.out.println("3. 역 조회");
        System.out.println("B. 돌아가기"+NEXT_LINE);
        guideChooseFunction();
    }

    public void printLineManagementScreen() {
        System.out.println("## 노선 관리 화면");
        System.out.println("1. 노선 등록");
        System.out.println("2. 노선 삭제");
        System.out.println("3. 노선 조회");
        System.out.println("B. 돌아가기"+NEXT_LINE);
        guideChooseFunction();
    }

    public void printSectionManagementScreen() {
        System.out.println("## 구간 관리 화면");
        System.out.println("1. 구간 등록");
        System.out.println("2. 구간 삭제");
        System.out.println("B. 돌아가기"+NEXT_LINE);
        guideChooseFunction();
    }

    public void printAllStations() {
        System.out.println(String.join(" ",GUIDE_MESSAGE_START,"역 목록"));
        for(Station station : StationRepository.getStations()) {
            System.out.println(String.join(" ",INFO_MESSAGE_START,station.getName()));
        }
    }

    public void printAllLines() {
        System.out.println(String.join(" ",GUIDE_MESSAGE_START,"노선 목록"));
        for(Line line : LineRepository.getLines()) {
            System.out.println(String.join(" ",INFO_MESSAGE_START,line.getName()));
        }
    }

    public void printSubwaySections() {
        System.out.println(String.join(" ", GUIDE_MESSAGE_START, "지하철 노선도"));
        for(Line line : LineRepository.getLines()) {
            System.out.println(String.join(" ",INFO_MESSAGE_START,line.getName()));
            System.out.println(String.join(" ",INFO_MESSAGE_START,"---"));
            for(Station station : line.getSections()) {
                System.out.println(String.join(" ",INFO_MESSAGE_START,station.getName()));
            }
            System.out.println();
        }
    }

}
