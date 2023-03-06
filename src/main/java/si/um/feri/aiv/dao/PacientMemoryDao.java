package si.um.feri.aiv.dao;

import si.um.feri.aiv.vao.Pacient;
import si.um.feri.aiv.vao.Zdravnik;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

public class PacientMemoryDao implements SplosniDao<Pacient> {

    Logger log=Logger.getLogger(SplosniDao.class.toString());
    private static PacientMemoryDao instance=null;

    public synchronized static PacientMemoryDao getInstance() {
        if(instance==null){
            return new PacientMemoryDao();
        }
        return instance;
    }

    private PacientMemoryDao(){

    }

    private static List<Pacient> pacienti= Collections.synchronizedList(new ArrayList<Pacient>());
    @Override
    public List<Pacient> izpisi() {
        log.info("DAO: Vracam vse paciente");
        return pacienti;
    }
    @Override
    public Pacient najdi(String email)  {
        log.info("DAO pacienti: finding "+email);
        for (Pacient o : pacienti)
            if (o.getEmail().equals(email))
                return o;
        return null;
    }

    @Override
    public void shrani(Pacient p)  {
        log.info("DAO: shrani "+p);
        if(najdi(p.getEmail())!=null) {
            log.info("DAO: ? "+p);
            izbrisi(p.getEmail());
        }
        pacienti.add(p);
    }
    @Override
    public void izbrisi(String email) {
        log.info("Deleting: " + email);
        for (Iterator<Pacient> z = pacienti.iterator(); z.hasNext(); ) {
            if (z.next().getEmail().equals(email)) {
                z.remove();
            }
        }

    }

}
