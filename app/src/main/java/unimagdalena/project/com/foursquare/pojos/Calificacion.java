package unimagdalena.project.com.foursquare.pojos;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ingenieros on 18/11/2016.
 */
public class Calificacion implements Parcelable {
    private float puntaje;
    private int toltal;

    public Calificacion(float puntaje, int toltal) {
        this.puntaje = puntaje;
        this.toltal = toltal;
    }

    protected Calificacion(Parcel in) {
        puntaje = in.readFloat();
        toltal = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(puntaje);
        dest.writeInt(toltal);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Calificacion> CREATOR = new Creator<Calificacion>() {
        @Override
        public Calificacion createFromParcel(Parcel in) {
            return new Calificacion(in);
        }

        @Override
        public Calificacion[] newArray(int size) {
            return new Calificacion[size];
        }
    };

    public float getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(float puntaje) {
        this.puntaje = puntaje;
    }

    public int getToltal() {
        return toltal;
    }

    public void setToltal(int toltal) {
        this.toltal = toltal;
    }
}
