/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop1;

/**
 *
 * @author munka
 */
public class OOP1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Computer comp = new Computer("Lenovo", "Ideapad", "AMD", 16, "128 GB", "Windows", 600);
        comp.checkStatus();
    }
    
}
