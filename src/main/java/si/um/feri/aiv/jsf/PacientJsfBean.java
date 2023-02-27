package si.um.feri.aiv.jsf;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import si.um.feri.aiv.dao.PacientDao;
import si.um.feri.aiv.dao.PacientMemoryDao;
import si.um.feri.aiv.vao.Pacient;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Named("demo")
@SessionScoped
public class PacientJsfBean implements Serializable {

        private static final long serialVersionUID = -8979220536758073133L;

        Logger log= Logger.getLogger(PacientJsfBean.class.toString());

        private PacientDao dao= PacientMemoryDao.getInstance();
        List<Pacient>  getVsiPacientiRet=null;

        private Pacient izbranPacient=new Pacient();

        private String izbranEmail;

        public List<Pacient> getVsiPacienti(){
            log.info("JSF BEAN: getVsiPacienti");

            if (getVsiPacientiRet==null) {
                try {
                    getVsiPacientiRet=dao.vrniPaciente();
                } catch (Exception e) {
                    getVsiPacientiRet=new ArrayList<>();
                }
            }

            return getVsiPacientiRet;
        }

        public String shraniPacienta() throws Exception {
            log.info("JSF BEAN: dodajPacienta");
            dao.shrani(izbranPacient);
            return "pacient dodan/ shranjen";
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
            return izbranPacient;
        }

        public void setIzbranPacient(Pacient izbranaOseba) {
            this.izbranPacient = izbranaOseba;
        }



    }
