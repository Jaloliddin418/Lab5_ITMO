package Commands;

import CommandsLogic.CollectionManager;
import lombok.Setter;

@Setter
public class InfoCommand implements Command{
    private final String NAME = "info";
    CollectionManager collectionManager;


    public InfoCommand(CollectionManager collectionManager ) {
        this.collectionManager = collectionManager;
    }
    @Override
    public CommandStatus execute(String[] args) {
        collectionManager.info();
        return new CommandStatus("Info about collection",true);
    }

    @Override
    public String getName() {
        return NAME;
    }
}
