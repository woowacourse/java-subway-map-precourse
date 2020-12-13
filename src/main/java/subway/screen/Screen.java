package subway.screen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Screen {
    private final ScreenType screenType;
    private final List<Choice> choices = new ArrayList<>();
    
    Screen(ScreenType screenType) {
        this.screenType = screenType;
    }
    
    public ScreenType getScreenType() {
        return screenType;
    }
    
    public List<Choice> getChoices() {
        return Collections.unmodifiableList(choices);
    }
    
    public Choice getChoiceByCommand(String command) {
        return choices.stream()
                .filter(choice -> choice.commandEquals(command))
                .findAny()
                .get();
    }
    
    public boolean containsCommand(String command) {
        return choices.stream().anyMatch(choice -> choice.commandEquals(command));
    }
    
    void addChoice(Choice choice) {
        choices.add(choice);
    }
    
    void addChoice(int index, Choice choice) {
        choices.add(index, choice);
    }
    
    boolean deleteChoice(CommandType commandType) {
        return choices.removeIf(choice -> (choice.getCommandType() == commandType));
    }
}
