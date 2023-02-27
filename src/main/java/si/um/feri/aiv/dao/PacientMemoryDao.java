package si.um.feri.aiv.dao;

import si.um.feri.aiv.vao.Pacient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

public class PacientMemoryDao implements PacientDao {

    Logger log=Logger.getLogger(PacientMemoryDao.class.toString());
    private static PacientMemoryDao instance=new PacientMemoryDao();

    public static PacientMemoryDao getInstance() {
        return instance;
    }

    private static List<Pacient> pacienti= Collections.synchronizedList(new ArrayList<Pacient>());

    @Override
    public Pacient najdi(String email)  {
        for (Pacient o : pacienti)
            if (o.getEmail().equals(email))
                return o;
        return new Pacient();
    }

    @Override
    public void shrani(Pacient p)  {
        log.info("DAO: shranjujem "+p);
        pacienti.add(p);
    }
    @Override
    public List<Pacient> vrniPaciente() {
        log.info("DAO: Vracam vse paciente");
        return pacienti;
    }
    @Override
    public void izbrisi(String email) {
        log.info("DAO: brišem "+email);
        for (Iterator<Pacient> i = pacienti.iterator(); i.hasNext();) {
            if (i.next().getEmail().equals(email))
                i.remove();
        }
    }

//    @Override
//    public List<Pacient> vrniVse() {
//        log.info("DAO: vračam vse");
//        return pacienti;
//    }


//    @Override
//    public void shrani(Pacient o)  {
//        log.info("DAO: shranjujem "+o);
//        if(najdi(o.getEmail())!=null) {
//            log.info("DAO: urejam "+o);
//            izbrisi(o.getEmail());
//        }
//        pacienti.add(o);
//    }



//    @Override
//    public void izbrisiKontakt(int idKontakta, String emailOsebe) {
//        log.info("DAO: brišem kontakt "+idKontakta+" osebe "+emailOsebe);
//        Oseba najdena=najdi(emailOsebe);
//        if (najdena==null) return;
//        for (Iterator<Kontakt> i = najdena.getKontakti().iterator(); i.hasNext();) {
//            if (i.next().getId()==idKontakta)
//                i.remove();
//        }
//    }
//
//    @Override
//    public void shraniKontakt(Kontakt k, String emailOsebe) {
//        log.info("DAO: shranjujem kontakt "+k+" osebi "+emailOsebe);
//        Oseba najdena=najdi(emailOsebe);
//        if (najdena==null) return;
//        izbrisiKontakt(k.getId(), emailOsebe);
//        k.setId(najdena.getMaxKontaktId()+1);
//        najdena.getKontakti().add(k);
//    }
}
