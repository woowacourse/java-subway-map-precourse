package subway;

import subway.Manager.SubwayManager;
import subway.config.SubwayConfig;
import view.OutputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        SubwayConfig.subwayMapInit();
        SubwayManager subwayManager = new SubwayManager(scanner);
        subwayManager.manage();
        OutputView.printFinishProgram();
    }
}
