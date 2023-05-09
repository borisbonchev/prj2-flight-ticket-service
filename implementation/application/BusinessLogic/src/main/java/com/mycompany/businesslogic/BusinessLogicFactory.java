/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.businesslogic;

import com.mycompany.persistence.PersistenceAPI;

/**
 *
 * @author boris
 */
public interface BusinessLogicFactory {
    
    static BusinessLogicAPI getImplementation( PersistenceAPI persistenceAPI ){
        return new BusinessLogicAPIImplementation( persistenceAPI );
    }
}
