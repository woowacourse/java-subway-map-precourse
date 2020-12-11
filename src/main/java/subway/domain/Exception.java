package subway.domain;

public class Exception {
    private static final int NAME_LENGTH_MINIMUM = 2;
    private static final String STATION = "역";

    static String passNameExceptionTest(String input){
        input = Exception.isNotSpace(input);
        input = Exception.isNotEmpty(input);
        input = Exception.isNotTooShort(input);
        return Exception.isStation(input);
    }

    static String isStation(String input){
        String lastChar = input.substring(input.length() - 1, input.length());
        if(lastChar.equals(STATION)){
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
        if(input.length() >= NAME_LENGTH_MINIMUM){
            return input;
        }
        throw new IllegalArgumentException();
    }
}
