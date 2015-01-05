package com.siksha.prototype.enums;

/**
 * Created with IntelliJ IDEA.
 * User: shreyasl
 * Date: 10/18/14
 * Time: 6:58 PM
 * To change this template use File | Settings | File Templates.
 */
public enum Venue {
    Bangalore("Chinnaswamy Stadium",PitchType.BouncyPitch),
    Chennai("Chidambaram Stadium", PitchType.SpinnersPitch),
    Mumbai("Wankhede Stadium", PitchType.SwingingPitch),
    Kolkota("Eden Gardens", PitchType.FlatPitch),
    Delhi("Feroz Shah Kotla", PitchType.SpinnersPitch),
    Punjab("PCA Stadium", PitchType.GreenPitch),
    Jaipur("Sawai Mansingh Stadium", PitchType.SlowPitch),
    Hyderabad("Rajiv Gandhi International Stadium", PitchType.FlatPitch);

    private String stadiumName;
    private PitchType pitchType;

    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public PitchType getPitchType() {
        return pitchType;
    }

    public void setPitchType(PitchType pitchType) {
        this.pitchType = pitchType;
    }

    Venue(String stadiumName, PitchType pitchType){
        this.stadiumName = stadiumName;
        this.pitchType = pitchType;
    }
}
