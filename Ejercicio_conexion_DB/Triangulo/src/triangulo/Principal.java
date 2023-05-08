/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package triangulo;

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

        Consulta c= new Consulta("bd_geometria", "root", "");
        if(!c.procedureInsert(156, 257.22)){
            
            System.out.println(c.getMsgError());
        }
    }

}
