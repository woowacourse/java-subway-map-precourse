package subway.controller;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainControllerTest {

    @Test
    @Description("findAll 테스트, 지하철 노선도 출력")
    public void mainControllerTest(){

        MainController mainController = new MainController();

        mainController.findAll();

    }


}