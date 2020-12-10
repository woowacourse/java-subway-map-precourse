package subway;

import subway.Manager.SubwayManager;
import subway.config.SubwayConfig;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        SubwayConfig.metroSetup();
        SubwayManager subwayManager = new SubwayManager(scanner);
        while (true)
        {
            OutputView.mainView();
            String status = subwayManager.execute(InputView.inputFunction(scanner));
            if (status.equals("Q"))
                break;
        }

//        // 지하철 노선 값 확인을 위함
//        System.out.println("\n-----지하철 역 노선 연결 확인을 위함-----");
//        Map<Line, List<Station>> subway = SubwayRepository.getSubway();
//        for (Line line : subway.keySet()) {
//            System.out.println(line.getName() + ":" + subway.get(line));
//        }
    }
}
