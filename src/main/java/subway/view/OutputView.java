package subway.view;

import java.util.Arrays;
import subway.controller.IOption;
import subway.controller.MenuController;

public class OutputView {

    // todo 컨트롤러에서 준 데이터를 출력
    // todo 출력 방식에 관해서는 모두 OutputView 역할
    // todo 정상, 에러 출력 모두 이곳에서 담당 - try catch

    public static final String INFO = "[INFO] ";
    public static final String ERROR = "[ERROR] ";

    final MenuController menuController;

    public OutputView(MenuController menuController) {
        this.menuController = menuController;
    }

    public void printTitle() {
        System.out.println(menuController.TITLE);
    }

    public void printOptions() {
        Arrays.stream(menuController.getOptions())
                .map(IOption::toString)
                .forEach(System.out::println);
    }
}
