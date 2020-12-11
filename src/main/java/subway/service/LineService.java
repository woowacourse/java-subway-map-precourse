package subway.service;

import subway.constant.Constant;
import subway.constant.Information;
import subway.constant.InitialData;
import subway.domain.Line;
import subway.domain.Station;
import subway.exception.InvalidInputException;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static subway.constant.Information.INFO_HEADER;

public class LineService extends CrudService {

    private Scanner scanner;

    public LineService(Scanner scanner) {
        super(scanner, Information.LINE_INFO);
        this.scanner = scanner;
        initLines();
    }

    private void initLines() {
        LineRepository.addLine(InitialData.lines);
    }


    @Override
    public void add() {
        Line newLine = getNewLineInput();
        validateNewLine(newLine);
        LineRepository.addLine(newLine);
        System.out.println(Information.ADD_LINE_SUCCESS);
    }

    private Line getNewLineInput() {
        String name = getNewLineName();
        List<Station> endStations = getNewLineEndStations();
        return new Line(name, endStations);
    }

    private String getNewLineName() {
        System.out.println(Information.ADD_LINE_INFO);
        return scanner.nextLine();
    }

    private List<Station> getNewLineEndStations() {
        Station upEnd = getNewLineUpEnd();
        Station downEnd = getNewLineDownEnd();
        return new ArrayList<>(Arrays.asList(upEnd, downEnd));
    }

    private Station getNewLineUpEnd() {
        System.out.println(Information.ADD_LINE_INFO_UP_END);
        return new Station(scanner.nextLine());
    }

    private Station getNewLineDownEnd() {
        System.out.println(Information.ADD_LINE_INFO_DOWN_END);
        return new Station(scanner.nextLine());
    }

    private void validateNewLine(Line newLine) {
        validateNameLength(newLine);
        validateDuplicateLineExists(newLine);
        validateEndStationsExist(newLine);
    }

    private void validateNameLength(Line newLine) {
        if (newLine.getName().length() < Constant.MIN_NAME_LENGTH)
            throw new InvalidInputException(InvalidInputException.ExceptionCode.INVALID_NAME_LENGTH);
    }

    private void validateDuplicateLineExists(Line newLine) {
        if (LineRepository.lines().contains(newLine))
            throw new InvalidInputException(InvalidInputException.ExceptionCode.DUPLICATE_LINE);
    }

    private void validateEndStationsExist(Line newLine) {
        if (!StationRepository.stations().contains(newLine.getUpEnd())
                || !StationRepository.stations().contains(newLine.getDownEnd()))
            throw new InvalidInputException(InvalidInputException.ExceptionCode.NO_SUCH_STATION);
    }


    @Override
    public void delete() {
        String targetLineName = getTargetLineName();
        validateTargetLine(targetLineName);
        LineRepository.deleteLineByName(targetLineName);
        System.out.println(Information.DELETE_LINE_SUCCESS);
    }

    private String getTargetLineName() {
        System.out.println(Information.DELETE_LINE_INFO);
        return scanner.nextLine();
    }

    private void validateTargetLine(String targetLineName) {
        Line targetLine = new Line(targetLineName);
        if (!LineRepository.lines().contains(targetLine))
            throw new InvalidInputException(InvalidInputException.ExceptionCode.NO_SUCH_LINE);
    }


    @Override
    public void show() {
        System.out.print(Information.SHOW_LINE_INFO);
        for (Line line : LineRepository.lines())
            System.out.print(INFO_HEADER + line.getName());
        System.out.println();
    }
}
