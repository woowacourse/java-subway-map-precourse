package subway.controller;

import subway.view.InputView;

public abstract class BaseController {
    public final String COMMAND_SELECT_WARN = "선택지 안의 기능을 선택해주세요.";

    public abstract void service(InputView inputView);
    public abstract void menuSelector(String command, InputView inputView);
}
