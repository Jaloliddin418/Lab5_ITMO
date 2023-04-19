package Commands;

public interface Command {
    CommandStatus execute(String[] args);
    String getName();

    record CommandStatus(String message, Boolean isSuccess){
        @Override
        public String message() {
            return message;
        }
        @Override
        public Boolean isSuccess() {
            return isSuccess;
        }
    }
}
