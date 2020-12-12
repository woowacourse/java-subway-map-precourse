package output;

public enum Function {
    INSERT("등록"), DELETE("삭제"), SEARCH("조회"), BACK("돌아가기");

    private final String name;

    Function(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
