package duke;

import java.util.Scanner;

/**
 * Encapsulates a Command Line Application which acts as a Task Manager.
 *
 * @author Sean Chin Jun Kai
 */
public class Duke {
    private final Storage storage;
    private TaskList tasks;
    private final Ui ui;

    /**
     * Constructor to initialise the Task Manager.
     *
     * @param filePath the path of the file where we want to store the tasks.
     */
    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (DukeException e) {
            ui.showErrorMessage(e.getMessage());
            tasks = new TaskList();
        }
    }

    /**
     * Opens up the Task Manager to taking in input and executing commands.
     *
     */
    public void run() {
        ui.showWelcomeMessage();
        Scanner scanner = new Scanner(System.in);
        boolean isExit = false;
        while (!isExit) {
            try {
                String userInput = scanner.nextLine();
                Parser.parseUserResponse(userInput);
                switch(Parser.getCommand()) {
                    case BYE: {
                        storage.saveToFile(tasks.getTaskList());
                        ui.showGoodbyeMessage();
                        isExit = true;
                        break;
                    }
                    case LIST: {
                        ui.showTasksMessage(tasks.getTaskList());
                        break;
                    }
                    case MARK: {
                        int id = Parser.parseTask(Parser.getArgs());
                        Task chosen = tasks.getTask(id);
                        chosen.mark();
                        ui.markTaskMessage(chosen);
                        break;
                    }
                    case UNMARK: {
                        int id = Parser.parseTask(Parser.getArgs());
                        Task chosen = tasks.getTask(id);
                        chosen.unmark();
                        ui.unmarkTaskMessage(chosen);
                        break;

                    }
                    case DELETE: {
                        int id = Parser.parseTask(Parser.getArgs());
                        Task chosen = tasks.getTask(id);
                        tasks.deleteTask(chosen);
                        ui.deleteTaskMessage(chosen, tasks.getTaskList());
                        break;
                    }
                    case TODO: {
                        Todo created = Parser.parseTodo(Parser.getArgs());
                        tasks.addTask(created);
                        ui.addedTaskMessage(created, tasks.getTaskList());
                        break;
                    }
                    case DEADLINE: {
                        Deadline created = Parser.parseDeadline(Parser.getArgs());
                        tasks.addTask(created);
                        ui.addedTaskMessage(created, tasks.getTaskList());
                        break;
                    }
                    case EVENT: {
                        Event created = Parser.parseEvent(Parser.getArgs());
                        tasks.addTask(created);
                        ui.addedTaskMessage(created, tasks.getTaskList());
                        break;
                    }

                }
            } catch(DukeException e) {
                ui.showErrorMessage(e.getMessage());
            }
        }

    }

    public static void main(String[] args){
        new Duke("/duke.txt").run();
    }
}