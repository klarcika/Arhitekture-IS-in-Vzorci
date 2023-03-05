package si.um.feri.aiv.jsf;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import si.um.feri.aiv.dao.PacientMemoryDao;
import si.um.feri.aiv.dao.ZdravnikMemoryDao;
import si.um.feri.aiv.vao.Pacient;
import si.um.feri.aiv.vao.Zdravnik;

import java.io.Serializable;
import java.util.*;
import java.util.logging.Logger;

@Named("pregled")
@SessionScoped
public class PregledJsfBean implements Serializable {
    Logger log = Logger.getLogger(PregledJsfBean.class.toString());

    private PacientMemoryDao pacientDao = PacientMemoryDao.getInstance();

    private ZdravnikMemoryDao zdravnikDao = ZdravnikMemoryDao.getInstance();

    private Integer neopredeljeni;

    public Map<Zdravnik, List> listZdravnikov(){
        ArrayList<Pacient> pacienti = new ArrayList<>(pacientDao.izpisi());
        ArrayList<Zdravnik> zdravniki = new ArrayList<>(zdravnikDao.izpisi());

        Map<Zdravnik, List> relacija = new HashMap<>();
        this.neopredeljeni = 0;

        for(Zdravnik zdravnik : zdravniki){
            List<Pacient> njegovi = new ArrayList<>();
            for(Pacient pacient : pacienti){
                if(pacient.getZdravnik() == zdravnik){
                    njegovi.add(pacient);

                    log.info("Zdravnikov mail: " + zdravnik.getEmail());
                    if(Objects.equals(zdravnik.getEmail(), "") || Objects.equals(zdravnik.getEmail(), "null"))
                        this.neopredeljeni++;
                }
            }
            relacija.put(zdravnik, njegovi);
        }

        return relacija ;
    }
    public Integer getNeopredeljeni() {
        return this.neopredeljeni;
    }

}
