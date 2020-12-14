package subway.utils;

import subway.model.ResultDto;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ErrorUtils {

    public static ResultDto produceResponse(final Supplier<ResultDto> supplier) {
        try {
            return supplier.get();
        } catch (Exception e) {
            return ResultDto.bad(e);
        }
    }

    public static Object repeatInputUntilNoException(final Supplier<Object> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (Exception e) {
                System.out.println(e.getMessage() + "\n");
            }
        }
    }
}
