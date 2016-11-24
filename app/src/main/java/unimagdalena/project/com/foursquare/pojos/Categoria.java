package unimagdalena.project.com.foursquare.pojos;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Ingenieros on 18/11/2016.
 */

public class Categoria  implements Parcelable{
    private String nombre;
    private ArrayList<Sitio>sitios;
    private String icono;
    private ArrayList<Categoria>categorias;

    public Categoria(String nombre, ArrayList<Sitio> sitios, String icono) {
        this.nombre = nombre;
        this.sitios = sitios;
        this.icono = icono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Sitio> getSitios() {
        return sitios;
    }

    public void setSitios(ArrayList<Sitio> sitios) {
        this.sitios = sitios;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nombre);
        dest.writeTypedList(this.sitios);
        dest.writeString(this.icono);
        dest.writeTypedList(this.categorias);
    }

    protected Categoria(Parcel in) {
        this.nombre = in.readString();
        this.sitios = in.createTypedArrayList(Sitio.CREATOR);
        this.icono = in.readString();
        this.categorias = in.createTypedArrayList(Categoria.CREATOR);
    }

    public static final Creator<Categoria> CREATOR = new Creator<Categoria>() {
        @Override
        public Categoria createFromParcel(Parcel source) {
            return new Categoria(source);
        }

        @Override
        public Categoria[] newArray(int size) {
            return new Categoria[size];
        }
    };
}
