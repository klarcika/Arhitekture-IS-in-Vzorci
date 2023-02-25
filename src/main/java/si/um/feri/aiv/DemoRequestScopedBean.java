package si.um.feri.aiv;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import si.um.feri.aiv.dao.PacientDao;
import si.um.feri.aiv.dao.ZdravnikDao;
import si.um.feri.aiv.vao.Pacient;
import si.um.feri.aiv.vao.Zdravnik;

@Named("demors")
@RequestScoped
public class DemoRequestScopedBean implements Serializable {

	private static final long serialVersionUID = -7804846070746699266L;

	Logger log=Logger.getLogger(DemoRequestScopedBean.class.toString());


	private ZdravnikDao zdravnikDao=new ZdravnikDao();
	private PacientDao pacientDao=new PacientDao();

	List<Zdravnik> getVsiZdravnikiRet=null;
	List<Pacient>  getVsiPacientiRet=null;
	
	public List<Zdravnik> getVsiZdravniki(){
		log.info("JSF BEAN: getVsiZdravniki");
		
		if (getVsiZdravnikiRet==null) {
			try {
				getVsiZdravnikiRet=zdravnikDao.izpisiVseZdravnik();
			} catch (Exception e) {
				getVsiZdravnikiRet=new ArrayList<>();
			}
		}
		
		return getVsiZdravnikiRet;
	}
	public List<Pacient> getVsiPacienti(){
		log.info("JSF BEAN: getVsiPacienti");

		if (getVsiPacientiRet==null) {
			try {
				getVsiPacientiRet=pacientDao.vrniPaciente();
			} catch (Exception e) {
				getVsiPacientiRet=new ArrayList<>();
			}
		}

		return getVsiPacientiRet;
	}
	
}
