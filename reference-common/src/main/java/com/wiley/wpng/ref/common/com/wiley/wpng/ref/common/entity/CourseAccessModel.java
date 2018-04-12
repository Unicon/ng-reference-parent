package com.wiley.wpng.ref.common.com.wiley.wpng.ref.common.entity;

/**
 * @author <a href='mailto:ystartsev@wiley.com'>ystartsev</a>
 * @version 09.04.2018
 */
public enum CourseAccessModel {
    TEST_DRIVE("Test Drive"),
    ADOPTION("Adoption"),
    REP_ACCESS("Rep Access"),
    OTHER_INTERNAL_USE("other internal use");
    private final String type;

    CourseAccessModel(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }

}
