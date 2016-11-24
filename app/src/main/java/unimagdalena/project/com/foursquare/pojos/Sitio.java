package unimagdalena.project.com.foursquare.pojos;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Ingenieros on 18/11/2016.
 */
public class Sitio implements Parcelable {
    private String nombre;
    private String especialidad;
    private int valoracion;
    private String descripcion;
    private Calificacion calificacion;
    private Ubicacion ubicacion;
    private String propetario;
    private String telefono;
    private String estado;
    private ArrayList<Tip> tips;
    private String foto;

    public Sitio(String nombre, String especialidad, int valoracion, String descripcion, Calificacion calificacion, Ubicacion ubicacion, String propetario, String telefono, String estado, ArrayList<Tip> tips, String foto) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.valoracion = valoracion;
        this.descripcion = descripcion;
        this.calificacion = calificacion;
        this.ubicacion = ubicacion;
        this.propetario = propetario;
        this.telefono = telefono;
        this.estado = estado;
        this.tips = tips;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Calificacion getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Calificacion calificacion) {
        this.calificacion = calificacion;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getPropetario() {
        return propetario;
    }

    public void setPropetario(String propetario) {
        this.propetario = propetario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ArrayList<Tip> getTips() {
        return tips;
    }

    public void setTips(ArrayList<Tip> tips) {
        this.tips = tips;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nombre);
        dest.writeString(this.especialidad);
        dest.writeInt(this.valoracion);
        dest.writeString(this.descripcion);
        dest.writeParcelable(this.calificacion, flags);
        dest.writeParcelable(this.ubicacion, flags);
        dest.writeString(this.propetario);
        dest.writeString(this.telefono);
        dest.writeString(this.estado);
        dest.writeTypedList(this.tips);
        dest.writeString(this.foto);
    }

    protected Sitio(Parcel in) {
        this.nombre = in.readString();
        this.especialidad = in.readString();
        this.valoracion = in.readInt();
        this.descripcion = in.readString();
        this.calificacion = in.readParcelable(Calificacion.class.getClassLoader());
        this.ubicacion = in.readParcelable(Ubicacion.class.getClassLoader());
        this.propetario = in.readString();
        this.telefono = in.readString();
        this.estado = in.readString();
        this.tips = in.createTypedArrayList(Tip.CREATOR);
        this.foto = in.readString();
    }

    public static final Creator<Sitio> CREATOR = new Creator<Sitio>() {
        @Override
        public Sitio createFromParcel(Parcel source) {
            return new Sitio(source);
        }

        @Override
        public Sitio[] newArray(int size) {
            return new Sitio[size];
        }
    };
}
