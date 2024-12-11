package com.fca.calidad.maven;

import com.fca.calidad.dao.DAOUserSQLite;
import com.fca.calidad.modelo.User;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        DAOUserSQLite dao = new DAOUserSQLite();
        User usuario =new User("nombre","correo","password");
        int id = dao.save(usuario);
        
        usuario.setId(id);
        
        //Find
        System.out.println(dao.findById(id).toString());
        usuario.setPassword("123456");
        dao.updateUser(usuario);
    }
}