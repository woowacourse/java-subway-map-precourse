package subway.utils;

import java.util.function.Supplier;
import subway.view.OutputView;

public class ErrorUtils {

    public static void repeatingUntilNoException(final SupplierNoReturn supplierNoReturn) {
        while (true) {
            try {
                supplierNoReturn.execute();
                return;
            } catch (RuntimeException e) {
                OutputView.println(e.getMessage());
                OutputView.println();
            }
        }
    }

    public static Object repeatingUntilNoException(final Supplier<Object> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (RuntimeException e) {
                OutputView.println(e.getMessage());
                OutputView.println();
            }
        }
    }
}
