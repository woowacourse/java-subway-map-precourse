package subway.controller.section;

import static subway.util.Retry.retry;

import java.util.EnumMap;
import java.util.Map;
import subway.controller.MainOption;
import subway.controller.SubController;
import subway.view.InputView;
import subway.view.OutputView;

public class SectionController implements SubController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Map<SectionOption, SubSectionController> subSectionControllers = new EnumMap<>(SectionOption.class);

    public SectionController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        subSectionControllers.put(SectionOption.ADD, new SectionAddController(inputView, outputView));
        subSectionControllers.put(SectionOption.DELETE, new SectionRemoveController(inputView, outputView));
        subSectionControllers.put(SectionOption.BACK, new SectionBackController());
    }

    @Override
    public MainOption process() {
        while (true) {
            SectionOption sectionOption = retry(inputView::readSectionOption);
            SubSectionController subSectionController = subSectionControllers.get(sectionOption);
            if (subSectionController.process().isBack()) {
                break;
            }
        }

        return MainOption.SECTION;
    }
}
