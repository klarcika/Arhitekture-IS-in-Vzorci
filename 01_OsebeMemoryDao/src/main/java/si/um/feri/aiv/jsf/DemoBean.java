package si.um.feri.aiv.jsf;

import java.io.Serializable;
import java.util.logging.Logger;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import si.um.feri.aiv.dao.PacientMemoryDao;
import si.um.feri.aiv.dao.ZdravnikMemoryDao;
import si.um.feri.aiv.vao.Pacient;
import si.um.feri.aiv.vao.Zdravnik;

//@Named("demo")

public class DemoBean implements Serializable {

	//private static final long serialVersionUID = -4576958665520233267L;

	Logger log=Logger.getLogger(DemoBean.class.toString());
	
	private ZdravnikMemoryDao zdravnikDao=new ZdravnikMemoryDao();
	private PacientMemoryDao pacientDao=new PacientMemoryDao();
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

	// ---------------Pacient------------------

	public void dodajPacienta() {
		log.info("JSF BEAN: dodajPacienta");
		try {
			pacientDao.shrani(novP);
			novP=new Pacient();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// -------------------- zdravnik ------------------
	public void dodajZdravnika() {
		log.info("JSF BEAN: dodajZdravnika");
		try {
			zdravnikDao.shraniZdravnika(novZ);
			novZ=new Zdravnik();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//to spodaj sploh ne uporabim -------------------
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
