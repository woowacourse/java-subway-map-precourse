package subway.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NameTest {
    @Test
    public void 이름은_2자_보다_짧으면_에러() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Name("마");
        });
        Assertions.assertEquals("[ERROR] 이름의 길이는 2자 이상이어야 합니다.", exception.getMessage());
    }

    @Test
    public void 이름은_한글로만_이루어져_있어야_한다() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Name("마포역9a");
        });
        Assertions.assertEquals("[ERROR] 이름은 올바른 한글과 숫자만 가능합니다.", exception.getMessage());
    }
}