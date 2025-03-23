import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        boolean estado = true;
        List<Vehiculo> lsveh = new ArrayList<>();
        List<Cliente> lscl = new ArrayList<>();
        int diasalquilado = 0;

        do {
            System.out.println(
                    """
                              ++++++++++++++++++BIENVENIDO A TU ALQUILER DE AUTOS+++++++++++++++++
                             1. REGISTRAR VEHICULOS NUEVOS  
                             2. REGISTAR CLIENTES NUEVOS 
                             3. REALIZAR UN ALQUILER
                             4. CALCULAR EL COSTO DE ALQUILER DEL AUTO
                             5. MOSTRAR LISTA DE VEHICULOS DISPONIBLES
                             6. REGISTRAR LA DEVOLUCION DE UN VEHICULO
                             7. SALIR
                             +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                            """);
            int opmenu = teclado.nextInt();
            switch (opmenu) {
                case 1 -> {
                    boolean opcvalida = true;
                    do {


                        System.out.println("****REGISTRAR VEHICULOS NUEVOS******");
                        System.out.println("""
                                ¿QUE TIPO DE VEHICULO QUIERE REGISTRAR?
                                1. AUTO
                                2. CAMION
                                """);
                        int opcr = teclado.nextInt();
                        switch (opcr) {
                            case 1 -> {
                                System.out.println("REGISTRO DE VEHICULO TIPO: AUTO");
                                System.out.println("INGRESE LA MARCA DEL AUTOMOVIL");
                                String marca = teclado.next();
                                System.out.println("INGRESE El MODELO DEL AUTOMOVIL");
                                String modelo = teclado.next();
                                System.out.println("INGRESE EL AÑO DEL AUTOMOVIL");
                                String anio = teclado.next();
                                System.out.println("INGRESE EL PRECIO POR DIA PARA EL AUTOMOVIL");
                                double preciodia = teclado.nextDouble();
                                System.out.println("INGRESE EL NUMERO DE PUERTAS QUE TIENE SU AUTOMOVIL");
                                String numpuertas = teclado.next();


                                lsveh.add(new Autos(marca, modelo, anio, preciodia, "AUTO DISPONIBLE", numpuertas));
                                System.out.println("*****AUTO REGISTRADO EXITOSAMENTE****");
                                opcvalida = false;
                            }
                            case 2 -> {
                                System.out.println("REGISTRO DE VEHICULO TIPO : CAMION");
                                System.out.println("INGRESE LA MARCA DEL CAMION");
                                String marca = teclado.next();
                                System.out.println("INGRESE El MODELO DEL CAMION");
                                String modelo = teclado.next();
                                System.out.println("INGRESE EL AÑO DEL CAMION");
                                String anio = teclado.next();
                                System.out.println("INGRESE EL PRECIO POR DIA PARA EL CAMION");
                                double preciodia = teclado.nextDouble();
                                System.out.println("INGRESE LA CAPACIDAD DE CARGA DEL CAMION");
                                String capcarga = teclado.next();


                                lsveh.add(new Camiones(marca, modelo, anio, preciodia, "CAMION DISPONIBLE", capcarga));
                                System.out.println("*****CAMION REGISTRADO EXITOSAMENTE*****");
                                opcvalida = false;
                            }
                            default -> {
                                System.out.println("------OPCION NO VALIDA------");
                                opcvalida = true;
                            }
                        }
                    } while (opcvalida);

                }
                case 2 -> {
                    System.out.println("REGISTRO DE CLIENTES NUEVOS");
                    System.out.println("INGRESE SU NOMBRE");
                    String nombre = teclado.next();
                    System.out.println("INGRESE SU NUMERO DE CEDULA");
                    String ncedula = teclado.next();
                    System.out.println("INGRESE SU NUMERO DE LICENCIA");
                    String nlicencia = teclado.next();

                    lscl.add(new Cliente(nombre, ncedula, nlicencia));
                    System.out.println("*******CLIENTE REGISTRADO******");
                }
                case 3 -> {
                    System.out.println("*****REALIZAR UN ALQUILER****");
                    boolean clencontrado = false;
                    do {

                        System.out.println("***INGRESE EL NOMBRE DEL CLIENTE***");

                        String ncliente = teclado.next();

                        for (Cliente c : lscl) {
                            if (c.getNombre().equalsIgnoreCase(ncliente)) {
                                System.out.println(c);
                                System.out.println("***USUARIO SE ENCUENTRA REGISTRADO****");
                                clencontrado = true;
                                break;
                            }
                        }
                        if (!clencontrado) {
                            System.out.println("---USUARIO NO ESTA REGISTRADO-----");
                            System.out.println("REGISTRESE EN LA OPC 2");
                            System.out.println();

                            break;
                        }
                    } while (!clencontrado);
                    if (clencontrado) {
                        System.out.println("***PROCESO DE ALQUILER CONTINUA...***");
                        System.out.println("""
                                QUE VEHICULO QUIERE ALQUILAR
                                1. AUTO
                                2. CAMION
                                """);
                        int opalq = teclado.nextInt();
                        switch (opalq) {
                            case 1 -> {
                                System.out.println("*** ALQUILAR AUTOMOVIL ***");
                                boolean hayAutosDisponibles = false;
                                for (Vehiculo lsv : lsveh) {
                                    if (lsv instanceof Autos && lsv.getDisponibilidad().equalsIgnoreCase("AUTO DISPONIBLE")) {
                                        hayAutosDisponibles = true;
                                        break;
                                    }
                                }

                                if (!hayAutosDisponibles) {
                                    System.out.println("---- NO HAY AUTOS DISPONIBLES ----");
                                    break;
                                }
                                System.out.println("** AUTOS DISPONIBLES ** ");
                                for (Vehiculo lsv : lsveh) {
                                    if (lsv instanceof Autos && lsv.getDisponibilidad().equalsIgnoreCase("AUTO DISPONIBLE")) {
                                        System.out.println(lsv);
                                    }
                                }
                                System.out.println("**** INGRESE LA MARCA DEL AUTO A ALQUILAR ******");
                                String mauto = teclado.next();

                                boolean marcaencontrada = false;

                                for (Vehiculo cu : lsveh) {
                                    if (cu instanceof Autos && cu.getMarca().equalsIgnoreCase(mauto)) {
                                        marcaencontrada = true;
                                        if (cu.getDisponibilidad().equalsIgnoreCase("AUTO NO DISPONIBLE")) {
                                            System.out.println("AUTO NO DISPONIBLE");

                                        } else {
                                            System.out.println("INGRESE LOS DIAS QUE DESEA ALQUILAR EL AUTO");
                                            int diasalq = teclado.nextInt();

                                            cu.setDisponibilidad("--- ESTADO ACTUAL: AUTO NO DISPONIBLE ---");

                                            System.out.println("*** HA ALQUILADO EL AUTO CORRECTAMENTE : " + mauto + " POR : " + diasalq + " DIAS");
                                            System.out.println(cu);
                                            marcaencontrada = true;


                                        }
                                        break;
                                    }
                                }

                                if (!marcaencontrada) {
                                    System.out.println("La marca ingresada no corresponde a ningún auto disponible.");
                                }

                            }
                            case 2 -> {
                                System.out.println("*** ALQUILAR CAMION ***");

                                boolean haycamionesdisponibles = false;
                                for (Vehiculo lsv : lsveh) {
                                    if (lsv instanceof Camiones && lsv.getDisponibilidad().equalsIgnoreCase("CAMION DISPONIBLE")) {
                                        haycamionesdisponibles = true;
                                        break;
                                    }
                                }
                                if (!haycamionesdisponibles) {
                                    System.out.println("---- NO HAY CAMIONES DISPONIBLES ----");
                                    break;
                                }

                                System.out.println("** CAMIONES DISPONIBLES ** ");
                                for (Vehiculo lsv : lsveh) {
                                    if (lsv instanceof Camiones && lsv.getDisponibilidad().equalsIgnoreCase("CAMION DISPONIBLE")) {
                                        System.out.println(lsv);
                                    }
                                }
                                System.out.println("**** INGRESE LA MARCA DEL CAMION A ALQUILAR ******");
                                String mcamion = teclado.next();

                                boolean marcaencontrada = false;

                                for (Vehiculo cu : lsveh) {
                                    if (cu instanceof Camiones && cu.getMarca().equalsIgnoreCase(mcamion)) {
                                        marcaencontrada = true;
                                        if (cu.getDisponibilidad().equalsIgnoreCase("CAMION NO DISPONIBLE")) {
                                            System.out.println("CAMION NO DISPONIBLE");

                                        } else {
                                            System.out.println("INGRESE LOS DIAS QUE DESEA ALQUILAR EL CAMION");
                                            int diasalq = teclado.nextInt();

                                            cu.setDisponibilidad("--- ESTADO ACTUAL: CAMION NO DISPONIBLE ---");

                                            System.out.println("*** HA ALQUILADO EL AUTO CORRECTAMENTE : " + mcamion + " POR : " + diasalq + " DIAS");
                                            System.out.println(cu);
                                            marcaencontrada = true;
                                        }
                                        break;
                                    }
                                }
                                if (!marcaencontrada) {
                                    System.out.println("La marca ingresada no corresponde a ningún camion disponible.");
                                }
                            }
                        }

                    }
                }
                case 4 -> {
                    System.out.println("**** CALCULAR EL COSTO DE ALQUILER DEL VEHICULO *****");
                    System.out.println("""
                            DE QUE VEHICULO QUIERE CALCULAR SU COSTO DE ALQUILER
                            1. AUTO
                            2. CAMION
                            """);
                    int opct = teclado.nextInt();

                    switch (opct) {
                        case 1 -> {
                            System.out.println("** CALCULAR COSTO DE ALQUILER DEL AUTO");
                            System.out.println("INGRESE LA MARCA DEL AUTO");
                            String mauto = teclado.next();
                            boolean marcaencontrada = false;

                            for (Vehiculo v : lsveh) {
                                if (v instanceof Autos && v.getMarca().equalsIgnoreCase(mauto) && v.getDisponibilidad().equalsIgnoreCase("--- ESTADO ACTUAL: AUTO NO DISPONIBLE ---")) {
                                    marcaencontrada = true;

                                    System.out.println("INGRESE LA CANTIDAD DE DIAS ALQUILADOS");
                                    int dalqu = teclado.nextInt();
                                    double totalcosto = v.getPreciodia() * dalqu;

                                    if (dalqu >= 7) {
                                        totalcosto *= 0.9;
                                        System.out.println("POR ALQUILAR EL AUTO POR MAS DE 7 DIAS SE LE HA APLICADO UN DESCUENTO DEL 10%");
                                    }
                                    System.out.println("EL COSTO TOTAL DE SU ALQUILER DEL AUTO ES DE: " + totalcosto);
                                    break;
                                }
                            }
                            if(!marcaencontrada){
                                System.out.println("MARCA NO ENCONTRADA/ NO SE ENCUENTRA ALQUILADO");
                            }
                        }
                        case 2 -> {
                            System.out.println("** CALCULAR EL COSTO DE ALQUILER DEL CAMION");
                            System.out.println("INGRESE LA MARCA DEL CAMION");
                            String mcamion = teclado.next();
                            boolean marcaencontrada = false;

                            for (Vehiculo v : lsveh) {
                                if (v instanceof Camiones && v.getMarca().equalsIgnoreCase(mcamion) && v.getDisponibilidad().equalsIgnoreCase("--- ESTADO ACTUAL: CAMION NO DISPONIBLE ---")) {
                                    marcaencontrada = true;

                                    System.out.println("INGRESE LA CANTIDAD DE DIAS ALQUILADOS");
                                    int dalqu = teclado.nextInt();
                                    double totalcosto = v.getPreciodia() * dalqu;

                                    if (dalqu >= 7) {
                                        totalcosto *= 0.9;
                                        System.out.println("POR ALQUILAR EL CAMION POR MAS DE 7 DIAS SE LE HA APLICADO UN DESCUENTO DEL 10%");
                                    }
                                    System.out.println("EL COSTO TOTAL DE SU ALQUILER DEL CAMION ES DE: " + totalcosto);
                                    break;
                                }
                            }
                            if (!marcaencontrada){
                                System.out.println("NO SE ENCONTRO LA MARCA DEL CAMION O NO SE ENCUENTRA ALQUIILADO");
                            }

                        }
                    }
                    break;
                }
                case 5 -> {
                    System.out.println("****MOSTRAR LISTA DE VEHICULOS DISPONIBLES*****");
                    System.out.println("** AUTOS DISPONIBLES **");
                    boolean hayDisponibles=false;
                    for (Vehiculo lsv : lsveh) {
                        if (lsv instanceof Autos && lsv.getDisponibilidad().equalsIgnoreCase("AUTO DISPONIBLE")) {
                            System.out.println(lsv);
                            hayDisponibles = true;
                        }
                    }
                    System.out.println("** CAMIONES DISPONIBLES **");
                    for (Vehiculo lsv : lsveh) {
                        if (lsv instanceof Camiones && lsv.getDisponibilidad().equalsIgnoreCase("CAMION DISPONIBLE")) {
                            System.out.println(lsv);
                            hayDisponibles = true;
                        }
                    }

                    if (!hayDisponibles) {
                        System.out.println("NO HAY VEHÍCULOS DISPONIBLES EN ESTE MOMENTO");
                    }
                }
                case 6 -> {

                    System.out.println("****REGISTRAR LA DEVOLUCION DE UN VEHICULO*****");
                    System.out.println("¿QUE TIPO DE VEHICULO VA A DEVOLVERR?");
                    System.out.println("""
                            ************
                            
                            1. AUTO
                            2. CAMION
                            
                            *************
                            """);
                    int tipodev = teclado.nextInt();

                    if (tipodev == 1) {
                        System.out.println("INGRESE LA MARCA DEL AUTO A DEVOLVER:");
                        String mauto = teclado.next();
                        boolean encontrado = false;
                        for (Vehiculo v : lsveh) {
                            if (v instanceof Autos && v.getMarca().equalsIgnoreCase(mauto) && v.getDisponibilidad().contains("NO DISPONIBLE")) {
                                v.setDisponibilidad("AUTO DISPONIBLE");
                                System.out.println("**** AUTO DEVUELTO EXITOSAMENTE Y DISPONIBLE PARA OTRO CLIENTE ****" );
                                encontrado = true;
                                break;
                            }
                        }
                        if (!encontrado) {
                            System.out.println("-----NO SE ENCONTRO EL AUTO O NO HA SIDO ALQUILADO------");
                        }
                    } else if (tipodev == 2) {
                        System.out.println("**** INGRESE LA MARCA DEL CAMION A DEVOLVER:    ");
                        String mcamion = teclado.next();
                        boolean encontrado = false;
                        for (Vehiculo v : lsveh) {
                            if (v instanceof Camiones && v.getMarca().equalsIgnoreCase(mcamion) && v.getDisponibilidad().contains("NO DISPONIBLE")) {
                                v.setDisponibilidad("CAMION DISPONIBLE");
                                System.out.println("-------CAMION DEVUELTO EXITOSAMENTE Y DISPONIBLE PARA OTRO CLIENTE---------");
                                encontrado = true;
                                break;
                            }
                        }
                        if (!encontrado) {
                            System.out.println("No se encontró el camión o no está registrado como alquilado.");
                        }
                    } else {
                        System.out.println("OPCIÓN NO VÁLIDA");
                    }

                }case 7 -> {
                    System.out.println("""
                            GRACIAS POR USAR NUESTRO SISTEMA
                            
                            VUELVE PRONTO......
                            """);
                    estado=false;
                }
                default -> System.out.println("OPCION NO VALIDA");

            }

        } while (estado);
    }
}





