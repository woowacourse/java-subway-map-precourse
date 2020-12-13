package subway.view;

public class SectionRemovalView extends ManagerView {
	private static final String TOP_MENU_MESSAGE = "삭제할 구간의 노선을 입력하세요.";

	@Override
	public void print() {
		printTopMenu(TOP_MENU_MESSAGE);
	}	
}
