package com.droidmato.app.models;

/**
 * Created by Rex St. John on 3/30/14.
 */

public class MovieContainerLinksModel {

    private String self;
    private String next;
    private String alternate;

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getAlternate() {
        return alternate;
    }

    public void setAlternate(String alternate) {
        this.alternate = alternate;
    }
}
