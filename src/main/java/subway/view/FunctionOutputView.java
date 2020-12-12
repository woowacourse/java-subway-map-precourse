package subway.view;

import subway.domain.DetailFunctions;
import subway.domain.MainFunctions;

import java.util.List;
import java.util.Objects;

import static subway.view.OutputView.PRINT_INFO_HEAD;

public class FunctionOutputView {

    public static void printFunction(DetailFunctions detailFunctions, MainFunctions mainFunctions) {
        System.out.println();
        System.out.println("## " + detailFunctions.getFunctionName() + "할 " + mainFunctions.getFunctionName() + " 이름을 입력하세요.");
    }

    public static void printSuccess(DetailFunctions detailFunctions, MainFunctions mainFunctions) {
        System.out.println();
        System.out.println(PRINT_INFO_HEAD + "지하철 " + mainFunctions.getFunctionName() + "이 " + detailFunctions.getFunctionName() + "되었습니다.");
        System.out.println();
    }

    public static void printResearch(MainFunctions mainFunctions) {
        System.out.println();
        System.out.println("## " + mainFunctions.getFunctionName() + " 목록");

        for (String object : Objects.requireNonNull(MainFunctions.getObjectsToString(mainFunctions))) {
            System.out.println(PRINT_INFO_HEAD + object);
        }
        System.out.println();
    }

    public static void printStartOrFinishStation(String startOrFinish) {
        System.out.println();
        System.out.println("## 등록할 노선의 " + startOrFinish + " 종점역 이름을 입력하세요.");
    }
}