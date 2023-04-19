package Commands;

import CommandsLogic.CollectionManager;

public class ShowCommand implements Command{
    CollectionManager collectionManager;

    public ShowCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandStatus execute(String[] args) {
        collectionManager.show();
        return new CommandStatus("Collection content",true);
    }

    @Override
    public String getName() {
        return "show";
    }
}
