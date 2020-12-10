package subway.view;

import subway.domain.LineRepository;

import java.util.Arrays;

public class StationView {
    private static final String START_STATION_TEXT="## 역 관리 화면";
    private static final String ERROR="잘못된 입력입니다.";

    public static Boolean selectMenu(){
        while(true){
            showMenu();
            String input=InputView.getMenu();
            if(!StationMenu.isValidInput(input)){
                OutputView.printError(ERROR);
                continue;
            }
            if(!StationMenu.findMenuByKey(input).request()){
                continue;
            }
            break;
        }
        return false;
    }

    private static void showMenu(){
        System.out.println(START_STATION_TEXT);
        Arrays.stream(StationMenu.values()).forEach(menu->{
            System.out.println(menu.getKey()+". "+menu.getMenuName());
        });
    }
}
