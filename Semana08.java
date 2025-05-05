/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package semana08;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Andrea
 */
public class Semana08 {

    
    //Variables estáticas, de clase.
    static String nombreTeatro = "TEATRO MORO";
    static Scanner scanner = new Scanner(System.in);

    static ArrayList <Reserva> reservas = new ArrayList<>();
    static ArrayList <Venta> ventas = new ArrayList<>();
    static ArrayList <Cliente> clientes = new ArrayList<>();
    static ArrayList <Venta> ventasAnuladas = new ArrayList<>();

    static int capacidadSala = 50;
    static int totalIngresos = 0; 
    static int contadorAsientosOcupados = 0;
    static int entradasDisponibles = (capacidadSala - contadorAsientosOcupados);
    

     
    public static class Reserva{
        private static int contadorReservas = 0;
        
        private int idReserva;
        private String idCliente;
        private ArrayList<Asiento> asientos;
        private int cantidadEntradas;
        private int totalPagar;
        String codigos = "";
        
        public Reserva(String idCliente, ArrayList<Asiento> asientos, int totalPagar, int cantidadEntradas){
            this.idReserva = ++contadorReservas;
            this.idCliente = idCliente;
            this.asientos = asientos;
            this.totalPagar = totalPagar;
            this.cantidadEntradas = cantidadEntradas;
        }
     
        public int getIdReserva(){
            return idReserva;
        }

        public String getIdCliente(){
            return idCliente;
        }
        
        public ArrayList<Asiento> getAsientos(){
            return asientos;
        }
        
        public int getCantidadEntradas(){
            return cantidadEntradas;
        }
        
        public int getTotalPagar(){
            return totalPagar;
        }
        public void listarReservas(){
            for (Asiento a: asientos){
                codigos += a.getCodigo() + " ";

            }
            System.out.println("||  Num de Reserva: " + idReserva + " || idCliente : " + idCliente + " || Asientos Reservados : "+ codigos +"   ||");
        }
    } //Cierre Reserva
    
    static class Venta{
        //Variables de instancia, no estáticas:
        //recibe cliente, lista de asientos, descuento
        
        static int contadorVentas = 0;
        int idVenta; // id de la Boleta
        String idCliente;
        ArrayList <Asiento> asientos;
        int totalPagar; //valor total a pagar
        int cantidadEntradas; //Cantidad de entradas compradas
        //List<Entrada> entradas; //Una lista de tipo entrada, llamada Entradas que contiene el detalle de cada entrada
        //Entrada entrada;
        
            //Constructor
            public Venta(String idCliente, ArrayList<Asiento> asientos, int totalPagar, int cantidadEntradas){
                this.idVenta = ++contadorVentas;
                this.totalPagar = totalPagar;
                this.cantidadEntradas = cantidadEntradas;
                this.idCliente = idCliente;
                this.asientos = asientos;
                
            } //Cierre constructor Venta
            
        public int getIdVenta(){
            return idVenta;
        }
        
        public String getIdCliente(){
            return idCliente;
        }

        public int getCantidadEntradas(){
            return cantidadEntradas;
        }

        public int getTotalPagar(){
            return totalPagar;
        }
        
        public ArrayList<Asiento> getAsientos(){
            return asientos;
        }
        
        public void listarVentas(){

            System.out.println("||  Num de Venta: " + idVenta + " || Cantidad de Entradas: " + cantidadEntradas + " || Total pagado: " + totalPagar + "   ||");

        }            
            
         
    }//Cierre clase Venta
        
    public static class Cliente {
        String idCliente;
        private String nombre;
        private int edad;
        private String tipoCliente;
        
        public Cliente (String idCliente, String nombre, int edad){
            this.idCliente = idCliente;
            this.nombre = nombre;
            this.edad = edad;
            this.tipoCliente = definirTipoCliente(); //lo obtengo desde función
        }

        private String definirTipoCliente(){
            if(edad < 25) return "Estudiante. 10%";
            if(edad >= 65) return "Tercera Edad. 15%";
            return "Normal, sin dscto.";
        }    
        
        public String getTipoCliente(){
            return tipoCliente;
        }
        
        public String getIdCliente(){
            return idCliente;
        }        

        public String getNombre(){
            return nombre;
        }
        
        public int getEdad(){
            return edad;
        }        
        
        @Override
        public String toString(){
            return nombre + "(" + tipoCliente + ")";
        }
        
        public void listarClientes(){

            System.out.println("||  Rut Cliente: " + idCliente + " || Nombre: " + nombre + " || edad: " + edad + " || Tipo de Dscto que accede: " + tipoCliente);

        } 
        

    } //Cierre clase Cliente

    public static class Asiento {
        private final String tipo;
        private final String codigo;
        private String estado; // L = Libre, R = Reservado, O = Ocupado

        //contador de asientos ocupados
        //private static int contadorAsientosOcupados = 0;
        
        public Asiento(String tipo, String codigo) {
            this.tipo = tipo;
            this.codigo = codigo;
            this.estado = "L";
        }

        public String getTipo() {
            return tipo;
        }

        public String getCodigo() {
            return codigo;
        }
        
        public String getEstado() {
            return estado;
        }
        
        public static int getContadorAsientosOcupados(){
            return contadorAsientosOcupados;
        }
        
