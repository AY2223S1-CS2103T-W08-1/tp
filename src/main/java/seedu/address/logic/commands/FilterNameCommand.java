package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.core.Messages;
import seedu.address.model.Model;
import seedu.address.model.patient.NameContainsKeywordsPredicate;

/**
 * Filters and lists all patients in address book whose name contains any of the argument keywords.
 * Keyword matching is case insensitive.
 */
public class FilterNameCommand extends Command {

    public static final CommandWord COMMAND_WORD =
            new CommandWord("filtername", "findname", "fn");

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Filters all patients whose names contain any of "
            + "the specified keywords (case-insensitive) and displays them as a list with index numbers.\n"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + " alice bob charlie";

    private final NameContainsKeywordsPredicate predicate;

    public FilterNameCommand(NameContainsKeywordsPredicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredPatientList(predicate);
        return new CommandResult(
                String.format(Messages.MESSAGE_PATIENTS_LISTED_OVERVIEW, model.getFilteredPatientList().size()));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof FilterNameCommand // instanceof handles nulls
                && predicate.equals(((FilterNameCommand) other).predicate)); // state check
    }
}
