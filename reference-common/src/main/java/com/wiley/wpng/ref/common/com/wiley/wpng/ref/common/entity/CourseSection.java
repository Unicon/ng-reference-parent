package com.wiley.wpng.ref.common.com.wiley.wpng.ref.common.entity;

import java.util.Date;
import java.util.Objects;

/**
 * @author <a href='mailto:ystartsev@wiley.com'>ystartsev</a>
 * @version 23.03.2018
 */

public class CourseSection {

    private Long id;

    private Long courseId;

    private String sectionName;

    private Long canvasSectionId;

    private String sectionCode;

    private Date sectionStartDate;

    private Date sectionEndDate;


    private Course course;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public Long getCanvasSectionId() {
        return canvasSectionId;
    }

    public void setCanvasSectionId(Long canvasSectionId) {
        this.canvasSectionId = canvasSectionId;
    }

    public String getSectionCode() {
        return sectionCode;
    }

    public void setSectionCode(String sectionCode) {
        this.sectionCode = sectionCode;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Date getSectionStartDate() {
        return sectionStartDate;
    }

    public void setSectionStartDate(Date sectionStartDate) {
        if (Objects.nonNull(sectionStartDate)) {
            this.sectionStartDate = (Date) sectionStartDate.clone();
        } else {
            this.sectionStartDate = null;
        }
    }

    public Date getSectionEndDate() {
        return sectionEndDate;
    }

    public void setSectionEndDate(Date sectionEndDate) {
        if (Objects.nonNull(sectionEndDate)) {
            this.sectionEndDate = (Date) sectionEndDate.clone();
        } else {
            this.sectionEndDate = null;
        }
    }
}
