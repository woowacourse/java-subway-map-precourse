package subway.domain;

import subway.Constant;

import java.util.Scanner;

public class LineController {
    Scanner scanner;
    LineRepository lineRepository = new LineRepository();

    public LineController(Scanner scanner){
        this.scanner = scanner;
    }

    void printSelection(){
        System.out.println(Constant.LINE_ANNOUNCEMENT);
        String command = scanner.next();
        if (command.equals(Constant.FIRST_COMMAND)) {
            addLine();
        } else if (command.equals(Constant.SECOND_COMMAND)) {
            deleteLine();
        } else if (command.equals(Constant.THIRD_COMMAND)) {
            readLines();
        } else if (command.equals(Constant.BACK_COMMAND)) {
            return;
        }
    }

    void addLine(){
        System.out.println(String.join(" 노선 ", Constant.ADD_PREFIX, Constant.NAME_POSTFIX));
        String lineName = scanner.next();
        Line line = new Line(lineName);
        System.out.println(String.join(" 노선의 상행 ", Constant.ADD_PREFIX, Constant.NAME_POSTFIX));
        String upward = scanner.next();
        System.out.println(String.join(" 노선의 하행 ", Constant.ADD_PREFIX, Constant.NAME_POSTFIX));
        String downward = scanner.next();
        lineRepository.addLine(line, new Station(upward), new Station(downward));
    }

    void deleteLine(){
        System.out.println(String.join(" 노선 ", Constant.DELETE_PREFIX, Constant.NAME_POSTFIX));
        String lineName = scanner.next();
        boolean deleteFlag = lineRepository.deleteLineByName(lineName);
        if(deleteFlag){
            System.out.println(String.join(" ", Constant.INFO_PREFIX, Constant.DELETE_LINE_SUCCESS));
        }
    }

    void readLines(){
        lineRepository.printLines();
    }
}
