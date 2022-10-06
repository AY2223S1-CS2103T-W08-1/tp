package seedu.address.model.appointment;

import seedu.address.model.person.Email;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

/**
 * Represents an Appointment of a patient in the HealthConnect
 */
public class Appointment {
    /**
     * The FOREIGN KEY to identify a patient
     */
    private final Email email;
    private final MedicalTest medicalTest;
    private final Slot slot;
    private final Doctor doctor;

    public Appointment(Email email, MedicalTest medicalTest, Slot slot, Doctor doctor) {
        requireAllNonNull(email, medicalTest, slot, doctor);
        this.email = email;
        this.medicalTest = medicalTest;
        this.slot = slot;
        this.doctor = doctor;
    }

    public Email getEmail() {
        return email;
    }

    public MedicalTest getMedicalTest() {
        return medicalTest;
    }

    public Slot getSlot() {
        return slot;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof Appointment) {
            Appointment other = (Appointment) o;
            return slot.equals(other.getSlot())
                    && medicalTest.equals(other.getMedicalTest())
                    && doctor.equals(other.getDoctor())
                    && email.equals(other.getEmail());
        }
        return false;
    }
}
