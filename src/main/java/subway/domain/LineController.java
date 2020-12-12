package subway.domain;

import subway.Constant;

import java.util.Scanner;

public class LineController {
    Scanner scanner;

    public LineController(Scanner scanner){
        this.scanner = scanner;
    }

    void printSelection(){
        System.out.println(Constant.LINE_ANNOUNCEMENT);
        String flag = scanner.next();
        if (flag == "1") {

        } else if (flag == "2") {

        } else if (flag == "3") {

        } else if (flag == "b" || flag == "B") {

        }
    }
}
