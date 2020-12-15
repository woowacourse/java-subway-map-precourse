package subway;

import subway.controller.SubwayManageController;
import subway.domain.util.DataFactory;

public class Application {

    public static void main(String[] args) {
        DataFactory dataFactory = new DataFactory();
        dataFactory.makeData();

        SubwayManageController subwayManageController = new SubwayManageController();
        subwayManageController.run();
    }

}
