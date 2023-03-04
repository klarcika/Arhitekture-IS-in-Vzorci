package si.um.feri.aiv.jsf;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import si.um.feri.aiv.dao.ZdravnikMemoryDao;
import si.um.feri.aiv.vao.Zdravnik;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

@Named("demors") // zdravnik
@RequestScoped
public class ZdravnikJsfBean implements Serializable {
    Logger log=Logger.getLogger(ZdravnikJsfBean.class.toString());
    private ZdravnikMemoryDao dao= ZdravnikMemoryDao.getInstance();
    private Zdravnik izbranZdravnik=new Zdravnik();
    private String izbranEmail;

    public List<Zdravnik> getVsiZdravniki() throws Exception{
        log.info("JSF BEAN: getVsiZdravniki");
        this.izbranZdravnik = new Zdravnik();
        return dao.izpisi();
    }

    public String shraniZdravnika() throws Exception {
        log.info("JSF BEAN: dodajZdravnika");
        dao.shrani(izbranZdravnik);
        Zdravnik novi = new Zdravnik();
        novi.setIme(izbranZdravnik.getIme());
        novi.setPriimek(izbranZdravnik.getPriimek());
        novi.setEmail(izbranZdravnik.getEmail());
        novi.setStPacientov(izbranZdravnik.getStPacientov());
        dao.shrani(novi);
        izbranZdravnik = new Zdravnik();
        return "Zdravnik dodan";
    }

    public void izbrisiZdravnika(Zdravnik o) throws Exception {
        dao.izbrisi(o.getEmail());
    }


    public void urediZdravnika(String izbranEmail) throws Exception {
        log.info("posodabljam zdravnika"+ izbranZdravnik);
        Zdravnik X = dao.najdi(izbranEmail);
        izbranZdravnik.setIme(izbranZdravnik.getIme());
        izbranZdravnik.setPriimek(izbranZdravnik.getPriimek());
        izbranZdravnik.setEmail(izbranZdravnik.getEmail());
        izbranZdravnik.setStPacientov(izbranZdravnik.getStPacientov());
        dao.shrani(izbranZdravnik);
        log.info("zdravnik posodobljen" + izbranZdravnik);

    }

    public void setIzbranEmail(String email) throws Exception {
        izbranEmail=email;
        izbranZdravnik=dao.najdi(email);
        if(izbranZdravnik==null) izbranZdravnik=new Zdravnik();
    }

    public String getIzbranEmail() {
        return izbranEmail;
    }

    public Zdravnik getIzbranZdravnik() {
        return izbranZdravnik;
    }

    public void setIzbranZdravnik(Zdravnik izbranZdravnik) {
        this.izbranZdravnik = izbranZdravnik;
    }
}
