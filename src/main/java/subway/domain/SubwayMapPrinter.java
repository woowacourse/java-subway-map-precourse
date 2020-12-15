package subway.domain;

import subway.domain.section.SectionRepository;
import subway.util.MenuSelectManager;
import subway.util.PrefixPrinter;

import java.util.Scanner;

public class SubwayMapPrinter implements MenuSelectManager {
    @Override
    public void selectMenu(Scanner scanner) {
        SectionRepository.sections()
                .keySet()
                .stream().sorted()
                .forEach(line -> {
                    System.out.println(PrefixPrinter.INFO + line + "\n" + PrefixPrinter.INFO + "---");
                    SectionRepository.sections().get(line)
                            .forEach(station -> PrefixPrinter.printSubway(station.getName()));
                    System.out.println();
                });
    }
}
