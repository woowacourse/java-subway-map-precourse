package subway.controller;

import subway.InputUtils;

public class LineManagementScreen implements Screen{

    @Override
    public void start() {
        System.out.println("\n## 노선 관리 화면\n" +
                "1. 노선 등록\n" +
                "2. 노선 삭제\n" +
                "3. 노선 조회\n" +
                "B. 돌아가기\n");
        int userInput = InputUtils.createMainInput(3,"B");

        if(userInput == 1){

        }
        if(userInput == 2){

        }
        if(userInput == 3){

        }
    }
}
