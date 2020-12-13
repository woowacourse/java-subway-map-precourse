package subway.view;

public class LineRemovalView extends ManagerView {
	private static final String TOP_MENU_MESSAGE = "삭제할 노선 이름을 입력하세요.";

	@Override
	public void print() {
		printTopMenu(TOP_MENU_MESSAGE);
	}
}
