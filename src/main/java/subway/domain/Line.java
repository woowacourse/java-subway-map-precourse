package subway.domain;

import java.util.Arrays;
import java.util.LinkedList;

public class Line {

    private final String name;
    private Station upwardTerminal;
    private Station downwardTerminal;
    private final LinkedList<Station> terminals;

    public Line(String name, Station upwardTerminal, Station downwardTerminal) {
        this.name = name;
        this.upwardTerminal = upwardTerminal;
        this.downwardTerminal = downwardTerminal;
        terminals = new LinkedList<Station>(Arrays.asList(upwardTerminal, downwardTerminal));
    }

    public Line(String name, LinkedList<Station> terminals) {
        this.name = name;
        this.terminals = terminals;
    }

    public String getName() {
        return name;
    }

    public void printName() {
        System.out.println("[INFO] " + this.name);
    }

    public void printAllInfo() {
        printName();
        System.out.println("---");
        for (Station terminal : terminals) {
            terminal.print();
        }
    }
}
