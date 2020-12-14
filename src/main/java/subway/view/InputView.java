package subway.view;

import java.util.Scanner;

public class InputView {
    private String inputData;


    public String getInputData() {
        return inputData;
    }

//    public void run(Scanner scanner) {
//        OutputView.guideChooseFunction();
//        scanData(scanner);
//    }

    public void scanData(Scanner scanner) {
        inputData = scanner.nextLine();
        System.out.println();

        /*
        * 구간 재정의 할것. 역과 역사이를 구간. 구간이 모여서 노선.
        *
        * 에러코드 받으면 다시 실행
        *
        * 화면단 구성
        * 메인화면 stack 1
        * 기능선택 stack 2
        *
        * */
    }



}
