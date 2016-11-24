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

import unimagdalena.project.com.foursquare.R;

/**
 * Created by Ingenieros on 19/11/2016.
 */

public class TipsAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Tip>tips;

    public TipsAdapter(Context context, ArrayList<Tip> tips) {
        this.context = context;
        this.tips = tips;
    }

    @Override
    public int getCount() {
        return tips.size();
    }

    @Override
    public Object getItem(int i) {
        return tips.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Tip tip= (Tip) getItem(i);
        view=inflater.inflate(R.layout.tips_vista,viewGroup,false);
        ImageView imageCome= (ImageView) view.findViewById(R.id.image_coment);
        TextView textNombre=(TextView)view.findViewById(R.id.text_tips_nombre);
        TextView textComen= (TextView) view.findViewById(R.id.text_tips_com);
        Picasso.with(context).load(tip.getFoto()).into(imageCome);
        textNombre.setText(tip.getAutor()+".");
        textComen.setText(tip.getComentario());

        return view;
    }
}
