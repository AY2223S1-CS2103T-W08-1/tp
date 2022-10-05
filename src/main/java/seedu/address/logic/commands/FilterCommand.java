package seedu.address.logic.commands;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

/**
 * Filter and list all persons that satisfies given condition.
 */
public class FilterCommand extends Command {
    public static final String COMMAND_WORD = "filter";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": filter the users that satisfying given condition."
            + "Parameters: [Field Name], [Operator], [Value], where [Operator] includes '==', '>', '<', '>=', '<='."
            + "filter [Field Name] [Operator] [Value]\n"
            + "Example: " + COMMAND_WORD + " age >= 20 ";

    public static final String MESSAGE_ADD_REMARK_SUCCESS = "Added remark to Person: %1$s";
    public static final String MESSAGE_DELETE_REMARK_SUCCESS = "Removed remark from Person: %1$s";

    private final String fieldName;
    private final String operator;
    private final String value;

    /**
     * @param fieldName The field to be filtered by conditions.
     * @param operator The operator in the condition.
     * @param value The value in the condition.
     */
    public FilterCommand(String fieldName, String operator, String value) {
        requireAllNonNull(fieldName, operator, value);
        this.fieldName = fieldName;
        this.operator = operator;
        this.value = value;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        return null;
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }
        // instanceof handles nulls
        if (!(other instanceof FilterCommand)) {
            return false;
        }
        // state check
        FilterCommand e = (FilterCommand) other;
        return fieldName.equals(e.fieldName) && operator.equals(e.operator)
                && value.equals(e.value);
    }
}
