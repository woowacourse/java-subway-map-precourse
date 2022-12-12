package constants;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum LineMenu {
    FIRST("1", "1. 노선 등록", List.of("## 등록할 노선 이름을 입력하세요.", "## 등록할 노선의 상행 종점역 이름을 입력하세요.", "## 등록할 노선의 하행 종점역 이름을 입력하세요.")),
    SECOND("2", "2. 노선 삭제", null),
    THIRD("3", "3. 노선 조회", null),
    BACK("B", "B. 돌아가기", null);

    private final String userInput;
    private final String menuName;
    private final List<String> followingInputMessage;

    LineMenu(String userInput, String menuName, List<String> followingInputMessage) {
        this.userInput = userInput;
        this.menuName = menuName;
        this.followingInputMessage = followingInputMessage;
    }

    public String getUserInput() {
        return this.userInput;
    }

    public static List<String> getFollowingInputMessage() {
        return FIRST.followingInputMessage;
    }

    public static String getWholeMenu() {
        return Arrays.stream(LineMenu.values())
                .map(menu -> menu.menuName)
                .collect(Collectors.joining("\n"));
    }
}
