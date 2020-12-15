package subway.ui;

import static java.util.stream.Collectors.toMap;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public enum StationMenuEnum {
    ADD_STATION("역 등록", "1") {
        @Override
        public void action(final Scanner scanner) {
            try {
                StationMenu.addStation(scanner);
            } catch (IllegalArgumentException e) {
                ConsoleOutput.printErrorMessage(e.getMessage());
            }
        }
    },
    DELETE_STATION("역 삭제", "2") {
        @Override
        public void action(final Scanner scanner) {
            try {
                StationMenu.deleteStation(scanner);
            } catch (IllegalArgumentException e) {
                ConsoleOutput.printErrorMessage(e.getMessage());
            }
        }
    },
    VIEW_STATION("역 조회", "3") {
        @Override
        public void action(final Scanner scanner) {
            try {
                StationMenu.viewStation();
            } catch (IllegalArgumentException e) {
                ConsoleOutput.printErrorMessage(e.getMessage());
            }
        }
    },
    GO_BACK("돌아가기", "B") {
        @Override
        public void action(final Scanner scanner) {
        }
    };

    private static final Map<String, StationMenuEnum> MAP;

    static {
        Map<String, StationMenuEnum> stationMenuEnumMap = Arrays.stream(values())
            .collect(toMap(stationMenuEnum -> stationMenuEnum.shortcut, e -> e));
        MAP = Collections.unmodifiableMap(stationMenuEnumMap);
    }

    private final String name;
    private final String shortcut;

    StationMenuEnum(String name, String shortcut) {
        this.name = name;
        this.shortcut = shortcut;
    }

    public static Optional<StationMenuEnum> of(final String shortcut) {
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
