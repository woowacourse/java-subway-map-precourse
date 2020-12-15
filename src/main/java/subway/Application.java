package subway;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import javax.lang.model.util.Types;

public class Application {
    static final String stationInput = "1";
    static final String lineInput = "2";
    static final String sectionInput = "3";
    static final String allPrintInput = "4";
    static final String exitInput = "Q";
    private static final ArrayList<String> mainInputWhiteList = new ArrayList<>(Arrays.asList(
        stationInput, lineInput, sectionInput, allPrintInput, exitInput));

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        boolean exitFlag = false;
        while (!exitFlag) {
            mainScreenPrint();
            String mainInput = scanner.next();
            exitFlag = isExit(mainInput);
        }
    }

    public static void mainScreenPrint() {
        System.out.println("## 메인 화면\n"
            + "1. 역 관리\n"
            + "2. 노선 관리\n"
            + "3. 구간 관리\n"
            + "4. 지하철 노선도 출력\n"
            + "Q. 종료\n"
            + "\n"
            + "## 원하는 기능을 선택하세요.");
    }

    public static boolean isExit(String mainInput) {
        if (!mainInputWhiteList.contains(mainInput)) {
            System.out.println("[ERROR] 선택할 수 없는 기능입니다.");
            return true;
        }
        if (mainInput.equalsIgnoreCase(exitInput)) {
            return true;
        }
        return false;
    }
}
