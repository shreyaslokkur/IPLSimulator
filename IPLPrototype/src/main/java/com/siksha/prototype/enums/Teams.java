package com.siksha.prototype.enums;

/**
 * Created with IntelliJ IDEA.
 * User: shreyasl
 * Date: 10/21/14
 * Time: 11:12 PM
 * To change this template use File | Settings | File Templates.
 */
public enum Teams {
    RCB(Venue.Bangalore, "Vijay Mallya"),
    MI(Venue.Mumbai, "Nita Ambani"),
    CSK(Venue.Chennai, "Srinivasan"),
    KKR(Venue.Kolkota, "Shah Rukh Khan"),
    DD(Venue.Delhi, "GMR Group"),
    SH(Venue.Hyderabad, "Sun Group"),
    RR(Venue.Jaipur, "Shilpa Shetty"),
    KXIP(Venue.Punjab, "Priety Zinta");

    private Venue venue;
    private String owner;

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    Teams(Venue venue, String owner){
        this.venue = venue;
        this.owner = owner;

    }
}
