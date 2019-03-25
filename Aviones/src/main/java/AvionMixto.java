import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Duvan
 */
public class AvionMixto extends Avion {
    Scanner sc = new Scanner(System.in);
    private String sillasVip[][];
    private String sillasEconomicas[][];
    int ban = 1;

    /**
     * Constructor de la clase
     */
    public AvionMixto() {
        this.sillasVip = new String[2][3];
        this.sillasEconomicas = new String[6][6];
    }

    /**
     * @return the sillasVip
     */
    public String[][] getSillasVip() {
        return sillasVip;
    }

    /**
     * @param sillasVip the sillasVip to set
     */
    public void setSillasVip(String[][] sillasVip) {
        this.sillasVip = sillasVip;
    }

    /**
     * @return the sillasEconomicas
     */
    public String[][] getSillasEconomicas() {
        return sillasEconomicas;
    }

    /**
     * @param sillasEconomicas the sillasEconomicas to set
     */
    public void setSillasEconomicas(String[][] sillasEconomicas) {
        this.sillasEconomicas = sillasEconomicas;
    }
    
    /**
     * Metodo para imprimir el arreglo de las sillas
     */
    public void imprimirMix(){
        int cont = 0;
        for (String[] sillasVip1 : sillasVip) {
            System.out.println();
            for(String val : sillasVip1){
                System.out.print(val+"\t");
            }
        }
         System.out.println("\n");
    
    
        int cont1 = 0;
        for (String[] sillasEco1 : sillasEconomicas) {
            System.out.println();
            for(String val : sillasEco1){
                System.out.print(val+"\t");
            }
        }
        System.out.println("\n");
    }
    /**
     * Metodo que crea el arreglo de las sillas VIP
     */
    public void crearMix(){
        int cont=0;
        for(int i=0; i<sillasVip.length;i++){
            System.out.println();
            for(int j=0;j<sillasVip[i].length;j++){
                sillasVip[i][j]="V"+cont;
                cont ++;                
            }  
        }
    
    }
    /**
     * Metodo que crea las sillas Estandar
     */
    public void crearEstandar(){
        int cont1 = 0;
        for(int i=0; i<sillasEconomicas.length;i++){
            System.out.println();
            for(int j=0;j<sillasEconomicas[i].length;j++){
                sillasEconomicas[i][j]="E"+cont1;
                cont1 ++;                
            }  
        } 
    }
    /**
     * Metodo que contiene el menu de la clase Avion mixto para poder realizar las opciones disponibles
     */
    public void menuOpcion() {
        int opcion = 0;
        do
        {
            System.out.println("\n\tUsted se encuentra en el avion mixto");
            System.out.println("1. Reservar sillas");
            System.out.println("2. Imprimir Avion(Reservados)");
            System.out.println("3. Despegar Avion..");
            System.out.println("4. Volver.."); 
            System.out.println("5. Salir / Terminar Programa");
            System.out.println("\nIngrese una opcion de las siguientes por favor: ");
            try
            {
                opcion = sc.nextInt();
                switch(opcion)
                {
                    case 1: 
                        if(ban == 1){
                            agregarUsuario();
                        }else{
                            System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                            System.out.println("||| El avion ya despego, no se pueden realizar mas reservas!! ||||||");
                            System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                        }
                    break;
                    case 2:
                        imprimirMix();
                        precio();
                        menuOpcion();
                    break;
                    case 3:
                        ban = limpiarMix(ban);
                        menuOpcion();
                    break;
                    case 4:
                        Logica principal = new Logica();
                        principal.menuPrincipal();
                    break;
                    case 5:
                        System.out.println("Gracias...");
                        System.exit(0);
                    break;
                    default:
                    System.out.println("Opcion no valida...");
                    break;
                }
            }catch(InputMismatchException e)
            {
                System.out.println("Opcion no valida...\nIntentelo de nuevo..\n");
                opcion = 0;
                sc= new Scanner(System.in);
                menuOpcion();
            }
        }while(opcion != 4);         
    }
    /**
     * Metodo que pide los datos de la reserva al usuario
     */
    public void agregarUsuario(){
        try{
        System.out.println("\nDigite su numero de identificacion:  ");
        int identi = sc.nextInt();
        System.out.println("\nDigite su nombre: ");
        String nombre = sc.next();
        boolean alfa = Pattern.matches("^[a-zA-Z]*$",nombre);
        if(!alfa){
            System.out.println("El nombre no puede contener numeros!!");
            agregarUsuario();
        }//if
        System.out.println("\nDigite su fecha de nacimiento: ");
        System.out.println("\nFormato valido(dd-mm-yyyy)");
        String fecha = sc.next();
        Date fech = fecha(fecha);
        imprimirMix();
        System.out.println("\nDigite el codigo de la silla: ");
        String idSilla = sc.next();
        String temp=buscarSillasMixtas(idSilla);
        System.out.println(temp);
        Silla s = new Silla(5000, idSilla);
        Persona p = new Persona(identi, nombre, fech);         
        s.getPersona().add(p);
        silla.add(s);
        }catch(InputMismatchException ex){
            System.out.println("Los datos que ingreso en este campo no son Permitidos");
            sc = new Scanner(System.in);
            agregarUsuario();
        }
    }//agregarUsuario
    
    /**
     * Metodo que busca las sillas para poder realizar las reservas
     * @param valor
     * @return 
     */
    public String buscarSillasMixtas(String valor){
        String mensaje="";
            for (int i=0;i<sillasVip.length;i++){
                for(int j=0;j<sillasVip[i].length;j++){
                    if(sillasVip[i][j].equals(valor)){
                        sillasVip[i][j] = "X";
                        return mensaje = "Silla VIP Reservada Correctamente";
                    }
                    else{
                        mensaje = "La silla Vip que quiere registrar no se encuentra en este avion"
                                + "o Ya se encuentra Reservada";
                    }
                }   
            }    
            for (int i=0;i<sillasEconomicas.length;i++){
                for(int j=0;j<sillasEconomicas[i].length;j++){
                    if(sillasEconomicas[i][j].equals(valor)){
                        sillasEconomicas[i][j] = "X";
                        return mensaje = "Silla Economica Reservada Correctamente";
                    }
                    else{
                        mensaje = "La silla Economica que quiere registrar no se encuentra en este avion"
                                + "o Ya se encuentra Reservada";
                    }
                }   
            }return mensaje;
    }   
     /**
     * Metodo para establecer el formato de la fecha
     * @param fech
     * @return 
     */
    public Date fecha(String fech){
        
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-mm-yyyy");
            Date fecha= null;
            try {
                fecha = formatoDelTexto.parse(fech);
            }catch (ParseException ex) {
                System.out.print("\nFecha incorrecta no lleva el formato valido venta cancelada");                   
            }
            return fecha;
    }
    
    /**
     * Metodo para despegar el avion y sumar las ganancias
     * @param val
     * @return val 
     */
    public int limpiarMix(int val){
        if(val==1){
            System.out.println("||||||||||||||||||||||||||||");
            System.out.println("|||El avion ha despegado!!||");
            System.out.println("||||||||||||||||||||||||||||");
            val=-1;
            return val;
    }
        return val;
    }
    
    /**
     * Metodo para calcular el precio total de las sillas que se vendieron
     */
    public void precio(){
        float preciot =0;
            for (int i=0;i<silla.size();i++){
                
                preciot = preciot + silla.get(i).getPrecio();
            }       
        System.out.println("Las ganancias totales fueron:  "+preciot);
    }
    
}
