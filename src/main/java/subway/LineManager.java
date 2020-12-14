package subway;

import subway.domain.Line;
import subway.domain.LineRepository;

import java.util.Scanner;

public class LineManager {
    private final Scanner scanner;

    public LineManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        InputView inputView = new InputView(scanner, "lineManager");
        String menuNumber = inputView.nextMenu();
        selectMenu(menuNumber);
    }

    public void initializeLine() {
        Line line2 = new Line("2호선");
        line2.initializeSection("교대역", "역삼역");
        line2.addStationToSection(1, "강남역");
        LineRepository.addLine(line2);

        Line line3 = new Line("3호선");
        line3.initializeSection("교대역", "매봉역");
        line3.addStationToSection(1, "남부터미널역");
        line3.addStationToSection(2, "양재역");
        LineRepository.addLine(line3);

        Line lineSinbundang = new Line("신분당선");
        lineSinbundang.initializeSection("강남역", "양재시민의숲역");
        lineSinbundang.addStationToSection(1, "양재역");
        LineRepository.addLine(lineSinbundang);
    }


    private void selectMenu(String menuNumber) {
        if (menuNumber.equals("1")) {
            addLine();
        } else if (menuNumber.equals("2")) {
            deleteLine();
        } else if (menuNumber.equals("3")) {
            printLine();
        }
    }

    private void addLine() {
        System.out.println("\n## 등록할 노선 이름을 입력하세요.");
        String line = InputView.askName(scanner);
        if (LineRepository.hasLine(line)){
            System.out.println("\n[ERROR] 이미 등록된 노선입니다.");
            run();
        }
        Line newLine = new Line(line);
        System.out.println("\n등록할 노선의 상행 종점역 이름을 입력하세요.");
        String startStation = InputView.askName(scanner);
        System.out.println("\n등록할 노선의 하행 종점역 이름을 입력하세요.");
        String endStation = InputView.askName(scanner);
        try {
            newLine.initializeSection(startStation, endStation);
            LineRepository.addLine(newLine);
            System.out.println("[INFO] 노선이 등록되었습니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            run();
        }
    }

    private void deleteLine() {
        System.out.println("\n## 삭제할 노선 이름을 입력하세요.");
        String station = InputView.askName(scanner);
        try {
            if (!LineRepository.deleteLineByName(station)) {
                throw new IllegalArgumentException("[ERROR] 존재하지 않는 노선입니다.");
            }
        } catch (IllegalArgumentException e)  {
            System.out.println(e);
            run();
        }
    }

    private void printLine() {
        LineRepository.printLineList();
    }


}
