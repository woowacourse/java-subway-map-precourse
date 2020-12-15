package subway;

import subway.controller.SubwayMapEditor;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        SubwayMapEditor subwayMapEditor = new SubwayMapEditor(scanner);
        subwayMapEditor.run();
    }
}
