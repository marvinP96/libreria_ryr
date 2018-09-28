/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Miguel Benavides
 */
public class entityMain {
    private static final EntityManagerFactory ent=
            Persistence.createEntityManagerFactory("Libreria_RYRPU");
    
    public entityMain(){
        
    }
    
    public static EntityManagerFactory getInstance()
    {
        return ent;
    }
    
}