         public void reservar() {
            if (estado.equals("L")) {
                estado = "RR";
            }
        }

        public void ocupar() {
            if (estado.equals("RR")) {
                estado = "OO";
                contadorAsientosOcupados++;
            }
        }

        public void liberar() {
            if (estado.equals("RR")) {
                estado = "L";
            }
        }
        
        public void desocupar(){
            if(estado.equals("OO")){
                estado = "L";
                contadorAsientosOcupados--;
            }
        }

        public String mostrar() {
            switch (estado) {
                case "L": return codigo;
                case "RR": return "RR";
                case "OO": return "OO";
                default: return "?";
            }
        }
        
    } //Cierre clase Asiento

    
    
    
    
    public static void mensajeCierreSistema(){
        System.out.println("--------------------------------------------------------------");
        System.out.println("--//////////////////////////////////////////////////////////--");
        System.out.println("||                                                          ||");        
        System.out.println("||      Cerrando el Sistema. Gracias por su compra.         ||");
        System.out.println("||                                                          ||");
        System.out.println("--//////////////////////////////////////////////////////////--");
        System.out.println("--------------------------------------------------------------");
    }//Cierre mensajeCierreSistema

    public static void estadisticasGenerales(){
         
        System.out.println("--------------------------------------");
        System.out.println("--//////////////////////////////////--");
        System.out.println("======= ESTADISTICAS GENERALES =======");
        System.out.println("Capacidad de la Sala: " +capacidadSala + " asientos");
        System.out.println("Asientos disponibles actualmente: " + (capacidadSala - contadorAsientosOcupados));
        System.out.println("Asientos Ocupados: " + contadorAsientosOcupados);
        System.out.println("Total de ventas efectivas: " + ventas.size());
        System.out.println("Total de ventas anuladas: " + ventasAnuladas.size());
        System.out.println("Total de ventas realizadas: " + (ventas.size()+ventasAnuladas.size()));
        System.out.println("Ingresos acumulados: $" + totalIngresos);
        System.out.println("\nPlano con entradas disponibles actualmente: \n");
        System.out.println("=================================");
        System.out.println("--/////////////////////////////--");
        System.out.println("---------------------------------");
    }//Cierre estadisticasGenerales

    public static void anularUltimaVenta(ArrayList<Venta> ventas, ArrayList<Venta> ventasAnuladas){
        if(ventas.isEmpty()){
            System.out.println("\n----------------------------------");
            System.out.println("No hay ventas para anular.");
            return;
        }
        
        //Obtener la última venta
        Venta ultimaVenta = ventas.remove(ventas.size()-1);
        
        //Disminuyo el ingreso
        totalIngresos -= ultimaVenta.getTotalPagar();
        
        //Liberar asientos previamente vendidos, de la venta anulada
        
        for (Asiento asiento: ultimaVenta.getAsientos()){
            asiento.desocupar(); //libera las reservas
            System.out.println("Asiento " + asiento.getCodigo() + " ha sido desocupado");
        }
        
        //Agrego la venta anulada a la lista de anuladas
        ventasAnuladas.add(ultimaVenta);
        
        System.out.println("\n---------------------------------------");
        System.out.println("La venta ha sido anulada\n");
        System.out.println("Presiona ENTER para desplegar el mapa y confirmar la liberación de los asientos");
        scanner.nextLine();//Limpia el buffer
    } //Cierre anularVenta
    
    public static void modificarReserva(Scanner scanner, Reserva reserva){
       int entradasDevueltas;
        
        if(reserva == null || reserva.getAsientos().isEmpty()) {
            System.out.println("No tiene reservas realizadas. Realice una para poder modificarla.");
            return;
        }

        System.out.println("\n------------------------------\n****** MODIFICAR RESERVA ********");
     
        System.out.println("Usted ha reservado " + reserva.getCantidadEntradas() + " entradas.");
       
        do{
            System.out.println("-Cuantas desea devolver?");
            entradasDevueltas = validarInt(scanner);
            scanner.nextLine();// Limpiar buffer

            if(entradasDevueltas>reserva.getCantidadEntradas()){
                System.out.println("No puede devolver mas entradas que las compradas, intente nuevamente");
            } else if (entradasDevueltas <=0){
                System.out.println("Opcion no valida."); 
            }else{
                break;
            }    

        }while(true);
        

        System.out.println("\nUsted reservo los siguientes asientos: " );
        
        for (Asiento a : reserva.getAsientos()){
            System.out.println(" Ubicacion: " + a.getTipo() + " | Asiento: " + a.getCodigo());
        }    
        
        ArrayList<Asiento> asientosDevueltos = new ArrayList<>();

        for (int i = 1; i <= entradasDevueltas; i++){
            System.out.println("Ingrese el codigo del asiento # " + i + " que desea devolver:");
            String codigo = scanner.nextLine().trim().toUpperCase();

            Asiento asientoEncontrado = null;
            
            for(Asiento a : reserva.getAsientos()){
                if(a.getCodigo().equalsIgnoreCase(codigo)){
                    asientoEncontrado = a;
                    break;
                }
            }

            if(asientoEncontrado != null){
                asientosDevueltos.add(asientoEncontrado);
            }else{
                System.out.println("El asiento ingresado no esta en su reserva. Intente nuevamente");
                i--;//repetir intento
            }
        }

        //libera los asientos reservados de la lista donde almacenó los asientos devueltos
        for(Asiento a : asientosDevueltos){
            a.estado="L"; //libera las reservas
        }
            System.out.println("Se ha liberado la reserva del asiento indicado. Revise el mapa para confirmar.");
    //reserva.cantidadEntradas = reserva.getAsientos().size();
reserva.getAsientos().removeAll(asientosDevueltos);

              
    }//Cierre modificarReserva    
    
