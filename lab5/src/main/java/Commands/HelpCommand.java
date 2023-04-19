package Commands;

import CommandsLogic.CollectionManager;

import java.util.Objects;

public class HelpCommand implements Command {
    public static final String NAME = "help";
    private final CollectionManager manager;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HelpCommand that = (HelpCommand) o;
        return Objects.equals(manager, that.manager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manager);
    }


    public HelpCommand(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public CommandStatus execute(String[] args) {
        return new CommandStatus("help : вывести справку по доступным командам\n" +
                "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                "add {element} : добавить новый элемент в коллекцию\n" +
                "update_id{element} : обновить значение элемента коллекции, id которого равен заданному\n" +
                "remove_by_id id : удалить элемент из коллекции по его id\n" +
                "clear : очистить коллекцию\n" +
                "save : сохранить коллекцию в файл\n" +
                "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
                "exit : завершить программу (без сохранения в файл)\n" +
                "отсортировать коллекцию в порядке, обратном нынешнему\n" +
                "sort : отсортировать коллекцию в естественном порядке\n" +
                "history : вывести последние 7 команд (без их аргументов)\n" +
                "sum_of_age : вывести сумму значений поля age для всех элементов коллекции\n" +
                "max_by_coordinates : вывести любой объект из коллекции, значение поля coordinates которого является максимальным\n" +
                "filter_contains_name name : вывести элементы, значение поля name которых содержит заданную подстроку",true);
    }

    @Override
    public String getName() {
        return NAME;
    }

}
