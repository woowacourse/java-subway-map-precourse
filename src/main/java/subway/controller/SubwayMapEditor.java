package subway.controller;

import subway.domain.SubwayMap;

import java.util.Scanner;

public class SubwayMapEditor {
    private final Scanner scanner;
    private final SubwayMap subwayMap = new SubwayMap();

    public SubwayMapEditor(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        initializeSubwayMap();
    }

    private void initializeSubwayMap() {
        subwayMap.initialize();
    }
}
