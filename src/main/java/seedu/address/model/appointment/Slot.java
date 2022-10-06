package seedu.address.model.appointment;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents an Appointment's timeSlot in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidMedicalTest (String)}
 */
public class MedicalTest {


    public static final String MESSAGE_CONSTRAINTS =
            "Medical Test Names should only contain alphanumeric characters and spaces, and it should not be blank";
    /*
     * The first character of the medical test name must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";

    public final String medicalTestName;

    /**
     * Constructs a {@code MedicalTest}.
     *
     * @param medicalTestName A valid name of a medical test.
     */
    public MedicalTest(String medicalTestName) {
        requireNonNull(medicalTestName);
        checkArgument(isValidMedicalTest(medicalTestName), MESSAGE_CONSTRAINTS);
        this.medicalTestName = medicalTestName;
    }

    /**
     * Returns true if a given string is a valid medical test name.
     */
    public static boolean isValidMedicalTest(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return medicalTestName;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof MedicalTest // instanceof handles nulls
                && medicalTestName.equals(((MedicalTest) other).medicalTestName)); // state check
    }

    @Override
    public int hashCode() {
        return medicalTestName.hashCode();
    }
}