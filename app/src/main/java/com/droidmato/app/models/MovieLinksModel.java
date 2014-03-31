package com.droidmato.app.models;

/**
 * Created by Rex St. John on 3/30/14.
 */
public class MovieLinksModel {

    private String self;
    private String alternate;
    private String cast;
    private String clips;
    private String reviews;
    private String similar;

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getAlternate() {
        return alternate;
    }

    public void setAlternate(String alternate) {
        this.alternate = alternate;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getClips() {
        return clips;
    }

    public void setClips(String clips) {
        this.clips = clips;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    public String getSimilar() {
        return similar;
    }

    public void setSimilar(String similar) {
        this.similar = similar;
    }
}