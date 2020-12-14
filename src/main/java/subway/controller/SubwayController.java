package subway.controller;

import subway.menu.MainMenu;
import subway.view.InputView;

public class SubwayController {
  public static void run() {
      while(true){
          MainMenu.findByCommand(InputView.nextLine()).run();
      }
  }
}
