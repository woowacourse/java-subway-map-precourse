package subway.userinterface;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.exception.DomainIsNotExistedException;
import subway.exception.IllegalCommandException;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class SectionManagementView extends View {
    private static final SectionManagementView instance;
    private Scanner scanner;

    public static SectionManagementView getInstance() {
        return instance;
    }

    static {
        instance = new SectionManagementView();
    }

    private SectionManagementView() {

    }

    void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void printGuidance() {
        System.out.println(
                "## 구간 관리 화면\n" +
                        "1. 구간 등록\n" +
                        "2. 구간 삭제\n" +
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
            addSection();
        }
        if (Command.REMOVE.value.equals(command)) {
            removeSection();
        }
        if (Command.BACK.value.equals(command)) {
            UserInterface.setView(MainView.getInstance());
        }
    }

    private void addSection() {
        Line line = getLine();
        Station station = getStation();
        int sequence = getSequence();

        validatePossibleSequence(line, sequence);

        line.addStation(sequence, station);
        System.out.println("[INFO] 구간이 등록되었습니다.");
    }

    private Line getLine() {
        System.out.println("## 노선 입력하세요.");
        String input = scanner.nextLine();

        if (!LineRepository.isContainedLineName(input)) {
            throw new DomainIsNotExistedException();
        }

        return LineRepository.getLine(input);
    }

    private Station getStation() {
        System.out.println("## 역이름을 입력하세요.");
        String input = scanner.nextLine();

        if (!StationRepository.isContainedStationName(input)) {
            throw new DomainIsNotExistedException();
        }

        return StationRepository.getStation(input);
    }

    private int getSequence() {
        System.out.println("## 순서를 입력하세요.");
        String input = scanner.nextLine();

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    private void validatePossibleSequence(Line line, int sequence) {
        if (line.getStations().size() < sequence) {
            throw new IllegalArgumentException("가능하지 않는 순서입니다.");
        }
    }

    private void removeSection() {
        Line line = getLineToRemove();
        Station station = getStationToRemove(line);

        line.deleteStation(station);
    }

    private Line getLineToRemove() {
        System.out.println("## 삭제할 구간의 노선 입력하세요.");
        String input = scanner.nextLine();

        if (!LineRepository.isContainedLineName(input)) {
            throw new DomainIsNotExistedException();
        }

        return LineRepository.getLine(input);
    }

    private Station getStationToRemove(Line line) {
        System.out.println("## 삭제할 구간의 역을 입력하세요.");
        String input = scanner.nextLine();

        return line.getStations()
                .stream()
                .filter(station -> Objects.equals(station.getName(), input))
                .findFirst()
                .orElseThrow(DomainIsNotExistedException::new);
    }

    @Override
    void finish() {
        UserInterface.setView(MainView.getInstance());
    }

    private enum Command {
        ADD("1"),
        REMOVE("2"),
        BACK("B");

        private final String value;

        Command(String value) {
            this.value = value;
        }
    }
}
