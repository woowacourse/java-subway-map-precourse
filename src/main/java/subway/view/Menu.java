package subway.view;

public class Menu {

    public static final String GUIDE_PREFIX = "## ";
    public static final String WHAT_MENU = "원하는 기능을 선택하세요.";
    public static final String STATION_GUIDE = " 역 이름을 입력하세요.";

    public static final String LINE_GUIDE = " 노선 이름을 입력하세요.";


    private Menu() {
    }

    public static void printMenu(String[] menuItems) {
        for (String item : menuItems) {
            System.out.println(item);
        }
        System.out.println();
    }

    public static void printWhatMenu(){
        System.out.println(GUIDE_PREFIX+WHAT_MENU);
    }

    public static void printStationGuide(String function){
        System.out.println(GUIDE_PREFIX+function+STATION_GUIDE);
    }
    public static void printLineGuide(String function){
        System.out.println(GUIDE_PREFIX+function+LINE_GUIDE);
    }

}
