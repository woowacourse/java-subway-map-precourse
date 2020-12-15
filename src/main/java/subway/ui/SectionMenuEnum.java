package subway.ui;

import static java.util.stream.Collectors.toMap;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public enum SectionMenuEnum {
    ADD_SECTION("구간 등록", "1") {
        @Override
        public void action(final Scanner scanner) {
            try {
                SectionMenu.addSection(scanner);
            } catch (IllegalArgumentException e) {
                ConsoleOutput.printErrorMessage(e.getMessage());
            }
        }
    },
    DELETE_SECTION("구간 삭제", "2") {
        @Override
        public void action(final Scanner scanner) {
            try {
                SectionMenu.deleteSection(scanner);
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

    private static final Map<String, SectionMenuEnum> MAP;

    static {
        Map<String, SectionMenuEnum> mainMenuMap = Arrays.stream(values())
            .collect(toMap(mainMenuEnum -> mainMenuEnum.shortcut, e -> e));
        MAP = Collections.unmodifiableMap(mainMenuMap);
    }

    private final String name;
    private final String shortcut;

    SectionMenuEnum(String name, String shortcut) {
        this.name = name;
        this.shortcut = shortcut;
    }

    public static Optional<SectionMenuEnum> of(final String shortcut) {
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
