package Commands;

import CommandsLogic.CollectionManager;

import Data.*;

public class AddCommand implements Command{

    private final String NAME = "add";
    private CollectionManager collectionManager;
    private String message;

    public AddCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandStatus execute(String[] args) {
        Dragon dragon = DragonReadFromConsole.readDragon();
        if (dragon == null)
            return new CommandStatus("Dragon not added",false);
        collectionManager.add(dragon);
        System.out.println("Dragon added successfully!");
        return new CommandStatus("Dragon added successfully!",true);
    }

    @Override
    public String getName() {
        return NAME;
    }
}


