package subway.controller;

public class LineController implements IController{

    @Override
    public void save() {

    }

    @Override
    public void remove() {

    }

    @Override
    public void getList() {

    }

    public static LineController getInstance() {
        return LineController.LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final LineController INSTANCE = new LineController();
    }
}
