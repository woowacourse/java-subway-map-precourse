package subway.controller.section;

public class SectionBackController implements SubSectionController {
    @Override
    public SectionOption process() {
        return SectionOption.BACK;
    }
}
