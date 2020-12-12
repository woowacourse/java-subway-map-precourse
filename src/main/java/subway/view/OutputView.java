package subway.view;

import subway.domain.LineRepository;
import subway.domain.StationRepository;

public class OutputView {

    public static void inquiryStation() {
        System.out.println("[INFO] 역 목록");
        StationRepository.stations().stream().forEach(x -> System.out.println(x.getName()));
        System.out.println();
    }
}
