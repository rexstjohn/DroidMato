package com.droidmato.app.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rex St. John on 3/30/14.
 */
public class CastModel {

    private String name;
    private List<String> characters;

    public List<String> getCharacters() {
        return characters;
    }

    public void setCharacters(List<String> characters) {
        this.characters = characters;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
