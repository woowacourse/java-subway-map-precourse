package subway.domain.menu;

public enum  ManagementMenu {

    REGISTER("1", "등록")
    , DELETE("2", "삭제")
    , FIND("3", "조회")
    , BACK("B", "돌아가기");

    final private String order;
    final private String message;

    ManagementMenu(String order, String message) {
        this.order = order;
        this.message = message;
    }

    public String getOrder() {
        return order;
    }

    public String getMessage() {
        return message;
    }

}
