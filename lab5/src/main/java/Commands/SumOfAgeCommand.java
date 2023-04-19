package Commands;

import CommandsLogic.CollectionManager;

public class SumOfAgeCommand implements Command{
    CollectionManager collectionManager;

    public SumOfAgeCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandStatus execute(String[] args) {
            collectionManager.sumOfAge();
            return new CommandStatus("Sum of age",true);
    }
    @Override
    public String getName() {
        return "sum_of_age";
    }
}
