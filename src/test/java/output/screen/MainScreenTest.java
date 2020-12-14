package output.screen;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class MainScreenTest {

    @Test
    @DisplayName("기능 선택이 잘못되었을 때 예외 발생")
    public void setSelectedScreen() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        MainScreen mainScreen = new MainScreen();

        Method method = mainScreen.getClass().getDeclaredMethod("setSelectedScreen", String.class);
        method.setAccessible(true);
        method.invoke(mainScreen, "&");
    }


}