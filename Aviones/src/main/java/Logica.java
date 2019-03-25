import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Duvan
 */
public class Logica {
    Scanner sc = new Scanner(System.in);
    AvionVip vip = new AvionVip();
    AvionNormal econo = new AvionNormal();
    AvionMixto mix = new AvionMixto();
    public Logica() {
        vip.crearVip();
        mix.crearMix();
        mix.crearEstandar();
        econo.crearEconomico();
        menuPrincipal();
    }
    public void menuPrincipal() 
    {
        int opcion = 0;
        do
        {
            System.out.println("\t\tBienvenido");
            System.out.println("1. Ver Avion Mixto..");
            System.out.println("2. Ver Avion Clase Economica..");
            System.out.println("3. Ver Avion clase Vip");
            System.out.println("4. Salir.");   
            System.out.println("\nIngrese una opcion de las siguientes por favor: ");
            try
            {
                opcion = sc.nextInt();
                switch(opcion)
                {
                    case 1:
                        
                        mix.menuOpcion();
                    break;
                    case 2:
                        
                        econo.menuEconomico();
                    break;
                    case 3:
                        
                        vip.menuVip();
                    break;
                    case 4:
                        System.out.println("Gracias...por su visita");
                        System.exit(0);
                    break;
                    default:
                    System.out.println("Opcion no valida...");
                    break;
                }
            }catch(InputMismatchException e){
                System.out.println("Opcion no valida...\nIntentelo de nuevo..\n");
                opcion = 0;
                sc= new Scanner(System.in);
                menuPrincipal();
            }
        }while(opcion != 4);         
    }
}
