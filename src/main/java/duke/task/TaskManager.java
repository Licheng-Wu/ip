package duke.task;

import java.util.Scanner;

import java.io.FileNotFoundException;
import java.time.format.DateTimeParseException;

import duke.parser.Parser;
import duke.storage.Storage;
import duke.commands.Command;
import duke.exceptions.DukeException;
import duke.ui.Ui;

public class TaskManager {
    private Ui ui;
    private Parser parser;
    private TaskList taskList;
    private Storage storage;

    public TaskManager(TaskList taskList, Ui ui, Storage storage, Parser parser) {
        this.ui = ui;
        this.parser = parser;
        this.taskList = taskList;
        this.storage = storage;
    }

    public void manage() {
        // Take in user input
        Scanner sc = new Scanner(System.in); // Create a Scanner object
        boolean isExit = false;
        while (!isExit) {
            String fullCommand = sc.nextLine(); // Read user input
            try {
                try {
                    Command c = Parser.parse(fullCommand);
                    c.execute(taskList, ui, storage);
                    isExit = c.isExit();
                } catch (NumberFormatException error) {
                    // When "done" is not followed by a valid number
                    throw new DukeException("OOPS!!! Please enter a valid index!");
                } catch (ArrayIndexOutOfBoundsException error) {
                    // When "done" is not followed by any number
                    throw new DukeException("OOPS!!! Please enter a valid index!");
                } catch (IndexOutOfBoundsException error) {
                    // When "done is followed by a number that is out of range
                    throw new DukeException("OOPS!!! That index is out of range!");
                } catch (DateTimeParseException e) {
                    throw new DukeException("OOPS!!! Please enter the date in yyyy-mm-dd format!");
                }
            } catch (DukeException error) {
                System.out.println(error.getMessage());
            }
        }
        sc.close();
    }
}
