package subway.utils;

import subway.view.ErrorView;

public class Util {

    public static int operationNumber(String number,int start, int end){
        if(number.equals("Q")){
            return 0;
        }
        if(!isNumber(number)){
            ErrorView.writeAppropriateNumber();
            return -1;
        }
        int operationNumber = Integer.parseInt(number);
        if(operationNumber < start || operationNumber > end){
            ErrorView.writeAppropriateNumber();
            return -1;
        }
        return operationNumber;
    }

    private static boolean isNumber(String number) {
        int length = number.length();
        for(int i=0;i<length;i++){
            if(!Character.isDigit(number.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
