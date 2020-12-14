package subway.utils;

import subway.model.ResultDto;

import java.util.function.Supplier;

public class ErrorUtils {

    public static ResultDto produceResponse(final Supplier<ResultDto> supplier) {
        try {
            return supplier.get();
        } catch (Exception e) {
            return ResultDto.bad(e);
        }
    }


}
