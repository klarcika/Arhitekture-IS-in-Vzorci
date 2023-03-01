package si.um.feri.aiv.vao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;


public class Zdravnik {

    public Zdravnik(){
        this("", "", "" );
    }

        public Zdravnik(String ime, String priimek, String email, int stPacientov) {
            this.ime = ime;
            this.priimek = priimek;
            this.email = email;
            this.stPacientov=stPacientov;
        }
        public Zdravnik(String ime, String priimek, String email) {
            this.ime = ime;
            this.priimek = priimek;
            this.email = email;
    }


        private String ime;

        private String priimek;

        private String email;

       private int stPacientov;



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



        public void setStPacientov(int stPacientov) {
            this.stPacientov = stPacientov;
        }

        public int getStPacientov() {
            return stPacientov;
        }


        @Override
        public String toString() {
            return ime + " " + priimek + ","+" ("+email+");"+ "; posebnosti: "+ "stevilo pacientov"+ stPacientov  ;
        }

    }

