package si.um.feri.aiv.vao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Pacient {


    public Pacient() {
        this("", "", "", "");
    }
        public Pacient(String ime, String priimek, String email, String posebnosti) {
            this.ime = ime;
            this.priimek = priimek;
            this.email = email;
            datumRojstva=new GregorianCalendar();
            this.posebnosti=posebnosti;
        }

        public Pacient(String ime, String priimek, String email, int id) {
            this.email = email;
            this.ime = ime;
            this.priimek = priimek;
            datumRojstva=new GregorianCalendar();
            this.posebnosti=posebnosti;

        }

        private int id;

        private String ime;

        private String priimek;

        private String email;

        private Calendar datumRojstva;

        private String posebnosti;


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

        public Calendar getDatumRojstva() {
            return datumRojstva;
        }

        public void setDatumRojstva(Calendar datumRojstva) {
            this.datumRojstva = datumRojstva;
        }

        public void setPosebnosti(String posebnosti) {
            this.posebnosti = posebnosti;
        }

        public String getPosebnosti() {
            return posebnosti;
        }

        public int getId() {
        return id;
        }

        public void setId(int id) {
        this.id = id;
        }

    private static SimpleDateFormat sdf=new SimpleDateFormat("dd. MM. yyyy HH:mm:ss");
        @Override
        public String toString() {
            return ime + " " + priimek + ","+" ("+email+");"+ "; posebnosti: "+ posebnosti + "datum rojstva: "+sdf.format(datumRojstva.getTime());
        }

    }

