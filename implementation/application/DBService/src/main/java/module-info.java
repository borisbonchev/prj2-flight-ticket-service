/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/module-info.java to edit this template
 */

module DBService_module {
    exports com.mycompany.dbservice;
    
    requires org.postgresql.jdbc;
    requires java.logging;
    requires java.sql;
    requires java.naming;
}
