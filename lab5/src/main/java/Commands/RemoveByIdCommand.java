package Commands;

import CommandsLogic.CollectionManager;

public class RemoveByIdCommand implements Command{
    CollectionManager collectionManager;

    public RemoveByIdCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandStatus execute(String[]args) {
        if (args.length == 0) {
            return new CommandStatus("Not enough parameters",false);
        }
        int id;
        try {
            id = Integer.parseInt(args[1]);
        }catch (Exception e) {
            return new CommandStatus("Param must be integer",false);
        }
        collectionManager.removeById(id);
        return new CommandStatus("Element removed successfully",true);
    }
    @Override
    public String getName() {
        return "remove_by_id";
    }
}
