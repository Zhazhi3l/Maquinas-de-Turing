package MaquinasDeTuring;

import java.util.ArrayList;

public class Sumador {
    ArrayList<String> cadena = new ArrayList<>();
    int posCabezal;

    public Sumador(String entrada) {
        entrada = "◻◻◻◻" + entrada + "◻◻◻◻";
        for (int i = 0; i < entrada.length(); i++) {
            cadena.add(entrada.charAt(i) + "");
        }
        posCabezal = 4;
        System.out.println("\033[035mCinta\t\t\t\t\tEdoOrigen\tCaracLeido\tCaracRemp\tEdoDestino\tDirec\033[030m");
        q0();
    }

    @Override
    public String toString() {
        String cinta = "";
        for (int i = 0; i < cadena.size(); i++) {
            if (i == posCabezal) {
                cinta += "\033[31m[" + cadena.get(i) + "]\033[0m";
            } else {
                cinta += cadena.get(i);
            }
        }
        return cinta + "\t\t";
    }

    public void rechazarCadena(String estado) {
        System.out.println("Rechazado en: " + estado);
    }

    public void q0() {
        String caracter = cadena.get(posCabezal);
        switch (caracter) {
            case "0":
                System.out.print(toString());
                cadena.set(posCabezal, "0");
                System.out.println("q0\t\t\t0\t\t\t0\t\t\tq1\t\t\tR");
                posCabezal++;
                q1();
                break;
            case "1":
                System.out.print(toString());
                cadena.set(posCabezal, "1");
                System.out.println("q0\t\t\t1\t\t\t1\t\t\tq1\t\t\tR");
                posCabezal++;
                q1();
                break;
            default:
                rechazarCadena("q0");
        }
    }

    public void q1() {
        String caracter = cadena.get(posCabezal);
        switch (caracter) {
            case "0":
                System.out.print(toString());
                cadena.set(posCabezal, "0");
                System.out.println("q1\t\t\t0\t\t\t0\t\t\tq2\t\t\tR");
                posCabezal++;
                q1();
                break;
            case "1":
                System.out.print(toString());
                cadena.set(posCabezal, "1");
                System.out.println("q1\t\t\t1\t\t\t1\t\t\tq2\t\t\tR");
                posCabezal++;
                q1();
                break;
            case "=":
                System.out.print(toString());
                cadena.set(posCabezal, "=");
                System.out.println("q1\t\t\t=\t\t\t=\t\t\tq2\t\t\tR");
                posCabezal++;
                q2();
                break;
            default:
                rechazarCadena("q1");
        }
    }

    public void q2() {
        String caracter = cadena.get(posCabezal);
        switch (caracter) {
            case "◻":
                System.out.print(toString());
                cadena.set(posCabezal, "◻");
                System.out.println("q2\t\t\t◻\t\t\t◻\t\t\tq3\t\t\tL");
                posCabezal--;
                q3();
                break;
            default:
                rechazarCadena("q2");
        }
    }

    public void q3() {
        String caracter = cadena.get(posCabezal);
        switch (caracter) {
            case "=":
                System.out.print(toString());
                cadena.set(posCabezal, "=");
                System.out.println("q3\t\t\t=\t\t\t=\t\t\tq3\t\t\tL");
                posCabezal--;
                q3();
                break;
            case "1":
                System.out.print(toString());
                cadena.set(posCabezal, "1");
                System.out.println("q3\t\t\t1\t\t\t1\t\t\tq3\t\t\tL");
                posCabezal--;
                q3();
                break;
            case "0":
                System.out.print(toString());
                cadena.set(posCabezal, "0");
                System.out.println("q3\t\t\t0\t\t\t0\t\t\tq3\t\t\tL");
                posCabezal--;
                q3();
                break;
            case"◻":
                System.out.print(toString());
                cadena.set(posCabezal, "◻");
                System.out.println("q3\t\t\t◻\t\t\t◻\t\t\tq4\t\t\tR");
                posCabezal++;
                q4();
                break;
            default:
                rechazarCadena("q3");
        }
    }

    public void q4() {
        String caracter = cadena.get(posCabezal);
        switch (caracter) {
            case "0":
                System.out.print(toString());
                cadena.set(posCabezal, "0");
                System.out.println("q4\t\t\t0\t\t\t0\t\t\tq4\t\t\tR");
                posCabezal++;
                q4();
                break;
            case "1":
                System.out.print(toString());
                cadena.set(posCabezal, "x");
                System.out.println("q4\t\t\t1\t\t\tx\t\t\tq5\t\t\tR");
                posCabezal++;
                q5();
                break;
            case "=":
                System.out.print(toString());
                cadena.set(posCabezal, "=");
                System.out.println("q4\t\t\t=\t\t\t=\t\t\tq11\t\t\tR");
                posCabezal++;
                q11();
                break;
            default:
                rechazarCadena("q4");
        }
    }