    public static boolean agregarCliente (ArrayList<Cliente> clientes, Cliente nuevoCliente){
        for (Cliente cliente : clientes){
            if (cliente.getIdCliente().equals(nuevoCliente.getIdCliente())){
            System.out.println("--------------------------------------------------------------");
            System.out.println("--//////////////////////////////////////////////////////////--");
            System.out.println("||                                                          ||");        
            System.out.println("||           CLIENTE YA EXISTE EN LOS REGISTROS             ||");
            System.out.println("||                                                          ||");
            System.out.println("--//////////////////////////////////////////////////////////--");
            System.out.println("--------------------------------------------------------------");
                return false;
            }
        }
        clientes.add(nuevoCliente);
            System.out.println("--------------------------------------------------------------");
            System.out.println("--//////////////////////////////////////////////////////////--");
            System.out.println("||                                                          ||");        
            System.out.println("||           CLIENTE REGISTRADO EXITOSAMENTE                ||");
            System.out.println("||                                                          ||");
            System.out.println("--//////////////////////////////////////////////////////////--");
            System.out.println("--------------------------------------------------------------");
        return true;
    
    }//Cierre agregarCliente
    
    public static void listarVentasAnuladas(){
        
        if(ventasAnuladas.isEmpty()){
            System.out.println("--------------------------------------------------------------");
            System.out.println("--//////////////////////////////////////////////////////////--");
            System.out.println("||                                                          ||");        
            System.out.println("||              Aun no hay ventas anuladas                  ||");
            System.out.println("||                                                          ||");
            System.out.println("--//////////////////////////////////////////////////////////--");
            System.out.println("--------------------------------------------------------------");
        }else{
            System.out.println("");  
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("--//////////////////////////////////////////////////////////////////////--");
            System.out.println("||                                                                      ||");        
            System.out.println("||                     LISTADO DE VENTAS ANULADAS                       ||");
            System.out.println("||                                                                      ||");
                for (Venta ventaAnulada : ventasAnuladas) {
                ventaAnulada.listarVentas();
                }
            System.out.println("||                                                                      ||"); 
            System.out.println("--//////////////////////////////////////////////////////////////////////--");
            System.out.println("--------------------------------------------------------------------------");
        }
    }//Cierre listarVentasAnuladas
    
    public static void listarClientes(){
        
        if(clientes.isEmpty()){
            System.out.println("--------------------------------------------------------------");
            System.out.println("--//////////////////////////////////////////////////////////--");
            System.out.println("||                                                          ||");        
            System.out.println("||           Aun no hay clientes registrados                ||");
            System.out.println("||                                                          ||");
            System.out.println("--//////////////////////////////////////////////////////////--");
            System.out.println("--------------------------------------------------------------");
        }else{
            System.out.println("");  
            System.out.println("---------------------------------------------------------------------------------------------------");
            System.out.println("--///////////////////////////////////////////////////////////////////////////////////////////////--");
            System.out.println("||                                                                                               ||");        
            System.out.println("||                                 LISTA DE CLIENTES REGISTRADOS                                 ||");
            System.out.println("||                                                                                               ||");
                for (Cliente cliente : clientes) {
                cliente.listarClientes();
                }
            System.out.println("||                                                                                               ||"); 
            System.out.println("--///////////////////////////////////////////////////////////////////////////////////////////////--");
            System.out.println("---------------------------------------------------------------------------------------------------");
        }
    }//Cierre listarClientes

    public static void listarReservas(){
        
        if(reservas.isEmpty()){
            System.out.println("--------------------------------------------------------------");
            System.out.println("--//////////////////////////////////////////////////////////--");
            System.out.println("||                                                          ||");        
            System.out.println("||             Aun no hay reservas realizadas               ||");
            System.out.println("||                                                          ||");
            System.out.println("--//////////////////////////////////////////////////////////--");
            System.out.println("--------------------------------------------------------------");
        }else{
            System.out.println("");  
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("--////////////////////////////////////////////////////////////////////////////////////--");
            System.out.println("||                                                                                    ||");        
            System.out.println("||                         HISTORICO DE RESERVAS REALIZADAS                           ||");
            System.out.println("||                                                                                    ||");
                for (Reserva reserva : reservas) {
                reserva.listarReservas();
                }
            System.out.println("||                                                                                    ||"); 
            System.out.println("--////////////////////////////////////////////////////////////////////////////////////--");
            System.out.println("----------------------------------------------------------------------------------------");
        }
    }//Cierre listarReservas    
    
