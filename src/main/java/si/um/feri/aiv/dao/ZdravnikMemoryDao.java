package si.um.feri.aiv.dao;

import si.um.feri.aiv.vao.Zdravnik;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

public class ZdravnikMemoryDao implements ZdravnikDao {
    Logger log= Logger.getLogger(ZdravnikDao.class.toString());

    private static List<Zdravnik> zdravniki= Collections.synchronizedList(new ArrayList<Zdravnik>());


    private static ZdravnikMemoryDao instance=new ZdravnikMemoryDao();

    public static ZdravnikMemoryDao getInstance() {
        return instance;
    }
    @Override
    public List<Zdravnik> izpisiVseZdravnike() {
        log.info("DAO: Vracam vse Zdravnike");
        return zdravniki;
    }

    @Override
    public Zdravnik najdi(String email) {
        log.info("DAO: iščem "+email);
        for (Zdravnik o : zdravniki)
            if (o.getEmail().equals(email))
                return o;
        return null;
    }

    @Override
    public void shraniZdravnika(Zdravnik z){
        log.info("DAO: dodajanje zdravnika"+ z);
        zdravniki.add(z);
    }

    @Override
    public void izbrisiZdravnika(String email) {
        log.info("DAO: brišem "+ email);
        for (Iterator<Zdravnik> i = zdravniki.iterator(); i.hasNext();) {
            if (i.next().getEmail().equals(email))
                i.remove();
        }
    }
}
