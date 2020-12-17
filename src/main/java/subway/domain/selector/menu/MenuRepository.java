package subway.domain.selector.menu;

import java.util.LinkedHashMap;
import subway.domain.selector.lineitem.LineAdder;
import subway.domain.selector.lineitem.LineGetter;
import subway.domain.selector.lineitem.LineRemover;
import subway.domain.selector.sectionitem.SectionAdder;
import subway.domain.selector.sectionitem.SectionRemover;
import subway.domain.selector.stationitem.StationAdder;
import subway.domain.selector.stationitem.StationGetter;
import subway.domain.selector.stationitem.StationRemover;
import subway.domain.selector.utilitem.BackWardItem;
import subway.domain.selector.utilitem.ExitItem;
import subway.domain.selector.utilitem.PrintSubwayLineItem;

public class MenuRepository {

    private static final LinkedHashMap<String, Menu> menus = new LinkedHashMap<>();

    static {
        Menu stationMenu = new Menu("1", "역 관리");
        stationMenu.addMenuItems("1", new StationAdder("1", "역 등록"));
        stationMenu.addMenuItems("2", new StationRemover("2", "역 삭제"));
        stationMenu.addMenuItems("3", new StationGetter("3", "역 조회"));
        stationMenu.addMenuItems("B", new BackWardItem("B", "돌아가기"));
        menus.put("1", stationMenu);

        Menu lineMenu = new Menu("2", "노선 관리");
        lineMenu.addMenuItems("1", new LineAdder("1", "노선 등록"));
        lineMenu.addMenuItems("2", new LineRemover("2", "노선 삭제"));
        lineMenu.addMenuItems("3", new LineGetter("3", "노선 조회"));
        lineMenu.addMenuItems("B", new BackWardItem("B", "돌아가기"));
        menus.put("2", lineMenu);

        Menu sectionMenu = new Menu("3", "구간 관리");
        sectionMenu.addMenuItems("1", new SectionAdder("1", "구간 등록"));
        sectionMenu.addMenuItems("2", new SectionRemover("2", "구간 삭제"));
        sectionMenu.addMenuItems("B", new BackWardItem("B", "돌아가기"));
        menus.put("3", sectionMenu);

        Menu mainMenu = new Menu("0", "메인");
        mainMenu.addMenus("1", stationMenu);
        mainMenu.addMenus("2", lineMenu);
        mainMenu.addMenus("3", sectionMenu);
        mainMenu.addMenuItems("4", new PrintSubwayLineItem("4", "지하철 노선도 출력"));
        mainMenu.addMenuItems("Q", new ExitItem("Q", "종료"));
        menus.put("0", mainMenu);
    }

    public static LinkedHashMap<String, Menu> menus() {
        return menus;
    }
}
