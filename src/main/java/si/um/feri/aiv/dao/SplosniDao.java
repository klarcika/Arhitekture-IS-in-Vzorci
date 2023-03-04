package si.um.feri.aiv.dao;

import java.util.List;

public interface SplosniDao <S>{


    List<S> izpisi();
    void shrani(S x);
    S najdi(String x);
    void izbrisi(String x);



}


