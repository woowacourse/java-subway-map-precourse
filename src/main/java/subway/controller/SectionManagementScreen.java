package subway.controller;

import subway.InputUtils;

public class SectionManagementScreen implements Screen{

    @Override
    public void start() {
        System.out.println("\n## 구간 관리 화면\n" +
                "1. 구간 등록\n" +
                "2. 구간 삭제\n" +
                "B. 돌아가기\n");
        int userInput = InputUtils.createMainInput(2,"B");

        if(userInput == 1){

        }
        if(userInput == 2){

        }
    }
}
