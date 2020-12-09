package subway.view;

public class CommonView {
    private static final String selectFeatureView = "## 원하는 기능을 선택하세요.";

    public static void printSelectFeatureView(){
        System.out.println(selectFeatureView);
    }

    public static void printWhiteLine(){
        System.out.println();
    }
}
