package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DOCTOR;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MEDICAL_TEST;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SLOT;
import static seedu.address.logic.parser.ParserUtil.arePrefixesPresent;
import static seedu.address.logic.parser.ParserUtil.createPredicateString;

import java.util.Optional;
import java.util.function.Predicate;

import seedu.address.logic.commands.FindAppointmentCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.appointment.Doctor;
import seedu.address.model.appointment.MedicalTest;
import seedu.address.model.appointment.Slot;
import seedu.address.model.patient.Name;

/**
 * Parses input arguments and creates a new FindAppointmentCommand object
 */
public class FindAppointmentCommandParser implements Parser<FindAppointmentCommand> {
    private Optional<Predicate<Name>> namePredicate;
    private Optional<Predicate<MedicalTest>> testPredicate;
    private Optional<Predicate<Slot>> slotPredicate;
    private Optional<Predicate<Doctor>> doctorPredicate;

    /**
     * Parses the given {@code String} of arguments in the context of the FindAppointmentCommand
     * @throws ParseException if the user input does not conform the expected format
     */
    public FindAppointmentCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_NAME, PREFIX_MEDICAL_TEST,
                        PREFIX_SLOT, PREFIX_DOCTOR);

        if (!arePrefixesPresent(argMultimap, PREFIX_NAME, PREFIX_MEDICAL_TEST, PREFIX_SLOT, PREFIX_DOCTOR)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindAppointmentCommand.MESSAGE_USAGE));
        }

        this.namePredicate = argMultimap.getValue(PREFIX_NAME)
                .map(s -> s.trim())
                .map(s -> createPredicateString(s))
                .map(s -> name -> name.fullName.toLowerCase().contains(s.toLowerCase()));

        this.testPredicate = argMultimap.getValue(PREFIX_MEDICAL_TEST)
                .map(s -> s.trim())
                .map(s -> createPredicateString(s))
                .map(s -> test -> test.toString().toLowerCase().contains(s.toLowerCase()));

        this.slotPredicate = argMultimap.getValue(PREFIX_SLOT)
                .map(s -> s.trim())
                .map(s -> slot -> slot.toString().toLowerCase().contains(s.toLowerCase()));

        this.doctorPredicate = argMultimap.getValue(PREFIX_DOCTOR)
                .map(s -> s.trim())
                .map(s -> createPredicateString(s))
                .map(s -> doctor -> doctor.toString().toLowerCase().contains(s.toLowerCase()));

        return new FindAppointmentCommand(namePredicate, testPredicate, slotPredicate, doctorPredicate);
    }
}
