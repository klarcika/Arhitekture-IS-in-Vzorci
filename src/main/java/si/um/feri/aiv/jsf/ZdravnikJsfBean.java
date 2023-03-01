package si.um.feri.aiv.jsf;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import si.um.feri.aiv.dao.ZdravnikDao;
import si.um.feri.aiv.dao.ZdravnikMemoryDao;
import si.um.feri.aiv.vao.Pacient;
import si.um.feri.aiv.vao.Zdravnik;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Named("demors") // zdravnik
@RequestScoped
public class ZdravnikJsfBean implements Serializable {
    Logger log=Logger.getLogger(ZdravnikJsfBean.class.toString());
    private ZdravnikDao dao= ZdravnikMemoryDao.getInstance();
    private Zdravnik izbranZdravnik=new Zdravnik();
    private String izbranEmail;

    public List<Zdravnik> getVsiZdravniki() throws Exception{
        log.info("JSF BEAN: getVsiZdravniki");
        this.izbranZdravnik = new Zdravnik();
        return dao.izpisiVseZdravnike();
    }

    public String shraniZdravnika() throws Exception {
        log.info("JSF BEAN: dodajZdravnika");
        dao.shraniZdravnika(izbranZdravnik);
        Zdravnik novi = new Zdravnik();
        novi.setIme(izbranZdravnik.getIme());
        novi.setPriimek(izbranZdravnik.getPriimek());
        novi.setEmail(izbranZdravnik.getEmail());
        novi.setStPacientov(izbranZdravnik.getStPacientov());
        dao.shraniZdravnika(novi);
        izbranZdravnik = new Zdravnik();
        return "Zdravnik dodan";
    }

    public void izbrisiZdravnika(Zdravnik o) throws Exception {
        dao.izbrisiZdravnika(o.getEmail());
    }

//    public void shraniPacienta() throws Exception {
//        dao.shraniPacienta(new Pacient(), izbranZdravnik.getEmail());
//        izbranZdravnik=dao.najdi(izbranZdravnik.getEmail());
//    }
//
//    public void dodajPacienta() throws Exception {
//        dao.shraniPacienta(new Pacient(), izbranZdravnik.getEmail());
//        izbranZdravnik=dao.najdi(izbranZdravnik.getEmail());
//    }
//
//    public void shraniKontakt(Pacient k) throws Exception {
//       // k.setUrejanje(false);
//        dao.shraniPacienta(k, izbranZdravnik.getEmail());
//        izbranZdravnik=dao.najdi(izbranZdravnik.getEmail());
//    }
//
//    public void izbrisiPacienta(Pacient k) throws Exception {
//        dao.izbrisiPacienta(k.getId(), izbranZdravnik.getEmail());
//        izbranZdravnik=dao.najdi(izbranZdravnik.getEmail());
//    }

//    public void urediKontakt(Kontakt k) throws Exception {
//        k.setUrejanje(true);
//        dao.shraniKontakt(k, izbranZdravnik.getEmail());
//        izbranZdravnik=dao.najdi(izbranZdravnik.getEmail());
//    }

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
