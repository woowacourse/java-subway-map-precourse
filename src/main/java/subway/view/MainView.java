package subway.view;

import subway.view.*;
public class MainView {
    public static boolean MainMenu(){
        try{
            showView();
            String user_input = InputView.mainInput();
            System.out.println(user_input+"??");
            if(user_input.compareTo("Q") ==0) return true;
            nextMenu();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    public static void showView() {
        System.out.println("## 메인 화면");
        System.out.println("1. 역 관리");
        System.out.println("2. 노선 관리");
        System.out.println("3. 구간 관리");
        System.out.println("4. 지하철 노선도 출력");
        System.out.println("Q. 종료");
    }
    public static void nextMenu(int menu) {
        if(menu == 1) StationManagementView
    }

}
