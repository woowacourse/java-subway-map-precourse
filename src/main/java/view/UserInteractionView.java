package view;

import enumerated.Operation;
import enumerated.SubMenuType;
import java.util.HashMap;
import java.util.Map;

public class UserInteractionView {

    protected String MANUAL = "";
    protected Map<Operation, Runnable> operationToCommand= new HashMap<>();

    public UserInteractionView() {

    }

    public String getManual() {
        return MANUAL;
    }

    public void execute(Operation operation) {
        if(operationToCommand.get(operation) == null) {
            return;
        }
        operationToCommand.get(operation).run();
    }

    public SubMenuType updateMenu(Operation operation, SubMenuType curMenu) {
        return curMenu;
    }

}
