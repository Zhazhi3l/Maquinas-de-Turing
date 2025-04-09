package AutomataFDFecha;

import java.util.ArrayList;

public class MT {
    ArrayList<String> cadena = new ArrayList<>();
    int cabezal;

    public MT(String input){
        input= "□□□□"+input+"□□□□";
        for (int i = 0; i < input.length(); i++) {
            cadena.add(input.substring(i, i+1));
        }
        cabezal=4;
        System.out.println("\033[034m\t\tEdoOrigen\tCaracLeido\tCaracRemp\tEdoDestino\tDirec\033[030m");
        q0();
    }

    public void q0(){
        if (cadena.get(cabezal).equals("")) {
            System.out.println("q0\t\t"+cadena.get(cabezal)+"\t□"+"\tq0\tR");
            System.out.println("RECHAZADA");
        }else if (cadena.get(cabezal).equals("0")){
            System.out.print(tostring());
            cadena.set(cabezal, "□");
            System.out.println("q0\t\t0\t\t□\t\tq6\t\tR");
            cadena.remove(0);
            q6();
        }else if (cadena.get(cabezal).equals("1")){
            System.out.print(tostring());
            cadena.set(cabezal, "0");
            System.out.println("q0\t\t1\t\t0\t\tq1\t\tR");
            cabezal++;
            q1();
        }else if (cadena.get(cabezal).equals("2")){
            System.out.print(tostring());
            cadena.set(cabezal, "1");
            System.out.println("q0\t\t2\t\t1\t\tq2\t\tR");
            cabezal++;
            q2();
        }else if (cadena.get(cabezal).equals("3")){
            System.out.print(tostring());
            cadena.set(cabezal, "2");
            System.out.println("q0\t\t3\t\t2\t\tq2\t\tR");
            cabezal++;
            q2();
        }else if (cadena.get(cabezal).equals("4")){
            System.out.print(tostring());
            cadena.set(cabezal, "3");
            System.out.println("q0\t\t4\t\t3\t\tq2\t\tR");
            cabezal++;
            q2();
        }else if (cadena.get(cabezal).equals("5")){
            System.out.print(tostring());
            cadena.set(cabezal, "4");
            System.out.println("q0\t\t5\t\t4\t\tq2\t\tR");
            cabezal++;
            q2();
        }else if (cadena.get(cabezal).equals("6")){
            System.out.print(tostring());
            cadena.set(cabezal, "5");
            System.out.println("q0\t\t6\t\t5\t\tq2\t\tR");
            cabezal++;
            q2();
        }else if (cadena.get(cabezal).equals("7")){
            System.out.print(tostring());
            cadena.set(cabezal, "6");
            System.out.println("q0\t\t7\t\t6\t\tq2\t\tR");
            cabezal++;
            q2();
        }else if (cadena.get(cabezal).equals("8")){
            System.out.print(tostring());
            cadena.set(cabezal, "7");
            System.out.println("q0\t\t8\t\t7\t\tq2\t\tR");
            cabezal++;
            q2();
        }else if (cadena.get(cabezal).equals("9")){
            System.out.print(tostring());
            cadena.set(cabezal, "8");
            System.out.println("q0\t\t9\t\t8\t\tq2\t\tR");
            cabezal++;
            q2();
        }
    }

    public void q1(){
        if (cadena.get(cabezal).equals("")) {
            System.out.print(tostring());
            System.out.println("Cadena Rechazada");
        }else if (cadena.get(cabezal).equals("=")){
            System.out.print(tostring());
            cadena.set(cabezal, "=");
            System.out.println("q1\t\t=\t\t=\t\tq4\t\tR");
            cabezal++;
            q4();
        }else if (cadena.get(cabezal).equals("0")){
            System.out.print(tostring());
            cadena.set(cabezal, "9");
            System.out.println("q1\t\t0\t\t9\t\tq3\t\tR");
            cabezal++;
            q3();
        }
    }

    public void q2(){
        if (cadena.get(cabezal).equals("")) {
            System.out.print(tostring());
            System.out.println("Cadena Rechazada");
        }else if (cadena.get(cabezal).equals("=")){
            System.out.print(tostring());
            System.out.println("q2\t\t=\t\t=\t\tq4\t\tR");
            cabezal++;
            q4();
        }
    }

