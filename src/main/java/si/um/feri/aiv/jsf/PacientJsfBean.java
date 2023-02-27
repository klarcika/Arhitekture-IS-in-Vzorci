package si.um.feri.aiv.jsf;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import si.um.feri.aiv.dao.PacientDao;
import si.um.feri.aiv.dao.PacientMemoryDao;
import si.um.feri.aiv.vao.Pacient;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

@Named("demo")
@SessionScoped
public class PacientJsfBean implements Serializable {

        private static final long serialVersionUID = -8979220536758073133L;

        Logger log= Logger.getLogger(PacientJsfBean.class.toString());

        private PacientDao dao= PacientMemoryDao.getInstance();

        private Pacient izbranaPacient=new Pacient();

        private String izbranEmail;

        public List<Pacient> getVsePaciente() throws Exception {
            return dao.vrniPaciente();
        }

        public String shraniPacienta() throws Exception {
            dao.shrani(izbranaPacient);
            return "vse";
        }

        public void izbrisiPacienta(Pacient o) throws Exception {
            dao.izbrisi(o.getEmail());
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

        public String getIzbranEmail() {
            return izbranEmail;
        }

        public Pacient getIzbranaPacient() {
            return izbranaPacient;
        }

        public void setIzbranPacient(Pacient izbranaOseba) {
            this.izbranaPacient = izbranaOseba;
        }

    }
