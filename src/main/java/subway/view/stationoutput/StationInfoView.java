package subway.view.stationoutput;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InfoView;
import subway.view.OutputView;

public class StationInfoView extends InfoView {
    private static final String REGISTER_INFO = "지하철 역이 등록되었습니다.";
    private static final String DELETE_INFO = "지하철 역이 삭제되었습니다.";

    public static void printRegisterInfo() {
        printInfo(REGISTER_INFO);
    }

    public static void printDeleteInfo() {
        printInfo(DELETE_INFO);
    }

    public static void printStation() {
        for (Station station : StationRepository.stations()) {
            System.out.println(INFO + station.getName());
        }
        OutputView.printNewLine();
    }
}
