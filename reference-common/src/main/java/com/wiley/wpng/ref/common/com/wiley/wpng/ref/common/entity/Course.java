package com.wiley.wpng.ref.common.com.wiley.wpng.ref.common.entity;

import java.util.List;



/**
 * @author <a href='mailto:azagnityko@wiley.com'>azagnityko</a>
 * @version 29.03.2018
 */

public class Course {


    private Long id;

    private Long institutionId;

    private Long canvasCourseId;
    private String productId;

    private String courseName;

    private String courseDescription;


    private CourseAccessModel courseAccessModel;


    private CourseRecommendationOption courseRecommendationOption;

    private List<CourseSection> courseSections;


    private Institution institution;

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Long getCanvasCourseId() {
        return canvasCourseId;
    }

    public void setCanvasCourseId(Long canvasCourseId) {
        this.canvasCourseId = canvasCourseId;
    }

    public Long getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(Long institutionId) {
        this.institutionId = institutionId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CourseSection> getCourseSections() {
        return courseSections;
    }

    public void setCourseSections(List<CourseSection> courseSections) {
        this.courseSections = courseSections;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public CourseAccessModel getCourseAccessModel() {
        return courseAccessModel;
    }

    public void setCourseAccessModel(CourseAccessModel courseAccessModel) {
        this.courseAccessModel = courseAccessModel;
    }

    public CourseRecommendationOption getCourseRecommendationOption() {
        return courseRecommendationOption;
    }

    public void setCourseRecommendationOption(CourseRecommendationOption courseRecommendationOption) {
        this.courseRecommendationOption = courseRecommendationOption;
    }
}
