/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/module-info.java to edit this template
 */

module Persistance_module {
    requires DataRecords_module;
    requires transitive DBService_module;
    
    requires java.sql;
    requires org.postgresql.jdbc;
    
    exports com.mycompany.persistence;
}
