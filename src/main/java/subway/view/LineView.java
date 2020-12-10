package subway.view;

import java.util.Arrays;

public class LineView {
    private static final String START_STATION_TEXT="## 노선 관리 화면";
    private static final String ERROR="잘못된 입력입니다.";

    public static Boolean selectMenu(){
        while(true){
            showMenu();
            String input=InputView.getMenu();
            if(!LineMenu.isValidInput(input)){
                OutputView.printError(ERROR);
                continue;
            }
            if(!LineMenu.findMenuByKey(input).request()){
                continue;
            }
            break;
        }
        return false;
    }

    private static void showMenu(){
        System.out.println(START_STATION_TEXT);
        Arrays.stream(LineMenu.values()).forEach(menu->{
            System.out.println(menu.getKey()+". "+menu.getMenuName());
        });
    }
}