    public void q3(){
        if (cadena.get(cabezal).equals("")) {
            System.out.print(tostring());
            System.out.println("Cadena Rechazada");
        }else if (cadena.get(cabezal).equals("=")){
            System.out.print(tostring());
            cadena.set(cabezal, "=");
            System.out.println("q3\t\t=\t\t=\t\tq4\t\tR");
            cabezal++;
            q4();
        }
    }

    public void q4(){
        if (cadena.get(cabezal).equals("1")){
            System.out.print(tostring());
            cadena.set(cabezal, "1");
            System.out.println("q4\t\t1\t\t1\t\tq4\t\tR");
            cabezal++;
            q4();
        }else if (cadena.get(cabezal).equals("□")){
            System.out.print(tostring());
            cadena.set(cabezal, "1");
            System.out.println("q4\t\t□\t\t1\t\tq8\t\tL");
            cadena.add("□");
            cabezal--;
            q7();
        }
    }

    public void q7(){
        if (cadena.get(cabezal).equals("1")){
            System.out.print(tostring());
            cadena.set(cabezal, "1");
            System.out.println("q8\t\t1\t\t1\t\tq8\t\tL");
            cabezal--;
            q7();
        }else if (cadena.get(cabezal).equals("=")){
            System.out.print(tostring());
            cadena.set(cabezal, "=");
            System.out.println("q8\t\t=\t\t=\t\tq5\t\tL");
            cabezal--;
            q5();
        }
    }

    public void q5(){
        if (cadena.get(cabezal).equals("1")){
            System.out.print(tostring());
            cadena.set(cabezal, "1");
            System.out.println("q5\t\t1\t\t1\t\tq0\t\tS");
            q0();
        }else if (cadena.get(cabezal).equals("2")){
            System.out.print(tostring());
            cadena.set(cabezal, "2");
            System.out.println("q5\t\t2\t\t1\t\tq2\t\tS");
            q0();
        }else if (cadena.get(cabezal).equals("3")){
            System.out.print(tostring());
            cadena.set(cabezal, "3");
            System.out.println("q5\t\t3\t\t3\t\tq0\t\tS");
            q0();
        }else if (cadena.get(cabezal).equals("4")){
            System.out.print(tostring());
            cadena.set(cabezal, "4");
            System.out.println("q5\t\t4\t\t4\t\tq0\t\tS");
            q0();
        }else if (cadena.get(cabezal).equals("5")){
            System.out.print(tostring());
            cadena.set(cabezal, "5");
            System.out.println("q5\t\t5\t\t5\t\tq2\t\tS");
            q0();
        }else if (cadena.get(cabezal).equals("6")){
            System.out.print(tostring());
            cadena.set(cabezal, "6");
            System.out.println("q5\t\t6\t\t6\t\tq0\t\tS");
            q0();
        }else if (cadena.get(cabezal).equals("7")){
            System.out.print(tostring());
            cadena.set(cabezal, "7");
            System.out.println("q5\t\t7\t\t7\t\tq0\t\tS");
            q0();
        }else if (cadena.get(cabezal).equals("8")){
            System.out.print(tostring());
            cadena.set(cabezal, "8");
            System.out.println("q5\t\t8\t\t8\t\tq0\t\tS");
            q0();
        }else if (cadena.get(cabezal).equals("9")){
            System.out.print(tostring());
            cadena.set(cabezal, "9");
            System.out.println("q5\t\t9\t\t9\t\tq0\t\tS");
            q0();
        }else if (cadena.get(cabezal).equals("0")){
            System.out.print(tostring());
            cadena.set(cabezal, "□");
            System.out.println("q5\t\t0\t\t□\t\tq6\t\tR");
            cadena.remove(0);
            q6();
        }
    }

    public void q6(){
        System.out.print(tostring());
        System.out.println("q6\t\t"+cadena.get(cabezal)+"\t\t"+cadena.get(cabezal)+"\t\tq6\t\t");
        System.out.println("\033[032mACEPTADA");
    }

    public String tostring() {
        String cinta="";
        for (int i = 0; i<cadena.size(); i++) {
            if(i==cabezal){
                cinta+="\033[031m["+cadena.get(i)+"]\033[030m";
            }else{
                cinta+=cadena.get(i);
            }
        }
        return cinta+"\t";
    }

    public static void main(String[] args) {
        MT obj1 = new MT("2=");
       // MT obj2 = new MT("8=");
       // MT obj3 = new MT("3=1");
    }
}
