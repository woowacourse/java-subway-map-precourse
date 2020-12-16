package subway.domain;

import static log.Logger.infoPrint;

import java.util.Arrays;
import java.util.LinkedList;

public class Line {

    private final String name;
    private final LinkedList<Station> terminals;
    private Station upwardTerminal;
    private Station downwardTerminal;

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

    public int getLength() {
        return terminals.size();
    }

    public boolean hasTerminal(String terminalName) {
        for (Station terminal : terminals) {
            if (terminal.getName().equals(terminalName)) {
                return true;
            }
        }
        return false;
    }

    public void addTerminal(int position, Station newTerminal) {
        terminals.add(position, newTerminal);
    }

    public void deleteTerminal(String terminalName) {
        terminals.removeIf(terminal -> terminal.getName().equals(terminalName));
    }

    public void printName() {
        infoPrint(this.name);
    }

    public void printAllInfo() {
        printName();
        infoPrint("---\n");
        for (Station terminal : terminals) {
            terminal.print();
        }
    }
}
