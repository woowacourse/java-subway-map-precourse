package Category;

public enum Category {
    MAIN(
            "\n## 메인 화면",
            "1. 역관리\n" + "2. 노선관리\n" + "3. 구간 관리\n" + "4. 지하철 노선도 출력\n" + "Q. 종료"),
    STATION(
            "\n## 역 관리 화면",
            "1. 역 등록\n" + "2. 역 삭제\n" + "3. 역 조회\n" + "B. 돌아가기"),
    LINE(
            "\n## 노선 관리 화면",
            "1. 노선 등록\n" + "2. 노선 삭제\n" + "3. 노선 조회\n" + "B. 돌아가기"),
    SECTION(
            "\n## 구간 관리 화면",
            "1. 구간 등록\n" + "2. 구간 삭제\n" + "B. 돌아가기");

    private final String name;
    private final String actionOrder;

    Category(String name, String actionOrder) {
        this.name = name;
        this.actionOrder = actionOrder;
    }

    public String getName() {
        return name;
    }

    public String getActionOrder() {
        return actionOrder;
    }
}
