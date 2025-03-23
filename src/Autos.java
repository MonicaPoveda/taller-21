public class Autos extends Vehiculo{
    private String numeropuertas;

    public Autos(String marca, String modelo, String anio, double preciodia, String disponibilidad, String numeropuertas) {
        super(marca, modelo, anio, preciodia, disponibilidad);
        this.numeropuertas = numeropuertas;
    }

    public String getNumeropuertas() {
        return numeropuertas;
    }

    public void setNumeropuertas(String numeropuertas) {
        this.numeropuertas = numeropuertas;
    }

    @Override
    public String toString() {
        return "Autos{" +
                "numeropuertas='" + numeropuertas + '\'' +
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
        System.out.println("NUMERO DE PUERTAS"+numeropuertas);

    }

}
