package com.epam.pryndate.grow.annotations;

/**
 * @author Tetiana_Prynda
 *         Created on 2/16/2017.
 */
@Note("Nice simple service")
@Note("It is the first one")
@Service(name = "simple")
public class SimpleService implements Initializable {

    @Init
    public void init() {
        System.out.println("Init Service in " + this.getClass());

    }
}
