package si.um.feri.aiv;

import java.io.Serializable;
import java.util.logging.Logger;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import si.um.feri.aiv.dao.PacientDao;
import si.um.feri.aiv.dao.ZdravnikDao;
import si.um.feri.aiv.vao.Pacient;
import si.um.feri.aiv.vao.Zdravnik;

@Named("demo")
@SessionScoped
public class DemoBean implements Serializable {

	private static final long serialVersionUID = -4576958665520233267L;

	Logger log=Logger.getLogger(DemoBean.class.toString());
	
	private ZdravnikDao zdravnikDao=new ZdravnikDao();
	private PacientDao pacientDao=new PacientDao();
	private Zdravnik novZ= new Zdravnik();
	private Pacient novP=new Pacient();



//	public String izberiOsebo(String email) {
//		log.info("JSF BEAN: izberiOsebo");
//		try {
//			izbranaOseba=dao.najdi(email);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return "podrobnosti.xhtml";
//	}

	public void dodajPacienta() {
		log.info("JSF BEAN: dodajPacienta");
		try {
			pacientDao.shrani(novP);
			novP=new Pacient();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void dodajZdravnika() {
		log.info("JSF BEAN: dodajZdravnika");
		try {
			zdravnikDao.shraniZdravnika(novZ);
			novZ=new Zdravnik();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//to spodaj sploh ne uporabim
	public Pacient getNovP() {
		return novP;
	}

	public void setNovP(Pacient novP) {
		this.novP = novP;
	}
	public Zdravnik getNovZ() {
		return novZ;
	}

	public void setNovZ(Zdravnik novZ) {
		this.novZ = novZ;
	}


}
