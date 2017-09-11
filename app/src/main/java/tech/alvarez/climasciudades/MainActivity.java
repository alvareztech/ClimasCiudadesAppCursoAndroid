package tech.alvarez.climasciudades;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tech.alvarez.climasciudades.models.Ciudad;
import tech.alvarez.climasciudades.models.ClimaCiudadesRespuesta;
import tech.alvarez.climasciudades.service.OpenWeatherMapService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onStart() {
        super.onStart();

        OpenWeatherMapService service = ServiceGenerator.createService(OpenWeatherMapService.class);

        Call<ClimaCiudadesRespuesta> call = service.obtenerClimaCiudades("3911925,3919968,3904906", "5ea80a3a5da74b767f1e1bd67efdadb8");
        call.enqueue(new Callback<ClimaCiudadesRespuesta>() {
            @Override
            public void onResponse(Call<ClimaCiudadesRespuesta> call, Response<ClimaCiudadesRespuesta> response) {

                ClimaCiudadesRespuesta respuesta = response.body();

                ArrayList<Ciudad> ciudades = respuesta.getList();

                for (int i = 0; i < ciudades.size(); i++) {
                    Ciudad c = ciudades.get(i);

                    Log.i("MIAPP", "Temp: " + c.getMain().getTemp());
                    Log.i("MIAPP", "Humedad: " + c.getMain().getHumidity());
                    Log.i("MIAPP", "Ciudad: " + c.getNombre());

                }
            }

            @Override
            public void onFailure(Call<ClimaCiudadesRespuesta> call, Throwable t) {

            }
        });
    }
}
