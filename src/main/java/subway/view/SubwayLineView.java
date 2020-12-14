package subway.view;

import subway.console.Output;
import subway.repository.SectionRepository;

/**
 * @author yhh1056
 * @since 2020/12/11
 */
public class SubwayLineView {

    public void showSubwayLine() {
        Output.printSubwayLine(SectionRepository.sections());
    }
}
