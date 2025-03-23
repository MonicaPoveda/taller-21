public abstract class Vehiculo {
    protected String marca;
    protected String modelo;
    protected String anio;
    protected double preciodia;
    protected String disponibilidad;

    public Vehiculo() {
    }

    public Vehiculo(String marca, String modelo, String anio, double preciodia, String disponibilidad) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.preciodia = preciodia;
        this.disponibilidad = disponibilidad;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public double getPreciodia() {
        return preciodia;
    }

    public void setPreciodia(double preciodia) {
        this.preciodia = preciodia;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anio='" + anio + '\'' +
                ", preciodia=" + preciodia +
                ", disponibilidad=" + disponibilidad +
                '}';
    }

    public void mostrarinf() {
        System.out.println("MARCA DEL VEHICULO: " + marca);
        System.out.println("MODELO DEL VEHICULO: " + modelo);
        System.out.println("AÑO DEL VEHICULO: " + anio);
        System.out.println("DISPONIBILIDAD DEL VEHICULO: " + disponibilidad);
    }
}
