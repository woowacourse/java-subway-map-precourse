package subway.view;

import subway.service.output.OutputService;

public class MainView extends Screen {
    private static final String MAIN = Prefix.SHARP.getPrefix() + "메인 화면";
    private static final String MAIN_ONE = Prefix.ONE.getPrefix() + "역 관리";
    private static final String MAIN_TWO = Prefix.TWO.getPrefix() + "노선 관리";
    private static final String MAIN_THREE = Prefix.THREE.getPrefix() + "구간 관리";
    private static final String MAIN_FOUR = Prefix.FOUR.getPrefix() + "지하철 노선도 출력";
    private static final String MAIN_QUIT = Prefix.QUIT.getPrefix() + "종료";

    public MainView(OutputService outputService) {
        super(outputService);
    }

    public void showOptions() {
        outputService.printOptions(new String[]{MAIN, MAIN_ONE, MAIN_TWO, MAIN_THREE, MAIN_FOUR, MAIN_QUIT});
    }

    @Override
    public void showAdd() {
        return;
    }

    @Override
    public void showDelete() {
        return;
    }

    @Override
    public void showAfterAdd() {
        return;
    }

    @Override
    public void showAfterDelete() {
        return;
    }
}
