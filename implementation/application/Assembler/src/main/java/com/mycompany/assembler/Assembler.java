/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assembler;

import com.mycompany.businesslogic.BusinessLogicAPI;
import com.mycompany.businesslogic.BusinessLogicFactory;
import com.mycompany.persistence.PersistenceAPI;
import com.mycompany.persistence.PersistenceFactory;
import com.mycompany.gui.App;

/**
 *
 * @author boris
 */
public class Assembler {

    public static void main(String[] args) {
        
        PersistenceAPI persistenceAPI = PersistenceFactory.getImplementation();
        BusinessLogicAPI businesslogicAPI = BusinessLogicFactory.getImplementation( persistenceAPI );
        
        new App( businesslogicAPI ).show();
    }
}
