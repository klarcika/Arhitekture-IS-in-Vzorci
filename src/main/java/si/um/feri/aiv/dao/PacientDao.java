package si.um.feri.aiv.dao;
import si.um.feri.aiv.vao.Pacient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public interface PacientDao {

    List<Pacient> vrniPaciente();
    Pacient najdi(String email);
    void shrani(Pacient o);
    void izbrisi(String email);


//    void shraniKontakt(Kontakt k,String emailOsebe);
//    void izbrisiKontakt(int idKontakta,String emailOsebe);


}
