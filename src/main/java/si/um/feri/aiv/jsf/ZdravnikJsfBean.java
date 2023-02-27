package si.um.feri.aiv.jsf;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import si.um.feri.aiv.dao.ZdravnikDao;
import si.um.feri.aiv.dao.ZdravnikMemoryDao;
import si.um.feri.aiv.vao.Zdravnik;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

@Named("demors")
@RequestScoped
public class ZdravnikJsfBean implements Serializable {


    private static final long serialVersionUID = -7804846070746699266L;

    Logger log=Logger.getLogger(ZdravnikJsfBean.class.toString());

    private ZdravnikDao dao= ZdravnikMemoryDao.getInstance();

    private Zdravnik izbranZdravnik=new Zdravnik();

    private String izbranEmail;

    public List<Zdravnik> getVseOsebe() throws Exception {
        return dao.izpisiVseZdravnike();
    }

    public String shraniZdravnika() throws Exception {
        dao.shraniZdravnika(izbranZdravnik);
        return "vse";
    }

    public void izbrisiZdravnika(Zdravnik o) throws Exception {
        dao.izbrisiZdravnika(o.getEmail());
    }

//    public void dodajKontakt() throws Exception {
//        dao.shraniKontakt(new Kontakt(), izbranZdravnik.getEmail());
//        izbranaOseba=dao.najdi(izbranZdravnik.getEmail());
//    }

//    public void shraniKontakt(Kontakt k) throws Exception {
//        k.setUrejanje(false);
//        dao.shraniKontakt(k, izbranZdravnik.getEmail());
//        izbranaOseba=dao.najdi(izbranZdravnik.getEmail());
//    }

//    public void izbrisiKontakt(Kontakt k) throws Exception {
//        dao.izbrisiKontakt(k.getId(), izbranZdravnik.getEmail());
//        izbranaOseba=dao.najdi(izbranZdravnik.getEmail());
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
