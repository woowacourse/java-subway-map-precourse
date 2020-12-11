package subway.view.component;

public class ErrorViewComponent {
    private static final String errorPrefixComponent = "[ERROR] ";
    private static final String unselectableFeatureComponent = "선택할 수 없는 기능입니다.";

    public static String getUnselectableFeatureComponent(){
        return errorPrefixComponent + unselectableFeatureComponent;
    }
}
