package subway.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum SectionMenu {
    FIRST("1", "1. 구간 등록", List.of("## 노선을 입력하세요.", "## 역이름을 입력하세요.", "## 순서를 입력하세요.")),
    SECOND("2", "2. 구간 삭제", List.of("## 삭제할 구간의 노선을 입력하세요.", "## 삭제할 구간의 역을 입력하세요.")),
    BACK("B", "B. 돌아가기", null);

    private final String userInput;
    private final String menuName;
    private final List<String> followingMessages;

    SectionMenu(String userInput, String menuName, List<String> followingMessages) {
        this.userInput = userInput;
        this.menuName = menuName;
        this.followingMessages = followingMessages;
    }

    public static String getDeletingLineName() {
        return SECOND.followingMessages.get(0);
    }

    public static String getDeletingStationName() {
        return SECOND.followingMessages.get(1);
    }

    public static String getAddingLineName() {
        return FIRST.followingMessages.get(0);
    }

    public static String getAddingStationName() {
        return FIRST.followingMessages.get(1);
    }

    public static String getAddingOrder() {
        return FIRST.followingMessages.get(2);
    }

    public String getUserInput() {
        return this.userInput;
    }

    public static List<String> getAddSectionFollowingMessages() {
        return FIRST.followingMessages;
    }

    public static List<String> getDeleteSectionFollowingMessages() {
        return SECOND.followingMessages;
    }

    public static String getWholeMenu() {
        return Arrays.stream(SectionMenu.values())
                .map(menu -> menu.menuName)
                .collect(Collectors.joining("\n"));
    }
}
