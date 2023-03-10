package si.um.feri.aiv;

import si.um.feri.aiv.dao.PacientMemoryDao;
import si.um.feri.aiv.dao.ZdravnikMemoryDao;
import si.um.feri.aiv.vao.Pacient;
import si.um.feri.aiv.vao.Zdravnik;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class DodeljevanjeZdravnikov {
    Logger log = Logger.getLogger(DodeljevanjeZdravnikov.class.toString());

    PacientMemoryDao dao= PacientMemoryDao.getInstance();
    ZdravnikMemoryDao zdravnikMemoryDao= ZdravnikMemoryDao.getInstance();

    public int stPacientov(Zdravnik selectedZdravnik){
        List<Pacient> pacienti= new ArrayList<>(dao.izpisi());
        int st=0;
        for(Pacient pacient: pacienti){
            if(pacient.getZdravnik().getEmail().equals(selectedZdravnik.getEmail())){
                st++;
            }else continue;
        }
        return st;
    }
    public void nastaviZdravnika(Zdravnik selectedZdravnik, Pacient pacient){
        int stevilo = stPacientov(selectedZdravnik);
        if(stevilo > selectedZdravnik.getStPacientov()) {
            // tu bos pol poslala mail samo pacientu da zdranvika nemore vec izbrat
            if (selectedZdravnik.getEmail().equals("")) {
                   Mail.send(pacient.getEmail(), "Niste izbrali zdravnika", "Zdravnika niste izbrali, zato ne spadate nikam");
            } else {
                 Mail.send(pacient.getEmail(), "Neuspesna registracija k zdravniku", "Žal ima zdravnik z emailom " + selectedZdravnik.getEmail() + ", že zasedeno število mest pacientov");
                log.info("NI DODAN");

            }
        }else if(stevilo < selectedZdravnik.getStPacientov()) {
            //poslji selected zdravniku in temu pacientu mail
            Mail.send(selectedZdravnik.getEmail(), "Nov pacient", "Dodan nov pacient/ka, z emailom: " + pacient.getEmail());
            Mail.send(pacient.getEmail(), "Uspesna registracija k zdravniku", "Uspesno vam je bil dodeljen zdravnik, z emailom " + selectedZdravnik.getEmail() + ".");
            pacient.setZdravnik(selectedZdravnik);
            log.info("DODANO");
        }

    }



}
