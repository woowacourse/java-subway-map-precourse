package subway.view;

public class Error {
    public static boolean noFunction() {
        System.out.println("\n[ERROR] 선택할 수 없는 기능입니다.\n");
        return false;
    }

    public static boolean alreadyExist() {
        System.out.println("\n[ERROR] 이미 등록된 이름입니다.\n");
        return false;
    }

    public static boolean notExist() {
        System.out.println("\n[ERROR] 존재하지 않는 이름입니다.\n");
        return false;
    }

    public static boolean stationHasLine() {
        System.out.println("\n[ERROR] 노선에 등록되어있어 삭제할 수 없습니다.\n");
        return true;
    }

    public static boolean createLine() {
        System.out.println("\n[ERROR] 노선 생성 불가\n");
        return false;
    }

    public static boolean nameLength() {
        System.out.println("\n[ERROR] 이름은 2자 이상만 가능합니다.\n");
        return false;
    }

    public static boolean indexOutOfRange() {
        System.out.println("\n[ERROR] 범위를 벗어난 순서입니다.\n");
        return false;
    }

    public static boolean numberOnly() {
        System.out.println("\n[ERROR] 숫자만 가능합니다.\n");
        return false;
    }
}