    public static void listarVentas(){
        
        if(ventas.isEmpty()){
            System.out.println("--------------------------------------------------------------");
            System.out.println("--//////////////////////////////////////////////////////////--");
            System.out.println("||                                                          ||");        
            System.out.println("||             Aun no hay ventas realizadas                 ||");
            System.out.println("||                                                          ||");
            System.out.println("--//////////////////////////////////////////////////////////--");
            System.out.println("--------------------------------------------------------------");
        }else{
            System.out.println("");  
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("--//////////////////////////////////////////////////////////////////////--");
            System.out.println("||                                                                      ||");        
            System.out.println("||                     LISTADO DE VENTAS REALIZADAS                     ||");
            System.out.println("||                                                                      ||");
                for (Venta venta : ventas) {
                venta.listarVentas();
                }
            System.out.println("||                                                                      ||"); 
            System.out.println("--//////////////////////////////////////////////////////////////////////--");
            System.out.println("--------------------------------------------------------------------------");
        }
    }//Cierre listarVentas    
    
    public static void eliminarReserva(Reserva reserva, Scanner scanner){
        ArrayList<Asiento> reservados = reserva.getAsientos();
        
        System.out.println("\n-Desea eliminar la reserva vigente? (s/n) :");
        String confirmacion = scanner.nextLine().toLowerCase();
   
        if(confirmacion.equalsIgnoreCase("s")){
            for(Asiento a : reservados){
                a.estado="L"; //libera las reservas
            }
            System.out.println("-----------------------------------------");
            System.out.println("Reserva Eliminada. Asientos Liberados.");
           //¿ nuevaReserva.. clean? dejo null su información ?
            
        }else if (confirmacion.equalsIgnoreCase("n")){
           System.out.println("-----------------------------------------");
            System.out.println("Los asientos continuan reservados. \nElija una opcion del menu principal para seguir.");
             
        } else {
            //No hacemos nada, quedan reservados. 
            //salimos del metodo y volvemos al menu principal
            System.out.println("-----------------------------------------");
            System.out.println("Opcion no valida. Los asientos quedan reservados temporalmente. \nElija una opcion del menu principal para seguir.");
        }
        
    }//Cierre eliminarReserva
    
    public static void mostrarResumenReserva (String nombreCliente, int cantidadEntradas, String ubicacionEntrada, double totalPagar, double precioBase, double valorUnitario, String tipoDescuento){
        //Resumen de la compra
        System.out.println(" ");
        System.out.println("-----------------------------------------------");
        System.out.println("--///////////////////////////////////////////--");
        System.out.println("||                                           ||");        
        System.out.println("||            RESUMEN DE LA RESERVA           ||");
        System.out.println("||                                           ||");
        System.out.println("|| A nombre de : " + nombreCliente+ "                      ||");
        System.out.println("|| Cantidad de entradas compradas: " + cantidadEntradas + "         ||" );

        System.out.println("|| Ubicacion de las entradas: " + ubicacionEntrada +"            ||");
        //System.out.println("Descuento aplicado: " + tipoEntrada);
        System.out.println("|| Precio final a pagar: " + totalPagar+"             ||");
        System.out.println("||*******************************************||"); 
        System.out.println("|| Valor unitario sin descuento: " + precioBase+"     ||");
        System.out.println("|| Valor unitario con descuento: " + valorUnitario+"     ||");
        System.out.println("|| Tipo de descuento aplicado  : " + tipoDescuento +"     ||");
        System.out.println("||                                           ||");
        System.out.println("||                                           ||");
        System.out.println("--///////////////////////////////////////////--");
        System.out.println("-----------------------------------------------");


    }//Cierre mostrarResumenReserva
        
    public static int calcularValorEntradas(Scanner scanner, int precioBase, double descuento, int cantidadEntradas){
      
        int totalPagar;
        int precio_descuento_edad;
        int precio_descuento_grupal;
        
        if(descuento == 0){
           precio_descuento_edad = precioBase*cantidadEntradas;
        } else{
           precio_descuento_edad = (int) ((precioBase*descuento)*cantidadEntradas);  
        }
        
         if(4 == cantidadEntradas){

                        //descuento = precioBase/2;
                        precio_descuento_grupal = ((precioBase * 3) + (precioBase/2));
                        //tipoEntrada = "4ta al 50%";

            } else{
                precio_descuento_grupal = precio_descuento_edad ;  
            }
         
        //Seleccionar el menor precio
        //Compara el precio del descuento de edad con el descuento grupal
        //Se aplica el descuento mayor, se cobra el menor valor a pagar
        
            if(precio_descuento_grupal < precio_descuento_edad){
             totalPagar = precio_descuento_grupal;
             //tipoDescuento = "Grupal";
            } else {
                totalPagar = precio_descuento_edad;

            }
            
            
        return totalPagar;
        
    }//Cierre calcularValorEntradas
    
