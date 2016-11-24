package unimagdalena.project.com.foursquare.pojos;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ingenieros on 18/11/2016.
 */

public class GsonCategoriaParser {
    public List<Categoria>leerFlujoJson(InputStream in)throws IOException{
        Gson gson=new Gson();
        JsonReader reader=new JsonReader(new InputStreamReader(in,"UTF-8"));
        List<Categoria>categorias=new ArrayList<>();
        Categoria categoria=null;
        reader.beginArray();
        while(reader.hasNext()){
            categoria=gson.fromJson(reader,Categoria.class);
            categorias.add(categoria);
        }
        reader.endArray();
        reader.close();
        return categorias;
    }
}
