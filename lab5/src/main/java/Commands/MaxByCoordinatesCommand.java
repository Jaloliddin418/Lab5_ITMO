package Commands;

import CommandsLogic.CollectionManager;

public class MaxByCoordinatesCommand implements Command{
    CollectionManager collectionManager;

    public MaxByCoordinatesCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandStatus execute(String[] args) {
        collectionManager.maxByCoordinates();
        return new CommandStatus("Dragon by max coordinates",true);
    }
    @Override
    public String getName() {
        return "max_by_coordinates";
    }
}
