package tech.alvarez.climasciudades.service;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import tech.alvarez.climasciudades.models.ClimaCiudadesRespuesta;

public interface OpenWeatherMapService {

    // http://api.openweathermap.org/data/2.5/group?id=3911925,3919968&&appid=API_KEY


    @GET("group?units=metric")
    Call<ClimaCiudadesRespuesta> obtenerClimaCiudades(@Query("id") String id, @Query("appid") String appid);

}
