package com.epam.pryndate.grow.jndi;

/**
 * @author Tetiana_Prynda
 * Created on 2/13/2017.
 */
public interface LdapAuth {
    boolean authenticate(String name,   String password);
}
