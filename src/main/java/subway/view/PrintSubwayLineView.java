package subway.view;

public class PrintSubwayLineView extends GeneralView {

    private static final String VIEW_NAME = "지하철 노선도 출력";
    private static final String PRINT_SUBWAY_LINE_MAP_GUIDE_TEXT = VIEW_TEXT_PREFIX + "지하철 노선도";

    @Override
    protected void initViewName() {
        this.name = VIEW_NAME;
    }

    @Override
    public void setVisible() {
        println(PRINT_SUBWAY_LINE_MAP_GUIDE_TEXT);
        /** LineService에게 모든 노선과 역 요청 */
    }
}
