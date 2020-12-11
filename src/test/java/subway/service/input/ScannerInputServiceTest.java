package subway.service.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.exception.ErrorCode;
import subway.exception.InputServiceException;

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
        String incheonStationName = scannerInputUtils.getName();
        String seoulStationName = scannerInputUtils2.getName();

        //then
        assertThat(incheonStationName).isEqualTo(incheonText);
        assertThat(seoulStationName).isEqualTo(seoulText);
    }

    @Test
    @DisplayName("옵션을 입력받는다")
    void inputOption() {
        //given
        String optionOne = "1";
        String optionTwo = "2";
        String optionQuit = "Q";

        //when
        InputService scannerInputUtils = getScannerInputUtils(optionOne);
        InputService scannerInputUtils2 = getScannerInputUtils(optionTwo);
        InputService scannerInputUtils3 = getScannerInputUtils(optionQuit);
        int mainOptionOne = scannerInputUtils.getMainOption();
        int mainOptionTwo = scannerInputUtils2.getMainOption();
        int mainOptionQuit = scannerInputUtils3.getMainOption();

        //then
        assertThat(mainOptionOne).isEqualTo(InputService.MANAGE_STATION);
        assertThat(mainOptionTwo).isEqualTo(InputService.MANAGE_ROUTE);
        assertThat(mainOptionQuit).isEqualTo(InputService.OPTION_QUIT);
    }

    @Test
    @DisplayName("지정된 옵션 이외의 것들을 입력하면 에러를 출력한다.")
    void inputOptionQuit() {
        //given
        String optionMinus = "-1";
        String optionNine = "9";
        String option = "w";

        //when
        InputService scannerInputUtils = getScannerInputUtils(optionMinus);
        InputService scannerInputUtils2 = getScannerInputUtils(optionNine);
        InputService scannerInputUtils3 = getScannerInputUtils(option);

        //then
        assertThatThrownBy(() -> scannerInputUtils.getMainOption())
                .isInstanceOf(InputServiceException.class)
                .hasMessage("[ERROR] 선택할 수 없는 기능입니다.");
        assertThatThrownBy(() -> scannerInputUtils2.getMainOption())
                .isInstanceOf(InputServiceException.class)
                .hasMessage("[ERROR] 선택할 수 없는 기능입니다.");
        assertThatThrownBy(() -> scannerInputUtils3.getMainOption())
                .isInstanceOf(InputServiceException.class)
                .hasMessage("[ERROR] 선택할 수 없는 기능입니다.");
    }

    @Test
    @DisplayName("지하철 역 관리 옵션을 입력받는다")
    void inputManageStationOption() {
        //given
        String optionOne = "1";
        String optionTwo = "2";
        String optionBack = "B";

        //when
        InputService scannerInputUtils = getScannerInputUtils(optionOne);
        InputService scannerInputUtils2 = getScannerInputUtils(optionTwo);
        InputService scannerInputUtils3 = getScannerInputUtils(optionBack);
        int mainOptionOne = scannerInputUtils.getManageStationOption();
        int mainOptionTwo = scannerInputUtils2.getManageStationOption();
        int mainOptionBack = scannerInputUtils3.getManageStationOption();

        //then
        assertThat(mainOptionOne).isEqualTo(InputService.ADD);
        assertThat(mainOptionTwo).isEqualTo(InputService.DELETE);
        assertThat(mainOptionBack).isEqualTo(InputService.OPTION_BACK);
    }

    @Test
    @DisplayName("지정되지 않은 옵션을 선택하면 에러가 발생한다.")
    void inputManageStationOptionError() {
        //given
        String optionOne = "`";
        String optionTwo = "0";
        String optionBack = "C";

        //when
        InputService scannerInputUtils = getScannerInputUtils(optionOne);
        InputService scannerInputUtils2 = getScannerInputUtils(optionTwo);
        InputService scannerInputUtils3 = getScannerInputUtils(optionBack);

        //then
        assertThatThrownBy(() -> scannerInputUtils.getManageStationOption())
                .isInstanceOf(InputServiceException.class)
                .hasMessage(ErrorCode.CANNOT_CHOOSE_OPTION.getMessage());
        assertThatThrownBy(() -> scannerInputUtils2.getManageStationOption())
                .isInstanceOf(InputServiceException.class)
                .hasMessage(ErrorCode.CANNOT_CHOOSE_OPTION.getMessage());
        assertThatThrownBy(() -> scannerInputUtils3.getManageStationOption())
                .isInstanceOf(InputServiceException.class)
                .hasMessage(ErrorCode.CANNOT_CHOOSE_OPTION.getMessage());
    }
}
