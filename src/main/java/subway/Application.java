package subway;

import subway.service.MainService;

public class Application {
    public static void main(String[] args) {
        Settings.init();
        MainService.view();
    }
}

