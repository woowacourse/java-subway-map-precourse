package subway.controller;

public abstract class SubController {
    private static final String REGISTER_MENU = "1";
    private static final String DELETE_MENU = "2";
    private static final String INQUIRE_MENU = "3";
    private static final String BACK = "B";

    protected String selection;

    protected final void goToRegisterMenuIfUserSelect() {
        if (isSelect(REGISTER_MENU)) {
            register();
        }
    }

    protected final void goToDeleteMenuIfUserSelect() {
        if (isSelect(DELETE_MENU)) {
            delete();
        }
    }

    protected final void goToInquireMenuIfUserSelect() {
        if (isSelect(INQUIRE_MENU)) {
            inquire();
        }
    }
    
    protected final boolean isBack() {
        if (isSelect(BACK)) {
            return true;
        }
        return false;
    }

    private boolean isSelect(String menu) {
        return selection.equals(menu);
    }

    protected void inquire() {
        // SectionController에서는 inquire 메뉴가 없기 때문에 디폴트 메소드로 선언
    }

    public abstract void goToMenu();

    protected abstract void register();

    protected abstract void delete();
}
