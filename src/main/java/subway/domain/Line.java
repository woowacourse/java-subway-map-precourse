package subway.domain;

import java.util.ArrayList;

public class Line {
    private String name;
    private String ascendingEndPoint;
    private String descendingEndPoint;
    private final ArrayList<String> lineSection = new ArrayList<String>();

    public Line(String name, String ascendingEndPoint, String descendingEndPoint) {
        this.name = name;
        this.ascendingEndPoint = ascendingEndPoint;
        this.descendingEndPoint = descendingEndPoint;
    }

    public String getName() {
        return name;
    }

    public int lengthSection() {
    	return lineSection.size();
    }
    
    public void registerSection(String stationName) {
    	lineSection.add(stationName);
    	descendingEndPoint = stationName;
    }
    
    public void registerSection(int index, String stationName) {
    	lineSection.add(index,stationName);
    	
    	if (index == 0) {
    		ascendingEndPoint = stationName;
    		return;
    	}
    	if (index > lengthSection()) {
    		descendingEndPoint = stationName;
    	}
    }
    
    public void deleteSection(String stationName) {
    	int index = lineSection.indexOf(stationName);
    	lineSection.remove(index);
    }
}
