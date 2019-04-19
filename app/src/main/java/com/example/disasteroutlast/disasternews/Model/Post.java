package com.example.disasteroutlast.disasternews.Model;


public class Post {
    private String crisis_vulnerability;

    private Crisis_vulnerability_hash crisis_vulnerability_hash;

    private Crisis_severity_hash crisis_severity_hash;

    private String subject;

    private String dc_date;

    private String schema_endDate;

    private String crisis_alertLevel;

    private String dc_description;

    private String[] gn_parentCountry;

    private String crisis_severity;

    private String schema_startDate;

    private String dc_title;

    private Crisis_population_hash crisis_population_hash;

    private String[] foaf_based_near;

    private String _id;

    private String crisis_population;

    public String getCrisis_vulnerability ()
    {
        return crisis_vulnerability;
    }

    public void setCrisis_vulnerability (String crisis_vulnerability)
    {
        this.crisis_vulnerability = crisis_vulnerability;
    }

    public Crisis_vulnerability_hash getCrisis_vulnerability_hash ()
    {
        return crisis_vulnerability_hash;
    }

    public void setCrisis_vulnerability_hash (Crisis_vulnerability_hash crisis_vulnerability_hash)
    {
        this.crisis_vulnerability_hash = crisis_vulnerability_hash;
    }

    public Crisis_severity_hash getCrisis_severity_hash ()
    {
        return crisis_severity_hash;
    }

    public void setCrisis_severity_hash (Crisis_severity_hash crisis_severity_hash)
    {
        this.crisis_severity_hash = crisis_severity_hash;
    }

    public String getSubject ()
    {
        return subject;
    }

    public void setSubject (String subject)
    {
        this.subject = subject;
    }

    public String getDc_date ()
    {
        return dc_date;
    }

    public void setDc_date (String dc_date)
    {
        this.dc_date = dc_date;
    }

    public String getSchema_endDate ()
    {
        return schema_endDate;
    }

    public void setSchema_endDate (String schema_endDate)
    {
        this.schema_endDate = schema_endDate;
    }

    public String getCrisis_alertLevel ()
    {
        return crisis_alertLevel;
    }

    public void setCrisis_alertLevel (String crisis_alertLevel)
    {
        this.crisis_alertLevel = crisis_alertLevel;
    }

    public String getDc_description ()
    {
        return dc_description;
    }

    public void setDc_description (String dc_description)
    {
        this.dc_description = dc_description;
    }

    public String[] getGn_parentCountry ()
    {
        return gn_parentCountry;
    }

    public void setGn_parentCountry (String[] gn_parentCountry)
    {
        this.gn_parentCountry = gn_parentCountry;
    }

    public String getCrisis_severity ()
    {
        return crisis_severity;
    }

    public void setCrisis_severity (String crisis_severity)
    {
        this.crisis_severity = crisis_severity;
    }

    public String getSchema_startDate ()
    {
        return schema_startDate;
    }

    public void setSchema_startDate (String schema_startDate)
    {
        this.schema_startDate = schema_startDate;
    }

    public String getDc_title ()
    {
        return dc_title;
    }

    public void setDc_title (String dc_title)
    {
        this.dc_title = dc_title;
    }

    public Crisis_population_hash getCrisis_population_hash ()
    {
        return crisis_population_hash;
    }

    public void setCrisis_population_hash (Crisis_population_hash crisis_population_hash)
    {
        this.crisis_population_hash = crisis_population_hash;
    }

    public String[] getFoaf_based_near ()
    {
        return foaf_based_near;
    }

    public void setFoaf_based_near (String[] foaf_based_near)
    {
        this.foaf_based_near = foaf_based_near;
    }

    public String get_id ()
    {
        return _id;
    }

    public void set_id (String _id)
    {
        this._id = _id;
    }

    public String getCrisis_population ()
    {
        return crisis_population;
    }

    public void setCrisis_population (String crisis_population)
    {
        this.crisis_population = crisis_population;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [crisis_vulnerability = "+crisis_vulnerability+", crisis_vulnerability_hash = "+crisis_vulnerability_hash+", crisis_severity_hash = "+crisis_severity_hash+", subject = "+subject+", dc_date = "+dc_date+", schema_endDate = "+schema_endDate+", crisis_alertLevel = "+crisis_alertLevel+", dc_description = "+dc_description+", gn_parentCountry = "+gn_parentCountry+", crisis_severity = "+crisis_severity+", schema_startDate = "+schema_startDate+", dc_title = "+dc_title+", crisis_population_hash = "+crisis_population_hash+", foaf_based_near = "+foaf_based_near+", _id = "+_id+", crisis_population = "+crisis_population+"]";
    }
}
