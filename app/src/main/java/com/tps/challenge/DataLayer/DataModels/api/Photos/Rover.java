
package com.tps.challenge.DataLayer.DataModels.api.Photos;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rover implements Parcelable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("landing_date")
    @Expose
    private String landingDate;
    @SerializedName("launch_date")
    @Expose
    private String launchDate;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("max_sol")
    @Expose
    private Integer maxSol;
    @SerializedName("max_date")
    @Expose
    private String maxDate;
    @SerializedName("total_photos")
    @Expose
    private Integer totalPhotos;
    public final static Creator<Rover> CREATOR = new Creator<Rover>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Rover createFromParcel(Parcel in) {
            return new Rover(in);
        }

        public Rover[] newArray(int size) {
            return (new Rover[size]);
        }

    }
    ;

    protected Rover(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.landingDate = ((String) in.readValue((String.class.getClassLoader())));
        this.launchDate = ((String) in.readValue((String.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.maxSol = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.maxDate = ((String) in.readValue((String.class.getClassLoader())));
        this.totalPhotos = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public Rover() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLandingDate() {
        return landingDate;
    }

    public void setLandingDate(String landingDate) {
        this.landingDate = landingDate;
    }

    public String getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(String launchDate) {
        this.launchDate = launchDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getMaxSol() {
        return maxSol;
    }

    public void setMaxSol(Integer maxSol) {
        this.maxSol = maxSol;
    }

    public String getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(String maxDate) {
        this.maxDate = maxDate;
    }

    public Integer getTotalPhotos() {
        return totalPhotos;
    }

    public void setTotalPhotos(Integer totalPhotos) {
        this.totalPhotos = totalPhotos;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(landingDate);
        dest.writeValue(launchDate);
        dest.writeValue(status);
        dest.writeValue(maxSol);
        dest.writeValue(maxDate);
        dest.writeValue(totalPhotos);
    }

    public int describeContents() {
        return  0;
    }

}
