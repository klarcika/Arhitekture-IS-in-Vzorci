package si.um.feri.aiv.dao;
import si.um.feri.aiv.vao.Pacient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class PacientDao {

    Logger log=Logger.getLogger(PacientDao.class.toString());

    private static List<Pacient> pacienti= Collections.synchronizedList(new ArrayList<Pacient>());

//    public Oseba najdi(String email)  {
//        for (Oseba o : osebe)
//            if (o.getEmail().equals(email))
//                return o;
//        return new Oseba();
//    }

    public void shrani(Pacient p)  {
        log.info("DAO: shranjujem "+p);
        pacienti.add(p);
    }

    public List<Pacient> vrniPaciente() {
        log.info("DAO: Vracam vse paciente");
        return pacienti;
    }

}