    public static int precioSegunUbicacion(String ubicacionElegida){
            
        int precioBase = 0;
            
            //Uso switch para asignar el precio Base de cada entrada según la ubicación elegida.
            switch (ubicacionElegida){
                case "vip":
                    precioBase = 25000;
                        System.out.println("");  
                        System.out.println("-----------------------------------------------");
                        System.out.println("--///////////////////////////////////////////--");
                        System.out.println(" ");        
                        System.out.println("El valor de las entradas VIP es de $" + precioBase+ " cada una.");
                        System.out.println(" ");        
                        System.out.println("--///////////////////////////////////////////--");
                        System.out.println("-----------------------------------------------");
            
                    break;
                case "palco":
                    precioBase = 18000;
                        System.out.println("");  
                        System.out.println("-----------------------------------------------");
                        System.out.println("--///////////////////////////////////////////--");
                        System.out.println(" ");        
                        System.out.println("El valor de las entradas PALCO es de $" + precioBase + " cada una.");
                        System.out.println(" ");        
                        System.out.println("--///////////////////////////////////////////--");
                        System.out.println("-----------------------------------------------");
                    break;
                case "platea baja":
                    precioBase = 15000;
                        System.out.println("");  
                        System.out.println("-----------------------------------------------");
                        System.out.println("--///////////////////////////////////////////--");
                        System.out.println(" ");        
                        System.out.println("El valor de las entradas PLATEA BAJA es de $" + precioBase + " cada una.");
                        System.out.println(" ");        
                        System.out.println("--///////////////////////////////////////////--");
                        System.out.println("-----------------------------------------------");
                    break;
                case "platea alta":
                    precioBase = 12500;
                        System.out.println("");  
                        System.out.println("-----------------------------------------------");
                        System.out.println("--///////////////////////////////////////////--");
                        System.out.println(" ");        
                        System.out.println("El valor de las entradas PLATEA ALTA es de $" + precioBase + " cada una.");
                        System.out.println(" ");        
                        System.out.println("--///////////////////////////////////////////--");
                        System.out.println("-----------------------------------------------");
                    break;
                case "galeria":
                    precioBase = 10000;
                        System.out.println("");  
                        System.out.println("-----------------------------------------------");
                        System.out.println("--///////////////////////////////////////////--");
                        System.out.println(" ");        
                        System.out.println("El valor de las entradas GALERIA es de $" + precioBase+ " cada una.");
                        System.out.println(" ");        
                        System.out.println("--///////////////////////////////////////////--");
                        System.out.println("-----------------------------------------------");
                    break;
            }
        
        return precioBase;
        
    }//Cierre precioSegunUbicacion
        
    public static String[] validarDescuento(Scanner scanner, int edad){
        String[] descuentoInfo = new String[2];
       
        //Validación de edad y..
            //Aplicar descuento 10% para estudiantes, 
            //15 % para personas de la tercera edad, mayores de 60 años. El cálculo sería precioBase * 0.85 corresponde al 15%
        //precioBase * 0.9 corresponde  al 10% de descuento para estudiantes 

        
                if(edad>60){
                System.out.println("------------------------------------");
                System.out.println("Aplica descuento del 15%, para tercera edad.");
                descuentoInfo[0] = "0.85";
                descuentoInfo[1] = "Tercera Edad. 15%";
                //totalPagar = (int) (precioBase * descuento)*cantidadEntradas;
                
                } else if (edad<23){
                     System.out.println("------------------------------------");
                    System.out.println("Aplica descuento del 10%, para estudiantes.");
                    descuentoInfo[0] = "0.9";
                    descuentoInfo[1] = "Estudiante. 10%";
                
                } else {
                        System.out.println("------------------------------------");
                        System.out.println("No aplica descuentos, tarifa normal.");
                        descuentoInfo[0] = "0";
                        descuentoInfo[1] = "Sin Descuento. Valor Normal de la entrada";
                        
                }
                

            return descuentoInfo; //retorno el array con la informacion

    }//Cierre de validarDescuento   
    
    public static int solicitarEdad(Scanner scanner){
        int edad;
        System.out.println("\n--------------------------------------------------------------");
        System.out.println("Ahora ingrese su edad para validar aplicacion de descuentos:");
        edad = validarInt(scanner);
        return edad;
    }//Cierre solicitarEdad
    
    public static void confirmarCompra(Reserva reserva, Scanner scanner){
        ArrayList<Asiento> reservados = reserva.getAsientos();
        
        System.out.println("\n-Desea confirmar la compra y ocupar estos asientos? (s/n) :");
        String confirmacion = scanner.nextLine().toLowerCase();
   
        if(confirmacion.equalsIgnoreCase("s")){
            for(Asiento a: reservados){
                a.ocupar();
            }

            Venta nuevaVenta = new Venta(reserva.getIdCliente(), reservados, reserva.getTotalPagar(), reserva.getCantidadEntradas());
            ventas.add(nuevaVenta);
            
            //Sumo el total de ingresos, estadistica global
            totalIngresos += reserva.getTotalPagar();
            
            System.out.println("----------------------------------------");
            System.out.println("\nCompra confirmada. \nVenta Registrada. \nAsientos Ocupados.");
            System.out.println("");
            
        }else if (confirmacion.equalsIgnoreCase("n")){
            for(Asiento a : reservados){
                a.estado="L"; //libera las reservas
            }
            System.out.println("-----------------------------------------");
            System.out.println("Compra cancelada. Asientos Liberados.");
        } else {
            //No hacemos nada, quedan reservados. 
            //salimos del metodo y volvemos al menu principal
            System.out.println("-----------------------------------------");
            System.out.println("Opcion no valida. Los asientos quedan reservados temporalmente. \nElija una opcion del menu principal para seguir.");
        }
        
    }//Cierre confirmarCompra
    
