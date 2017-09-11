package tech.alvarez.climasciudades.models;


import com.google.gson.annotations.SerializedName;

public class Ciudad {

    @SerializedName("name")
    private String nombre;
    private DatosClima main;


    public DatosClima getMain() {
        return main;
    }

    public void setMain(DatosClima main) {
        this.main = main;
    }

    public String getNombre() {
        return nombre;
    }
}
