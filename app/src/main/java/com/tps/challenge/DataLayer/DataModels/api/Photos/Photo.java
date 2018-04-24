package com.tps.challenge.DataLayer.DataModels.api.Photos;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Photo implements Parcelable {

    public final static Creator<Photo> CREATOR = new Creator<Photo>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Photo createFromParcel(Parcel in) {
            return new Photo(in);
        }

        public Photo[] newArray(int size) {
            return (new Photo[size]);
        }

    };
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("sol")
    @Expose
    private Integer sol;
    @SerializedName("img_src")
    @Expose
    private String imgSrc;
    @SerializedName("earth_date")
    @Expose
    private String earthDate;
    @SerializedName("rover")
    @Expose
    private Rover rover;

    protected Photo(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.sol = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.imgSrc = ((String) in.readValue((String.class.getClassLoader())));
        this.earthDate = ((String) in.readValue((String.class.getClassLoader())));
        this.rover = ((Rover) in.readValue((Rover.class.getClassLoader())));
    }

    public Photo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSol() {
        return sol;
    }

    public void setSol(Integer sol) {
        this.sol = sol;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getEarthDate() {
        return earthDate;
    }

    public void setEarthDate(String earthDate) {
        this.earthDate = earthDate;
    }

    public Rover getRover() {
        return rover;
    }

    public void setRover(Rover rover) {
        this.rover = rover;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(sol);
        dest.writeValue(imgSrc);
        dest.writeValue(earthDate);
        dest.writeValue(rover);
    }

    public int describeContents() {
        return 0;
    }

}
