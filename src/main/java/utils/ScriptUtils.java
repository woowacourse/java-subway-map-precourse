package utils;

public class ScriptUtils {

    public static final String[] MENUS = {
        "## 메인 화면\n1. 역 관리\n2. 노선 관리\n3. 구간 관리\n4. 지하철 노선도 출력\nQ. 종료\n",
        "\n## 역 관리 화면\n1. 역 등록\n2. 역 삭제\n3. 역 조회\nB. 돌아가기\n",
        "\n## 노선 관리 화면\n1. 노선 등록\n2. 노선 삭제\n3. 노선 조회\nB. 돌아가기\n",
        "\n## 구간 관리 화면\n1. 구간 등록\n2. 구간 삭제\nB. 돌아가기\n"
    };
    public static final String ASK_SELECTION = "## 원하는 기능을 선택하세요.";
    public static final String ERROR_OUT_OF_VALUE = "\n[ERROR] 선택할 수 없는 기능입니다.\n";
}
