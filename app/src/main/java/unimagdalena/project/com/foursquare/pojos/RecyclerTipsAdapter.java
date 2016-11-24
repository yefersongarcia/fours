package unimagdalena.project.com.foursquare.pojos;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import unimagdalena.project.com.foursquare.R;

/**
 * Created by Ingenieros on 23/11/2016.
 */

public class RecyclerTipsAdapter extends RecyclerView.Adapter<RecyclerTipsAdapter.TipsViewHolder> {
    private Context context;
    private ArrayList<Tip>tips;
    private LayoutInflater inflater;

    public RecyclerTipsAdapter(Context context, ArrayList<Tip> tips) {
        this.context = context;
        this.tips = tips;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public TipsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root=inflater.inflate(R.layout.tips_vista,parent,false);
        TipsViewHolder holder= new TipsViewHolder(root,tips,context);

        return holder;
    }

    @Override
    public void onBindViewHolder(TipsViewHolder holder, int position) {
        Tip tip=tips.get(position);
        Picasso.with(context).load(tip.getFoto()).into(holder.imageCome);
        holder.textNombre.setText(tip.getAutor()+".");
        holder.textComen.setText(tip.getComentario());

    }

    @Override
    public int getItemCount() {
        return tips.size();
    }

    public class TipsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ArrayList<Tip>tips;
        private Context context;
        private ImageView imageCome;
        private TextView textNombre;
        private TextView textComen;

        public TipsViewHolder(View itemView, ArrayList<Tip> tips, Context context) {
            super(itemView);
            this.tips = tips;
            this.context = context;
            itemView.setOnClickListener(this);
            imageCome= (ImageView) itemView.findViewById(R.id.image_coment);
            textNombre=(TextView)itemView.findViewById(R.id.text_tips_nombre);
            textComen= (TextView) itemView.findViewById(R.id.text_tips_com);
        }


        @Override
        public void onClick(View view) {


        }
    }
}

