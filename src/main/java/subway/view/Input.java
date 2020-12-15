package subway.view;

import java.util.Scanner;

import subway.screen.LineScreen;
import subway.screen.Screen;
import subway.screen.SectionScreen;
import subway.screen.StationScreen;

public class Input {
    public static Scanner scanner;
	
    public static String chooseFunction() {
        Screen.chooseFunction();
        return scanner.next();
    }
    
    public static String inputAddStationName() {
        StationScreen.askAddStationName();
        return scanner.next();
    }
    
    public static String inputDeleteStationName() {
        StationScreen.askDeleteStationName();
        return scanner.next();
    }
    
    public static String[] inputAddLine() {
        String[] info = new String[3];
        LineScreen.askAddLineName();
        info[0] = scanner.next();
        LineScreen.askAddLineUpTerminalName();
        info[1] = scanner.next();
        LineScreen.askAddLineDownTerminalName();
        info[2] = scanner.next();
        return info;
    }
	
    public static String inputDeleteLineName() {
        LineScreen.askDeleteLineName();
        return scanner.next();
    }
    
    public static String[] inputAddSection() {
        String[] info = new String[3];
        SectionScreen.askAddSectionLineName();
        info[0] = scanner.next();
        SectionScreen.askAddSectionStationName();
        info[1] = scanner.next();
        SectionScreen.askAddSectionOrder();
        info[2] = scanner.next();
        return info;
    }
    
    public static String[] inputDeleteSection() {
    	String[] info = new String[2];
    	SectionScreen.askDeleteLineName();
    	info[0] = scanner.next();
    	SectionScreen.askDeleteStationName();
    	info[1] = scanner.next();
    	return info;
    }
}
