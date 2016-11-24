package unimagdalena.project.com.foursquare.pojos;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ingenieros on 18/11/2016.
 */
public class Ubicacion implements Parcelable{
    private float latitud;
    private float longitud;
    private String direccion;
    private String ciudad;

    public Ubicacion(float latitud, float longitud, String direccion, String ciudad) {
        this.latitud = latitud;
        this.longitud = longitud;
        this.direccion = direccion;
        this.ciudad = ciudad;
    }

    protected Ubicacion(Parcel in) {
        latitud = in.readFloat();
        longitud = in.readFloat();
        direccion = in.readString();
        ciudad = in.readString();
    }

    public static final Creator<Ubicacion> CREATOR = new Creator<Ubicacion>() {
        @Override
        public Ubicacion createFromParcel(Parcel in) {
            return new Ubicacion(in);
        }

        @Override
        public Ubicacion[] newArray(int size) {
            return new Ubicacion[size];
        }
    };

    public float getLatitud() {
        return latitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(latitud);
        parcel.writeFloat(longitud);
        parcel.writeString(direccion);
        parcel.writeString(ciudad);
    }
}
