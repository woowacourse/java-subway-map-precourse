package subway.tool;

import subway.domain.Station;

public class InputTool {
    public static boolean isMainInputVaild(String input){
        if(input.compareTo("1") ==0) return true;
        if(input.compareTo("2") ==0) return true;
        if(input.compareTo("3") ==0) return true;
        if(input.compareTo("4") ==0) return true;
        if(input.compareTo("Q") ==0) return true;
        return false;
    }
    public static boolean isStationInputVaild(String input){
        if(input.compareTo("1") ==0) return true;
        if(input.compareTo("2") ==0) return true;
        if(input.compareTo("3") ==0) return true;
        if(input.compareTo("B") ==0) return true;
        return false;
    }
    public static boolean isValidName(String name){
        final int MIN_NAME_LENGTH = 2;
        if(name.length() < MIN_NAME_LENGTH) return false;
        return true;
    }
    public static boolean isLineInputVaild(String input){
        if(input.compareTo("1") ==0) return true;
        if(input.compareTo("2") ==0) return true;
        if(input.compareTo("3") ==0) return true;
        if(input.compareTo("B") ==0) return true;
        return false;
    }
}
