package subway.Service;

import subway.domain.*;
import validator.ExceptionMessage;
import view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LineService {

    private final Scanner scanner;
    private LineRepository lineRepository = new LineRepository();

    public LineService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void createLine() { // 노선 만들기위한 정보 가져오기
        try {
            String lineName = InputView.inputLineName(scanner);
            isValidLineName(lineName);
            String upTerminal = InputView.inputUpTerminalStation(scanner);
            isPossibleTerminalStation(upTerminal);
            String downTerminal = InputView.inputDownTerminalStation(scanner);
            isPossibleTerminalStation(downTerminal);

            createLineAndStation(lineName, upTerminal, downTerminal);
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            createLine();
        }
    }

    public void createLineAndStation(String lineName, String upTerminal, String downTerminal) { // 노선이름, 상행, 하행 종점 등록
        Station upTerminalStation = StationRepository.findByName(upTerminal);
        Station downTerminalStation = StationRepository.findByName(downTerminal);
        Line newLine = new Line(lineName);
        List<Station> sections = Arrays.asList(upTerminalStation, downTerminalStation);
        LineStationRepository.addLineStation(new LineStation(newLine, sections));
    }

    public void isValidLineName(String name) { // 유효한 노선 이름인지, 유효성 검사
        if (name.length() < 2) {
            throw new IllegalArgumentException(ExceptionMessage.LINE_NAME_OVER_TWO);
        }
        if (LineRepository.contains(name)) {
            throw new IllegalArgumentException(ExceptionMessage.LINE_NAME_EXISTS);
        }
    }

    public void isPossibleTerminalStation(String name) { // 상행 하행역 등록을 위해, 존재하는 역인지 확인
        if (!StationRepository.contains(name)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_EXIST_STATION);
        }
    }

    public void deleteLine(String lineName) {
        try {
            if(!LineRepository.deleteLineByName(lineName)) {
                throw new IllegalArgumentException(ExceptionMessage.NOT_EXIST_LINE);
            }
            LineStationRepository.deleteLineOnSubway(lineName);
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            deleteLine(InputView.inputDeleteLineName(scanner));
        }
    }

    public String lineLookup() {
        return lineRepository.toString();
    }
}
