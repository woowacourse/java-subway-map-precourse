package subway.domain;

import subway.util.MenuSelectManager;

import java.util.Scanner;

public class SubwayMapPrinter implements MenuSelectManager {
    @Override
    public void forward(Scanner scanner) {
        SectionRepository.sections()
                .keySet()
                .stream().sorted()
                .forEach(line -> {
                    System.out.println("[INFO] " + line + "\n" + "[INFO] ---");
                    SectionRepository.sections().get(line)
                            .forEach(station -> System.out.println("[INFO] " + station.getName()));
                    System.out.println();
                });
    }
}
