package com.wiley.wpng.ref.common.com.wiley.wpng.ref.common.entity;

/**
 * @author <a href='mailto:azagnityko@wiley.com'>azagnityko</a>
 * @version 29.03.2018
 */

public class LtiConsumer {
    public static final String INSTITUTION_ID_LMS_TYPE_CONSTRAINT_NAME = "institution_id_lms_type_unique";
    public static final String CONSUMER_KEY_CONSTRAINT_NAME = "consumer_key_unique";


    private Long id;

    private String consumerKey;

    private String consumerSecret;

    private Long institutionId;


    private LMSType lmsType;


    private Institution institution;





    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConsumerKey() {
        return consumerKey;
    }

    public void setConsumerKey(String consumerKey) {
        this.consumerKey = consumerKey;
    }

    public String getConsumerSecret() {
        return consumerSecret;
    }

    public void setConsumerSecret(String consumerSecret) {
        this.consumerSecret = consumerSecret;
    }

    public Long getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(Long institutionId) {
        this.institutionId = institutionId;
    }

    public LMSType getLmsType() {
        return lmsType;
    }

    public void setLmsType(LMSType lmsType) {
        this.lmsType = lmsType;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }




}
