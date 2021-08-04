package csd_ass1_library_.management;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.StringTokenizer;


public class MyListReader {
    Node head, tail;

    public MyListReader() {
        head=tail=null;
    }
     void clear1() {
    }

    boolean isEmpty1() {
        return head == null;
    }
    void traverse1() {
        Node q = head;
        while (q != null) {
            System.out.println(q.info);
            q = q.next;
        }
    }
     void addLast1(Reader x) {
        Node q = new Node(x);
        if (isEmpty1()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
    }
//=================================================================================
void loadFromFile1(String fname) throws FileNotFoundException, Exception {
        RandomAccessFile f = new RandomAccessFile(fname, "r");
        StringTokenizer t;
        String s, s1, s2, s3;
        int k;        
        clear1();
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
            addLast1(new Reader(s1, s2, k));
        }
        f.close();
    }   
//===================================================================================
Reader enterData1(){
    Reader r=new Reader();
    System.out.println("enter rcode:");
    r.rcode=CSD_ASS1_LIBRARY_MANAGEMENT.checkInputRCODE();
    System.out.println("enter name:");
    r.name=CSD_ASS1_LIBRARY_MANAGEMENT.checkInputString();
    System.out.println("enter birth year:");
    r.byear=CSD_ASS1_LIBRARY_MANAGEMENT.checkInputBYEAR();
    r=new Reader(r.rcode,r.name,r.byear);
    System.out.println("enter successful!");
    return r;
}
//==================================================================================
  void display1() {      
        System.out.printf("%10s%30s%20s", "CODE", "NAME", "BIRTH YEAR");
        System.out.println();
       Node p = head;
        Reader r =new Reader();
        while (p != null) {
           r=(Reader) p.getInfo();          
            System.out.format("%10s%30s%20d",r.rcode,r.name,r.byear );
            System.out.println();
            p = p.next;
        }
    }
//====================================================================================
   void saveToFile1(String fname) throws FileNotFoundException, IOException {
        File f = new File(fname);
        if (f.exists()) {
            f.delete();
        }
        RandomAccessFile g = new RandomAccessFile(fname, "rw");
        Node q = head;
        while (q != null) {
            g.writeBytes(q.info + "\r\n");
            System.out.println(q.info);
            q = q.next;
        }
        g.close();
    }
//===================================================================================
 Node search1(String rcodex) {
        Node q = head;
       Reader r=new Reader();
        while (q != null) {            
           r=(Reader) q.getInfo();
            String st1 = r.rcode.trim();
            if (st1.equalsIgnoreCase(rcodex)) {
                return q;
            }
            q = q.next;
        }
        return  q;
    } 
//=================================================================================
  void delete1(String xcode) {
        if (head == null) {
            System.out.println("the given list is empty");
            return;
        }
        Node p = head;
        Reader r = (Reader) head.getInfo();
        String st = r.rcode.trim();
        if (st.equalsIgnoreCase(xcode)) {
            head = head.next;
            System.out.println("delete successful!");
        } else {
            while (p.next != null) {
                r= (Reader) head.next.getInfo();
                String st1 = r.rcode.trim();
                if (st1.equalsIgnoreCase(xcode)) {
                    p.next = p.next.next;
                    System.out.println("delete successful!");
                    return;
                }
                p = p.next;
            }
        }
    }
  //==============================================================================   
}
