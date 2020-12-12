package subway.utils;

import java.util.function.Supplier;
import subway.view.OutputView;
import subway.view.screen.Screen;
import subway.view.screen.ScreenManager;

public class ErrorUtils {

    public static Object repeatingUntilNoException(final Supplier<Object> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (RuntimeException e) {
                OutputView.println();
                OutputView.println(Screen.ERROR_PREFIX + e.getMessage());
            }
        }
    }

    public static void screenGoBackWhenException(final SupplierNoReturn supplierNoReturn) {
        try {
            supplierNoReturn.execute();
        } catch (RuntimeException e) {
            OutputView.println();
            OutputView.println(Screen.ERROR_PREFIX + e.getMessage());
            ScreenManager.goBack();
        }
    }
}
