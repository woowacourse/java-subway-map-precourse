package subway.service.input;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.station.MemoryStationRepository;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;

class ScannerInputServiceTest {

    public static InputService getScannerInputUtils(String inputText) {
        InputStream inputStream = new ByteArrayInputStream(inputText.getBytes());
        System.setIn(inputStream);
        Scanner scanner = new Scanner(inputStream);
        InputService inputUtils = ScannerInputService.of(scanner);
        return inputUtils;
    }

    @Test
    @DisplayName("지하철 역 이름을 입력받는다")
    void inputStationName() {
        //given
        String incheonText = "인천시청";
        String seoulText = "서울시청";

        //when
        InputService scannerInputUtils = getScannerInputUtils(incheonText);
        InputService scannerInputUtils2 = getScannerInputUtils(seoulText);
        String incheonStationName = scannerInputUtils.getStationName();
        String seoulStationName = scannerInputUtils2.getStationName();

        //then
        assertThat(incheonStationName).isEqualTo(incheonText);
        assertThat(seoulStationName).isEqualTo(seoulText);

    }
}
