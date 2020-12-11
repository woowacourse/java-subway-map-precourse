package subway.view;

import subway.domain.DetailFunctions;
import subway.domain.Line;

import java.util.List;

import static subway.view.StationOutputView.PRINT_INFO_HEAD;

public class LineOutputView {

    public static void printFunction(DetailFunctions detailFunctions) {
        System.out.println();
        System.out.println("## "+detailFunctions.getFunctionName()+"할 " + "노선" + " 이름을 입력하세요.");
    }

    public static void printSuccess(DetailFunctions detailFunctions) {
        System.out.println();
        System.out.println(PRINT_INFO_HEAD +"지하철 "+"노선"+"이 "+detailFunctions.getFunctionName()+"되었습니다.");
        System.out.println();
    }

    public static void printResearch(List<Line> lines) {
        System.out.println();
        System.out.println("## "+"노선"+" 목록");
        for(Line line: lines){
            System.out.println(PRINT_INFO_HEAD+line.getName());
        }
        System.out.println();
    }

    public static void printStartStation() {
        System.out.println();
        System.out.println("## 등록할 노선의 상행 종점역 이름을 입력하세요.");
    }

    public static void printFinishStation() {
        System.out.println();
        System.out.println("## 등록할 노선의 하행 종점역 이름을 입력하세요.");
    }
}