    public void q5() {
        String caracter = cadena.get(posCabezal);
        switch (caracter) {
            case "1":
                System.out.print(toString());
                cadena.set(posCabezal, "1");
                System.out.println("q5\t\t\t1\t\t\t1\t\t\tq5\t\t\tR");
                posCabezal++;
                q5();
                break;
            case "0":
                System.out.print(toString());
                cadena.set(posCabezal, "0");
                System.out.println("q5\t\t\t0\t\t\t0\t\t\tq5\t\t\tR");
                posCabezal++;
                q5();
                break;
            case "=":
                System.out.print(toString());
                cadena.set(posCabezal, "=");
                System.out.println("q5\t\t\t=\t\t\t=\t\t\tq6\t\t\tR");
                posCabezal++;
                q6();
                break;
            default:
                rechazarCadena("q5");
        }
    }

    public void q6() {
        String caracter = cadena.get(posCabezal);
        switch (caracter) {
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                System.out.print(toString());
                cadena.set(posCabezal, caracter);
                System.out.println("q6\t\t\t" + caracter + "\t\t\t" + caracter + "\t\t\tq7\t\t\tR");
                posCabezal++;
                q7();
                break;
            case "◻":
                System.out.print(toString());
                cadena.set(posCabezal, "0");
                System.out.println("q6\t\t\t◻\t\t\t0\t\t\tq8\t\t\tR");
                posCabezal++;
                q8();
                break;
            default:
                rechazarCadena("q6");
        }
    }

    public void q7() {
        String caracter = cadena.get(posCabezal);
        switch (caracter) {
            case "0":
                System.out.print(toString());
                cadena.set(posCabezal, "1");
                System.out.println("q7\t\t\t0\t\t\t1\t\t\tq9\t\t\tL");
                posCabezal--;
                q9();
                break;
            case "1":
                System.out.print(toString());
                cadena.set(posCabezal, "2");
                System.out.println("q7\t\t\t1\t\t\t2\t\t\tq9\t\t\tL");
                posCabezal--;
                q9();
                break;
            case "2":
                System.out.print(toString());
                cadena.set(posCabezal, "3");
                System.out.println("q7\t\t\t2\t\t\t3\t\t\tq9\t\t\tL");
                posCabezal--;
                q9();
                break;
            case "3":
                System.out.print(toString());
                cadena.set(posCabezal, "4");
                System.out.println("q7\t\t\t3\t\t\t4\t\t\tq9\t\t\tL");
                posCabezal--;
                q9();
                break;
            case "4":
                System.out.print(toString());
                cadena.set(posCabezal, "5");
                System.out.println("q7\t\t\t4\t\t\t5\t\t\tq9\t\t\tL");
                posCabezal--;
                q9();
                break;
            case "5":
                System.out.print(toString());
                cadena.set(posCabezal, "6");
                System.out.println("q7\t\t\t5\t\t\t6\t\t\tq9\t\t\tL");
                posCabezal--;
                q9();
                break;
            case "6":
                System.out.print(toString());
                cadena.set(posCabezal, "7");
                System.out.println("q7\t\t\t6\t\t\t7\t\t\tq9\t\t\tL");
                posCabezal--;
                q9();
                break;
            case "7":
                System.out.print(toString());
                cadena.set(posCabezal, "8");
                System.out.println("q7\t\t\t7\t\t\t8\t\t\tq9\t\t\tL");
                posCabezal--;
                q9();
                break;
            case "8":
                System.out.print(toString());
                cadena.set(posCabezal, "9");
                System.out.println("q7\t\t\t8\t\t\t9\t\t\tq9\t\t\tL");
                posCabezal--;
                q9();
                break;
            case "9":
                System.out.print(toString());
                cadena.set(posCabezal, "0");
                System.out.println("q7\t\t\t9\t\t\t0\t\t\tq8\t\t\tL");
                posCabezal--;
                q8();
                break;
            default:
                rechazarCadena("q7");
        }
    }

