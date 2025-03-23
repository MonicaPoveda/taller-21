public class Cliente {
    protected String nombre;
    protected String numerocedula;
    protected String numerolicencia;

    public Cliente() {
    }

    public Cliente(String nombre, String numerocedula, String numerolicencia) {
        this.nombre = nombre;
        this.numerocedula = numerocedula;
        this.numerolicencia = numerolicencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumerocedula() {
        return numerocedula;
    }

    public void setNumerocedula(String numerocedula) {
        this.numerocedula = numerocedula;
    }

    public String getNumerolicencia() {
        return numerolicencia;
    }

    public void setNumerolicencia(String numerolicencia) {
        this.numerolicencia = numerolicencia;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", numerocedula='" + numerocedula + '\'' +
                ", numerolicencia='" + numerolicencia + '\'' +
                '}';
    }
    public void mostrarinf(){
        System.out.println("NOMBRE DEL CLIENTE"+nombre);
        System.out.println("NUMERO DE CEDULA DEL CLIENTE"+numerocedula);
        System.out.println("NUMERO DE LICENCIA DEL CLIENTE"+numerolicencia);
    }
}
