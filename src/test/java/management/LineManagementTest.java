package management;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class LineManagementTest {
    @Test
    @DisplayName("기능 선택이 잘못되었을 때 예외 발생")
    public void checkFunctionButton() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        LineManagement lineManagement = new LineManagement();

        Method method = lineManagement.getClass().getDeclaredMethod("checkFunctionButton", String.class);
        method.setAccessible(true);
        method.invoke(lineManagement, "&");

    }

}