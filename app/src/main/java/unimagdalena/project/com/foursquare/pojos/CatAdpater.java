package unimagdalena.project.com.foursquare.pojos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import unimagdalena.project.com.foursquare.R;

/**
 * Created by Ingenieros on 14/11/2016.
 */

public class CatAdpater extends BaseAdapter {
    private Context context;
    private final List<Categoria> categorias;

    public CatAdpater(Context context, List<Categoria> categorias) {
        this.context = context;
        this.categorias = categorias;
    }

    @Override
    public int getCount() {
        return categorias.size();
    }

    @Override
    public Object getItem(int i) {
        return categorias.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ImageView imageCat;
        TextView texCat;
        Categoria cat= (Categoria) getItem(i);
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view=inflater.inflate(R.layout.vista_cat,viewGroup,false);

        imageCat= (ImageView) view.findViewById(R.id.imagen_cat);

        Picasso.with(context).load(cat.getIcono()).into(imageCat);

        texCat= (TextView) view.findViewById(R.id.text_cat);
        texCat.setText(cat.getNombre());


        return view;
    }
}
