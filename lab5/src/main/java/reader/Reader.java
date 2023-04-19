package reader;

import Commands.Command;;
import java.util.*;

public class Reader {
    boolean isExit = true;
   private String message;
   private Map<String, Command> commandsM;
   private ArrayList <Command> commands = new ArrayList<>();
   private Deque<String> commandHistory = new LinkedList<>();
    public Reader( ) {
    }
    public Deque<String> getHistory(){
        return new LinkedList<>(commandHistory.stream().limit(7).toList());
    }
    public void addCommand(Command cmd){
        commands.add(cmd);
    }

    public void read(LineInterpreter interpreter){
        while(isExit) {
            try {
                interpreter.nextLine();
            } catch (NoSuchElementException e) {
                return;
            }
            message = interpreter.getAllWords()[0];
            boolean commandFound = false;
            if (message.equals("exit")) {
                isExit = false;
                commandFound = true;
            }
            for (Command cmd : commands) {
                if (cmd.getName().equals(message)) {
                    commandFound = true;
                    commandHistory.push(cmd.getName());
                    cmd.execute(interpreter.getAllWords());
                    break;
                }
            }
            if (!commandFound) {
                System.out.println("No command found for input: " + message);
            }
        }
    }
}

