package subway.view;

import subway.Constant;
import subway.domain.SectionRepository;

import java.util.Scanner;

public class SectionController {
    Scanner scanner;
    SectionRepository sectionRepository = new SectionRepository();
    private static final String GET_LINE_NAME = "\n## 노선을 입력하세요.";
    private static final String GET_STATION_NAME = "\n## 역 이름을 입력하세요.";
    private static final String GET_ORDER_NAME = "\n## 순서를 입력하세요.";
    private static final String GET_DELETE_LINE_NAME = "\n## 삭제할 구간의 노선을 입력하세요.";
    private static final String GET_DELETE_STATION_NAME = "\n## 삭제할 구간의 역을 입력하세요.";

    public SectionController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void printSelection() {
        System.out.println(Constant.SECTION_ANNOUNCEMENT);
        String command = scanner.next();
        if (command.equals(Constant.FIRST_COMMAND)) {
            addSection();
        } else if (command.equals(Constant.SECOND_COMMAND)) {
            deleteSection();
        } else if (command.equals(Constant.BACK_COMMAND)) {
            return;
        }
    }

    void addSection(){
        System.out.println(GET_LINE_NAME);
        String lineName = scanner.next();
        System.out.println(GET_STATION_NAME);
        String stationName = scanner.next();
        System.out.println(GET_ORDER_NAME);
        String order = scanner.next();
        try {
            sectionRepository.addSection(lineName, stationName, Integer.parseInt(order));
            System.out.println(String.join(" ", Constant.INFO_PREFIX, Constant.ADD_SECTION_SUCCESS));
        }catch(IllegalArgumentException e){
            System.err.println(String.join(" ", Constant.ERROR_PREFIX, Constant.NO_EXIST_INFO));
        }catch(IndexOutOfBoundsException e){
            System.err.println(String.join(" ", Constant.ERROR_PREFIX, "추가할 수 없는 구간입니다."));
        }
    }

    void deleteSection(){
        System.out.println(GET_DELETE_LINE_NAME);
        String lineName = scanner.next();
        System.out.println(GET_DELETE_STATION_NAME);
        String stationName = scanner.next();
        try {
            boolean deleteFlag = sectionRepository.deleteSection(lineName, stationName);
            if (deleteFlag) {
                System.out.println(String.join(" ", Constant.INFO_PREFIX, Constant.DELETE_SECTION_SUCCESS));
                return;
            }
            System.err.println(String.join(" ", Constant.ERROR_PREFIX, Constant.FAIL));
        }catch (IllegalArgumentException e){
            System.err.println(String.join(" ", Constant.ERROR_PREFIX, Constant.NO_EXIST_INFO));
        }

    }

    public void readSections() {
        sectionRepository.printMap();
    }
}
