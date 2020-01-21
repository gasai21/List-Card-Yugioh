package com.example.listcardyugioh.model.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CardResponse implements Parcelable {
    @SerializedName("name")
    String name;
    @SerializedName("type")
    String type;
    @SerializedName("desc")
    String desc;
    @SerializedName("race")
    String race;
    @SerializedName("archetype")
    String archetype;
    @SerializedName("formats")
    String formats;
    @SerializedName("card_images")
    List<DataImages> card_images;

    protected CardResponse(Parcel in) {
        name = in.readString();
        type = in.readString();
        desc = in.readString();
        race = in.readString();
        archetype = in.readString();
        formats = in.readString();
    }

    public static final Creator<CardResponse> CREATOR = new Creator<CardResponse>() {
        @Override
        public CardResponse createFromParcel(Parcel in) {
            return new CardResponse(in);
        }

        @Override
        public CardResponse[] newArray(int size) {
            return new CardResponse[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getArchetype() {
        return archetype;
    }

    public void setArchetype(String archetype) {
        this.archetype = archetype;
    }

    public String getFormats() {
        return formats;
    }

    public void setFormats(String formats) {
        this.formats = formats;
    }

    public List<DataImages> getCard_images() {
        return card_images;
    }

    public void setCard_images(List<DataImages> card_images) {
        this.card_images = card_images;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(type);
        dest.writeString(desc);
        dest.writeString(race);
        dest.writeString(archetype);
        dest.writeString(formats);
    }

    public  static class DataImages implements Parcelable{
        @SerializedName("image_url")
        String image;

        protected DataImages(Parcel in) {
            image = in.readString();
        }

        public static final Creator<DataImages> CREATOR = new Creator<DataImages>() {
            @Override
            public DataImages createFromParcel(Parcel in) {
                return new DataImages(in);
            }

            @Override
            public DataImages[] newArray(int size) {
                return new DataImages[size];
            }
        };

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(image);
        }
    }
}
