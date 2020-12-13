package subway.tool;

public class InputTool {
    public static boolean isMainInputVaild(String input){
        if(input.compareTo("1") ==0) return true;
        if(input.compareTo("2") ==0) return true;
        if(input.compareTo("3") ==0) return true;
        if(input.compareTo("4") ==0) return true;
        if(input.compareTo("Q") ==0) return true;
        return false;
    }
}
