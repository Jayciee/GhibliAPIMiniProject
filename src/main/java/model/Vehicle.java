package model;

import java.util.List;

public class Vehicle {
    private String id;
    private String name;
    private String description;
    private String vehicle_class;
    private String length;
    private String pilot;
    private List<String> films;
    private String url;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getVehicle_class() {
        return vehicle_class;
    }

    public String getLength() {
        return length;
    }

    public String getPilot() {
        return pilot;
    }

    public List<String> getFilms() {
        return films;
    }

    public String getUrl() {
        return url;
    }
}