    public static Asiento buscarAsiento(Asiento[][] mapa, String codigo){
        for(int i= 0; i<mapa.length;i++){
            for(int j=0; j<mapa[i].length; j++){
                if(mapa[i][j].getCodigo().equalsIgnoreCase(codigo)){
                    return mapa[i][j];
                }
            }
        }
        return null;
    } //Cierre buscarAsiento
    
    public static int solicitarCantidadEntradas(Scanner scanner){
    int cantidad =0;    
    if(entradasDisponibles <=0){

        System.out.println("\n*****************************************");
        System.out.println("No hay entradas disponibles para la venta");
        System.out.println("*****************************************");
        return 0;
    }
        
    do{
        
        System.out.println("\n---------------------------------");
        System.out.println("-Cuantas entradas desea comprar?");
            cantidad = validarInt(scanner);
            scanner.nextLine(); //Limpia el buffer
            
            if(cantidad > entradasDisponibles){
                System.out.println("Hay solo " + entradasDisponibles + " entradas disponibles.");
                System.out.println("10 maximo por ubicacion. \nRevise el mapa para confirmar las entradas disponibles.");

            }   
            if(cantidad <=0){
                System.out.println("No valido. Ingrese un numero de entradas valido.");
            }
            
    }while(cantidad<=0 || cantidad > entradasDisponibles);
            

        return cantidad;
    }//Cierre solicitarCantidadEntradas    
    
    public static String solicitarUbicacion(Scanner scanner){
     
        String ubicacionElegida;

        // Manejo de error con ciclo do-while para validar la entrada
        do {
            System.out.println("\n---------------------------------");
            System.out.println("-En que tipo de ubicacion desea comprar? (VIP, Palco, Platea Baja, Platea Alta, Galeria): ");
            ubicacionElegida = scanner.nextLine().trim().toLowerCase();
            //System.out.println("ubicacion elegida input: " + ubicacionElegida); //comprobacion de input
            // Validar que la ubicación sea una opción válida
            if (!ubicacionElegida.equals("vip") && 
                !ubicacionElegida.equals("palco") && 
                !ubicacionElegida.equals("platea baja") && 
                !ubicacionElegida.equals("platea alta") && 
                !ubicacionElegida.equals("galeria")) {
                System.out.println("Ubicacion no valida, por favor ingrese VIP, Palco, Platea Baja, Platea Alta, Galeria.");
            }

        } while (!ubicacionElegida.equals("vip") && 
                 !ubicacionElegida.equals("palco") && 
                !ubicacionElegida.equals("platea baja") && 
                !ubicacionElegida.equals("platea alta") && 
                 !ubicacionElegida.equals("galeria"));

       return ubicacionElegida;
    } //Cierre solicitarUbicacion
    
    public static Reserva reservarEntradas(Asiento[][] mapa, String[] tipos, Scanner scanner){
        
        mostrarMapa(mapa, tipos);
        int cantidadEntradas = solicitarCantidadEntradas(scanner);
        
        
        if(cantidadEntradas == 0 ){
             System.out.println("\n*****************************************");
            System.out.println(" Volviendo al Menu Principal...");
            System.out.println("*****************************************");
            return null;
            
        }

        String ubicacionElegida = solicitarUbicacion(scanner);

        
        ArrayList<Asiento> asientosReservados = new ArrayList<>();
        
        for(int contador = 0; contador < cantidadEntradas; contador ++){
            System.out.println("\nA continuacion seleccionara el asiento de la entrada " + (contador+1) + " : ");
            System.out.println("Ingrese el numero del asiento (ejemplo: A1) :");
            String codigoAsiento = scanner.nextLine().trim().toUpperCase();
        
            Asiento asiento = buscarAsiento(mapa, codigoAsiento);
            
            if(asiento != null && asiento.getTipo().equalsIgnoreCase(ubicacionElegida)){
                if(asiento.getEstado().equals("L")){
                    asiento.reservar();
                    asientosReservados.add(asiento);
                }else{
                    System.out.println("El asiento " + codigoAsiento + " no esta disponible.");
                    contador --;
                }
            } else{
                System.out.println("El asiento no existe o no pertenece a la ubicacion seleccionada.");
                contador --;
            }
        }
        
        System.out.println("\n-----------------------------------------------");
        System.out.println("Usted ha reservado los siguientes asientos:");
        
        for(Asiento a : asientosReservados){
            System.out.println(a.getCodigo()+" ");
        }
        
        System.out.println("\n");
        
        mostrarMapa(mapa, tipos);
        
        //hasta aquí llega el proceso de reserva propiamente tal.
        
        //Solicitar edad para hacer calculos y validar descuento
        int edad = solicitarEdad(scanner);
        int precioBase = precioSegunUbicacion(ubicacionElegida);
        String[] descuentoInfo = validarDescuento(scanner, edad);
        double descuento = Double.parseDouble(descuentoInfo[0]);
        String tipoDescuento = descuentoInfo[1];    
        if(cantidadEntradas == 4){
            tipoDescuento = "Grupal";
        }
        
        int totalPagar = calcularValorEntradas (scanner, precioBase, descuento, cantidadEntradas);

        //Cálculo del valor individual de cada entrada en la compra:   
        int valorUnitario = totalPagar/cantidadEntradas;        
        
        System.out.println("\nFinalmente ingrese su nombre:");
        String nombreCliente = scanner.next().trim().toLowerCase();
  
        System.out.println("\ne ingrese su rut sin puntos ni digito verificador (ejemplo: 171766877) :");
        String idCliente = scanner.next().trim().toLowerCase(); 
        scanner.nextLine(); //Limpia el buffer, con esta línea al incorporar el if antes del while, el programa se detiene hasta que el usuario presione Enter

        
        mostrarResumenReserva(nombreCliente, cantidadEntradas, ubicacionElegida, totalPagar, precioBase, valorUnitario, tipoDescuento);

        //Crear reservar y agregarla a la lista.
        Reserva nuevaReserva = new Reserva(idCliente, asientosReservados, totalPagar, cantidadEntradas);
        reservas.add(nuevaReserva);

        //Crear cliente y agregarlo a la lista
        Cliente nuevoCliente = new Cliente(nombreCliente, idCliente, edad);
        agregarCliente(clientes, nuevoCliente);
        
        System.out.println("\n-------------------------------------------");
        System.out.println("Su reserva ha sido creada con exito. El ID de su reserva es: " + nuevaReserva.getIdReserva());
        System.out.println("Para confirmar la compra, modificar o eliminar su reserva \nlo enviaremos de vuelta al menu principal");
        
        return nuevaReserva;

        // --------------------------------------------------------------------------
        // Aqui da la opcion de compra desde dentro de la reserva sin salir del menú: 
        //confirmarCompra(asientosReservados, scanner); //llamar confirmacion de compra
        
        //System.out.println("\nMapa actualizado: ");
        //mostrarMapa(mapa, tipos);
        
        //deberia retornar una reserva.
        
    }//Cierre reservarEntradas
    
