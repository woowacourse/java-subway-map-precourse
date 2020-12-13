package subway.view;

public class MainManagerView extends ManagerView {
	private static final String TOP_MENU_MESSAGE = "메인 화면";
	private static final String FIRST_MENU_MESSAGE = "역 관리";
	private static final String SECOND_MENU_MESSAGE = "노선 관리";
	private static final String THIRD_MENU_MESSAGE = "구간 관리";
	private static final String FOURTH_MENU_MESSAGE = "지하철 노선도 출력";
	private static final String EXIT_MENU_MESSAGE = "종료";
	
	@Override
	public void print() {
		printTopMenu(TOP_MENU_MESSAGE);
		printFirstMenu(FIRST_MENU_MESSAGE);
		printSecondMenu(SECOND_MENU_MESSAGE);
		printThirdMenu(THIRD_MENU_MESSAGE);
		printFourthMenu(FOURTH_MENU_MESSAGE);
		printExitMenu(EXIT_MENU_MESSAGE);
	}
}
