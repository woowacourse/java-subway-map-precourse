package subway.domain.menu;

public enum MainMenu {
    STATION(String.valueOf(DataList.STATION.ordinal()+1), DataList.STATION.getName()+" 관리")
    , LINE(String.valueOf(DataList.LINE.ordinal()+1), DataList.LINE.getName()+" 관리")
    , SECTION(String.valueOf(DataList.SECTION.ordinal()+1), DataList.SECTION.getName()+" 관리")
    , MAP(String.valueOf(DataList.MAP.ordinal()+1), DataList.MAP.getName()+" 출력")
    , END("Q", "종료");

    final private String order;
    final private String message;

    MainMenu(String order, String message) {
        this.order = order;
        this.message = message;
    }

    public String getOrder() {
        return order;
    }

    public String getMessage() {
        return message;
    }

    public static boolean isValidOrder(String order){
        for(MainMenu mainMenu : MainMenu.values()){
            if(mainMenu.getOrder().equals(order)){
                return true;
            }
        }
        return false;
    }

}
