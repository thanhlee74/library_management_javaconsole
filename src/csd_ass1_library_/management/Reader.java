package csd_ass1_library_.management;







public class Reader extends Books{
    String rcode,name;
    int byear;

    public Reader() {
    }

    public Reader(String rcode1, String name1, int byear1) {
     rcode = rcode1;
        name = name1;
        byear = byear1;
    }

    public String getRcode() {
        return rcode;
    }

    public String getName() {
        return name;
    }

    public int getByear() {
        return byear;
    }

    @Override
    public String toString() {
        return   rcode + "  |  " + name + "  |  " + byear ;
    }
    
}
