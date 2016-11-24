package unimagdalena.project.com.foursquare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import unimagdalena.project.com.foursquare.pojos.Categoria;
import unimagdalena.project.com.foursquare.pojos.RecyclerSitiosAdpaters;
import unimagdalena.project.com.foursquare.pojos.SitioAdpater;

public class MainActivity2 extends AppCompatActivity {
    private SitioAdpater adpater;
    private ListView lista;
    private Toolbar toolbar;
    private ImageButton button;
    private ImageButton button2;
    private RecyclerView reci;
    private RecyclerSitiosAdpaters sitiosAdpaters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
       // lista= (ListView) findViewById(R.id.lista_tips);
        reci= (RecyclerView) findViewById(R.id.receyclerSit);
        toolbar= (Toolbar) findViewById(R.id.tool);
        setSupportActionBar(toolbar);
        Bundle bundle=getIntent().getExtras();
        final Categoria item= (Categoria) bundle.get("cat");
        button= (ImageButton) findViewById(R.id.home);
        button2= (ImageButton) findViewById(R.id.mpa);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent irHome=new Intent(getBaseContext(),MainActivity.class);
                startActivity(irHome);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pass=new Intent(getBaseContext(),MainActivity4.class);
                pass.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                pass.putExtra("item",item);
                startActivity(pass);


            }
        });


        if(item!=null){
            adpater=new SitioAdpater(getBaseContext(),item.getSitios());
            sitiosAdpaters=new RecyclerSitiosAdpaters(getBaseContext(),item.getSitios());
            reci.setLayoutManager(new LinearLayoutManager(getBaseContext()));
            reci.setAdapter(sitiosAdpaters);

        }else{
            Toast.makeText(getBaseContext(),"Error al cargar los archivos",Toast.LENGTH_SHORT ).show();
        }
    }
}
