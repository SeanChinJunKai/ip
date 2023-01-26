package duke;

/**
 * Encapsulates a task to be completed.
 *
 * @author Sean Chin Jun Kai
 */
public class Todo extends Task{
    /**
     * Constructor for creating a Todo object.
     *
     * @param description name of the task.
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Returns string representation of a Todo object which users can see in the command line.
     *
     * @return String representation of Todo.
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    /**
     * Returns string representation of a Todo. object to store in txt file.
     *
     * @return String representation of Todo.
     */
    @Override
    public String getText() {
        return "T " + super.getText();
    }
}
