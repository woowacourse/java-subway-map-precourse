package subway.setup;

/**
 * @author yhh1056
 * @since 2020/12/11
 */
public class Setting {

    private Setting() {
    }

    public static void setUpSubwayInformation() {
        SetStation.setUpStation();
        SetLine.setUpLines();
        SetSection.setUpSection();
    }
}
