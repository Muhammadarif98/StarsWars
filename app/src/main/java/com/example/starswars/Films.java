package com.example.starswars;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;


/**
 * Film model represents a Star Wars single film.
 *
 * @author Zygimantus
 */

public class Films implements Serializable {

    private String title;

    @SerializedName("episode_id")
    private int episodeId;

    @SerializedName("opening_crawl")
    private String openingCrawl;

    private String director;
    private String producer;
    private String release_date;
    private String url;
    private String created;
    private String edited;

    @SerializedName("species")
    private List<String> speciesUrls;

    @SerializedName("starships")
    private List<String> starshipsUrls;

    @SerializedName("vehicles")
    private List<String> vehiclesUrls;

    @SerializedName("planets")
    private List<String> planetsUrls;

    @SerializedName("characters")
    private List<String> charactersUrls;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}