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
    public static boolean nameLength() {
        System.out.println("\n[ERROR] 이름은 2자 이상만 가능합니다.\n");
        return false;
    }
}
