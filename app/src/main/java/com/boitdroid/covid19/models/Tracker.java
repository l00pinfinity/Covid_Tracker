
package com.boitdroid.covid19.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tracker {

    @SerializedName("Active Cases_text")
    @Expose
    private String activeCasesText;
    @SerializedName("Country_text")
    @Expose
    private String countryText;
    @SerializedName("Last Update")
    @Expose
    private String lastUpdate;
    @SerializedName("New Cases_text")
    @Expose
    private String newCasesText;
    @SerializedName("New Deaths_text")
    @Expose
    private String newDeathsText;
    @SerializedName("Total Cases_text")
    @Expose
    private String totalCasesText;
    @SerializedName("Total Deaths_text")
    @Expose
    private String totalDeathsText;
    @SerializedName("Total Recovered_text")
    @Expose
    private String totalRecoveredText;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Tracker() {
    }

    /**
     * 
     * @param newCasesText
     * @param newDeathsText
     * @param totalCasesText
     * @param lastUpdate
     * @param totalDeathsText
     * @param totalRecoveredText
     * @param countryText
     * @param activeCasesText
     */
    public Tracker(String activeCasesText, String countryText, String lastUpdate, String newCasesText, String newDeathsText, String totalCasesText, String totalDeathsText, String totalRecoveredText) {
        super();
        this.activeCasesText = activeCasesText;
        this.countryText = countryText;
        this.lastUpdate = lastUpdate;
        this.newCasesText = newCasesText;
        this.newDeathsText = newDeathsText;
        this.totalCasesText = totalCasesText;
        this.totalDeathsText = totalDeathsText;
        this.totalRecoveredText = totalRecoveredText;
    }

    public String getActiveCasesText() {
        return activeCasesText;
    }

    public void setActiveCasesText(String activeCasesText) {
        this.activeCasesText = activeCasesText;
    }

    public String getCountryText() {
        return countryText;
    }

    public void setCountryText(String countryText) {
        this.countryText = countryText;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getNewCasesText() {
        return newCasesText;
    }

    public void setNewCasesText(String newCasesText) {
        this.newCasesText = newCasesText;
    }

    public String getNewDeathsText() {
        return newDeathsText;
    }

    public void setNewDeathsText(String newDeathsText) {
        this.newDeathsText = newDeathsText;
    }

    public String getTotalCasesText() {
        return totalCasesText;
    }

    public void setTotalCasesText(String totalCasesText) {
        this.totalCasesText = totalCasesText;
    }

    public String getTotalDeathsText() {
        return totalDeathsText;
    }

    public void setTotalDeathsText(String totalDeathsText) {
        this.totalDeathsText = totalDeathsText;
    }

    public String getTotalRecoveredText() {
        return totalRecoveredText;
    }

    public void setTotalRecoveredText(String totalRecoveredText) {
        this.totalRecoveredText = totalRecoveredText;
    }

}
