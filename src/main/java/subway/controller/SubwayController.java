package subway.controller;

import subway.menu.MainMenu;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayController {
  public static void run() {
      while(true){
          //TODO : Menu enum에서 값을 추출하여 동적으로 메뉴를 출력하도록 수정
          OutputView.showMainMenu();
          MainMenu.findByCommand(InputView.nextLine()).run();
      }
  }
}
