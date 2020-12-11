package subway.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuItemsRepository {

    private static final String[] mainItems = {
        "## 메인 화면",
        "1. 역 관리", "2. 노선 관리", "3. 구간 관리",
        "4. 지하철 노선도 출력", "Q. 종료"
    };
    private  static final List<String> mainValidSelection = Arrays.asList("1","2","3","4","Q");

    private static final String[] stationItems = {
        "## 역 관리 화면",
        "1. 역 등록", "2. 역 삭제", "3. 역 조회",
        "B. 돌아가기"
    };
    private static final String[] lineItems = {
        "## 노선 관리 화면",
        "1. 노선 등록", "2. 노선 삭제", "3. 노선 조회",
        "B. 돌아가기"
    };
    private static final String[] sectionItems = {
        "## 구간 관리 화면",
        "1. 구간 등록", "2. 구간 삭제",
        "B. 돌아가기"
    };

    private MenuItemsRepository(){

    }

    public static String[] getMainItems(){
        return mainItems;
    }
    public static String[] getStationItems(){
        return stationItems;
    }
    public static String[] getLineItems(){
        return lineItems;
    }
    public static String[] getSectionItems(){
        return sectionItems;
    }

    public static List<String> getMainSelections(){
        return mainValidSelection;
    }
}
