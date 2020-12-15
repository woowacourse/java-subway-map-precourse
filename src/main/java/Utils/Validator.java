package Utils;

import subway.Constant;

import java.util.IllformedLocaleException;

public class Validator {

    public static void checkDataLength(String data){
        if(data.length() < Constant.MINIMUM_LENGTH){
            throw new IllegalArgumentException(Constant.ILLEGAL_ARGUMENT_EXCEPTION_MINIMUM_LENGTH);
        }
    }
}
