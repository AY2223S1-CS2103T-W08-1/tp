package seedu.address.logic.commands;

import seedu.address.model.Model;
import seedu.address.model.person.Remark;

/**
 * Changes the remark of an existing person in the address book.
 */
public class RemarkCommand extends Command {

    public static final String COMMAND_WORD = "remark";

    private final Remark remark;

    public RemarkCommand(Remark remark) {
        this.remark = remark;
    }

    @Override
    public CommandResult execute(Model model) {
        return new CommandResult(this.remark.value);
    }
}