package subway.screen;

import subway.CommonConstants;

public class Choice {
    private static final String COMMAND_OPERATION_DELIMITER = ".";
    
    private final CommandType commandType;
    private final EntityType entityType;
    private final ActionType actionType;
    
    Choice(CommandType commandType, EntityType entityType, ActionType actionType) {
        this.commandType = commandType;
        this.entityType = entityType;
        this.actionType = actionType;
    }
    
    public CommandType getCommandType() {
        return commandType;
    }
    
    public EntityType getEntityType() {
        return entityType;
    }
    
    public ActionType getActionType() {
        return actionType;
    }
    
    public boolean commandEquals(String command) {
        return commandType.toString().equals(command);
    }
    
    public boolean entityTypeEquals(EntityType entityType) {
        return this.entityType == entityType;
    }
    
    public boolean actionTypeEquals(ActionType actionType) {
        return this.actionType == actionType;
    }
    
    public String toString() {
        String resultString = commandType.toString() + COMMAND_OPERATION_DELIMITER;
        
        if (entityType != EntityType.NONE) {
            resultString += CommonConstants.SPACE + entityType.toString();
        }
        
        resultString += CommonConstants.SPACE + actionType.toString();
        
        return resultString;
    }
}
