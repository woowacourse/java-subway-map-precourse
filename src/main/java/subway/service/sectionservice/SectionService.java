package subway.service.sectionservice;

import subway.controller.SectionMenuController;
import subway.domain.Line;
import subway.repository.LineRepository;

import java.util.Optional;
import java.util.Scanner;

public class SectionService {
    private static final String NOT_EXIST_LINE_MESSAGE = "\n[ERROR] 존재하지 않는 노선입니다.";

    private SectionService(){
    }

    static void goToMenu(IllegalArgumentException e, Scanner scanner) {
        System.out.println(e.getMessage());
        SectionMenuController sectionMenuController = SectionMenuController.getInstance();
        sectionMenuController.mappingMenu(scanner);
    }

    static void isExistLine(String lineName) {
        if (!LineRepository.lines().contains(new Line(lineName))) {
            throw new IllegalArgumentException(NOT_EXIST_LINE_MESSAGE);
        }
    }

    static Line findLineByLineName(String lineName) {
        return LineRepository.lines().stream()
            .filter(line -> line.equals(new Line(lineName)))
            .findFirst()
            .get();
    }

    static int getLineStationSize(String lineName) {
        return findLineByName(lineName)
            .map(line -> line.getStations().size())
            .get();
    }

    static Optional<Line> findLineByName(String lineName) {
        return LineRepository.lines().stream()
            .filter(line -> line.getName().equals(lineName))
            .findFirst();
    }
}
