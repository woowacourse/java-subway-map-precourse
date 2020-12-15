package subway.controller;

import subway.domain.SubwayMap;
import subway.view.MainScreenInputView;
import subway.view.MainScreenOutputView;

import java.util.Scanner;

public class SubwayMapEditor {
    private final Scanner scanner;

    public SubwayMapEditor(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        SubwayMap subwayMap = new SubwayMap();
        boolean isPersist = false;
        do {
            isPersist = MainScreenInputView.getMainScreenUserSelection(scanner);
        } while (isPersist);

    }
}
