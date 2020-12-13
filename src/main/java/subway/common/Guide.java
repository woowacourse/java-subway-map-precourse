package subway.common;

public class Guide {
    public static final String GUIDE_PREFIX = "\n## ";

    private Guide() {
    }

    public static void print(String message){
        System.out.println(GUIDE_PREFIX+message);
    }

}
