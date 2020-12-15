package subway.controller.screen;

import subway.controller.function.Function;
import subway.controller.function.LineFunction;
import subway.controller.function.MainFunction;
import subway.controller.function.SectionFunction;
import subway.controller.function.StationFunction;

import java.util.Arrays;
import java.util.List;

public enum SubwayScreen implements Screen {
    MAIN("메인 화면", Arrays.asList(MainFunction.values())),
    STATION_MANAGEMENT("역 관리 화면", Arrays.asList(StationFunction.values())),
    LINE_MANAGEMENT("노선 관리 화면", Arrays.asList(LineFunction.values())),
    SECTION_MANAGEMENT("구간 관리 화면", Arrays.asList(SectionFunction.values()));

    private String title;
    private List<Function> functions;

    SubwayScreen(String title, List<Function> functions) {
        this.title = title;
        this.functions = functions;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public List<Function> getFunctions() {
        return functions;
    }
}
