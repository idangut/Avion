
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author gtior
 */
public class AvionNormal extends Avion{
    Scanner sc = new Scanner(System.in);
    private String asientosEconomicos[][];
    int ban = 1;

    public AvionNormal() {
        this.asientosEconomicos = new String[3][5];
    }

    /**
     * @return the asientosEconomicos
     */
    public String[][] getAsientosEconomicos() {
        return asientosEconomicos;
    }

    /**
     * @param asientosEconomicos the asientosEconomicos to set
     */
    public void setAsientosEconomicos(String[][] asientosEconomicos) {
        this.asientosEconomicos = asientosEconomicos;
    }
    /**
     * Metodo que imprime el arreglo del avion economico
     */
    public void imprimirEconomico(){
        int cont=0;
        for(String [] dat : asientosEconomicos){
            System.out.println();
            for(String val : dat){
                System.out.print(val+"\t");
            }            
        }
        System.out.println("\n");
       
    }
    /**
     * Metodo que crea el arreglo de las sillas del avion economico
     */
    public void crearEconomico(){
        int cont=0;
        for(int i=0; i<asientosEconomicos.length;i++){
            System.out.println();
            for(int j=0;j<asientosEconomicos[i].length;j++){
                asientosEconomicos[i][j]="E"+cont;
                cont ++;                
            }  
        }       
    }
    
    /**
     * Metodo que contiene el menu del avion Economico
     */
    public void menuEconomico(){
        int opcion = 0;
        do
        {
            System.out.println("\n\tUsted se encuentra en el avion Economico");
            System.out.println("1. Reservar asiento..");
            System.out.println("2. Despegar avion..");
            System.out.println("3. Imprimir Reservados");
            System.out.println("4. Volver...");
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
                        ban = limpiarEconomico(ban);
                        menuEconomico();
                    break;
                    case 3:
                        imprimirEconomico();
                        precio();
                        menuEconomico();
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
                menuEconomico();
            }
        }while(opcion != 5);         
    }
    /**
     * Metodo para pedir los datos de la reserva
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
        imprimirEconomico();
        System.out.println("\nDigite el codigo de la silla: ");
        String idSilla = sc.next();
        String temp=buscarSillas(idSilla);
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
    }
    
    /**
     * Metodo para generar la reserva
     * @param valor
     * @return 
     */
    public String buscarSillas(String valor){
       String mensaje="";
            for (int i=0;i<asientosEconomicos.length;i++){
                for(int j=0;j<asientosEconomicos[i].length;j++){
                    if(asientosEconomicos[i][j].equals(valor)){
                        asientosEconomicos[i][j] = "X";
                        return mensaje = "Silla Economica Reservada Correctamente";
                    }else{
                        mensaje = "La silla Economica que quiere registrar no se encuentra en este avion"
                                + "o Ya se encuentra Reservada";
                    }               
                }   
            }       
       return mensaje;
    }    
    /**
     * Metodo para establecer el formato de la fecha
     * @param fech
     * @return fecha
     */
    public Date fecha(String fech){
        
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-mm-yyyy");
            Date fecha= null;
            try {
                fecha = formatoDelTexto.parse(fech);
            }catch (ParseException ex) {
                System.out.print("\nFecha incorrecta no lleva el formato valido venta cancelada");   
                agregarUsuario();
            }
            return fecha;
    }
    
    /**
     * Metodo para despegar el avion
     * @param val
     * @return val
     */
    public int limpiarEconomico(int val){
        if(val  == 1){
            System.out.println("||||||||||||||||||||||||||||");
            System.out.println("|||El avion ha despegado!!||");
            System.out.println("||||||||||||||||||||||||||||");
            val=-1;
            return val;
        }
        return val;
    }
    
    /**
     * Metodo para calcular el precio total de las ventas
     */
    public void precio(){
        float preciot =0;
            for (int i=0;i<silla.size();i++){
                
                preciot = preciot + silla.get(i).getPrecio();
            }       
        System.out.println("Las ganancias totales fueron:  "+preciot);
    }
}
