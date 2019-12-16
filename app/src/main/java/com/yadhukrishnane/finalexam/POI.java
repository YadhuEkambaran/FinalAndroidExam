package com.yadhukrishnane.finalexam;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class POI implements Parcelable {

    private String name;
    private int resID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResID() {
        return resID;
    }

    public void setResID(int resID) {
        this.resID = resID;
    }


    public static List<POI> getPOIs(List<POI> pois, int position) {
        pois.clear();
        if (position == 1) {
            POI poi = new POI();
            poi.setName("Niagara falls");
            poi.setResID(R.drawable.niagara_falls);
            pois.add(poi);

            POI poi2 = new POI();
            poi2.setName("CN Tower");
            poi2.setResID(R.drawable.cn_tower);
            pois.add(poi2);

            POI poi3 = new POI();
            poi3.setName("The Butchart Gardens");
            poi3.setResID(R.drawable.butchart_gardens);
            pois.add(poi3);

            POI poi4 = new POI();
            poi4.setName("Notre-Dame Basilica");
            poi4.setResID(R.drawable.basilica);
            pois.add(poi4);
        } else if (position == 2) {
            POI poi = new POI();
            poi.setName("The Statue of Liberty");
            poi.setResID(R.drawable.liberty);
            pois.add(poi);

            POI poi2 = new POI();
            poi2.setName("The White House");
            poi2.setResID(R.drawable.house);
            pois.add(poi2);

            POI poi3 = new POI();
            poi3.setName("Tims Square");
            poi3.setResID(R.drawable.tim);
            pois.add(poi3);
        } else if (position == 3) {

            POI poi = new POI();
            poi.setName("Big Ben");
            poi.setResID(R.drawable.ben);
            pois.add(poi);

            POI poi2 = new POI();
            poi2.setName("Westminster Abbey");
            poi2.setResID(R.drawable.abbey);
            pois.add(poi2);

            POI poi3 = new POI();
            poi3.setName("Hyde Park");
            poi3.setResID(R.drawable.hyde);
            pois.add(poi3);
        }


        return pois;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.resID);
    }

    public POI() {
    }

    protected POI(Parcel in) {
        this.name = in.readString();
        this.resID = in.readInt();
    }

    public static final Parcelable.Creator<POI> CREATOR = new Parcelable.Creator<POI>() {
        @Override
        public POI createFromParcel(Parcel source) {
            return new POI(source);
        }

        @Override
        public POI[] newArray(int size) {
            return new POI[size];
        }
    };
}
