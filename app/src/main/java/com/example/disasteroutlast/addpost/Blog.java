package com.example.disasteroutlast.addpost;


public class Blog {
    private String Title;
    private String Description;
    private String Image;
    private String username;
    private String genre;

    public void setUsername(String username) {
        this.username = username;
    }

    private String release_year;

    public String getUsername() {
        return username;
    }

    public void setRating(String username) {
        this.username = username;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setRelease_year(String release_year) {
        this.release_year = release_year;
    }

    public String getRating() {
        return username;
    }

    public String getGenre() {
        return genre;
    }

    public String getRelease_year() {
        return release_year;
    }

    public Blog(){

    }

    public Blog(String title, String description, String image, String username, String genre, String release_year) {
        Title = title;
        Description = description;
        Image = image;
        this.username = username;
        this.genre = genre;
        this.release_year = release_year;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
