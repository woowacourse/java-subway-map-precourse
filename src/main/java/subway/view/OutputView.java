package subway.view;

import subway.domain.MainFunctions;
import subway.domain.DetailFunctions;

public class OutputView {
    public static void printMain(){
        System.out.println("## 메인 화면");
        System.out.println(MainFunctions.STATION.getFunctionNumber()+". "+ MainFunctions.STATION.getFunctionName()+" 관리");
        System.out.println(MainFunctions.LINE.getFunctionNumber()+". "+ MainFunctions.LINE.getFunctionName()+" 관리");
        System.out.println(MainFunctions.WAY.getFunctionNumber()+". "+ MainFunctions.WAY.getFunctionName()+" 관리");
        System.out.println(MainFunctions.SUBWAY.getFunctionNumber()+". "+ MainFunctions.SUBWAY.getFunctionName()+" 출력");
        System.out.println(MainFunctions.FINISH.getFunctionNumber()+". "+ MainFunctions.FINISH.getFunctionName());
    }

    public static void printDetailFunction(MainFunctions mainFunction) {
        System.out.println("## " + mainFunction.getFunctionName()+" 관리 화면");
        System.out.println(DetailFunctions.ENROLL.getFunctionNumber()+". "+mainFunction.getFunctionName()+" "+ DetailFunctions.ENROLL.getFunctionName());
        System.out.println(DetailFunctions.REMOVE.getFunctionNumber()+". "+mainFunction.getFunctionName()+" "+ DetailFunctions.REMOVE.getFunctionName());
        if(!mainFunction.equals(MainFunctions.WAY)) {
            System.out.println(DetailFunctions.RESEARCH.getFunctionNumber() + ". " + mainFunction.getFunctionName() + " " + DetailFunctions.RESEARCH.getFunctionName());
        }
        System.out.println(DetailFunctions.BACK.getFunctionNumber()+". "+ DetailFunctions.BACK.getFunctionName());
    }
}
