package subway.domain.selector.menu;

import java.util.LinkedHashMap;
import subway.domain.selector.lineitem.AddLineItem;
import subway.domain.selector.lineitem.GetLineItem;
import subway.domain.selector.lineitem.RemoveLineItem;
import subway.domain.selector.sectionitem.AddSectionItem;
import subway.domain.selector.sectionitem.RemoveSectionItem;
import subway.domain.selector.stationitem.AddStationItem;
import subway.domain.selector.stationitem.GetStationItem;
import subway.domain.selector.stationitem.RemoveStationItem;
import subway.domain.selector.utilitem.BackWardItem;
import subway.domain.selector.utilitem.ExitItem;
import subway.domain.selector.utilitem.PrintSubwayLineItem;

public class MenuRepository {

    private static final LinkedHashMap<String, Menu> menus = new LinkedHashMap<>();

    static {
        Menu stationMenu = new Menu("1", "역 관리");
        stationMenu.addMenuItems("1", new AddStationItem("1", "역 등록"));
        stationMenu.addMenuItems("2", new RemoveStationItem("2", "역 삭제"));
        stationMenu.addMenuItems("3", new GetStationItem("3", "역 조회"));
        stationMenu.addMenuItems("B", new BackWardItem("B", "돌아가기"));
        menus.put("1", stationMenu);

        Menu lineMenu = new Menu("2", "노선 관리");
        lineMenu.addMenuItems("1", new AddLineItem("1", "노선 등록"));
        lineMenu.addMenuItems("2", new RemoveLineItem("2", "노선 삭제"));
        lineMenu.addMenuItems("3", new GetLineItem("3", "노선 조회"));
        lineMenu.addMenuItems("B", new BackWardItem("B", "돌아가기"));
        menus.put("2", lineMenu);

        Menu sectionMenu = new Menu("3", "구간 관리");
        sectionMenu.addMenuItems("1", new AddSectionItem("1", "구간 등록"));
        sectionMenu.addMenuItems("2", new RemoveSectionItem("2", "구간 삭제"));
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
