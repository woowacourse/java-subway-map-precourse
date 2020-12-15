package subway.userinterface;

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

public class StationManagementView extends View {
    private static final StationManagementView instance;
    private Scanner scanner;

    public static StationManagementView getInstance() {
        return instance;
    }

    static {
        instance = new StationManagementView();
    }

    private StationManagementView() {

    }

    void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void printGuidance() {
        System.out.println(
                        "## 역 관리 화면\n" +
                        "1. 역 등록\n" +
                        "2. 역 삭제\n" +
                        "3. 역 조회\n" +
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
            addStation();
        }
        if (Command.REMOVE.value.equals(command)) {
            removeStation();
        }
        if (Command.INQUIRE.value.equals(command)) {
            printStations();
        }
        if (Command.BACK.value.equals(command)) {
            UserInterface.setView(MainView.getInstance());
        }
    }

    private void addStation() {
        System.out.println("## 등록할 역 이름을 입력하세요.");
        String input = scanner.nextLine();

        if (StationRepository.isContainedStationName(input)) {
            throw new DuplicatedNameException();
        }

        if (input.length() < Station.NAME_MIN_LENGTH) {
            throw new ShortNameException();
        }

        StationRepository.addStation(new Station(input));
        System.out.println("[INFO] 지하철 역이 등록되었습니다.");
    }

    private void removeStation() {
        System.out.println("## 삭제할 역 이름을 입력하세요.");
        String input = scanner.nextLine();

        if (!StationRepository.isContainedStationName(input)) {
            throw new DomainIsNotExistedException();
        }
        if (LineRepository.isContainedStationInLines(input)) {
            throw new IllegalStateException("[ERROR] 노선에 등록된 역은 삭제 할 수 없습니다.");
        }

        StationRepository.deleteStation(input);
        System.out.println("[INFO] 지하철 역이 삭제되었습니다.");
    }

    private void printStations() {
        StringBuilder outputBuilder = new StringBuilder("## 역 목록\n");

        StationRepository.stations().forEach(outputBuilder::append);

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
