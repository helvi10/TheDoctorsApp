package com.example.helvi.thedoctorsapplication.activities.model;

public class CategoryDoctor
{
     public String doctorId;
    public String doctorName;
    public String experience;
    public String qualification;
    public String doctorPhoto;
    public String  address;
    public String rating;

    public CategoryDoctor(String doctorId, String doctorName, String experience, String qualification, String doctorPhoto, String address, String rating) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.experience = "Experience: "+experience;
        this.qualification = "Qualification: "+qualification;
        this.doctorPhoto = doctorPhoto;
        this.address = "Address:  "+address;
        this.rating = "Rating: "+rating;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getDoctorPhoto() {
        return doctorPhoto;
    }

    public void setDoctorPhoto(String doctorPhoto) {
        this.doctorPhoto = doctorPhoto;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
