package subway.view;

import subway.domain.DetailFunctions;

import static subway.view.StationOutputView.PRINT_INFO_HEAD;

public class WayOutputView {
    public static void printEnrollLine() {
        System.out.println();
        System.out.println("## "+"노선"+"을 입력하세요.");
    }

    public static void printEnrollStation() {
        System.out.println();
        System.out.println("## "+"역"+"을 입력하세요.");
    }

    public static void printOrder() {
        System.out.println();
        System.out.println("## "+"순서"+"를 입력하세요.");
    }

    public static void printSuccess(DetailFunctions detailFunction) {
        System.out.println();
        System.out.println(PRINT_INFO_HEAD+"구간"+"이 "+detailFunction.getFunctionName()+"되었습니다.");
    }

    public static void printRemoveLine() {
        System.out.println();
        System.out.println("## 삭제할 구간의 "+"노선"+"을 입력하세요.");
    }

    public static void printRemoveStation() {
        System.out.println();
        System.out.println("## 삭제할 구간의 "+"역"+"을 입력하세요.");
    }

}
