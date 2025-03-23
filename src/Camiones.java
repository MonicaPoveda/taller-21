public class Camiones extends Vehiculo{
    private String capacidadcarga;

    public Camiones(String marca, String modelo, String anio, double preciodia, String disponibilidad, String capacidadcarga) {
        super(marca, modelo, anio, preciodia, disponibilidad);
        this.capacidadcarga = capacidadcarga;
    }

    public String getCapacidadcarga() {
        return capacidadcarga;
    }

    public void setCapacidadcarga(String capacidadcarga) {
        this.capacidadcarga = capacidadcarga;
    }

    @Override
    public String toString() {
        return "Camiones{" +
                "capacidadcarga='" + capacidadcarga + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anio='" + anio + '\'' +
                ", preciodia=" + preciodia +
                ", disponibilidad=" + disponibilidad +
                '}';
    }
    @Override
    public void mostrarinf(){
        super.mostrarinf();
        System.out.println("CAPACIDAD DE CARGA"+capacidadcarga);

    }
}
