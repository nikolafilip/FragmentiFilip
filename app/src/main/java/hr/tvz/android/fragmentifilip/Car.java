package hr.tvz.android.fragmentifilip;

import android.os.Parcel;
import android.os.Parcelable;

public class Car implements Parcelable {

    public Car(String name, String image, String url) {
        this.name = name;
        this.image = image;
        this.url = url;
    }

    public String name;
    public String image;
    public String url;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.image);
        dest.writeString(this.url);
    }

    protected Car(Parcel in) {
        this.name = in.readString();
        this.image = in.readString();
        this.url = in.readString();
    }

    public static final Creator<Car> CREATOR = new Creator<Car>() {
        @Override
        public Car createFromParcel(Parcel source) {
            return new Car(source);
        }

        @Override
        public Car[] newArray(int size) {
            return new Car[size];
        }
    };

}
