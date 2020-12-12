package subway.view;

import subway.domain.DetailFunctions;
import subway.domain.MainFunctions;

import java.util.Objects;

import static subway.view.OutputView.INFO_HEAD;
import static subway.view.OutputView.NOTICE_HEAD;

public class FunctionOutputView {

    public static void printFunction(DetailFunctions detailFunctions, MainFunctions mainFunctions) {
        System.out.println();
        System.out.println(NOTICE_HEAD + detailFunctions.getFunctionName() + "할 " + mainFunctions.getFunctionName() + " 이름을 입력하세요.");
    }

    public static void printSuccess(DetailFunctions detailFunctions, MainFunctions mainFunctions) {
        System.out.println();
        System.out.println(INFO_HEAD + "지하철 " + mainFunctions.getFunctionName() + "이 " + detailFunctions.getFunctionName() + "되었습니다.");
        System.out.println();
    }

    public static void printResearch(MainFunctions mainFunctions) {
        System.out.println();
        System.out.println(NOTICE_HEAD + mainFunctions.getFunctionName() + " 목록");

        for (String object : Objects.requireNonNull(MainFunctions.getObjectsToString(mainFunctions))) {
            System.out.println(INFO_HEAD + object);
        }
        System.out.println();
    }

    public static void printStartOrFinishStation(String startOrFinish) {
        System.out.println();
        System.out.println(NOTICE_HEAD + "등록할 노선의 " + startOrFinish + " 종점역 이름을 입력하세요.");
    }

    public static void printReceiveSomething(DetailFunctions detailFunctions, MainFunctions mainFunctions) {
        System.out.println();
        String detailName = "";
        if (detailFunctions.equals(DetailFunctions.REMOVE)) {
            detailName = detailFunctions.getFunctionName() + "할 구간의 ";
        }
        System.out.println(NOTICE_HEAD + detailName + mainFunctions.getFunctionName() + "을 입력하세요.");
    }

    public static void printOrder() {
        System.out.println();
        System.out.println(INFO_HEAD + "순서를 입력하세요.");
    }
}