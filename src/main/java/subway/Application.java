package subway;

import subway.domain.menu.DataList;
import subway.view.OutputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현

        OutputView.printMainView();
        OutputView.printManagementView(DataList.SECTION);
    }
}
