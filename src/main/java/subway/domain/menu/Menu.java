package subway.domain.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Menu {
    MAIN(Arrays.asList( "\n## 메인 화면",
        "1. 역 관리", "2. 노선 관리", "3. 구간 관리",
        "4. 지하철 노선도 출력", "Q. 종료"), Arrays.asList(MenuKeys.ONE,MenuKeys.TWO,MenuKeys.THREE,MenuKeys.FOUR,MenuKeys.EXIT) )
    ,
    STATION(Arrays.asList( "\n## 역 관리 화면",
        "1. 역 등록", "2. 역 삭제", "3. 역 조회",
        "B. 돌아가기"), Arrays.asList(MenuKeys.ONE,MenuKeys.TWO,MenuKeys.THREE,MenuKeys.BACK) ),
    LINE(Arrays.asList( "\n## 노선 관리 화면",
        "1. 노선 등록", "2. 노선 삭제", "3. 노선 조회",
        "B. 돌아가기"), Arrays.asList(MenuKeys.ONE,MenuKeys.TWO,MenuKeys.THREE,MenuKeys.BACK) ),
    PATH(Arrays.asList( "\n## 구간 관리 화면",
        "1. 구간 등록", "2. 구간 삭제",
        "B. 돌아가기"), Arrays.asList(MenuKeys.ONE,MenuKeys.TWO,MenuKeys.BACK) )
    ;

    private final List<String> menuItems;
    private final List<MenuKeys> menuKeys;

    Menu(List<String> menuItems, List<MenuKeys> menuKeys) {
        this.menuItems = menuItems;
        this.menuKeys = menuKeys;
    }

    public List<String> getMenuItems(){
        return menuItems;
    }


    public String getStringMenuKeys(){
        List<String> keys = new ArrayList<>();
        for(MenuKeys key: menuKeys){
            keys.add(key.getKey());
        }
        return keys.toString();
    }

    public boolean containsKey(String inputKey){
        for(MenuKeys key : menuKeys){
            if(key.getKey().equals(inputKey)){
                return true;
            }
        }
        return false;
    }
}
