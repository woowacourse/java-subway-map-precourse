package subway.userinterface;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.exception.DomainIsNotExistedException;
import subway.exception.DuplicatedNameException;
import subway.exception.IllegalCommandException;
import subway.exception.ShortNameException;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class LineManagementView extends View {
    private static final LineManagementView instance;
    private Scanner scanner;

    public static LineManagementView getInstance() {
        return instance;
    }

    static {
        instance = new LineManagementView();
    }

    private LineManagementView() {

    }

    void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void printGuidance() {
        System.out.println(
                "## 노선 관리 화면\n" +
                        "1. 노선 등록\n" +
                        "2. 노선 삭제\n" +
                        "3. 노선 조회\n" +
                        "B. 돌아가기");
    }

    @Override
    void validateCommand(String command) {
        Arrays.stream(Command.values())
                .filter(commandType -> Objects.equals(commandType.value, command))
                .findAny()
                .orElseThrow(IllegalCommandException::new);
    }

    @Override
    void executeCommand(String command) {
        if (Command.ADD.value.equals(command)) {
            addLine();
        }
        if (Command.REMOVE.value.equals(command)) {
            removeLine();
        }
        if (Command.INQUIRE.value.equals(command)) {
            printLines();
        }
        if (Command.BACK.value.equals(command)) {
            UserInterface.setView(MainView.getInstance());
        }
    }

    private void addLine() {
        Line line = new Line(getLineName());
        line.addStation(getFirstStation());
        line.addStation(getLastStation());

        LineRepository.addLine(line);
        System.out.println("[INFO] 지하철 노선이 등록되었습니다.");
    }

    private String getLineName() {
        System.out.println("## 등록할 노선 이름을 입력하세요.");
        String input = scanner.nextLine();

        if(input.length() < Line.NAME_MIN_LENGTH){
            throw new ShortNameException();
        }
        if (LineRepository.isContainedLineName(input)) {
            throw new DuplicatedNameException();
        }

        return input;
    }

    private Station getFirstStation() {
        System.out.println("## 등록할 노선의 상행 종점역 이름을 입력하세요.");
        String input = scanner.nextLine();

        if (!StationRepository.isContainedStationName(input)) {
            throw new DomainIsNotExistedException();
        }

        return StationRepository.getStation(input);
    }

    private Station getLastStation() {
        System.out.println("## 등록할 노선의 하행 종점역 이름을 입력하세요.");
        String input = scanner.nextLine();

        if (!StationRepository.isContainedStationName(input)) {
            throw new DomainIsNotExistedException();
        }

        return StationRepository.getStation(input);
    }

    private void removeLine() {
        System.out.println("## 삭제할 노선 이름을 입력하세요.");
        String input = scanner.nextLine();

        if (!LineRepository.isContainedLineName(input)) {
            throw new DomainIsNotExistedException();
        }

        LineRepository.deleteLineByName(input);
        System.out.println("[INFO] 지하철 노선이 삭제되었습니다.");
    }

    private void printLines() {
        StringBuilder outputBuilder = new StringBuilder("## 역 목록\n");

        LineRepository.lines().forEach(outputBuilder::append);

        System.out.print(outputBuilder.toString());
    }

    @Override
    void finish() {
        UserInterface.setView(MainView.getInstance());
    }

    private enum Command {
        ADD("1"),
        REMOVE("2"),
        INQUIRE("3"),
        BACK("B");

        private final String value;

        Command(String value) {
            this.value = value;
        }
    }
}
