package com.example.testhibernate.domain.entity.enumeration;

/**
 * Created by ballmw on 3/25/16.
 */
public enum ClosedCaptionStatus {

    REQUESTED("Requested"),
    READY_TO_SUBMIT("readyToSubmit"),
    COMPLETE("Complete"),
    CANCELLED("Cancelled"),
    RECEIVED("Received"),
    IN_PROGRESS("In Progress"),
    FINDING_CAPTIONER("Finding Captioner"),
    TRANSCRIBED("transcribed"),
    FAILED("failed");

    private final String value;

    private ClosedCaptionStatus(String value) {
        this.value = value;
    }

    public String value() { return this.value; }

    public static ClosedCaptionStatus fromString(String ccString) {
        if (ccString != null) {
            for (ClosedCaptionStatus type : ClosedCaptionStatus.values()) {
                if (ccString.equals(type.value())) {
                    return type;
                }
            }
        }
        throw new IllegalArgumentException("No scan type defined for '" + ccString + "'.");
    }

}
