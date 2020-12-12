package subway.view;

import subway.service.output.OutputService;

public abstract class Screen {
    protected final OutputService outputService;
    public static final String PREFIX_ERROR = "[ERROR] ";
    public static final String PREFIX_INFO = "[INFO] ";
    public static final String PREFIX_SHARP = "## ";
    public static final String CONTOUR = "---";

    public Screen(OutputService outputService) {
        this.outputService = outputService;
    }

    public abstract String getAdd();

    public abstract String getDelete();

    public abstract String getAfterAdd();

    public abstract String getAfterDelete();
}
