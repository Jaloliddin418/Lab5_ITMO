package Commands;

import CommandsLogic.CollectionManager;

public class ReorderCommand implements Command{
    CollectionManager collectionManager;

    public ReorderCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    private final String NAME = "reorder";




    @Override
    public CommandStatus execute(String[] args) {
        collectionManager.reorder();
        return new CommandStatus("Reverse sort",true);
    }

    @Override
    public String getName() {
        return NAME;
    }
}