   static void tituloAnulacionVenta(){
            System.out.println("-----------------------------------------------");
            System.out.println("--///////////////////////////////////////////--");
            System.out.println("||                                           ||");        
            System.out.println("||            ANULACION DE VENTA             ||");
            System.out.println("||                                           ||");
            System.out.println("--///////////////////////////////////////////--");
            System.out.println("-----------------------------------------------");
    }  
    
    static void tituloModificarReservas(){
            System.out.println("-----------------------------------------------");
            System.out.println("--///////////////////////////////////////////--");
            System.out.println("||                                           ||");        
            System.out.println("||            MODIFICAR RESERVA              ||");
            System.out.println("||                                           ||");
            System.out.println("--///////////////////////////////////////////--");
            System.out.println("-----------------------------------------------");
    }    
    
    static void tituloEliminarReservas(){
            System.out.println("-----------------------------------------------");
            System.out.println("--///////////////////////////////////////////--");
            System.out.println("||                                           ||");        
            System.out.println("||             ELIMINAR RESERVAS             ||");
            System.out.println("||                                           ||");
            System.out.println("--///////////////////////////////////////////--");
            System.out.println("-----------------------------------------------");
    }    
    
    static void tituloCompras(){
            System.out.println("-----------------------------------------------");
            System.out.println("--///////////////////////////////////////////--");
            System.out.println("||                                           ||");        
            System.out.println("||             COMPRA DE ENTRADAS            ||");
            System.out.println("||                                           ||");
            System.out.println("--///////////////////////////////////////////--");
            System.out.println("-----------------------------------------------");
    }
    
    static void tituloReservas(){
            System.out.println("-----------------------------------------------");
            System.out.println("--///////////////////////////////////////////--");
            System.out.println("||                                           ||");        
            System.out.println("||            RESERVA DE ENTRADAS            ||");
            System.out.println("||                                           ||");
            System.out.println("--///////////////////////////////////////////--");
            System.out.println("-----------------------------------------------");
    }
    
    static void mostrarMapa(Asiento[][] mapa, String[] tipos){
        
        System.out.println("-----------------------------------------------");
        System.out.println("--///////////////////////////////////////////--");
        System.out.println("||                                           ||");        
        System.out.println("||                 ESCENARIO                 ||");
        System.out.println("||                                           ||");
  
        for (int i = 0; i < mapa.length; i++) {
                //System.out.print(tipos[i] + ": ");
                for (int j = 0; j < mapa[i].length; j++) {
                    System.out.print(mapa[i][j].mostrar());
                    if (j < mapa[i].length - 1) System.out.print(", ");

                }
              System.out.println(" ------ "+tipos[i] );  
              //  System.out.println();
        }   
        
        System.out.println("||                                           ||");
        System.out.println("--///////////////////////////////////////////--");
        System.out.println("-----------------------------------------------");
        
    } //Cierre de mostrarMapa    
    
