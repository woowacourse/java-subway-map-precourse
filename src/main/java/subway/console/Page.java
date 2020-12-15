package subway.console;

import java.util.Arrays;
import java.util.List;

/**
 * @author yhh1056
 * @since 2020/12/15
 */
public enum Page {
    MAIN(Arrays.asList("## 메인 화면",
            "1. 역 관리", "2. 노선 관리", "3. 구간 관리", "4. 지하철 노선도 출력", "Q. 종료",
            "\n## 원하는 기능을 선택하세요.")),

    STATION(Arrays.asList("\n## 역 관리 화면",
            "1. 역 등록", "2. 역 삭제", "3. 역 조회", "B. 돌아가기",
            "\n## 원하는 기능을 선택하세요.")),

    LINE(Arrays.asList("\n## 노선 관리 화면",
            "1. 노선 등록", "2. 노선 삭제", "3. 노선 조회", "B. 돌아가기",
            "\n## 원하는 기능을 선택하세요.")),

    SECTION(Arrays.asList("\n## 구간 관리 화면",
            "1. 구간 등록", "2. 구간 삭제", "B. 돌아가기",
            "\n## 원하는 기능을 선택하세요."));

    private List<String> pages;

    Page(List<String> pages) {
        this.pages = pages;
    }

    public List<String> getPages() {
        return pages;
    }
}

