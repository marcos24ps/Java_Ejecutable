/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package triangulo;

import java.util.Scanner;

/**
 *
 * @author Curso Tarde
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Conexion c=new Conexion("bd_geometria", "root", "");
        
        System.out.print(c.getMsgError());
        c.insert();
        c.finalize();
    }

}
