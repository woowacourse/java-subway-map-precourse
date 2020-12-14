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
        initializeLine();
        InputView inputView = new InputView(scanner, "lineManager");
        String menuNumber = inputView.nextMenu();
        selectMenu(menuNumber);
    }

    public void initializeLine() {
        Line line2 = new Line("2호선");
//        line2
    }


    public void selectMenu(String menuNumber) {
        if (menuNumber.equals("1")) {
            addLine();
        } else if (menuNumber.equals("2")) {
            deleteLine();
        }
    }

    private void addLine() {
        System.out.println("\n## 등록할 노선 이름을 입력하세요.");
        String line = InputView.askName(scanner);
        if (isDuplicate(line)){
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
        }
    }

    private void deleteLine() {
        System.out.println("\n## ")
    }

    public boolean isDuplicate(String line) {
        return LineRepository.hasLine(line);
    }




}
