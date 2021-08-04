package csd_ass1_library_.management;





import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.StringTokenizer;

public class MyListLending {

    Node head, tail;

    public MyListLending() {
        head = tail = null;
    }

    void clear2() {
    }

    boolean isEmpty2() {
        return head == null;
    }
//=================================================================================
    void traverse2() {
        Node q = head;
        while (q != null) {
            System.out.println(q.info);
            q = q.next;
        }
    }
//====================================================================================
    void addLast2(Lending x) {
        Node q = new Node(x);
        if (isEmpty2()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;

    }
//=====================================================================================
    void addFirst2(Lending x) {
        Node q = new Node(x, head);
        head = q;
        if (tail == null) {
            tail = q.next;
        }
    }
//=================================================================================
    Node search2(String rcodex) {
        Node q = head;
        Lending r = new Lending();
        while (q != null) {
            r = (Lending) q.getInfo();
            String st1 = r.Lrcode.trim();
            if (st1.equalsIgnoreCase(rcodex) && r.state == 1) {
                return q;
            }
            q = q.next;
        }
        return q;
    }
//============================================================================
    Node search3(String bcodex) {
        Node q = head;
        Lending r = new Lending();
        while (q != null) {
            r = (Lending) q.getInfo();
            String st1 = r.Lbcode.trim();
            if (st1.equalsIgnoreCase(bcodex) && r.state == 1) {
                return q;
            }
            q = q.next;
        }
        return q;
    }
//========================================================================================
    Lending enterdata2() throws Exception {
        MyListBooks mlb1 = new MyListBooks();
        MyListReader mlr1 = new MyListReader();
        mlb1.loadFromFile("book.txt");
        mlr1.loadFromFile1("reader.txt");
        Lending l = new Lending();
        System.out.println("enter book code:");
        l.Lbcode = CSD_ASS1_LIBRARY_MANAGEMENT.checkInputBCODE();
        System.out.println("enter reader code:");
        l.Lrcode = CSD_ASS1_LIBRARY_MANAGEMENT.checkInputRCODE();
        while ((mlb1.search(l.Lbcode) == null) || (mlr1.search1(l.Lrcode) == null)) {
            System.out.println("Bcode Or Rcode Not Exists");
            System.out.println("Enter again:");
            System.out.println("enter book code:");
            l.Lbcode = CSD_ASS1_LIBRARY_MANAGEMENT.checkInputBCODE();
            System.out.println("enter reader code:");
            l.Lrcode = CSD_ASS1_LIBRARY_MANAGEMENT.checkInputRCODE();
        }
        while  ((search3(l.Lbcode)) != null && (search2(l.Lrcode) != null)) {
            System.out.println(" data is not accepted!, because you have not returned the book");
            System.out.println("enter book code:");
            l.Lbcode = CSD_ASS1_LIBRARY_MANAGEMENT.checkInputBCODE();
            System.out.println("enter reader code:");
            l.Lrcode = CSD_ASS1_LIBRARY_MANAGEMENT.checkInputRCODE();
                    
        } 
            Books b = new Books();
            b = (Books) mlb1.search(l.Lbcode).getInfo();
            if (b.quantity == b.lended) {
                l = new Lending(l.Lbcode, l.Lrcode, 0);
            }
            if (b.quantity > b.lended) {
                l = new Lending(l.Lbcode, l.Lrcode, 1);
            }
        
        return l;
    }
//====================================================================================
    void display2() {

        System.out.printf("%10s%10s%10s", "BCODE", "RCODE", "STATE");
        System.out.println();

        Node p = head;
        Lending l = new Lending();
        while (p != null) {
            l = (Lending) p.getInfo();
            System.out.format("%10s%10s%10d", l.Lbcode, l.Lrcode, l.state);
            System.out.println();
            p = p.next;
        }
    }
//=================================================================================
    void sortByCode3() {
        Node pi, pj;
        Lending t, bi, bj;
        pi = head;
        while (pi != null) {
            pj = pi.next;
            while (pj != null) {
                bi = (Lending) pi.getInfo();
                bj = (Lending) pj.getInfo();

                if (bi.Lbcode.compareTo(bj.Lbcode) < 0) {
                    t = (Lending) pi.info;
                    pi.info = (Lending) pj.info;
                    pj.info = t;

                } else {
                    if (bi.Lbcode.compareTo(bj.Lbcode) == 0) {
                        if (bi.Lrcode.compareTo(bj.Lrcode) < 0) {
                            t = (Lending) pi.info;
                            pi.info = (Lending) pj.info;
                            pj.info = t;

                        }
                    }
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }
//====================================================================================
    void loadFromFile2(String fname) throws FileNotFoundException, Exception {
        RandomAccessFile f = new RandomAccessFile(fname, "r");
        StringTokenizer t;
        String s, s1, s2, s3;
        int k;
        clear2();
        while (true) {
            s = f.readLine();
            if (s == null) {
                break;
            }
            if (s.trim().length() < 5) {
                continue;
            }
            t = new StringTokenizer(s, "|");
            s1 = t.nextToken();
            s2 = t.nextToken();
            s3 = t.nextToken();
            k = Integer.parseInt(s3.trim());
            addLast2(new Lending(s1, s2, k));
        }
        f.close();
    }
}
