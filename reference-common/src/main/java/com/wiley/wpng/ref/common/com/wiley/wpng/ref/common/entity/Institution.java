package com.wiley.wpng.ref.common.com.wiley.wpng.ref.common.entity;

import java.util.List;


/**
 * @author <a href='mailto:azagnityko@wiley.com'>azagnityko</a>
 * @version 29.03.2018
 */

public class Institution {


    private Long id;

    private String institutionName;

    private String ficeCode;

    private Long countryCode;

    private String countryName;

    private String canvasAccountId;

    private String canvasSisAccountId;



    private List<Course> courses;


    private List<LtiConsumer> ltiConsumers;






    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getFiceCode() {
        return ficeCode;
    }

    public void setFiceCode(String ficeCode) {
        this.ficeCode = ficeCode;
    }

    public Long getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(Long countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCanvasAccountId() {
        return canvasAccountId;
    }

    public void setCanvasAccountId(String canvasAccountId) {
        this.canvasAccountId = canvasAccountId;
    }

    public String getCanvasSisAccountId() {
        return canvasSisAccountId;
    }

    public void setCanvasSisAccountId(String canvasSisAccountId) {
        this.canvasSisAccountId = canvasSisAccountId;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<LtiConsumer> getLtiConsumers() {
        return ltiConsumers;
    }

    public void setLtiConsumers(List<LtiConsumer> ltiConsumers) {
        this.ltiConsumers = ltiConsumers;
    }




}
