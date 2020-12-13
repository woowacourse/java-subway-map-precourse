package subway.controller;

import subway.view.InputView;
import subway.view.OutputView;
import subway.domain.LineRepository;
import subway.domain.exception.NonExistentNameException;

public class Edge {
    private static final String STATION_MESSAGE = "역";
    private static final String LINE_MESSAGE = "노선";
    private static final String NAME_MESSAGE = "이름";
    private static final String ORDER_MESSAGE = "순서";
    private Edge() {
    }

    public static void add(InputView inputView) {
        OutputView.printInputMessage(LINE_MESSAGE);
        String lineName = inputView.getInput();
        validateLineName(lineName);
    }

    private static void validateLineName(String lineName) {
        if (LineRepository.validateNewLineName(lineName)) {
            throw new NonExistentNameException(LINE_MESSAGE);
        }
    }

}
