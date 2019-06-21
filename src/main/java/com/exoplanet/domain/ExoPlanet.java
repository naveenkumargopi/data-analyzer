package com.exoplanet.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExoPlanet implements Comparable<ExoPlanet>{

    @JsonProperty("PlanetIdentifier")
    private String planetIdentifier;

    @JsonProperty("TypeFlag")
    private int typeFlag;

    @JsonProperty("RadiusJpt")
    private float radiusJpt;

    @JsonProperty("HostStarTempK")
    private int hostStarTempK;

    @JsonProperty("DiscoveryYear")
    private int discoveryYear;

    public String getSize() {
        if (radiusJpt < 1.0)
            return "small";
        else if (radiusJpt < 2.0)
            return "medium";
        else
            return "large";
    }

    public int getDiscoveryYear() {
        return discoveryYear;
    }

    public void setDiscoveryYear(int discoveryYear) {
        this.discoveryYear = discoveryYear;
    }

    public String getPlanetIdentifier() {
        return this.planetIdentifier;
    }

    public void setPlanetIdentifier(String planetIdentifier) {
        this.planetIdentifier = planetIdentifier;
    }

    public int getTypeFlag() {
        return typeFlag;
    }

    public void setTypeFlag(int typeFlag) {
        this.typeFlag = typeFlag;
    }

    public float getRadiusJpt() {
        return radiusJpt;
    }

    public void setRadiusJpt(float radiusJpt) {
        this.radiusJpt = radiusJpt;
    }

    public int getHostStarTempK() {
        return hostStarTempK;
    }

    public void setHostStarTempK(int hostStarTempK) {
        this.hostStarTempK = hostStarTempK;
    }

    @Override
    public int compareTo(ExoPlanet exoPlanet) {
        return this.hostStarTempK - exoPlanet.hostStarTempK;
    }
}
