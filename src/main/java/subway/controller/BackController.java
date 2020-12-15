package subway.controller;

import subway.util.InputUtils;

public class BackController implements Controller {

    private final String title = "돌아가기";

    @Override
    public void run(InputUtils inputUtils) {

    }

    @Override
    public String getTitle() {
        return this.title;
    }

}
