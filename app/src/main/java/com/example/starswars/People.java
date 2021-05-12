package com.example.starswars;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;


/**
 * People model represents an individual person or character within the Star
 * Wars universe.
 *
 * @author Zygimantus
 */

public class People implements Serializable {

    private String name;

    @SerializedName("birth_year")
    private String birthYear;

    @SerializedName("films")
    private List<String> filmsUrls;

    private String gender;

    @SerializedName("hair_color")
    private String hairColor;

    private String height;

    @SerializedName("homeworld")
    private String homeWorldUrl;

    private String mass;

    @SerializedName("skin_color")
    private String skinColor;

    private String created;
    private String edited;
    private String url;
    @SerializedName("species")
    private List<String> speciesUrls;

    @SerializedName("starships")
    private List<String> starshipsUrls;

    @SerializedName("vehicles")
    private List<String> vehiclesUrls;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}