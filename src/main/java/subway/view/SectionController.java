package subway.view;

import subway.Constant;
import subway.domain.LineRepository;
import subway.domain.SectionRepository;

import java.util.Scanner;

public class SectionController {
    private static final String GET_LINE_NAME = "\n## 노선을 입력하세요.";
    private static final String GET_STATION_NAME = "\n## 역 이름을 입력하세요.";
    private static final String GET_ORDER_NAME = "\n## 순서를 입력하세요.";
    private static final String GET_DELETE_LINE_NAME = "\n## 삭제할 구간의 노선을 입력하세요.";
    private static final String GET_DELETE_STATION_NAME = "\n## 삭제할 구간의 역을 입력하세요.";
    private static final String NO_SECTION_INFO = "등록된 노선이 없습니다.";
    private static final String ADD_SECTION_SUCCESS = "구간이 등록되었습니다.\n";
    private static final String DELETE_SECTION_SUCCESS = "구간이 삭제되었습니다.\n";
    private static final String NOT_ADD_POSSIBLE_SECTION = "추가할 수 없는 구간입니다.";
    private static final String NOT_DELETE_POSSIBLE_SECTION = "삭제할 수 없는 구간입니다.";
    private static final String NOT_NUMBER_FORMAT = "순서에는 숫자만 입력 가능합니다.";
    private static final String BAR = "---";
    Scanner scanner;
    SectionRepository sectionRepository = new SectionRepository();
    LineRepository lineRepository = new LineRepository();

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

    void addSection() {
        System.out.println(GET_LINE_NAME);
        String lineName = scanner.next();
        System.out.println(GET_STATION_NAME);
        String stationName = scanner.next();
        System.out.println(GET_ORDER_NAME);
        String order = scanner.next();
        try {
            int orderNum = Integer.parseInt(order);
            sectionRepository.addSection(lineName, stationName, orderNum);
            System.out.println(String.join(" ", Constant.INFO_PREFIX, ADD_SECTION_SUCCESS));
        } catch (NumberFormatException e) {
            System.err.println(String.join(" ", Constant.ERROR_PREFIX, NOT_NUMBER_FORMAT));
        } catch (IllegalArgumentException e) {
            System.err.println(String.join(" ", Constant.ERROR_PREFIX, Constant.NO_EXIST_INFO));
        } catch (IndexOutOfBoundsException e) {
            System.err.println(String.join(" ", Constant.ERROR_PREFIX, NOT_ADD_POSSIBLE_SECTION));
        } catch (IllegalStateException e) {
            System.err.println(String.join(" ", Constant.ERROR_PREFIX, Constant.DUPLICATE_STATION_NAME));
        }
    }

    void deleteSection() {
        System.out.println(GET_DELETE_LINE_NAME);
        String lineName = scanner.next();
        System.out.println(GET_DELETE_STATION_NAME);
        String stationName = scanner.next();
        try {
            boolean deleteFlag = sectionRepository.deleteSection(lineName, stationName);
            if (deleteFlag) {
                System.out.println(String.join(" ", Constant.INFO_PREFIX, DELETE_SECTION_SUCCESS));
                return;
            }
            System.err.println(String.join(" ", Constant.ERROR_PREFIX, Constant.FAIL));
        } catch (IllegalArgumentException e) {
            System.err.println(String.join(" ", Constant.ERROR_PREFIX, Constant.NO_EXIST_INFO));
        } catch (IllegalStateException e) {
            System.err.println(String.join(" ", Constant.ERROR_PREFIX, NOT_DELETE_POSSIBLE_SECTION));
        }

    }

    public void readSections() {
        if (lineRepository.lines.size() == 0) {
            System.err.println(String.join(" ", Constant.ERROR_PREFIX, NO_SECTION_INFO));
            return;
        }
        for (int i = 0; i < lineRepository.lines.size(); i++) {
            System.out.println("\n" + String.join(" ", Constant.INFO_PREFIX, lineRepository.lines.get(i).getName()));
            System.out.println(String.join(" ", Constant.INFO_PREFIX, BAR));
            for (int j = 0; j < lineRepository.lines.get(i).stations.size(); j++) {
                System.out.println(String.join(" ", Constant.INFO_PREFIX, lineRepository.lines.get(i).stations.get(j).getName()));
            }
        }
    }
}
