package subway.setup;

import static subway.setup.SetLine.sinbundangLine;
import static subway.setup.SetLine.threeLine;
import static subway.setup.SetLine.twoLine;
import static subway.setup.SetStation.gangNam;
import static subway.setup.SetStation.gyodae;
import static subway.setup.SetStation.maebong;
import static subway.setup.SetStation.nambuTerminal;
import static subway.setup.SetStation.yangjae;
import static subway.setup.SetStation.yangjaeCitizenForest;
import static subway.setup.SetStation.yeoksan;

import subway.repository.SectionRepository;

/**
 * @author yhh1056
 * @since 2020/12/12
 */
public class SetSection {

    private SetSection() {
    }

    static void setUpSection() {
        setTwoLineSection();
        setThreeLineSection();
        setSinbundangLineSection();
    }

    private static void setTwoLineSection() {
        SectionRepository.addSection(twoLine, gyodae);
        SectionRepository.addSection(twoLine, gangNam);
        SectionRepository.addSection(twoLine, yeoksan);
    }

    private static void setThreeLineSection() {
        SectionRepository.addSection(threeLine, gyodae);
        SectionRepository.addSection(threeLine, nambuTerminal);
        SectionRepository.addSection(threeLine, yangjae);
        SectionRepository.addSection(threeLine, maebong);
    }

    private static void setSinbundangLineSection() {
        SectionRepository.addSection(sinbundangLine, gangNam);
        SectionRepository.addSection(sinbundangLine, yangjae);
        SectionRepository.addSection(sinbundangLine, yangjaeCitizenForest);
    }
}
