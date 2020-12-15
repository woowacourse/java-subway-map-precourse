package subway.ui;

import static java.util.stream.Collectors.toMap;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public enum LineMenuEnum {
    ADD_LINE("노선 등록", "1") {
        @Override
        public void action(final Scanner scanner) {
            try {
                LineMenu.addLine(scanner);
            } catch (IllegalArgumentException e) {
                ConsoleOutput.printErrorMessage(e.getMessage());
            }
        }
    },
    DELETE_LINE("노선 삭제", "2") {
        @Override
        public void action(final Scanner scanner) {
            try {
                LineMenu.deleteLine(scanner);
            } catch (IllegalArgumentException e) {
                ConsoleOutput.printErrorMessage(e.getMessage());
            }
        }
    },
    VIEW_STATION("노선 조회", "3") {
        @Override
        public void action(final Scanner scanner) {
            try {
                LineMenu.viewLine();
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

    private static final Map<String, LineMenuEnum> MAP;

    static {
        Map<String, LineMenuEnum> lineMenuEnumMap = Arrays.stream(values())
            .collect(toMap(lineMenuEnum -> lineMenuEnum.shortcut, e -> e));
        MAP = Collections.unmodifiableMap(lineMenuEnumMap);
    }

    private final String name;
    private final String shortcut;

    LineMenuEnum(String name, String shortcut) {
        this.name = name;
        this.shortcut = shortcut;
    }

    public static Optional<LineMenuEnum> of(final String shortcut) {
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
