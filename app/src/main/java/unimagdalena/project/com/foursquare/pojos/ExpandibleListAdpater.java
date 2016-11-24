package unimagdalena.project.com.foursquare.pojos;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import unimagdalena.project.com.foursquare.R;

/**
 * Created by Ingenieros on 19/11/2016.
 */

public class ExpandibleListAdpater extends BaseExpandableListAdapter {
    private Context context;
    private ArrayList<Categoria> categorias;


    public ExpandibleListAdpater(Context context, ArrayList<Categoria> categorias) {
        this.context = context;
        this.categorias = categorias;

    }



    @Override
    public int getGroupCount() {
        return categorias.size();
    }

    @Override
    public int getChildrenCount(int i) {
        ArrayList<Sitio>sitios=categorias.get(i).getSitios();
        return sitios.size();
    }

    @Override
    public Object getGroup(int i) {
        return categorias.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        ArrayList<Sitio>sitios=categorias.get(i).getSitios();
        return sitios.get(i);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        Categoria categoria= (Categoria) getGroup(i);
        if (view==null){
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.group,null);
        }
        TextView titulo= (TextView) view.findViewById(R.id.group);
        titulo.setText(categoria.getNombre());
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        Categoria categoria= (Categoria) getChild(i,i1);
        if(view==null){
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.list_group,null);
        }
        ImageView imageView= (ImageView) view.findViewById(R.id.cabecera_image);
        TextView textView= (TextView) view.findViewById(R.id.cabecera_text);
        Picasso.with(context).load(categoria.getSitios().get(i).getFoto()).into(imageView);
        textView.setText(categoria.getSitios().get(i).getNombre());
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
