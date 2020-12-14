package subway.controller;

public abstract class SubController {
    protected String selection;

    protected final void goToRegisterMenuIfUserSelect() {
        if (selection.equals("1")) {
            register();
        }
    }

    protected final void goToDeleteMenuIfUserSelect() {
        if (selection.equals("2")) {
            delete();
        }
    }

    protected final void goToInquireMenuIfUserSelect() {
        if (selection.equals("3")) {
            inquire();
        }
    }

    protected void inquire() {
        // SectionController에서는 inquire 메뉴가 없기 때문에 디폴트 메소드로 선언
    }

    public abstract void goToMenu();

    protected abstract void register();

    protected abstract void delete();
}
