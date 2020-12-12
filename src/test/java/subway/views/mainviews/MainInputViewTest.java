package subway.views.mainviews;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainInputViewTest {

    @Test
    void 메인메뉴_선택_테스트() {
        boolean isExist = MainInputView.isExistMainMenu("Q");
        Assertions.assertEquals(true, isExist);
    }

    @Test
    void 메인메뉴_선택_예외_테스트() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            MainInputView.checkExistMainMenu("");
        });
        Assertions.assertEquals("[ERROR] 선택할 수 없는 기능입니다.", exception.getMessage());
    }
}