package subway;

import subway.view.View;

public class Application {
    public static void main(String[] args) {
        Settings.init();
        View view = new View();
        view.main();
    }
}

