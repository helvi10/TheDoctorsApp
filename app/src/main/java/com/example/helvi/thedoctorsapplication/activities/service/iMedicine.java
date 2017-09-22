package com.example.helvi.thedoctorsapplication.activities.service;



import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;



public interface iMedicine
{
    @GET("appointment_book.php")
    Call<AppointmentConfirmation> getAppoint(@Query("patientID") String patientID,
                                             @Query("doctorID") String doctorID,
                                             @Query("startTime") String startTime,
                                             @Query("endTime") String endTime);
}
