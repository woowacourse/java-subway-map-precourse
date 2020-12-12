package subway.view.component;

public class SectionManagementViewComponent {
    private static final String menuComponent = "## 구간 관리 화면\n" +
            "1. 구간 등록\n" +
            "2. 구간 삭제\n" +
            "B. 돌아가기";
    private static final String finishPrefixComponent = "[INFO] ";
    private static final String sectionRegisterLineNameInputComponent = "## 노선을 입력하세요.";
    private static final String sectionRegisterStationNameInputComponent = "## 역이름을 입력하세요.";
    private static final String sectionRegisterStationOrderComponent = "## 순서를 입력하세요.";
    private static final String sectionRegisterFinishComponent = "구간이 등록되었습니다.";
    private static final String sectionRemoveLineNameInputComponent = "## 삭제할 구간의 노선을 입력하세요.";
    private static final String sectionRemoveStationNameInputComponent = "## 삭제할 구간의 역을 입력하세요.";
    private static final String sectionRemoveFinishComponent = "구간이 삭제되었습니다.";

    public static String getMenuComponent(){
        return menuComponent;
    }

    public static String getSectionRegisterLineNameInputComponent(){
        return sectionRegisterLineNameInputComponent;
    }

    public static String getSectionRegisterStationNameInputComponent(){
        return sectionRegisterStationNameInputComponent;
    }

    public static String getSectionRegisterStationOrderComponent(){
        return sectionRegisterStationOrderComponent;
    }

    public static String getSectionRegisterFinishComponent(){
        return finishPrefixComponent + sectionRegisterFinishComponent;
    }

    public static String getSectionRemoveLineNameInputComponent(){
        return sectionRemoveLineNameInputComponent;
    }

    public static String getSectionRemoveStationNameInputComponent(){
        return sectionRemoveStationNameInputComponent;
    }

    public static String getSectionRemoveFinishComponent(){
        return finishPrefixComponent + sectionRemoveFinishComponent;
    }
}
