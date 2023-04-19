package Commands;

import CommandsLogic.CollectionManager;


public class FilterContainsNameCommand implements Command{
    CollectionManager collectionManager;
    public FilterContainsNameCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }
    @Override
    public CommandStatus execute(String[]args) {
        if (args.length == 1) {
            return new CommandStatus("Not enough params",false);
        }
        String searchSubstring;
        try {
            searchSubstring = args[1];
        }catch (Exception e) {
            return new CommandStatus("Invalid params",false);
        }
        collectionManager.filterContainsName(searchSubstring);
        return new CommandStatus("Dragon is found",true);
    }

    @Override
    public String getName() {
        return "filter_contains_name";
    }

}
