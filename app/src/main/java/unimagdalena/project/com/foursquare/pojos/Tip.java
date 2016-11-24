package unimagdalena.project.com.foursquare.pojos;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ingenieros on 18/11/2016.
 */
public class Tip implements Parcelable{
    private String autor;
    private String fecha;
    private int visitas;
    private String comentario;
    private int likes;
    private int dislike;
    private String foto;

    public Tip(String autor, String fecha, int visitas, String comentario, int likes, int dislike, String foto) {
        this.autor = autor;
        this.fecha = fecha;
        this.visitas = visitas;
        this.comentario = comentario;
        this.likes = likes;
        this.dislike = dislike;
        this.foto = foto;
    }

    protected Tip(Parcel in) {
        autor = in.readString();
        fecha = in.readString();
        visitas = in.readInt();
        comentario = in.readString();
        likes = in.readInt();
        dislike = in.readInt();
        foto = in.readString();
    }

    public static final Creator<Tip> CREATOR = new Creator<Tip>() {
        @Override
        public Tip createFromParcel(Parcel in) {
            return new Tip(in);
        }

        @Override
        public Tip[] newArray(int size) {
            return new Tip[size];
        }
    };

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getVisitas() {
        return visitas;
    }

    public void setVisitas(int visitas) {
        this.visitas = visitas;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislike() {
        return dislike;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
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
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(autor);
        parcel.writeString(fecha);
        parcel.writeInt(visitas);
        parcel.writeString(comentario);
        parcel.writeInt(likes);
        parcel.writeInt(dislike);
        parcel.writeString(foto);
    }
}
