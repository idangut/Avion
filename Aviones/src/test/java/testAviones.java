/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gtior
 */
public class testAviones {
    
    /**
     * Instancias de los objetos a los que se les realizaran los test
     */
    static AvionVip vip = new AvionVip();
    static AvionNormal nor = new AvionNormal();
    static AvionMixto mix = new AvionMixto();
    
    public testAviones() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        crearVip();
        crearEconomico();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * metodo de llenado para las sillas VIP
     */
    public static void crearVip(){
        int cont=0;
        for(int i=0; i<vip.getAsientosVip().length;i++){
            System.out.println();
            for(int j=0;j<vip.getAsientosVip()[i].length;j++){
                vip.getAsientosVip()[i][j]="V"+cont;
                cont ++;                
            }  
        }       
    }
    
    /**
     * metodo de llenado para las Sillas Economicas
     */
    public static void crearEconomico(){
        int cont=0;
        for(int i=0; i<nor.getAsientosEconomicos().length;i++){
            System.out.println();
            for(int j=0;j<nor.getAsientosEconomicos()[i].length;j++){
                nor.getAsientosEconomicos()[i][j]="E"+cont;
                cont ++;                
            }  
        }       
    }
    
    @Test
    public void pruebaFecha(){
        Date prueba = mix.fecha("17-06-2015");
        assertNotNull(prueba);
    }
    
    @Test
    public void buscarNormal(){
        String esperado = nor.buscarSillas("E2");
        assertEquals("Reservacion Correcta",esperado);
    }
    @Test
    public void buscarSillas(){
        String esperado = vip.buscarSillas("V2");
        assertEquals("Reservacion Correcta",esperado);
    }
}
