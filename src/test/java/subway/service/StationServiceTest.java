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

    @Test
    public void 역_중복_예외_테스트() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            StationRepository.addStation(yangsan);
            StationService stationService = new StationService(scanner);
            stationService.isDuplicatedStation(new Station("양산역"));
        });
        Assertions.assertEquals("\n[ERROR] 해당 역은 이미 등록되었습니다.", exception.getMessage());
    }
}