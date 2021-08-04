package csd_ass1_library_.management;





public class Lending extends Reader {
   String Lbcode;
   String Lrcode;
   int state;

    public Lending() {
    }

    public Lending(String Lbcode1, String Lrcode1, int state1) {
        Lbcode=super.bcode;
        Lrcode=super.rcode;
        Lbcode = Lbcode1;
        Lrcode = Lrcode1;
        state = state1;
    }

   

    public void setLbcode(String Lbcode) {
        this.Lbcode = Lbcode;
    }

    public void setLrcode(String Lrcode) {
        this.Lrcode = Lrcode;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getLbcode() {
        return Lbcode;
    }

    public String getLrcode() {
        return Lrcode;
    }

    public int getState() {
        return state;
    }

    @Override
    public String toString() {
        return  Lbcode + "   |   " + Lrcode + "   |  " + state ;
    }    
}
