package subway.service;

import subway.constant.Information;
import subway.constant.InitialData;
import subway.domain.Line;
import subway.domain.Station;
import subway.exception.InvalidInputException;
import subway.repository.LineRepository;

import java.util.Scanner;

import static subway.constant.Information.INFO_HEADER;

public class LineService extends BaseService {

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
        Station upEnd = getNewLineUpEnd();
        Station downEnd = getNewLineDownEnd();
        Line newLine = new Line(name, upEnd, downEnd);
        validateNewLine(newLine);
        return newLine;
    }

    private String getNewLineName() {
        System.out.println(Information.ADD_LINE_INFO);
        return scanner.nextLine();
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
        validateDuplicateLine(newLine);
    }

    private void validateDuplicateLine(Line newLine) {
        if (LineRepository.lines().contains(newLine))
            throw new InvalidInputException(InvalidInputException.ExceptionCode.DUPLICATE_LINE);
    }

    @Override
    public void delete() {
        System.out.println(Information.DELETE_LINE_INFO);
    }

    @Override
    public void show() {
        System.out.print(Information.SHOW_LINE_INFO);
        for (Line line : LineRepository.lines())
            System.out.print(INFO_HEADER + line.getName());
        System.out.println();
    }
}
