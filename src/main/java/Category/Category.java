package Category;

import java.util.Arrays;
import java.util.List;

public enum Category {
    MAIN(
            "\n## 메인 화면",
            "1. 역관리\n" + "2. 노선관리\n" + "3. 구간 관리\n" + "4. 지하철 노선도 출력\n" + "Q. 종료",
            Arrays.asList("1", "2", "3", "4", "Q")),
    STATION(
            "\n## 역 관리 화면",
            "1. 역 등록\n" + "2. 역 삭제\n" + "3. 역 조회\n" + "B. 돌아가기",
            Arrays.asList("1", "2", "3", "B")),
    LINE(
            "\n## 노선 관리 화면",
            "1. 노선 등록\n" + "2. 노선 삭제\n" + "3. 노선 조회\n" + "B. 돌아가기",
            Arrays.asList("1", "2", "3", "B")),
    SECTION(
            "\n## 구간 관리 화면",
            "1. 구간 등록\n" + "2. 구간 삭제\n" + "B. 돌아가기",
            Arrays.asList("1", "2", "B"));

    private final String name;
    private final String actionOrder;
    private final List<String> actionType;

    Category(String name, String actionOrder, List<String> actionType) {
        this.name = name;
        this.actionOrder = actionOrder;
        this.actionType = actionType;
    }

    public String getName() {
        return name;
    }

    public String getActionOrder() {
        return actionOrder;
    }

    public List<String> getActionType() {
        return actionType;
    }
}
