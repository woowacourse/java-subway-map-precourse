package subway.view;

public class StationManagerView extends ManagerView {
	private static final String TOP_MENU_MESSAGE = "역 관리 화면";
	private static final String FIRST_MENU_MESSAGE = "역 등록";
	private static final String SECOND_MENU_MESSAGE = "역 삭제";
	private static final String THIRD_MENU_MESSAGE = "역 조회";
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
