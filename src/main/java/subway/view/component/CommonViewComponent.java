package subway.view.component;

public class CommonViewComponent {
    private static final String selectFeatureView = "## 원하는 기능을 선택하세요.";
    private static final String whiteLineComponent = "\n";

    public static String getSelectFeatureViewComponent(){
        return selectFeatureView;
    }

    public static String getWhiteLineComponent(){
        return whiteLineComponent;
    }
}
