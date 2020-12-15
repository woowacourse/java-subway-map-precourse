package subway.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import subway.domain.Station;
import subway.repository.StationRepository;

import java.util.Scanner;

class StationServiceTest {
    Station yangsan = new Station("양산역");
    Scanner scanner = new Scanner(System.in);

    @Test
    public void 역_추가_테스트() {
        StationRepository.addStation(yangsan);

        Assertions.assertEquals(true, StationRepository.stations().contains(yangsan));
    }

//    @Test
//    public void 역_중복_예외_테스트() {
//        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            StationRepository.addStation(yangsan);
//            StationService stationService = new StationService(scanner);
//            stationService.isDuplicatedStation(new Station("양산역"));
//        });
//        Assertions.assertEquals("\n[ERROR] 해당 역은 이미 등록되었습니다.", exception.getMessage());
//    }

    @Test
    public void 역_삭제_테스트() {
        StationRepository.deleteStation("양산역");
        Assertions.assertEquals(false, StationRepository.stations().contains(yangsan));
    }

//    @Test
//    public void 역_삭제할_때_존재하지_않으면_예외_테스트() {
//        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            StationRepository.addStation(yangsan);
//            StationService stationService = new StationService(scanner);
//            stationService.isNotExistStation(new Station("증산역"));
//        });
//        Assertions.assertEquals("\n[ERROR] 삭제할 역이 존재하지 않습니다.", exception.getMessage());
//    }
}