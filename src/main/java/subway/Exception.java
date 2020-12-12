package subway;

import java.util.List;

public class Exception {
    public static String checkMenu(String input, List<String> menuItemList) {
        input = isNotEmpty(input);
        input = isNotSpace(input);
        input = isInMenu(input, menuItemList);
        return input;
    }

    static String isNotEmpty(String input){
        if(!input.equals("")){
            return input;
        }
        throw new IllegalArgumentException();
    }

    static String isNotSpace(String input){
        if(!input.contains(" ")){
            return input;
        }
        throw new IllegalArgumentException();
    }

    static String isInMenu(String input, List<String> menuItemList){
        for (int i = 0; i < menuItemList.size(); i++) {
            String number = menuItemList.get(i).substring(0, 1);
            if(input.equals(number)){
                return input;
            }
        }
        throw new IllegalArgumentException();
    }
}
