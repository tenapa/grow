package com.epam.pryndate.grow.annotations;

/**
 * @author Tetiana_Prynda
 *         Created on 2/16/2017.
 */
@Service(name = "throwing")
public class ThrowingService {

    @Init(suppressException = true)
    public void init() throws Exception {
        System.out.println("Init Service in " + this.getClass());
        throw new Exception("not nice to call this method");
    }
}
