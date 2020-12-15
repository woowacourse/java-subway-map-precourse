package subway.controller.screen;

import subway.controller.function.Function;

import java.util.List;

public interface Screen {
    String getTitle();

    List<Function> getFunctions();
}
