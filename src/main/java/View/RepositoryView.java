package View;

import Enum.Operation;

public interface RepositoryView {

    default void executeOperation(Operation operation) {
        if(operation == Operation.INSERT) {

        }

        if(operation == Operation.DELETE) {

        }
    }
}
