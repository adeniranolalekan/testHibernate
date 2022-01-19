package com.example.testhibernate.domain.entity.enumeration;

public enum VideoRotation {

    AUTO("auto"),
    ZERO("0"),
    LEFT("270"),
    RIGHT("90"),
    FLIP("180");

    private final String value;

    private VideoRotation(String value) {
        this.value = value;
    }

    public String value() { return this.value; }

    public static VideoRotation fromString(String rotationValue) {
        if (rotationValue != null) {
            for (VideoRotation type : VideoRotation.values()) {
                if (rotationValue.equals(type.value())) {
                    return type;
                }
            }
        }
        throw new IllegalArgumentException("No scan type defined for '" + rotationValue + "'.");
    }
}