    public void q8() {
        String caracter = cadena.get(posCabezal);
        switch (caracter) {
            case "◻":
                System.out.print(toString());
                cadena.set(posCabezal, "1");
                System.out.println("q8\t\t\t◻\t\t\t1\t\t\tq9\t\t\tL");
                posCabezal--;
                q9();
                break;
            case "0":
                System.out.print(toString());
                cadena.set(posCabezal, "1");
                System.out.println("q8\t\t\t0\t\t\t1\t\t\tq9\t\t\tL");
                posCabezal--;
                q9();
                break;
            case "1":
                System.out.print(toString());
                cadena.set(posCabezal, "2");
                System.out.println("q8\t\t\t1\t\t\t2\t\t\tq9\t\t\tL");
                posCabezal--;
                q9();
                break;
            case "2":
                System.out.print(toString());
                cadena.set(posCabezal, "3");
                System.out.println("q8\t\t\t2\t\t\t3\t\t\tq9\t\t\tL");
                posCabezal--;
                q9();
                break;
            case "3":
                System.out.print(toString());
                cadena.set(posCabezal, "4");
                System.out.println("q8\t\t\t3\t\t\t4\t\t\tq9\t\t\tL");
                posCabezal--;
                q9();
                break;
            case "4":
                System.out.print(toString());
                cadena.set(posCabezal, "5");
                System.out.println("q8\t\t\t4\t\t\t5\t\t\tq9\t\t\tL");
                posCabezal--;
                q9();
                break;
            case "5":
                System.out.print(toString());
                cadena.set(posCabezal, "6");
                System.out.println("q8\t\t\t5\t\t\t6\t\t\tq9\t\t\tL");
                posCabezal--;
                q9();
                break;
            case "6":
                System.out.print(toString());
                cadena.set(posCabezal, "7");
                System.out.println("q8\t\t\t6\t\t\t7\t\t\tq9\t\t\tL");
                posCabezal--;
                q9();
                break;
            case "7":
                System.out.print(toString());
                cadena.set(posCabezal, "8");
                System.out.println("q8\t\t\t7\t\t\t8\t\t\tq9\t\t\tL");
                posCabezal--;
                q9();
                break;
            case "8":
                System.out.print(toString());
                cadena.set(posCabezal, "9");
                System.out.println("q8\t\t\t8\t\t\t9\t\t\tq9\t\t\tL");
                posCabezal--;
                q9();
                break;
            default:
                rechazarCadena("q8");
        }
    }

    public void q9() {
        String caracter = cadena.get(posCabezal);
        switch (caracter) {
            case "=":
                System.out.print(toString());
                cadena.set(posCabezal, "=");
                System.out.println("q9\t\t\t=\t\t\t=\t\t\tq10\t\t\tL");
                posCabezal--;
                q10();
                break;
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                System.out.print(toString());
                cadena.set(posCabezal, caracter);
                System.out.println("q9\t\t\t" + caracter + "\t\t\t" + caracter + "\t\t\tq9\t\t\tL");
                posCabezal--;
                q9();
                break;
            default:
                rechazarCadena("q9");
        }
    }

    public void q10() {
        String caracter = cadena.get(posCabezal);
        switch (caracter) {
            case "x":
                System.out.print(toString());
                cadena.set(posCabezal, "x");
                System.out.println("q10\t\t\tx\t\t\tx\t\t\tq4\t\t\tR");
                posCabezal++;
                q4();
                break;
            case "0":
            case "1":
                System.out.print(toString());
                cadena.set(posCabezal, caracter);
                System.out.println("q10\t\t\t" + caracter + "\t\t\t" + caracter + "\t\t\tq10\t\t\tL");
                posCabezal--;
                q10();
                break;
            default:
                rechazarCadena("q10");
        }
    }

    public void q11() {
        String caracter = cadena.get(posCabezal);
        switch (caracter) {
            case "◻":
                System.out.print(toString());
                cadena.set(posCabezal, "0");
                System.out.println("q11\t\t\t◻\t\t\t0\t\t\tq12\t\t\tL");
                posCabezal--;
                q12();
                break;
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                System.out.print(toString());
                cadena.set(posCabezal, caracter);
                System.out.println("q11\t\t\t" + caracter + "\t\t\t" + caracter + "\t\t\tq13\t\t\tL");
                posCabezal--;
                q13();
                break;
            default:
                rechazarCadena("q11");
        }
    }

    public void q12() {
        String caracter = cadena.get(posCabezal);
        switch (caracter) {
            case "=":
                System.out.print(toString());
                cadena.set(posCabezal, "=");
                System.out.println("q12\t\t\t=\t\t\t=\t\t\tq13\t\t\tL");
                posCabezal--;
                q13();
                break;
            default:
                rechazarCadena("q12");
        }
    }

    public void q13() {
        String caracter = cadena.get(posCabezal);
        switch (caracter) {
            case "x":
                System.out.print(toString());
                cadena.set(posCabezal, "1");
                System.out.println("q13\t\t\tx\t\t\t1\t\t\tq13\t\t\tL");
                posCabezal--;
                q13();
                break;
            case "=":
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                System.out.print(toString());
                cadena.set(posCabezal, caracter);
                System.out.println("q13\t\t\t" + caracter + "\t\t\t" + caracter + "\t\t\tq13\t\t\tL");
                posCabezal--;
                q13();
                break;
            case "◻":
                System.out.print(toString());
                cadena.set(posCabezal, "◻");
                System.out.println("q13\t\t\t◻\t\t\t◻\t\t\tq14\t\t\tR");
                posCabezal++;
                q14();
                break;
            default:
                rechazarCadena("q13");
        }
    }

    public void q14() {
        System.out.print(toString());
        System.out.println("q14");
        System.out.println("\033[32mCADENA ACEPTADA\033[0m"); // Verde
    }

    public static void main(String[] args) {
        Sumador cadena1 = new Sumador("1011=");
        Sumador cadena2 = new Sumador("0101010101010101010101=");
    }
}
