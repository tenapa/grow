package com.epam.pryndate.grow.annotations;

/**
 * @author Tetiana_Prynda
 *         Created on 2/16/2017.
 */
@Service(name = "lazy", lazyLoad = true)
public class LazyService implements Initializable {

    @Init
    @Override
    public void init() {
        System.out.println("Init Service in " + this.getClass());
    }

    @Override
    public String toString() {
        return "LazyService{}";
    }
}
