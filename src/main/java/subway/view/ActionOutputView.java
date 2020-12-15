package subway.view;

import subway.domain.DetailActions;
import subway.domain.Line;
import subway.domain.MainActions;
import subway.domain.Station;

import java.util.*;
import java.util.stream.Collectors;

import static subway.view.OutputView.INFO_HEAD;
import static subway.view.OutputView.NOTICE_HEAD;

public class ActionOutputView {
    private static final String DELIMITER_LINE_STATION = "---";
    private static final String ONE_LINE_MAKER = "\n";
    private static final String TWO_LINE_MAKER = "\n\n";

    public static void printFormat(String printContent) {
        System.out.println();
        System.out.println(printContent);
    }

    public static String makeReceiveActionNotice(DetailActions detailActions, MainActions mainActions) {
        return NOTICE_HEAD + detailActions.getActionName() + "할 " + mainActions.getActionName() + " 이름을 입력하세요.";
    }

    public static String makeSuccessNotice(DetailActions detailActions, MainActions mainActions) {
        String subwayText = "지하철 ";
        if (mainActions.equals(MainActions.WAY)) {
            subwayText = "";
        }
        return INFO_HEAD + subwayText + mainActions.getActionName() + "이 " + detailActions.getActionName() + "되었습니다.";
    }

    public static String makeResearchResult(MainActions mainActions) {
        return NOTICE_HEAD + mainActions.getActionName() + " 목록" + ONE_LINE_MAKER +
                String.join(ONE_LINE_MAKER, Objects.requireNonNull(MainActions.getObjectsToString(mainActions)));
    }

    public static String makeReceiveStartOrFinishStationNotice(String startOrFinish) {
        return NOTICE_HEAD + "등록할 노선의 " + startOrFinish + " 종점역 이름을 입력하세요.";
    }

    public static String makeReceiveNotice(DetailActions detailActions, MainActions mainActions) {
        String detailName = "";
        if (detailActions.equals(DetailActions.REMOVE)) {
            detailName = detailActions.getActionName() + "할 구간의 ";
        }
        return NOTICE_HEAD + detailName + mainActions.getActionName() + "을 입력하세요.";
    }

    public static String makeOrderNotice() {
        return NOTICE_HEAD + "순서를 입력하세요.";
    }

    public static String makeSubwayResult(Map<Line, List<Station>> subway) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(NOTICE_HEAD).append(MainActions.SUBWAY.getActionName()).append(ONE_LINE_MAKER);

        List<String> linesResult = new ArrayList<>();
        for (Line line : subway.keySet()) {
            linesResult.add(String.join(ONE_LINE_MAKER, Arrays.asList(line.formatName(), INFO_HEAD + DELIMITER_LINE_STATION, subway.get(line).stream().map(Station::formatName).collect(Collectors.joining(ONE_LINE_MAKER)))));
        }
        stringBuilder.append(String.join(TWO_LINE_MAKER, linesResult));

        return stringBuilder.toString();
    }
}