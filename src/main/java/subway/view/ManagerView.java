package subway.view;

public abstract class ManagerView {
	private static final String TOP_MENU_PREFIX = "\n## ";
	private static final String FIRST_MENU_PREFIX = "1. ";
	private static final String SECOND_MENU_PREFIX = "2. ";
	private static final String THIRD_MENU_PREFIX = "3. ";
	private static final String FOURTH_MENU_PREFIX = "4. ";
	private static final String BACK_MENU_PREFIX = "B. ";
	private static final String EXIT_MENU_PREFIX = "Q. ";

	public abstract void print();
	
	public void printTopMenu(String message) {
		System.out.println(TOP_MENU_PREFIX + message);
	}
	
	public void printFirstMenu(String message) {
		System.out.println(FIRST_MENU_PREFIX + message);
	}
	
	public void printSecondMenu(String message) {
		System.out.println(SECOND_MENU_PREFIX + message);
	}
	
	public void printThirdMenu(String message) {
		System.out.println(THIRD_MENU_PREFIX + message);
	}
	
	public void printFourthMenu(String message) {
		System.out.println(FOURTH_MENU_PREFIX + message);
	}
	
	public void printBackMenu(String message) {
		System.out.println(BACK_MENU_PREFIX + message);
	}
	
	public void printExitMenu(String message) {
		System.out.println(EXIT_MENU_PREFIX + message);
	}
}
