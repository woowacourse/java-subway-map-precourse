package subway.ui;

import static java.util.stream.Collectors.toMap;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public enum MainMenuEnum {
    MANAGE_STATIONS("역 관리", "1") {
        @Override
        public void action(final Scanner scanner) {
            try {
                StationMenu.run(scanner);
            } catch (IllegalArgumentException e) {
                ConsoleOutput.printErrorMessage(e.getMessage());
            }
        }
    },
    MANAGE_LINES("노선 관리", "2") {
        @Override
        public void action(final Scanner scanner) {
            try {
                LineMenu.run(scanner);
            } catch (IllegalArgumentException e) {
                ConsoleOutput.printErrorMessage(e.getMessage());
            }
        }
    },
    MANAGE_SECTIONS("구간 관리", "3") {
        @Override
        public void action(final Scanner scanner) {
            try {
                SectionMenu.run(scanner);
            } catch (IllegalArgumentException e) {
                ConsoleOutput.printErrorMessage(e.getMessage());
            }
        }
    },
    PRINT_SECTIONS("지하철 노선도 출력", "4") {
        @Override
        public void action(final Scanner scanner) {
            try {
                SectionMenu.viewSection();
            } catch (IllegalArgumentException e) {
                ConsoleOutput.printErrorMessage(e.getMessage());
            }
        }
    },
    EXIT("종료", "Q") {
        @Override
        public void action(final Scanner scanner) {
        }
    },
    ;

    private static final Map<String, MainMenuEnum> MAP;

    static {
        Map<String, MainMenuEnum> mainMenuEnumMap = Arrays.stream(values())
            .collect(toMap(mainMenuEnum -> mainMenuEnum.shortcut, e -> e));
        MAP = Collections.unmodifiableMap(mainMenuEnumMap);
    }

    private final String name;
    private final String shortcut;

    MainMenuEnum(String name, String shortcut) {
        this.name = name;
        this.shortcut = shortcut;
    }

    public static Optional<MainMenuEnum> of(final String shortcut) {
        return Optional.ofNullable(MAP.get(shortcut));
    }

    public abstract void action(final Scanner scanner);

    public String getName() {
        return name;
    }

    public String getShortcut() {
        return shortcut;
    }
}
