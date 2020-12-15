package subway.controller;

public class SectionController {

    private SectionController () {
    }

    public void save() {
    }

    public void remove() {
    }

    public static SectionController getInstance() {
        return SectionController.LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final SectionController INSTANCE = new SectionController();
    }
}
