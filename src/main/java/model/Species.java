package model;

import java.util.List;

public class Species {
    private String id;
    private String name;
    private String classification;
    private String eye_colors;
    private String hair_colors;
    private List<String> people;
    private List<String> films;
    private String url;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getClassification() {
        return classification;
    }

    public String getEye_colors() {
        return eye_colors;
    }

    public String getHair_colors() {
        return hair_colors;
    }

    public List<String> getPeople() {
        return people;
    }

    public List<String> getFilms() {
        return films;
    }

    public String getUrl() {
        return url;
    }
}
