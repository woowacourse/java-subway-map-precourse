package subway.view;

import java.util.Arrays;

public class MainView{
    private static final String START_MAIN_TEXT="## 메인 화면";
    private static final String ERROR="잘못된 입력입니다.";


    public void showMenu(){
        System.out.println(START_MAIN_TEXT);
        Arrays.stream(MainMenu.values()).forEach(menu->{
            System.out.println(menu.getKey()+". "+menu.getMenuName());
        });
    }

    public MainMenu selectMenu(){
        while(true){
            String input=InputView.getMenu();
            if(!MainMenu.isValidInput(input)){
                OutputView.printError(ERROR);
                continue;
            }
            return MainMenu.findMenuByKey(input);
        }
    }
}
