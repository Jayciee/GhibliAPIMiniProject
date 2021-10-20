package model;

import java.util.List;

public class People {
    private String id;
    private String name;
    private String gender;
    private String age;
    private String eye_color;
    private String hair_color;
    private List<String> films;
    private String species;
    private String url;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getAge() {
        return age;
    }

    public String getEye_color() {
        return eye_color;
    }

    public String getHair_color() {
        return hair_color;
    }

    public List<String> getFilms() {
        return films;
    }

    public String getSpecies() {
        return species;
    }

    public String getUrl() {
        return url;
    }
}
