package si.um.feri.aiv.vao;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Pacient {

    private int id;

    private String ime;

    private String priimek;

    private String email;

    private LocalDate datumRojstva;

    private String posebnosti;
    private Zdravnik zdravnik;



    private boolean uredi;

    public Pacient() {
        this("", "", "", null, "", null);
    }
        public Pacient(String ime, String priimek, String email, LocalDate datumRojstva, String posebnosti, Zdravnik zdravnik) {
        this(ime, priimek, email, datumRojstva, posebnosti);
        this.zdravnik=zdravnik;

        }
    public Pacient(String ime, String priimek, String email, LocalDate datumRojstva, String posebnosti) {
        this.ime = ime;
        this.priimek = priimek;
        this.email = email;
        this.datumRojstva = datumRojstva;
        this.posebnosti = posebnosti;
        this.zdravnik = null;
    }



    public String getIme() {
            return ime;
        }

        public void setIme(String ime) {
            this.ime = ime;
        }

        public String getPriimek() {
            return priimek;
        }

        public void setPriimek(String priimek) {
            this.priimek = priimek;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
        public LocalDate getDatumRojstva() {
            return datumRojstva;
        }
        public void setDatumRojstva(LocalDate datumRojstva) {
            this.datumRojstva = datumRojstva;
        }
        public void setPosebnosti(String posebnosti) {
            this.posebnosti = posebnosti;
        }
        public String getPosebnosti() {
            return posebnosti;
        }
        public Zdravnik getZdravnik() {
            return zdravnik;
        }
        public void setZdravnik(Zdravnik zdravnik) {
            this.zdravnik = zdravnik;
        }
    public boolean isUredi() {
        return uredi;
    }

    public void setUredi(boolean uredi) {
        this.uredi = uredi;
    }


        public int getId() {
        return id;
        }

        public void setId(int id) {
        this.id = id;
        }

   // private static SimpleDateFormat sdf=new SimpleDateFormat("dd. MM. yyyy HH:mm:ss");
        @Override
        public String toString() {
            return ime + " " + priimek + ","+" ("+email+");"+ "; posebnosti: "+ posebnosti + "datum rojstva: "+ datumRojstva;
        }

    }

