package com.epam.pryndate.grow.jndi;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

/**
 * @author Tetiana_Prynda
 *         Created on 2/13/2017.
 */
public class LdapAuthClient {
    public static void main(String[] args) {
        Hashtable<String, String> env = new Hashtable<String, String>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
        env.put(Context.PROVIDER_URL, "localhost:1099");
        try {
            InitialContext ctx = new InitialContext(env);
            LdapAuth auth = (LdapAuth) ctx.lookup("LdapAuth/Remote");
            System.out.println(auth.authenticate(args[0], args[1]));
            ctx.close();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

}
