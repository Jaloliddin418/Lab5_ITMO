package Commands;

import CommandsLogic.CollectionManager;

public class SortCommand implements Command{
    CollectionManager collectionManager;

    public SortCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandStatus execute(String[] args) {
        collectionManager.sort();
        return new CommandStatus("Collection sorted",true);
    }

    @Override
    public String getName() {
        return "sort";
    }

}
