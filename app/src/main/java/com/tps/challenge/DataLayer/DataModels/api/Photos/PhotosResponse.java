package com.tps.challenge.DataLayer.DataModels.api.Photos;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PhotosResponse implements Parcelable {

    public final static Creator<PhotosResponse> CREATOR = new Creator<PhotosResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public PhotosResponse createFromParcel(Parcel in) {
            return new PhotosResponse(in);
        }

        public PhotosResponse[] newArray(int size) {
            return (new PhotosResponse[size]);
        }

    };
    @SerializedName("photos")
    @Expose
    private List<Photo> photos;

    protected PhotosResponse(Parcel in) {
        in.readList(this.photos, (Photo.class.getClassLoader()));
    }

    public PhotosResponse() {
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(photos);
    }

    public int describeContents() {
        return 0;
    }

}
