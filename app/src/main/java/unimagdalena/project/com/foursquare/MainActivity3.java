package unimagdalena.project.com.foursquare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import unimagdalena.project.com.foursquare.pojos.RecyclerTipsAdapter;
import unimagdalena.project.com.foursquare.pojos.Sitio;
import unimagdalena.project.com.foursquare.pojos.TipsAdapter;

public class MainActivity3 extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView listComen;
    private TipsAdapter adapter;
    private ImageView imageSitio;
    private TextView textSnom;
    private TextView textSD;
    private TextView textSCa;
    private TextView textSE;
    private TextView textCalific;
    private ImageButton button1;
    private ImageButton button2;
    private RecyclerView recyclerView;
    private RecyclerTipsAdapter tipsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        button1= (ImageButton) findViewById(R.id.home);
        button2= (ImageButton) findViewById(R.id.lista);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent irHome=new Intent(getBaseContext(),MainActivity.class);
                startActivity(irHome);
            }
        });

        recyclerView= (RecyclerView) findViewById(R.id.receyclerTips);
        Bundle bundle =getIntent().getExtras();
        Sitio sitio= (Sitio) bundle.get("sit");
        textSnom= (TextView) findViewById(R.id.text_nomS);
        textSD= (TextView) findViewById(R.id.text_direccion_s);
        textCalific= (TextView) findViewById(R.id.textS_cal);
        textSCa= (TextView) findViewById(R.id.text_s_e);
        imageSitio= (ImageView) findViewById(R.id.image_comen);
        textSE= (TextView) findViewById(R.id.text_estado);
        textSnom.setText(sitio.getNombre());
        textSD.setText(sitio.getUbicacion().getDireccion());
        textSCa.setText(sitio.getEspecialidad());
        textSE.setText(sitio.getEstado());
        Picasso.with(getBaseContext()).load(sitio.getFoto()).into(imageSitio);
        textCalific.setText(Float.toString(sitio.getCalificacion().getPuntaje()) );

        if(sitio!=null){
            tipsAdapter=new RecyclerTipsAdapter(getBaseContext(),sitio.getTips());
            Toast.makeText(getBaseContext(),"Error",Toast.LENGTH_SHORT).show();
            recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
            recyclerView.setAdapter(tipsAdapter);
        }else{
            Toast.makeText(getBaseContext(),"Error al pasar el objeto",Toast.LENGTH_SHORT).show();
        }


    }
}
