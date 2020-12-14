package subway.controller;

import subway.domain.SubwayMap;
import subway.view.OutputView;

import java.util.Scanner;

public class SubwayMapEditor {
    private final Scanner scanner;

    public SubwayMapEditor(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        SubwayMap subwayMap = new SubwayMap();
        OutputView.printMainScreen();
    }
}
