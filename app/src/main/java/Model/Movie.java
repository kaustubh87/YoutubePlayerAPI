package Model;

import java.io.Serializable;

/**
 * Created by kvin on 2/15/16.
 */
public class Movie implements Serializable {
    private static final long id = 1L;
    private String title;
    private String description;
    private String thumbnail;
    private String releaseDate;
    private String genre;
    private String yurl;





    public static long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


    public String getYurl() {
        return yurl;
    }



    public void setYurl(String yurl) {
        this.yurl = yurl;
    }

}
