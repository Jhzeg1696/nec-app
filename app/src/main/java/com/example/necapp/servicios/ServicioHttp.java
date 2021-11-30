package com.example.necapp.servicios;


import android.os.AsyncTask;
import android.util.Log;

import com.example.necapp.modelos.Evento;
import com.example.necapp.recyclerview_adapters.EventosAdapter;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ServicioHttp extends AsyncTask<String, Integer, String> {

    @Override
    protected String doInBackground(String... params)
    {
        URL url;
        try
        {
            // Creando la conexión
            url = new URL("https://noticias.nld.gob.mx/assets/php/getNoticias.php?limit=20");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            // Especificando el metodo
            con.setRequestMethod("GET");

            // Obteniendo el codigo http de la petición
            int status = con.getResponseCode();

            // Obteniendo la respuesta
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            // Imprimiendo la respuesta
            //Log.d("Respuesta", content.toString());

            // Cerrando el stream y la conexión
            in.close();
            con.disconnect();
            Gson gson = new Gson();
            Evento[] tests = gson.fromJson(content.toString(), Evento[].class);
            List<Evento> eventos = new ArrayList<>();
            for(Evento item : tests)
            {
                System.out.println(item.getTitulo());
                eventos.add(item);
            }
            System.out.println(content.toString());
            EventosAdapter eventosAdapter = new EventosAdapter(eventos);
            eventosAdapter.updateData(eventos);
        }
        catch(Exception exception)
        {
            Log.d("Error: ", exception.getMessage());
        }
        return null;
    }
}
