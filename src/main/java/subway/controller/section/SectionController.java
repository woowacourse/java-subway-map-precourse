package subway.controller.section;

import static subway.util.Retry.retry;

import java.util.EnumMap;
import java.util.Map;
import subway.controller.SubController;
import subway.view.InputView;
import subway.view.OutputView;

public class SectionController implements SubController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Map<SectionOption, SubController> subControllers = new EnumMap<>(SectionOption.class);

    public SectionController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        subControllers.put(SectionOption.ADD, new SectionAddController(inputView, outputView));
        subControllers.put(SectionOption.DELETE, new SectionRemoveController(inputView, outputView));
    }

    @Override
    public void process() {
        while (true) {
            SectionOption sectionOption = retry(inputView::readSectionOption);
            if (sectionOption.isBack()) {
                break;
            }
            subControllers.get(sectionOption).process();
        }
    }
}
