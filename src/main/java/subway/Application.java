package subway;

import java.util.Scanner;
import subway.domain.SubwayManager;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        // TODO: 초기 설정

        // TODO: 프로그램 시작 및 반복
        SubwayManager subwayManager = new SubwayManager();
        subwayManager.execute(scanner);
    }
}
