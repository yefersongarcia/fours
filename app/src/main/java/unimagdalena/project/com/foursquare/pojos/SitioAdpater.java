package unimagdalena.project.com.foursquare.pojos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import io.techery.properratingbar.ProperRatingBar;
import unimagdalena.project.com.foursquare.R;

/**
 * Created by Ingenieros on 19/11/2016.
 */

public class SitioAdpater extends BaseAdapter {
    private Context context;
    private ArrayList<Sitio> sitios;

    public SitioAdpater(Context context, ArrayList<Sitio> sitios) {
        this.context = context;
        this.sitios = sitios;
    }

    @Override
    public int getCount() {
        return sitios.size();
    }

    @Override
    public Object getItem(int i) {
        return sitios.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageS;
        TextView texNS,textES,textCS,textCoS,textScom;
        ProperRatingBar bar;
        Sitio sitio;
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view=inflater.inflate(R.layout.sitios_vista,viewGroup,false);
        sitio= (Sitio) getItem(i);
        imageS= (ImageView) view.findViewById(R.id.image_sitio);
        texNS= (TextView) view.findViewById(R.id.sitio_nombre);
        textES= (TextView) view.findViewById(R.id.text_epcialidad);
        bar= (ProperRatingBar) view.findViewById(R.id.poper);
        textCS= (TextView) view.findViewById(R.id.text_ciudad);
        textCoS= (TextView) view.findViewById(R.id.text_primer_coment);
        textScom= (TextView) view.findViewById(R.id.text_comentador);
        Picasso.with(context).load(sitio.getFoto()).into(imageS);
        texNS.setText(sitio.getNombre());
        textES.setText(sitio.getEspecialidad());
        bar.setRating((int) sitio.getCalificacion().getPuntaje());
        textCS.setText(sitio.getUbicacion().getCiudad());
        textCoS.setText(sitio.getTips().get(0).getComentario());
        textScom.setText(sitio.getTips().get(0).getAutor());


        return view;
    }
}
