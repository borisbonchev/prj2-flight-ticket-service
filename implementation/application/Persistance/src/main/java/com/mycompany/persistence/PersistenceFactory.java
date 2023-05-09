/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.persistence;

/**
 *
 * @author boris
 */
public interface PersistenceFactory {
    static PersistenceAPI getImplementation(){
        return new PersistenceAPIImplementation();
    }
}
    