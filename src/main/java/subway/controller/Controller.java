package subway.controller;

import subway.util.InputUtils;

public interface Controller {

    public void run(InputUtils inputUtils);

    public String getTitle();

}
