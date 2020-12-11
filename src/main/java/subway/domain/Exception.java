package subway.domain;

public class Exception {


    static String passNameExceptionTest(String input){
        input = isNotSpace(input);
        input = isNotEmpty(input);
        input = isNotTooShort(input);
        return isStation(input);
    }

    static String isStation(String input){
        String lastChar = input.substring(input.length() - 1, input.length());
        if(lastChar.equals(Constant.STATION)){
            return input;
        }
        throw new IllegalArgumentException();
    }

    static String isNotEmpty(String input){
        if(!input.equals("")){
            return input;
        }
        throw new IllegalArgumentException();
    }

    static String isNotSpace(String input){
        if(!input.contains(" ")){
            return input;
        }
        throw new IllegalArgumentException();
    }

    static String isNotTooShort(String input){
        if(input.length() >= Constant.NAME_LENGTH_MINIMUM){
            return input;
        }
        throw new IllegalArgumentException();
    }
}
