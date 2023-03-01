package si.um.feri.aiv.dao;

import si.um.feri.aiv.vao.Pacient;
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
            log.info("DAO pacienti: finding " + email);
            for (Zdravnik z : zdravniki)
                if (z.getEmail().equals(email))
                    return z;
            return null;
        }

    @Override
    public void shraniZdravnika(Zdravnik z){
        log.info("DAO: shrani "+z);
        if(najdi(z.getEmail())!=null) {
            log.info("DAO: ? "+z);
            izbrisiZdravnika(z.getEmail());
        }
        zdravniki.add(z);
    }

    @Override
    public void izbrisiZdravnika(String email) {
        log.info("Deleting: " + email);
        Zdravnik zbrisan = null;
        for (Zdravnik zddravnik : zdravniki){
            if(zddravnik.getEmail().equals(email))
                zbrisan = zddravnik;
        }

        if(zbrisan != null)
            zdravniki.remove(zbrisan);
    }

    // -------------- to tu doli je mel luka napisano
//    @Override
//    public void izbrisiPacienta(int idKontakta, String emailPacienta) {
//        log.info("DAO: brišem pacienta "+idKontakta+" pacient "+emailPacienta);
//        Zdravnik najdena= najdi(emailPacienta);
//        if (najdena==null) return;
//        for (Iterator<Pacient> i = najdena.getPacientList().iterator(); i.hasNext();) {
//            if (i.next().getId()==idKontakta)
//                i.remove();
//        }
//    }
//
//    @Override
//    public void shraniPacienta(Pacient k, String emailPacienta) {
//        log.info("DAO: shranjujem kontakt "+k+" osebi "+emailPacienta);
//        Zdravnik najdena=najdi(emailPacienta);
//        if (najdena==null) return;
//        izbrisiPacienta(k.getId(), emailPacienta);

    }

