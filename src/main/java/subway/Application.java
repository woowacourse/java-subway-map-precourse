package subway;

import subway.view.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while(true){
            boolean isEndService = MainView.MainMenu();
            if(isEndService) break;
        }
    }
}
