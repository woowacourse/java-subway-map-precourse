package subway.controller.message;

public enum MainMessage implements Message {
    SELECT_FUNCTION("원하는 기능을 선택하세요."),
    ERROR_SELECT_FUNCTION("선택할 수 없는 기능입니다.");

    private String content;

    MainMessage(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {
        return content;
    }
}
