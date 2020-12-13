package subway.view;

public class LineManagerView extends ManagerView {
	private static final String TOP_MENU_MESSAGE = "노선 관리 화면";
	private static final String FIRST_MENU_MESSAGE = "노선 등록";
	private static final String SECOND_MENU_MESSAGE = "노선 삭제";
	private static final String THIRD_MENU_MESSAGE = "노선 조회";
	private static final String BACK_MENU_MESSAGE = "돌아가기";

	@Override
	public void print() {
		printTopMenu(TOP_MENU_MESSAGE);
		printFirstMenu(FIRST_MENU_MESSAGE);
		printSecondMenu(SECOND_MENU_MESSAGE);
		printThirdMenu(THIRD_MENU_MESSAGE);
		printBackMenu(BACK_MENU_MESSAGE);
	}
}
