package com.example.helvi.thedoctorsapplication.activities.model;



public class Feature
{
    public String Id,title,description;
    public int image;


    public Feature(String Id, String title,String description,int image)
    {
        this.Id=Id;
        this.title=title;
        this.description=description;
        this.image=image;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
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

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