    public static Asiento[][] crearMapa(String[] tipos){
        int filas = tipos.length;
        int columnas = 10;
        char[] letras = {'A', 'B', 'C', 'D', 'E'};
        Asiento [][] mapa = new Asiento [filas][columnas];
        
// Creamos el mapa: Llenamos el mapa con tipos y códigos
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                //String tipo = tipos[i];
                //System.out.print(tipos[i] + "Tipo :------");
                String codigo = letras[i] + String.valueOf(j + 1);
                //System.out.print(codigo + " codigo:------");
                mapa[i][j] = new Asiento(tipos[i], codigo);
            }
        }
        return mapa;

    }
          
    static void mostrarPromociones(){
        System.out.println("\n******PROMOCIONES DISPONIBLES********");
        System.out.println(" -> Estudiantes: 10% de descuento");
        System.out.println(" -> Tercera Edad: 15% de descuento");
        System.out.println(" -> Grupal: Si compras 4 entradas la 4ta al 50%");
        System.out.println(" *** Descuentos NO ACUMULATIVOS ***");
        System.out.println(" ***********************************");
    }    
    
    public static int validarInt(Scanner scanner){
        int opcionBusqueda =-1;
        while(true){
            if(scanner.hasNextInt()){
                opcionBusqueda = scanner.nextInt();
                break;
            }else{
                System.out.println("Opcion no valida. Ingrese un numero, por favor.");
                scanner.next(); //Evita bucle y limpia la entrada
            }
        }
        return opcionBusqueda;
    }    //Cierre validarInt    
    
    static void mostrarMenu(){
        System.out.println("\n**************** " + nombreTeatro +  " ****************");
        System.out.println("**************** Bienvenido  ****************");
        System.out.println("");
        System.out.println("1.Ver promociones y descuentos activos");
        System.out.println("2.Ver Mapa de asientos");
        System.out.println("3.Reserva de Entradas");
        System.out.println("4.Modificar Reservar");
        System.out.println("5.Cancelar Reserva");
        System.out.println("6.Comprar Entradas");
        System.out.println("7.Anular Compra"); //liberar asiento
        System.out.println("");
        System.out.println("----------DATOS DE SISTEMA----------");
        System.out.println("8.Estadisticas Generales");  //Entradas vendidas , ingresos totales
        System.out.println("9.Lista de Clientes Registrados");
        System.out.println("10.Historico de Reservas Realizadas");
        System.out.println("11.Historico de Ventas Realizadas");  
        System.out.println("12.Historico de Ventas Anuladas");        

        System.out.println("");
        System.out.println("13.Salir del Sistema");
        System.out.println("");
        System.out.println("Ingrese numero de la opcion que desea ejecutar:");            
        // Modificar datos de cliente
        // Ver lista de clientes registrados

    }      
    
    public static void main(String[] args) {
        
//        Scanner scanner = new Scanner(System.in);

        int opcion;
        String[] tipos = {"VIP", "Palco", "Platea Baja", "Platea Alta", "Galeria"};
        Asiento[][] mapa = crearMapa(tipos); 
        Reserva reserva = null; 


        do{ //ciclo principal que genera iteración del menú
            mostrarMenu();  
            opcion = validarInt(scanner);
            scanner.nextLine(); //Limpia el buffer, con esta línea al incorporar el if antes del while, el programa se detiene hasta que el usuario presione Enter
   
            switch(opcion){
                case 1:
                    mostrarPromociones();
                    break;
                case 2:
                    mostrarMapa(mapa, tipos);
                    break;
                case 3:
                    tituloReservas();
                    reserva = reservarEntradas(mapa, tipos, scanner);
                    break;
                case 4:
                    tituloModificarReservas();
                    if (reserva != null){
                    modificarReserva(scanner, reserva);
                    mostrarMapa(mapa, tipos);
                    }else{
                        System.out.println("\n-----------------------------------------------------");
                        System.out.println("Para modificar una reserva, realice una reserva primero.");
                    }
                    break;
                case 5:
                    tituloEliminarReservas();
                    if (reserva != null){
                        eliminarReserva(reserva, scanner);
                        mostrarMapa(mapa, tipos);
                    }else{
                        System.out.println("\n-----------------------------------------------------");
                        System.out.println("Para eliminar una reserva, realice una primero.");
                    }
                    break;
                case 6:
                    //Comprar la entrada
                    tituloCompras();
                    if (reserva != null){
                       confirmarCompra(reserva, scanner);
                        mostrarMapa(mapa, tipos);
                    }else{
                        System.out.println("\n-----------------------------------------------------");
                        System.out.println("Para realizar/confirmar una compra, realice una reserva primero.");
                    }
                    
                    break;


                    
                case 7:
                    tituloAnulacionVenta();
                    if(ventas.isEmpty()){
                       System.out.println("\n----------------------------------");
                        System.out.println("No hay ventas para anular.");
                    }else{
                        anularUltimaVenta(ventas, ventasAnuladas);
                        mostrarMapa(mapa, tipos);
                    }
        
                    break;
                case 8:
                    
                    estadisticasGenerales();
                    mostrarMapa(mapa, tipos);
                    break;
                case 9:
                    listarClientes();
                    break;
                case 10:
                    listarReservas();
                    break;
                case 11:
                    listarVentas();
                    break;
                case 12:
                    listarVentasAnuladas();
                    break;
                case 13:
                    mensajeCierreSistema();
                    break;
                default:
                    System.out.println("Opcion no valida intente nuevamente");
            }
            
            if (opcion != 13) {
                System.out.println("\n Presiona Enter para volver al menu...");
                scanner.nextLine(); //Esperar Enter del usuario
            }            
            
            
        } while( 13 != opcion);
    
        scanner.close();        
        
        
    }//Cierre del public static void main
    
    
    
}//Cierre public class Semana08
