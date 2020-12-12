package subway.manager;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import view.InputView;
import view.OutputView;

import java.util.Arrays;
import java.util.List;

enum SectionButton {
    REGISTER("1"), DELETE("2"), BACK("B");

    private final String symbol;

    SectionButton(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}

public class SectionManager {

    private static final List<String> choices = Arrays.asList(
            SectionButton.REGISTER.getSymbol(),
            SectionButton.DELETE.getSymbol(),
            SectionButton.BACK.getSymbol()
    );

    public static void execute() {
        OutputView.printSectionManagement();
        String command = InputView.getFunctionSelect(choices);
        nextProcedure(command);
    }

    public static void nextProcedure(String command) {
        if (command.equals(SectionButton.BACK.getSymbol())) {
            MainManager.execute();
            return;
        } else if (command.equals(SectionButton.REGISTER.getSymbol())) {
            registerSection();
        } else if (command.equals(SectionButton.DELETE.getSymbol())) {
            deleteSection();
        }
        MainManager.execute();
    }

    public static void registerSection() {
        String lineName = InputView.getRegisterSectionLineName();
        String stationName = InputView.getRegisterSectionStationName();
        Line currentLine = LineRepository.getLineNamed(lineName);
        int order = InputView.getRegisterSectionOrder(currentLine);
        Station currentStation = StationRepository.getStationNamed(stationName);
        currentStation.registerIn(lineName);
        currentLine.addOnLine(order, stationName);
        OutputView.printInformation(OutputView.MESSAGE_SUCCESS_REGISTER_SECTION);
    }

    public static void deleteSection() {
        String lineName = InputView.getDeleteSectionLineName();
        Line currentLine = LineRepository.getLineNamed(lineName);
        String stationName = InputView.getDeleteSectionStationName(currentLine);
        Station currentStation = StationRepository.getStationNamed(stationName);
        currentStation.deleteFrom(lineName);
        currentLine.deleteOnLine(stationName);
        OutputView.printInformation(OutputView.MESSAGE_SUCCESS_DELETE_SECTION);
    }

}
