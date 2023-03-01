package si.um.feri.aiv.dao;

import si.um.feri.aiv.vao.Pacient;
import si.um.feri.aiv.vao.Zdravnik;

import java.util.List;

public interface ZdravnikDao {

    List<Zdravnik> izpisiVseZdravnike();
    Zdravnik najdi(String email);
    void shraniZdravnika(Zdravnik o);
    void izbrisiZdravnika(String email);

//    void shraniPacienta(Pacient k, String emailPacienta);
//    void izbrisiPacienta(int idPacienta,String emailPacienta);

}
