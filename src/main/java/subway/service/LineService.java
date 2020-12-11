package subway.service;

import subway.constant.Information;
import subway.constant.InitialData;
import subway.repository.LineRepository;

import java.util.Scanner;

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
        System.out.println(Information.ADD_LINE_INFO);
    }

    @Override
    public void delete() {
        System.out.println(Information.DELETE_LINE_INFO);
    }

    @Override
    public void show() {
        System.out.println(Information.SHOW_LINE_INFO);
    }
}
