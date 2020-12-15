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
    
    public static String inputAddLineName() {
        LineScreen.askAddLineName();
        return scanner.next();
    }
    
    public static String inputAddLineUpTerminalName() {
        LineScreen.askAddLineUpTerminalName();
        return scanner.next();
    }
    
    public static String inputAddLineDownTerminalName() {
        LineScreen.askAddLineDownTerminalName();
        return scanner.next();
    }
   
    public static String inputDeleteLineName() {
        LineScreen.askDeleteLineName();
        return scanner.next();
    }
    
    public static String inputAddSectionLineName() {
        SectionScreen.askAddSectionLineName();
        return scanner.next();
    }
    
    public static String inputAddSectionStationName() {
        SectionScreen.askAddSectionStationName();
        return scanner.next();
    }
    
    public static String inputAddSectionOrder() {
        SectionScreen.askAddSectionOrder();
        return scanner.next();
    }
    
    public static String inputDeleteSectionLineName() {
        SectionScreen.askDeleteLineName();
        return scanner.next();
    }
    
    public static String inputDeleteSectionStationName() {
        SectionScreen.askDeleteStationName();
        return scanner.next();
    }

}
