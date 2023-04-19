package Commands;


import reader.Reader;

import java.util.Deque;

public class HistoryCommand implements Command{
    public static final String NAME = "history";

    private final Reader reader;

    public HistoryCommand(Reader reader) {
        this.reader = reader;
    }

    @Override
    public CommandStatus execute(String[] args) {
        Deque<String> commandHistory = reader.getHistory();

        int size = Math.min(commandHistory.size() , 7);
        for (int i = 0; i < size; i++) {
            System.out.println(commandHistory.removeLast());
        }
        return new CommandStatus("Command history:",true);
    }

    @Override
    public String getName() {
        return NAME;
    }
}
