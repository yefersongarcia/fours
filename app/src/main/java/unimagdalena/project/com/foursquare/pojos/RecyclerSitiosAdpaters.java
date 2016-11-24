package unimagdalena.project.com.foursquare.pojos;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import io.techery.properratingbar.ProperRatingBar;
import unimagdalena.project.com.foursquare.MainActivity3;
import unimagdalena.project.com.foursquare.R;

/**
 * Created by Ingenieros on 23/11/2016.
 */

public class RecyclerSitiosAdpaters extends RecyclerView.Adapter<RecyclerSitiosAdpaters.SitiosViewHolder> {
    private Context contex;
    private ArrayList<Sitio> sitios;
    private LayoutInflater inflater;

    public RecyclerSitiosAdpaters(Context contex, ArrayList<Sitio> sitios) {
        this.contex = contex;
        this.sitios=sitios;
        inflater=LayoutInflater.from(contex);

    }

    @Override
    public SitiosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root=inflater.inflate(R.layout.sitios_vista,parent,false);
        SitiosViewHolder sit= new SitiosViewHolder(root,sitios,contex);
        return sit;
    }

    @Override
    public void onBindViewHolder(SitiosViewHolder holder, int position) {
        Sitio sitio=sitios.get(position);
        Picasso.with(contex).load(sitio.getFoto()).into(holder.imageS);
        holder.texNS.setText(sitio.getNombre());
        holder.textES.setText(sitio.getEspecialidad());
        holder. bar.setRating((int) sitio.getCalificacion().getPuntaje());
        holder.textCS.setText(sitio.getUbicacion().getCiudad());
        holder. textCoS.setText(sitio.getTips().get(0).getComentario());
        holder.textScom.setText(sitio.getTips().get(0).getAutor());


    }

    @Override
    public int getItemCount() {
        return sitios.size();
    }

    public class SitiosViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ArrayList<Sitio>sitios;
        private Context context;
        private ImageView imageS;
        private TextView texNS,textES,textCS,textCoS,textScom;
        private ProperRatingBar bar;

        public SitiosViewHolder(View itemView, ArrayList<Sitio> sitios, Context context) {
            super(itemView);
            this.sitios = sitios;
            this.context = context;
            itemView.setOnClickListener(this);
            imageS= (ImageView) itemView.findViewById(R.id.image_sitio);
            texNS= (TextView) itemView.findViewById(R.id.sitio_nombre);
            textES= (TextView) itemView.findViewById(R.id.text_epcialidad);
            bar= (ProperRatingBar) itemView.findViewById(R.id.poper);
            textCS= (TextView) itemView.findViewById(R.id.text_ciudad);
            textCoS= (TextView) itemView.findViewById(R.id.text_primer_coment);
            textScom= (TextView) itemView.findViewById(R.id.text_comentador);

        }

        @Override
        public void onClick(View view) {
            int i=getAdapterPosition();
            Sitio sitio=sitios.get(i);
            Intent obj=new Intent(this.context, MainActivity3.class);
            obj.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            obj.putExtra("sit",sitio);
            this.context.startActivity(obj);
        }
    }
}
