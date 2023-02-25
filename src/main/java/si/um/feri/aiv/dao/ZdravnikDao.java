package si.um.feri.aiv.dao;

import si.um.feri.aiv.vao.Zdravnik;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class ZdravnikDao {

    Logger log= Logger.getLogger(ZdravnikDao.class.toString());

    private static List<Zdravnik> zdravniki= Collections.synchronizedList(new ArrayList<Zdravnik>());
    public void shraniZdravnika(Zdravnik z){
        log.info("DAO: dodajanje zdravnika"+ z);
        zdravniki.add(z);
    }

    public List<Zdravnik> izpisiVseZdravnik(){
        log.info("DAO: Vracam vse Zdravnike");
        return zdravniki;
    }
}
