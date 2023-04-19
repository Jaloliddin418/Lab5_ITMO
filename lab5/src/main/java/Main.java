import Commands.*;
import CommandsLogic.CollectionManager;
import Data.Dragon;
import database.CSVDataBase;
import reader.Reader;
import reader.LineInterpreter;
import java.util.Vector;
public class Main {
    public static void main(String[] args) {
        LineInterpreter lineInterpreter = new LineInterpreter(System.in);
        CollectionManager collectionManager = new CollectionManager(new Vector<>());
        for(Dragon d : CSVDataBase.readCoordinates("csv_data.csv")){
            collectionManager.add(d);
        };
        Reader reader = new Reader();
        reader.addCommand(new HelpCommand(collectionManager));
        reader.addCommand(new AddCommand(collectionManager ));
        reader.addCommand(new InfoCommand(collectionManager));
        reader.addCommand(new UpdateIDCommand(collectionManager));
        reader.addCommand(new SortCommand(collectionManager));
        reader.addCommand(new HistoryCommand(reader));
        reader.addCommand(new ClearCommand(collectionManager));
        reader.addCommand(new RemoveByIdCommand(collectionManager));
        reader.addCommand(new ReorderCommand(collectionManager));
        reader.addCommand(new ShowCommand(collectionManager));
        reader.addCommand(new SumOfAgeCommand(collectionManager));
        reader.addCommand(new FilterContainsNameCommand(collectionManager));
        reader.addCommand(new MaxByCoordinatesCommand(collectionManager));
        reader.addCommand(new SaveCommand(collectionManager));
        reader.addCommand(new ExecuteScriptCommand(reader));
        reader.read(lineInterpreter);
    }
}
