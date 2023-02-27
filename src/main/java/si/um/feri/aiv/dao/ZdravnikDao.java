package si.um.feri.aiv.dao;

import si.um.feri.aiv.vao.Zdravnik;

import java.util.List;

public interface ZdravnikDao {

    List<Zdravnik> izpisiVseZdravnike();
    Zdravnik najdi(String email);
    void shraniZdravnika(Zdravnik o);
    void izbrisiZdravnika(String email);

   // void shraniKontakt(Kontakt k,String emailOsebe);
  //  void izbrisiKontakt(int idKontakta,String emailOsebe);

}
