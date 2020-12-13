package subway.view;

public class LineRegisterView extends ManagerView {
	private static final String TOP_MENU_MESSAGE = "등록할 노선 이름을 입력하세요.";

	@Override
	public void print() {
		printThirdMenu(TOP_MENU_MESSAGE);
	}
}
