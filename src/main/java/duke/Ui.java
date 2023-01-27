package duke;

import java.util.ArrayList;

/**
 * Encapsulates a User Interface that interacts with user inputs.
 *
 * @author Sean Chin Jun Kai
 */
public class Ui {

    /**
     * Displays welcome message to user when Duke is first booted.
     *
     */
    public void showWelcomeMessage() {
        System.out.println("Hello! I'm Duke\nWhat can I do for you?");
    }


    /**
     * Displays error message to user.
     *
     */
    public void showErrorMessage(String error) {
        System.out.println(error);
    }

    /**
     * Displays all tasks in TaskList to user.
     *
     */
    public void showTasksMessage(ArrayList<Task> tasks) {
        System.out.println("Here are the tasks in your list:");
        if (tasks.size() != 0) {
            int idx = 1;
            for (Task task : tasks) {
                System.out.printf("%d.%s%n", idx, task);
                idx++;
            }
        } else {
            System.out.println("There are no tasks currently");
        }

    }

    /**
     * Displays goodbye message to user upon bye command.
     *
     */
    public void showGoodbyeMessage() {
        System.out.print("Bye. Hope to see you again soon!");
    }

    /**
     * Displays message to user upon successfully adding the task to the TaskList.
     *
     */
    public void addedTaskMessage(Task task, ArrayList<Task> tasks) {
        System.out.println("Got it. I've added this task:\n" + task);
        System.out.printf("Now you have %d tasks in the list.\n", tasks.size());
    }

    /**
     * Displays message to user upon successfully marking the task as done.
     *
     */
    public void markTaskMessage(Task task) {
        System.out.println("Nice! I've marked this task as done:\n" + task);
    }

    /**
     * Displays message to user upon successfully unmarking the task.
     *
     */
    public void unmarkTaskMessage(Task task) {
        System.out.println("OK, I've marked this task as not done yet:\n" + task);
    }


    /**
     * Displays message to user upon successfully deleting the task.
     *
     */
    public void deleteTaskMessage(Task task, ArrayList<Task> tasks) {
        System.out.println("Noted. I've removed this task:\n" + task);
        System.out.printf("Now you have %d tasks in the list.\n", tasks.size());
    }
}
