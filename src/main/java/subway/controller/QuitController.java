package subway.controller;

import subway.util.InputUtils;

public class QuitController implements Controller {

    private final String title = "종료";

    @Override
    public void run(InputUtils inputUtils) {

    }

    @Override
    public String getTitle() {
        return this.title;
    }
}
