package subway.view.resource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public enum Screen {
    MAIN("B", "메인", " 화면", Arrays.asList("1. 역 관리", "2. 노선 관리", "3. 구간 관리", "4. 지하철 노선도 출력", "Q. 종료")),
    STATION("1", "역", " 관리 화면", Arrays.asList("1. 역 등록", "2. 역 삭제", "3. 역 조회", "B. 돌아가기")),
    LINE("2", "노선", " 관리 화면", Arrays.asList("1. 노선 등록", "2. 노선 삭제", "3. 노선 조회", "B. 돌아가기")),
    SECTION("3", "구간", " 관리 화면", Arrays.asList("1. 구간 등록", "2. 구간 삭제", "B. 돌아가기")),
    MAP("4", "지하철 노선도", " 출력", Collections.emptyList()),
    QUIT("Q", "종료", "", Collections.emptyList());

    private String index;
    private String name;
    private String title;
    private List<String> functionList;

    Screen(String index, String name, String title, List<String> functionList) {
        this.index = index;
        this.name = name;
        this.title = title;
        this.functionList = functionList;
    }

    public String getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return name + title;
    }

    public List<String> getFunctionList() {
        return functionList;
    }

    public List<String> getIndexList() {
        return functionList.stream()
                .map(n -> n.substring(0, 1))
                .collect(Collectors.toList());
    }
}
