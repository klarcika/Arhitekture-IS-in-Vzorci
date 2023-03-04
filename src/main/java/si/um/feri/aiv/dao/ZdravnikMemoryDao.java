package si.um.feri.aiv.dao;

import si.um.feri.aiv.vao.Pacient;
import si.um.feri.aiv.vao.Zdravnik;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

public class ZdravnikMemoryDao implements SplosniDao<Zdravnik> {
    Logger log= Logger.getLogger(SplosniDao.class.toString());

    private static List<Zdravnik> zdravniki= Collections.synchronizedList(new ArrayList<Zdravnik>());


    private static ZdravnikMemoryDao instance=new ZdravnikMemoryDao();

    public static ZdravnikMemoryDao getInstance() {
        return instance;
    }
    @Override
    public List<Zdravnik> izpisi() {
        log.info("DAO: Vracam vse Zdravnike");
        return zdravniki;
    }

    @Override
    public Zdravnik najdi(String email) {
            log.info("DAO pacienti: finding " + email);
            for (Zdravnik z : zdravniki)
                if (z.getEmail().equals(email))
                    return z;
            return null;
        }

    @Override
    public void shrani(Zdravnik z){
        log.info("DAO: shrani "+z);
        if(najdi(z.getEmail())!=null) {
            log.info("DAO: ? "+z);
            izbrisi(z.getEmail());
        }
        zdravniki.add(z);
    }

    @Override
    public void izbrisi(String email) {
        log.info("Deleting: " + email);
        Zdravnik zaDelete = null;
        for (Zdravnik zdravnik : zdravniki){
            if(zdravnik.getEmail().equals(email))
                zaDelete = zdravnik;
        }

        if(zaDelete != null)
            zdravniki.remove(zaDelete);
    }
    }

//    public void urediZdravnika(Zdravnik zdravnik){
//        log.info("Uredi: " + zdravnik);
//        zdravnik.setIme();
//    }


