package Commands;

import CommandsLogic.CollectionManager;
import Data.DragonReadFromConsole;

public class UpdateIDCommand implements Command {
    private final CollectionManager collectionManager;

    public UpdateIDCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandStatus execute(String[] args) {
        if (args.length == 1) {
            return new CommandStatus("Not enough parameters", false);
        }
        int id;
        try {
            id = Integer.parseInt(args[1]);
        } catch (Exception e) {
            return new CommandStatus("Param must be integer", false);
        }
        if (!collectionManager.isThereDragon(id)) {
            return new CommandStatus("Dragon not found", false);
        }
        var dragon = DragonReadFromConsole.readDragon();
        if (dragon == null) {
            return new CommandStatus("Invalid dragon data", false);
        }
        collectionManager.updateId(id, dragon);
        return new CommandStatus("Element updated successfully", true);
    }


    @Override
    public String getName() {
        return "update_id";
    }

}
