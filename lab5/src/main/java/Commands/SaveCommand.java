package Commands;

import CommandsLogic.CollectionManager;

public class SaveCommand implements Command{
    CollectionManager collectionManager;

    public SaveCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandStatus execute(String[] args) {
        collectionManager.saveCollection();
        return new CommandStatus("Collection saved",true);
    }

    @Override
    public String getName() {
        return "save";
    }
}
