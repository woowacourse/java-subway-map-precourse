package subway.utils;

import java.util.Scanner;

/**
 * 프로그램의 입력 부분을 담당하는 클래스
 *
 * @author 483759@naver.com / 윤이진
 * @version 1.0 2020/12/10
 */
public class InputUtils {
    private final Scanner scanner;
    private final ValidateUtils validateUtils;
    private final PrintUtils printUtils;

    public InputUtils(){
        scanner = new Scanner(System.in);
        validateUtils = new ValidateUtils();
        printUtils = new PrintUtils();
    }

    public char inputFunctionSelect(int bound, char quit){
        try{
            String selectMenu = scanner.nextLine();
            if(!validateUtils.isValidMenuSelect(selectMenu, bound, quit))
                throw new IllegalArgumentException();
            return selectMenu.charAt(0);
        }catch(IllegalArgumentException e){
            printUtils.invalidMenuError();
            return inputFunctionSelect(bound, quit);
        }
    }

    public String inputStationName(){
        try{
            String stationName = scanner.nextLine();
            if(!validateUtils.isValidStationName(stationName))
                throw new IllegalArgumentException();
            return stationName;
        }catch(IllegalArgumentException e){
            printUtils.invalidStationNameLengthError();
            return inputStationName();
        }
    }

    public String inputLineName(){
        try{
            String lineName = scanner.nextLine();
            if(!validateUtils.isValidLineName(lineName))
                throw new IllegalArgumentException();
            return lineName;
        }catch(IllegalArgumentException e){
            printUtils.invalidLineNameError();
            return inputLineName();
        }
    }

    public int inputStationOrder(int stationSize){
        try{
            int stationOrder=Integer.parseInt(scanner.nextLine());
            if(!validateUtils.isValidOrder(stationSize,stationOrder-1))
                throw new IllegalArgumentException();
            return stationOrder-1;
        }catch (IllegalArgumentException e){
            printUtils.stationOrderError(stationSize);
            return inputStationOrder(stationSize);
        }
    }
}
