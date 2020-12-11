package subway.view;

import subway.service.output.OutputService;

public abstract class Screen {
    protected final OutputService outputService;
    public static final String PREFIX_ERROR = "[ERROR] ";
    public static final String PREFIX_INFO = "[INFO] ";
    public static final String PREFIX_SHARP = "## ";

    public Screen(OutputService outputService) {
        this.outputService = outputService;
    }
}
