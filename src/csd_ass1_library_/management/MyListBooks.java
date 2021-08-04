package csd_ass1_library_.management;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.StringTokenizer;

 class MyListBooks {

    Node head, tail;

    MyListBooks() {
        head = tail = null;
    }
    
//===================================
    
    void clear() {
    }

    boolean isEmpty() {
        return head == null;
    }
    
//====================================
    
    void addLast(Books x) {
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
    }
    
//====================================================================
    
    void addFirst(Books x) {
        Node q = new Node(x, head);
        head = q;
        if (tail == null) {
            tail = q.next;
        }
    }
    
//====================================================================
    
    void traverse() {
        Node q = head;
        while (q != null) {
            System.out.println(q.info);
            q = q.next;
        }
    }
    
//=============Đọc dữ liệu từ file==========================================
    
    void loadFromFile(String fname) throws FileNotFoundException, Exception {
        RandomAccessFile f = new RandomAccessFile(fname, "r");
        StringTokenizer t;
        String s, s1, s2, s3, s4, s5;
        int k, l;
        double pp;
        clear();
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
            s4 = t.nextToken();
            l = Integer.parseInt(s4.trim());
            s5 = t.nextToken();
            pp = Double.parseDouble(s5);
            addLast(new Books(s1, s2, k, l, pp));
        }
        f.close();
    }
    
//====================Nhập dữ liệu===========================================
    
    Books enterData() {
        Books b = new Books();
        System.out.println("enter bcode:");
        b.bcode = CSD_ASS1_LIBRARY_MANAGEMENT.checkInputBCODE();
        System.out.println("enter title:");
        b.title = CSD_ASS1_LIBRARY_MANAGEMENT.checkInputString();
        System.out.println("enter quantity:");
        b.quantity = CSD_ASS1_LIBRARY_MANAGEMENT.checkInputInt();
        System.out.println("enter lended codition:lended<quantity:");
        b.lended = CSD_ASS1_LIBRARY_MANAGEMENT.checkInputInt();
        while (b.lended > b.quantity) {
            System.out.println("enter lended codition:lended<quantity:");
            b.lended = CSD_ASS1_LIBRARY_MANAGEMENT.checkInputInt();
        }
        System.out.println("enter price:");
        b.price = CSD_ASS1_LIBRARY_MANAGEMENT.checkInputDouble();

        b = new Books(b.bcode, b.title, b.quantity, b.lended, b.price);
        System.out.println("Successful!");
        return b;
    }
    
//=================Ghi dữ liệu vừa nhập vào file=================================
    
    void saveToFile(String fname) throws FileNotFoundException, IOException {
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
    
//===============================================================================
    
    Node search(String bcodex) {
        Node q = head;
        Books b = new Books();
        while (q != null) {            
            b = (Books) q.getInfo();
            String st1 = b.bcode.trim();
            if (st1.equalsIgnoreCase(bcodex)) {
                return q;
            }
            q = q.next;
        }
        return  q;
    }
    
//==================================================================================
    
    void add(Books x) {
        Node q = search(x.bcode);
        if (q != null) {
            System.out.println("the name " + x.bcode + "is already exists, can't addition");
            return;
        }
        Node p = new Node(x);
        if (isEmpty()) {
            head = tail = p;
            return;
        }
        tail.next = p;
        tail = p;
    }
    
//===========================================================================================
    
    void addToHead(Books x) {
        Node q = search(x.bcode);
        if (q != null) {
            System.out.println("the name " + x.bcode + "is already exists, can't addition");
            return;
        }
        Node p = new Node(x);
        if (isEmpty()) {
            head = tail = p;
            return;
        }
        p.next = head;
        head = p;
    }
    
//================================================================================================
    
    void display() {        
        System.out.printf("%10s%30s%20s%10s%10s%10s", "CODE", "TITLE", "QUANTITY", "LENDED", "PRICE", "VALUES");
        System.out.println();      
        Node p = head;
        Books b = new Books();
        while (p != null) {
            b = (Books) p.getInfo();
            double value = b.price * b.quantity;
            System.out.format("%10s%30s%20s%10d%10.1f%10.1f", b.bcode, b.title, b.quantity, b.lended, b.price, value);
            System.out.println();
            p = p.next;
        }
    }
    
//=====================================================================================================
    
    void delete(String xcode) {
        if (head == null) {
            System.out.println("the given list is empty");
            return;
        }
        Node p = head;
        Books b = (Books) head.getInfo();
        String st = b.bcode.trim();
        if (st.equalsIgnoreCase(xcode)) {
            head = head.next;
            System.out.println("delete successful!");
        } else {
            while (p.next != null) {
                b = (Books) head.next.getInfo();
                String st1 = b.bcode.trim();
                if (st1.equalsIgnoreCase(xcode)) {
                    p.next = p.next.next;
                    System.out.println("delete successful!");
                    return;
                }
                p = p.next;
            }
        }
    }
    
//============================================================================================
    
    void sortByCode() {
        Node pi, pj;
        Books t, bi, bj;
        pi = head;
        while (pi != null) {
            pj = pi.next;
            while (pj != null) {
                bi = (Books) pi.getInfo();
                bj = (Books) pj.getInfo();
                if (bi.bcode.compareTo(bj.bcode) < 0) {
                    t = (Books) pi.info;
                    pi.info = (Books) pj.info;
                    pj.info = t;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }
    
//===========================================================================================
    
    void addAfter(Node prev_node, int x) {
        if (prev_node == null) {
            System.out.println("The given previous node cannot be null");
            return;

        }
        Node new_node = new Node(x);
        new_node.next = prev_node.next;
        prev_node.next = new_node;
    }
    
//=============================================================================================
    
    void addAtPossition(int position) {
        if (head == null) {
            return;
        }
        Node tem = head;
        if (position == 0) {
            head = tem.next;
            return;
        }
        for (int i = 0; tem != null && i < position; i++) {
            tem = tem.next;
        }
        if (tem == null || tem.next == null) {
            System.out.println(" the given list does not have this postion");
            return;
        }
        Books b = enterData();
        Node n = new Node(b);
        n.next = tem.next;
        tem.next = n;
    }
    
//=========================================================================================
    
    int isQuaLend(String bcodex) {
        Node p = search(bcodex);
        Books b = (Books) p.getInfo();
        if (p != null && b.quantity == b.lended) {
            return 1;
        }
        if (p != null && b.quantity < b.lended) {
            return -1;
        }
        return 0;
    }
//===========================================================================================  
    int count(){
         Node q;
      q=head;
      int numberElement=0;
      while(q.next!=tail){         
           numberElement++;
            q=q.next;
            
      }
         return  numberElement;
     }
//==============================================================================================    
     void deleIth(int i) {
         if(i==0) head=head.next;
         if(i>count())System.out.println("can't delete node i-th");
         else{
             Node q;
             q=head;
             int dem=0;
             while(dem!=i-1){
                 q=q.next;
                 dem++;
             }
             q.next=q.next.next;
         }
     }
        //==========================================================================================
    }

