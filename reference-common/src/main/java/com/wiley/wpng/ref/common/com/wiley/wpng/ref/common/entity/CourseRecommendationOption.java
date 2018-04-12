package com.wiley.wpng.ref.common.com.wiley.wpng.ref.common.entity;

/**
 * @author <a href='mailto:ystartsev@wiley.com'>ystartsev</a>
 * @version 09.04.2018
 */
public enum CourseRecommendationOption {
    RECOMMENDED("Recommended"),
    REQUIRED("Required"),
    NOT_SURE("not sure");
    private final String type;

    CourseRecommendationOption(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
