package model;

import java.util.List;

public class Film {
    private String id;
    private String title;
    private String original_title;
    private String original_title_romanised;
    private String image;
    private String movie_banner;
    private String description;
    private String director;
    private String producer;
    private String release_date;
    private String running_time;
    private String rt_score;
    private String url;
    private List<String> people;
    private List<String> species;
    private List<String> locations;
    private List<String> vehicles;

    public String getId(){
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public String getOriginal_title_romanised() {
        return original_title_romanised;
    }

    public String getImage() {
        return image;
    }

    public String getMovie_banner() {
        return movie_banner;
    }

    public String getDescription() {
        return description;
    }

    public String getDirector() {
        return director;
    }

    public String getProducer() {
        return producer;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getRunning_time() {
        return running_time;
    }

    public String getRt_score() {
        return rt_score;
    }

    public String getUrl() {
        return url;
    }

    public List<String> getPeople() {
        return people;
    }

    public List<String> getSpecies() {
        return species;
    }

    public List<String> getLocations() {
        return locations;
    }

    public List<String> getVehicles() {
        return vehicles;
    }
}
