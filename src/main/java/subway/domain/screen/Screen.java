package subway.domain.screen;

import subway.domain.command.Command;

public interface Screen {
    public String getMessage();

    public ScreenType getNextScreen(Command command);
}
