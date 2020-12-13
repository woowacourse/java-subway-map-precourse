package subway.view;

public abstract class ManagerView {
	private static final String TOP_MENU_PREFIX = "\n## ";
	private static final String FIRST_MENU = "1";
	private static final String SECOND_MENU = "2";
	private static final String THIRD_MENU = "3";
	private static final String FOURTH_MENU = "4";
	private static final String BACK_MENU = "B";
	private static final String QUIT_MENU = "Q";
	private static final String MENU_LISTING_SEPARATOR = ". ";

	public abstract void print();

	public void printTopMenu(String message) {
		System.out.println(TOP_MENU_PREFIX + message);
	}

	public void printFirstMenu(String message) {
		System.out.println(FIRST_MENU + MENU_LISTING_SEPARATOR + message);
	}

	public void printSecondMenu(String message) {
		System.out.println(SECOND_MENU + MENU_LISTING_SEPARATOR + message);
	}

	public void printThirdMenu(String message) {
		System.out.println(THIRD_MENU + MENU_LISTING_SEPARATOR + message);
	}

	public void printFourthMenu(String message) {
		System.out.println(FOURTH_MENU + MENU_LISTING_SEPARATOR + message);
	}

	public void printBackMenu(String message) {
		System.out.println(BACK_MENU + MENU_LISTING_SEPARATOR + message);
	}

	public void printQuitMenu(String message) {
		System.out.println(QUIT_MENU + MENU_LISTING_SEPARATOR + message);
	}
}
