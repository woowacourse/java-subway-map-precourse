package subway.view;

public class OutputView {
    public static void showMainMenu(){
        StringBuffer mainMenus = new StringBuffer();
        mainMenus.append("## 메인화면").append(System.lineSeparator())
                .append("1. 역 관리").append(System.lineSeparator())
                .append("2. 노선 관리").append(System.lineSeparator())
                .append("3. 구간 관리").append(System.lineSeparator())
                .append("4. 지하철 노선도 출력").append(System.lineSeparator())
                .append("Q. 종료").append(System.lineSeparator())
                .append("---");

        System.out.println(mainMenus.toString());
    }
    
    public static void println(String message){
        System.out.println(message);
    }
}
