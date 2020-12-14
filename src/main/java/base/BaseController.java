package base;

public abstract class BaseController {
    protected BaseView view;

    public BaseController(BaseView view) {
        this.view = view;
    }

}
