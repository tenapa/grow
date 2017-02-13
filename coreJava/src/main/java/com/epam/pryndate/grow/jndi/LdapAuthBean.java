package com.epam.pryndate.grow.jndi;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import java.util.Hashtable;

/**
 * @author Tetiana_Prynda
 * Created on 2/13/2017.
 */
public class LdapAuthBean implements LdapAuth {
    @Resource(name = "providerUrl")
    private String providerUrl;
    @Resource(name = "securityAuthentication")
    private String securityAuthentication;

    @Resource(name = "securityPrincipal")
    private String securityPrincipal;
    @Resource(name = "securityCredentials")
    private String securityCredentials;
    @Resource(name = "baseContext")
    private String baseContext;

    private InitialDirContext ctx;

    @PostConstruct
    public void init() {
        Hashtable<String, String> args = new Hashtable<String, String>();

        args.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        args.put(Context.PROVIDER_URL, providerUrl);
        args.put(Context.SECURITY_AUTHENTICATION, securityAuthentication);
        args.put(Context.SECURITY_PRINCIPAL, securityPrincipal);
        args.put(Context.SECURITY_CREDENTIALS, securityCredentials);
        try {
            ctx = new InitialDirContext(args);
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public boolean authenticate(String name, String password) {
        SearchControls controls = new SearchControls();
        controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        try {
            NamingEnumeration results = ctx.search(
                    baseContext, "(&(cn={0})(userPassword={1}))",
                    new String[]{name, password}, controls);
            return results.hasMore();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return false;
    }

}
