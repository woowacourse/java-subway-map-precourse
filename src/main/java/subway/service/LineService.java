package subway.service;

import subway.constant.Information;
import subway.constant.InitialData;
import subway.repository.LineRepository;

import java.util.Scanner;

public class LineService {

    private Scanner scanner;

    public LineService(Scanner scanner) {
        this.scanner = scanner;
        initLines();
    }

    private void initLines() {
        LineRepository.addLine(InitialData.lines);
    }

    public void run() {
        System.out.println(Information.LINE_INFO);
    }
}
