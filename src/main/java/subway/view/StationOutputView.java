package subway.view;

import subway.domain.DetailFunctions;
import subway.domain.Station;

import java.util.List;

public class StationOutputView {
    public static final String PRINT_INFO_HEAD = "[INFO] ";

    public static void printFunction(DetailFunctions detailFunctions) {
        System.out.println();
        System.out.println("## "+detailFunctions.getFunctionName()+"할 " + "역" + " 이름을 입력하세요.");
    }

    public static void printSuccess(DetailFunctions detailFunctions) {
        System.out.println();
        System.out.println(PRINT_INFO_HEAD +"지하철 "+"역"+"이 "+detailFunctions.getFunctionName()+"되었습니다.");
        System.out.println();
    }

    public static void printResearch(List<Station> stations) {
        System.out.println();
        System.out.println("## "+"역"+" 목록");
        for(Station station: stations){
            System.out.println(PRINT_INFO_HEAD+station.getName());
        }
        System.out.println();
    }
}
