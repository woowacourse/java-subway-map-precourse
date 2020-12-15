package subway.screen;

public enum EntityType {
    STATION("역"),
    LINE("노선"),
    ROUTE("구간"),
    MAP("지하철 노선도"),
    NONE("");
    
    String entity;
    
    EntityType(String entity) {
        this.entity = entity;
    }
    
    public String toString() {
        return entity;
    }
}
