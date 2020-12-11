package subway.domain;

public class Exception {
    static String isStation(String input){
        String lastChar = input.substring(input.length() - 1, input.length());
        if(lastChar.equals("역")){
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
}
