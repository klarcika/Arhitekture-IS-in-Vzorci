package si.um.feri.aiv.jsf;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import si.um.feri.aiv.dao.PacientDao;
import si.um.feri.aiv.dao.PacientMemoryDao;
import si.um.feri.aiv.vao.Pacient;
import si.um.feri.aiv.vao.Zdravnik;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

@Named("demo") //pacient
@SessionScoped
public class PacientJsfBean implements Serializable {

        Logger log= Logger.getLogger(PacientJsfBean.class.toString());
        private PacientMemoryDao dao= PacientMemoryDao.getInstance();
        private Pacient izbranPacient=new Pacient();
        private Zdravnik selectedZdravnik;
        private String izbranEmail;


    {
        Pacient marcus= new Pacient("marcus","priimek","marcus@mail.si", LocalDate.parse("1990-10-01"), "/");
    }


    public List<Pacient> getVsiPacienti() throws Exception {
        this.izbranPacient = new Pacient();
        return dao.vrniPaciente();
    }
        public String shraniPacienta() throws Exception {
                log.info("JSF BEAN: dodajPacienta");
                Pacient novi=new Pacient();
                novi.setIme(izbranPacient.getIme());
                novi.setPriimek(izbranPacient.getPriimek());
                novi.setEmail(izbranPacient.getEmail());
                novi.setDatumRojstva(izbranPacient.getDatumRojstva());
                novi.setPosebnosti(izbranPacient.getPosebnosti());
                novi.setZdravnik(izbranPacient.getZdravnik());
                dao.shrani(novi);
                izbranPacient= new Pacient();
                return "pacient dodan/ shranjen";

        }
    public Pacient getNewPacient() {
        return izbranPacient;
    }

        public void izbrisiPacienta(Pacient o) throws Exception {
            dao.izbrisi(o.getEmail());
        }

        public String getIzbranEmail() {
            return izbranEmail;
        }
        public void setIzbranEmail(String email) {
            try {
                izbranEmail = email;
                izbranPacient = dao.najdi(izbranEmail);
                if (izbranPacient == null)
                    izbranPacient = new Pacient();
            } catch (Exception x) {
            }
        }
    public Pacient getIzbranPacient(){
        return izbranPacient;
    }
    public void setIzbranPacient(Pacient izbranPacient){
        this.izbranPacient = izbranPacient;
    }


    public Zdravnik getIzbranZdravnik() {
        return selectedZdravnik;
    }

    public void setIzbranZdravnik(Zdravnik selectedZdravnik) {
        log.info("Pripadajoc zdravnik: " + selectedZdravnik.getEmail());
        this.selectedZdravnik = selectedZdravnik;
    }


    }

//        public void dodajKontakt() throws Exception {
//            dao.shraniKontakt(new Kontakt(), izbranaOseba.getEmail());
//            izbranaOseba=dao.najdi(izbranaOseba.getEmail());
//        }

//        public void shraniKontakt(Kontakt k) throws Exception {
//            k.setUrejanje(false);
//            dao.shraniKontakt(k, izbranaOseba.getEmail());
//            izbranaOseba=dao.najdi(izbranaOseba.getEmail());
//        }

//        public void izbrisiKontakt(Kontakt k) throws Exception {
//            dao.izbrisiKontakt(k.getId(), izbranaOseba.getEmail());
//            izbranaOseba=dao.najdi(izbranaOseba.getEmail());
//        }

//        public void urediPacienta(Pacient k) throws Exception {
//            k.setUrejanje(true);
//            dao.shraniKontakt(k, izbranaOseba.getEmail());
//            izbranaOseba=dao.najdi(izbranaOseba.getEmail());
//        }

//        public void setIzbranEmail(String email) throws Exception {
//            izbranEmail=email;
//            izbranaOseba=dao.najdi(email);
//            if(izbranaOseba==null) izbranaOseba=new Oseba();
//        }