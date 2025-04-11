package MTOperacionesBasicas;

import javax.swing.*;
import java.util.ArrayList;

public class MTOperaciones {
    ArrayList<String> cadena = new ArrayList<>();
    int posCabezal;
    String estado;

    /*Caracter por default del cuadrito vacio para no estarlo poniendo a cada rato*/
    String c="◻";

    public MTOperaciones(String entrada) {
        entrada = "◻◻◻◻" + entrada + "◻◻◻◻";
        for (int i = 0; i < entrada.length(); i++) {
            cadena.add(entrada.charAt(i) + "");
        }
        posCabezal = 4;
        estado = "q0";
        System.out.print("\033[035mCinta\t\t\t\t\tEdoOrigen\tCaracLeido\tCaracRemp\tEdoDestino\tDirec\033[030m");
        correrMaquina();
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
        this.estado = "rechazado";
    }

    public void aceptarCadena(String estado){
        System.out.println("\033[032mACEPTADA");
        this.estado = "aceptado";
    }

    /**
     * Funcionamiento del Switch principal por estados.
     * El metodo trabaja con estados como String que definen como se va a estar simulando
     * como una máquina de Turing. En este caso valida en un Switch cada estado según la
     * máquina de Turing.
     * ---------------------------------------------------------------------
     * Funcionamiento del Switch por caracter.
     * Los swtiches que están dentro del switch de cada estado revisan los casos que valida
     * la máquina de turing, de ahí que utilice el caracter que le otorgue el cabezal según
     * la posicion en la que se encuentre.
     * ---------------------------------------------------------------------
     * Funcionamiento del cabezal.
     * * Cuando el cabezal avanza hacia R, el cabezal aumenta (posCabezal++).
     * * Y se imprime la indicación entre la trancisión entre estados.
     * ---------------------------------------------------------------------
     * Funcionamiento del cabezal.
     * * Cuando el cabezal retrocede hacia L, el cabezal disminuye (posCabezal--).
     * * Y se imprime la indicación entre la trancisión entre estados.
     * ---------------------------------------------------------------------
     * Funcionamiento de aceptar cadena
     * * Se utiliza en los estados de aceptación al igual que rechazarCadena, recibe
     * * como parametros el estado actual e imprime cadena aceptada y modifica el estado a "aceptado"
     */
    public void correrMaquina() {
        while (!estado.equals("rechazado") && !estado.equals("aceptado")) {
            String caracter = cadena.get(posCabezal);
            switch (estado) {
                case "q0":
                    switch (caracter) {
                        case "0":
                            System.out.println(toString());
                            cadena.set(posCabezal, "0");
                            System.out.println("q0\t\t\t0\t\t\t0\t\t\tq1\t\t\tR");
                            posCabezal++;
                            estado = "q1";
                            break;
                        case "1":
                            System.out.println(toString());
                            cadena.set(posCabezal, "1");
                            System.out.println("q0\t\t\t1\t\t\t1\t\t\tq1\t\t\tR");
                            posCabezal++;
                            estado = "q1";
                            break;
                        default:
                            rechazarCadena(estado);
                            break;
                    }
                    break;
                case "q1":
                    switch (caracter) {
                        case "0":
                            System.out.println(toString());
                            cadena.set(posCabezal, "0");
                            System.out.println("q1\t\t\t0\t\t\t0\t\t\tq1\t\t\tR");
                            posCabezal++;
                            estado = "q1";
                            break;
                        case "1":
                            System.out.println(toString());
                            cadena.set(posCabezal, "1");
                            System.out.println("q1\t\t\t1\t\t\t1\t\t\tq1\t\t\tR");
                            posCabezal++;
                            estado = "q1";
                            break;
                        case "*":
                            System.out.println(toString());
                            cadena.set(posCabezal, "*");
                            System.out.println("q1\t\t\t*\t\t\t*\t\t\tq3\t\t\tL");
                            posCabezal--;
                            estado = "q3";
                            break;
                        case "+":

                            break;
                        case "-":
                            System.out.println(toString());
                            cadena.set(posCabezal, "-");
                            System.out.println("\t\t\tq1\t\t-\t\t-\t\tq2\t\tL");
                            posCabezal--;
                            estado = "q2";
                            break;
                        default:
                            rechazarCadena(estado);
                            break;
                    }
                    break;
                case "q2":
                    System.out.println(toString());
                    if (caracter.equals("0") || caracter.equals("1")) {
                        cadena.set(posCabezal, caracter);
                        System.out.println("\t\t\tq2\t\t" + caracter + "\t\t" + caracter + "\t\tq2\t\tL");
                        posCabezal--;
                        estado="q2";
                    } else if (caracter.equals(c)) {
                        cadena.set(posCabezal, "#");
                        System.out.println("\t\t\tq2\t\t" + c + "\t\t#\t\tq2\t\tR");
                        posCabezal++;
                        estado = "q4";
                    } else {
                        rechazarCadena(estado);

                    }
                    break;
                case "q3":
                    switch (caracter) {
                        case "0":
                            System.out.println(toString());
                            cadena.set(posCabezal, "0");
                            System.out.println("q3\t\t\t0\t\t\t0\t\t\tq3\t\t\tL");
                            posCabezal--;
                            estado = "q3";
                            break;
                        case "1":
                            System.out.println(toString());
                            cadena.set(posCabezal, "1");
                            System.out.println("q3\t\t\t1\t\t\t1\t\t\tq3\t\t\tL");
                            posCabezal--;
                            estado = "q3";
                            break;
                        case "◻":
                            System.out.println(toString());
                            cadena.set(posCabezal, "◻");
                            System.out.println("q3\t\t\t◻\t\t\t◻\t\t\tq47\t\t\tR");
                            posCabezal++;
                            estado = "q47";
                            break;
                        default:
                            rechazarCadena(estado);
                            break;
                    }
                    break;
                case "q4":
                    System.out.println(toString());
                    if (caracter.equals("0") || caracter.equals("1")) {
                        cadena.set(posCabezal, caracter);
                        System.out.println("\t\t\tq4\t\t" + caracter + "\t\t" + caracter + "\t\tq5\t\tR");
                        posCabezal++;
                        estado = "q5";
                    } else {
                        rechazarCadena(estado);
                    }
                    break;
                case "q5":
                    System.out.println(toString());
                    if (caracter.equals("0") || caracter.equals("1")) {
                        cadena.set(posCabezal, caracter);
                        System.out.println("\t\t\tq5\t\t" + caracter + "\t\t" + caracter + "\t\tq5\t\tR");
                        posCabezal++;
                        estado="q5";
                    } else if (caracter.equals("-")) {
                        cadena.set(posCabezal, "-");
                        System.out.println("\t\t\tq5\t\t-\t\t-\t\tq6\t\tR");
                        posCabezal++;
                        estado = "q6";
                    } else {
                        rechazarCadena(estado);
                    }
                    break;
                case "q6":
                    System.out.println(toString());
                    if (caracter.equals("0") || caracter.equals("1")) {
                        cadena.set(posCabezal, caracter);
                        System.out.println("\t\t\tq6\t\t" + caracter + "\t\t" + caracter + "\t\tq7\t\tR");
                        posCabezal++;
                        estado = "q7";
                    } else {
                        rechazarCadena(estado);

                    }
                    break;
                case "q7":
                    System.out.println(toString());
                    if (caracter.equals("0") || caracter.equals("1")) {
                        cadena.set(posCabezal, caracter);
                        System.out.println("\t\t\tq7\t\t" + caracter + "\t\t" + caracter + "\t\tq7\t\tR");
                        posCabezal++;
                        estado="q7";
                    } else if (caracter.equals("=")) {
                        cadena.set(posCabezal, "=");
                        System.out.println("\t\t\tq7\t\t=\t\t=\t\tq8\t\tR");
                        posCabezal++;
                        estado = "q8";
                    } else {
                        rechazarCadena(estado);
                    }
                    break;
                case "q8":
                    System.out.println(toString());
                    if (caracter.equals(c)) {
                        cadena.set(posCabezal, c);
                        System.out.println("\t\t\tq8\t\t" + c + "\t\t" + c + "\t\tq9\t\tL");
                        posCabezal--;
                        estado = "q9";
                    } else {
                        rechazarCadena(estado);
                    }
                    break;
                case "q9":
                    System.out.println(toString());
                    if (caracter.equals("0") || caracter.equals("1") || caracter.equals("=")) {
                        cadena.set(posCabezal, caracter);
                        System.out.println("\t\t\tq9\t\t" + caracter + "\t\t" + caracter + "\t\tq9\t\tL");
                        posCabezal--;
                    } else if (caracter.equals("-")) {
                        cadena.set(posCabezal, "-");
                        System.out.println("\t\t\tq9\t\t-\t\t-\t\tq10\t\tR");
                        posCabezal++;
                        estado = "q10";
                    } else {
                        rechazarCadena(estado);
                    }
                    break;
                case "q10":
                    System.out.println(toString());
                    if (caracter.equals("0") || caracter.equals("x")) {
                        cadena.set(posCabezal, caracter);
                        System.out.println("\t\t\tq10\t\t" + caracter + "\t\t" + caracter + "\t\tq10\t\tR");
                        posCabezal++;
                    } else if (caracter.equals("=")) {
                        cadena.set(posCabezal, "=");
                        System.out.println("\t\t\tq10\t\t=\t\t=\t\tq16\t\tL");
                        posCabezal--;
                        estado = "q16";
                    } else if (caracter.equals("1")) {
                        cadena.set(posCabezal, "x");
                        System.out.println("\t\t\tq10\t\t1\t\tx\t\tq11\t\tL");
                        posCabezal--;
                        estado = "q11";
                    } else {
                        rechazarCadena(estado);
                    }
                    break;
                case "q11":
                    System.out.println(toString());
                    if (caracter.equals("0") || caracter.equals("x")) {
                        cadena.set(posCabezal, caracter);
                        System.out.println("\t\t\tq11\t\t" + caracter + "\t\t" + caracter + "\t\tq11\t\tL");
                        posCabezal--;
                    } else if (caracter.equals("-")) {
                        cadena.set(posCabezal, "-");
                        System.out.println("\t\t\tq11\t\t-\t\t-\t\tq12\t\tL");
                        posCabezal--;
                        estado = "q12";
                    } else {
                        rechazarCadena(estado);
                    }
                    break;
                case "q12":
                    System.out.println(toString());
                    if (caracter.equals("0")) {
                        cadena.set(posCabezal, "0");
                        System.out.println("\t\t\tq12\t\t0\t\t0\t\tq12\t\tL");
                        posCabezal--;
                        estado = "q12";
                    } else if (caracter.equals("x")) {
                        cadena.set(posCabezal, "x");
                        System.out.println("\t\t\tq12\t\tx\t\tx\t\tq12\t\tL");
                        posCabezal--;
                        estado = "q12";
                    } else if (caracter.equals("#")) {
                        cadena.set(posCabezal, c);
                        System.out.println("\t\t\tq12\t\t#\t\t" + c + "\t\tq17\t\tR");
                        posCabezal++;
                        estado = "q17";
                    } else if (caracter.equals(c)) {
                        cadena.set(posCabezal, c);
                        System.out.println("\t\t\tq12\t\t" + c + "\t\t" + c + "\t\tq14\t\tR");
                        posCabezal++;
                        estado = "q14";
                    } else if (caracter.equals("1")) {
                        cadena.set(posCabezal, "x");
                        System.out.println("\t\t\tq12\t\t1\t\tx\t\tq13\t\tR");
                        posCabezal++;
                        estado = "q13";
                    } else {
                        rechazarCadena(estado);
                    }
                    break;
                case "q13":
                    System.out.println(toString());
                    if (caracter.equals("0")) {
                        cadena.set(posCabezal, "0");
                        System.out.println("\t\t\tq13\t\t0\t\t0\t\tq13\t\tR");
                        posCabezal++;
                        estado = "q13";
                    } else if (caracter.equals("x")) {
                        cadena.set(posCabezal, "x");
                        System.out.println("\t\t\tq13\t\tx\t\tx\t\tq13\t\tR");
                        posCabezal++;
                        estado = "q13";
                    } else if (caracter.equals("-")) {
                        cadena.set(posCabezal, "-");
                        System.out.println("\t\t\tq13\t\t-\t\t-\t\tq10\t\tR");
                        posCabezal++;
                        estado = "q10";
                    } else {
                        rechazarCadena(estado);
                    }
                    break;
                case "q14":
                    System.out.println(toString());
                    if (caracter.equals("-")) {
                        cadena.set(posCabezal, c);
                        System.out.println("\t\t\tq14\t\t-\t\t" + c + "\t\tq14\t\tR");
                        posCabezal++;
                        estado = "q14";
                    } else if (caracter.equals("x")) {
                        cadena.set(posCabezal, "x");
                        System.out.println("\t\t\tq14\t\tx\t\tx\t\tq14\t\tR");
                        posCabezal++;
                        estado = "q14";
                    } else if (caracter.equals("1")) {
                        cadena.set(posCabezal, "1");
                        System.out.println("\t\t\tq14\t\t1\t\t1\t\tq15\t\tL");
                        posCabezal--;
                        estado = "q15";
                    } else if (caracter.equals("=")) {
                        cadena.set(posCabezal, "=");
                        System.out.println("\t\t\tq14\t\t=\t\t=\t\tq15\t\tL");
                        posCabezal--;
                        estado = "q15";
                    } else if (caracter.equals("0")) {
                        cadena.set(posCabezal, "0");
                        System.out.println("\t\t\tq14\t\t0\t\t0\t\tq17\t\tR");
                        posCabezal++;
                        estado = "q17";
                    } else {
                        rechazarCadena(estado);
                    }
                    break;
                case "q15":
                    System.out.println(toString());
                    if (caracter.equals("x")) {
                        cadena.set(posCabezal, "1");
                        System.out.println("\t\t\tq15\t\tx\t\t1\t\tq21\t\tR");
                        posCabezal++;
                        estado = "q21";
                    } else if (caracter.equals("0")) {
                        cadena.set(posCabezal, "0");
                        System.out.println("\t\t\tq15\t\t0\t\t0\t\tq15\t\tR");
                        posCabezal++;
                        estado = "q15";
                    } else {
                        rechazarCadena(estado);
                    }
                    break;
                case "q16":
                    System.out.println(toString());
                    if (caracter.equals("x")) {
                        cadena.set(posCabezal, "x");
                        System.out.println("\t\t\tq16\t\tx\t\tx\t\tq16\t\tL");
                        posCabezal--;
                        estado = "q16";
                    } else if (caracter.equals("0")) {
                        cadena.set(posCabezal, "0");
                        System.out.println("\t\t\tq16\t\t0\t\t0\t\tq16\t\tL");
                        posCabezal--;
                        estado = "q16";
                    } else if (caracter.equals("-")) {
                        cadena.set(posCabezal, "-");
                        System.out.println("\t\t\tq16\t\t-\t\t-\t\tq18\t\tL");
                        posCabezal--;
                        estado = "q18";
                    } else {
                        rechazarCadena(estado);
                    }
                    break;
                case "q17":
                    System.out.println(toString());
                    if (caracter.equals("x")) {
                        cadena.set(posCabezal, "x");
                        System.out.println("\t\t\tq17\t\tx\t\tx\t\tq17\t\tR");
                        posCabezal++;
                        estado = "q17";
                    } else if (caracter.equals("0")) {
                        cadena.set(posCabezal, "0");
                        System.out.println("\t\t\tq17\t\t0\t\t0\t\tq17\t\tR");
                        posCabezal++;
                        estado = "q17";
                    } else if (caracter.equals("-")) {
                        cadena.set(posCabezal, "-");
                        System.out.println("\t\t\tq17\t\t-\t\t-\t\tq17\t\tR");
                        posCabezal++;
                        estado = "q17";
                    } else if (caracter.equals("1")) {
                        cadena.set(posCabezal, "1");
                        System.out.println("\t\t\tq17\t\t1\t\t1\t\tq15\t\tL");
                        posCabezal--;
                        estado = "q15";
                    } else if (caracter.equals("=")) {
                        cadena.set(posCabezal, "=");
                        System.out.println("\t\t\tq17\t\t=\t\t=\t\tq15\t\tL");
                        posCabezal--;
                        estado = "q15";
                    } else {
                        rechazarCadena(estado);
                    }
                    break;
                case "q18":
                    System.out.println(toString());
                    if (caracter.equals("x")) {
                        cadena.set(posCabezal, "x");
                        System.out.println("\t\t\tq18\t\tx\t\tx\t\tq18\t\tL");
                        posCabezal--;
                        estado = "q18";
                    } else if (caracter.equals("-")) {
                        cadena.set(posCabezal, "-");
                        System.out.println("\t\t\tq18\t\t-\t\t-\t\tq18\t\tL");
                        posCabezal--;
                        estado = "q18";
                    } else if (caracter.equals("0")) {
                        cadena.set(posCabezal, "0");
                        System.out.println("\t\t\tq18\t\t0\t\t0\t\tq18\t\tL");
                        posCabezal--;
                        estado = "q18";
                    } else if (caracter.equals("1")) {
                        cadena.set(posCabezal, "1");
                        System.out.println("\t\t\tq18\t\t1\t\t1\t\tq18\t\tL");
                        posCabezal--;
                        estado = "q18";
                    } else if (caracter.equals("#")) {
                        cadena.set(posCabezal, c);
                        System.out.println("\t\t\tq18\t\t#\t\t" + c + "\t\tq19\t\tR");
                        posCabezal++;
                        estado = "q19";
                    } else if (caracter.equals(c)) {
                        cadena.set(posCabezal, c);
                        System.out.println("\t\t\tq18\t\t" + c + "\t\t" + c + "\t\tq19\t\tR");
                        posCabezal++;
                        estado = "q19";
                    } else {
                        rechazarCadena(estado);
                    }
                    break;
                case "q19":
                    System.out.println(toString());
                    if (caracter.equals("x")) {
                        cadena.set(posCabezal, "x");
                        System.out.println("\t\t\tq19\t\tx\t\tx\t\tq19\t\tR");
                        posCabezal++;
                        estado = "q19";
                    } else if (caracter.equals("0")) {
                        cadena.set(posCabezal, "0");
                        System.out.println("\t\t\tq19\t\t0\t\t0\t\tq19\t\tR");
                        posCabezal++;
                        estado = "q19";
                    } else if (caracter.equals("-")) {
                        cadena.set(posCabezal, "-");
                        System.out.println("\t\t\tq19\t\t-\t\t-\t\tq19\t\tR");
                        posCabezal++;
                        estado = "q19";
                    } else if (caracter.equals("1")) {
                        cadena.set(posCabezal, "u");
                        System.out.println("\t\t\tq19\t\t1\t\tu\t\tq20\t\tR");
                        posCabezal++;
                        estado = "q20";
                    } else if (caracter.equals("=")) {
                        cadena.set(posCabezal, "=");
                        System.out.println("\t\t\tq19\t\t=\t\t=\t\tq29\t\tR");
                        posCabezal++;
                        estado = "q29";
                    } else {
                        rechazarCadena(estado);
                    }
                    break;
                case "q20":
                    System.out.println(toString());
                    if (caracter.equals("x")) {
                        cadena.set(posCabezal, "x");
                        System.out.println("\t\t\tq20\t\tx\t\tx\t\tq20\t\tR");
                        posCabezal++;
                        estado = "q20";
                    } else if (caracter.equals("-")) {
                        cadena.set(posCabezal, "-");
                        System.out.println("\t\t\tq20\t\t-\t\t-\t\tq20\t\tR");
                        posCabezal++;
                        estado = "q20";
                    } else if (caracter.equals("0")) {
                        cadena.set(posCabezal, "0");
                        System.out.println("\t\t\tq20\t\t0\t\t0\t\tq20\t\tR");
                        posCabezal++;
                        estado = "q20";
                    } else if (caracter.equals("1")) {
                        cadena.set(posCabezal, "1");
                        System.out.println("\t\t\tq20\t\t1\t\t1\t\tq20\t\tR");
                        posCabezal++;
                        estado = "q20";
                    } else if (caracter.equals("=")) {
                        cadena.set(posCabezal, "=");
                        System.out.println("\t\t\tq20\t\t=\t\t=\t\tq25\t\tR");
                        posCabezal++;
                        estado = "q25";
                    } else {
                        rechazarCadena(estado);
                    }
                    break;
                case "q21":
                    System.out.println(toString());
                    if (caracter.equals("1")) {
                        cadena.set(posCabezal, "1");
                        System.out.println("\t\t\tq21\t\t1\t\t1\t\tq21\t\tR");
                        posCabezal++;
                        estado = "q21";
                    } else if (caracter.equals("0")) {
                        cadena.set(posCabezal, "0");
                        System.out.println("\t\t\tq21\t\t0\t\t0\t\tq21\t\tR");
                        posCabezal++;
                        estado = "q21";
                    } else if (caracter.equals("x")) {
                        cadena.set(posCabezal, "x");
                        System.out.println("\t\t\tq21\t\tx\t\tx\t\tq21\t\tR");
                        posCabezal++;
                        estado = "q21";
                    } else if (caracter.equals("=")) {
                        cadena.set(posCabezal, "=");
                        System.out.println("\t\t\tq21\t\t=\t\t=\t\tq22\t\tR");
                        posCabezal++;
                        estado = "q22";
                    } else {
                        rechazarCadena(estado);
                    }
                    break;
                case "q22":
                    System.out.println(toString());
                    if (caracter.equals(c)) {
                        cadena.set(posCabezal, "-");
                        System.out.println("\t\t\tq22\t\t" + c + "\t\t-\t\tq23\t\tL");
                        posCabezal--;
                        estado = "q23";
                    } else {
                        rechazarCadena(estado);
                    }
                    break;
                case "q23":
                    System.out.println(toString());
                    if (caracter.equals("=")) {
                        cadena.set(posCabezal, "=");
                        System.out.println("\t\t\tq23\t\t=\t\t=\t\tq18\t\tL");
                        posCabezal--;
                        estado = "q18";
                    } else {
                        rechazarCadena(estado);
                    }
                    break;
                case "q24":
                    System.out.println(toString());
                    if (caracter.matches("[0-8]")) {
                        int a = Integer.parseInt(caracter) + 1;
                        cadena.set(posCabezal, a + "");
                        System.out.println("\t\t\tq24\t\t" + (a) + "\t\t" + a + "\t\tq27\t\tL");
                        posCabezal--;
                        estado = "q27";
                    } else if (caracter.equals(c)) {
                        cadena.set(posCabezal, "1");
                        System.out.println("\t\t\tq24\t\t" + c + "\t\t1\t\tq27\t\tL");
                        posCabezal--;
                        estado = "q27";
                    } else {
                        rechazarCadena(estado);
                    }
                    break;
                case "q25":
                    System.out.println(toString());
                    if (caracter.equals("-")) {
                        cadena.set(posCabezal, "-");
                        System.out.println("\t\t\tq25\t\t-t\t-\t\tq25\t\tR");
                        posCabezal++;
                        estado = "q25";
                    } else if (caracter.matches("[0-9]")) {
                        int a = Integer.parseInt(caracter);
                        cadena.set(posCabezal, a + "");
                        System.out.println("\t\t\tq25\t\t" + a + "\t\t" + a + "\t\tq26\t\tR");
                        posCabezal++;
                        estado = "q26";
                    } else if (caracter.equals(c)) {
                        cadena.set(posCabezal, "0");
                        System.out.println("\t\t\tq25\t\t" + c + "\t\t0\t\tq24\t\tR");
                        posCabezal++;
                        estado = "q24";
                    } else {
                        rechazarCadena(estado);
                    }
                    break;
                case "q26":
                    System.out.println(toString());
                    if (caracter.matches("[0-8]")) {
                        int a = Integer.parseInt(caracter) + 1;
                        cadena.set(posCabezal, a + "");
                        System.out.println("\t\t\tq26\t\t" + (a) + "\t\t" + a + "\t\tq27\t\tL");
                        posCabezal--;
                        estado = "q27";
                    } else if (caracter.equals("9")) {
                        cadena.set(posCabezal, "0");
                        System.out.println("\t\t\tq26\t\t9\t\t0\t\tq24\t\tL");
                        posCabezal--;
                        estado = "q24";
                    } else {
                        rechazarCadena(estado);
                    }
                    break;
                case "q27":
                    System.out.println(toString());
                    if (caracter.matches("[0-9]")) {
                        int a = Integer.parseInt(caracter);
                        cadena.set(posCabezal, a + "");
                        System.out.println("\t\t\tq27\t\t" + a + "\t\t" + a + "\t\tq27\t\tL");
                        posCabezal--;
                        estado = "q27";
                    } else if (caracter.equals("-")) {
                        cadena.set(posCabezal, "-");
                        System.out.println("\t\t\tq27\t\t-t\t-\t\tq27\t\tL");
                        posCabezal--;
                        estado = "q27";
                    } else if (caracter.equals("=")) {
                        cadena.set(posCabezal, "=");
                        System.out.println("\t\t\tq27\t\t=t\t=\t\tq28\t\tL");
                        posCabezal--;
                        estado = "q28";
                    } else {
                        rechazarCadena(estado);
                    }
                    break;
                case "q28":
                    System.out.println(toString());
                    if (caracter.equals("1")) {
                        cadena.set(posCabezal, "1");
                        System.out.println("\t\t\tq28\t\t1\t\t1\t\tq28\t\tL");
                        posCabezal--;
                        estado = "q28";
                    } else if (caracter.equals("0")) {
                        cadena.set(posCabezal, "0");
                        System.out.println("\t\t\tq28\t\t0\t\t0\t\tq28\t\tL");
                        posCabezal--;
                        estado = "q28";
                    } else if (caracter.equals("x")) {
                        cadena.set(posCabezal, "x");
                        System.out.println("\t\t\tq28\t\tx\t\tx\t\tq28\t\tL");
                        posCabezal--;
                        estado = "q28";
                    } else if (caracter.equals("-")) {
                        cadena.set(posCabezal, "-");
                        System.out.println("\t\t\tq28\t\t-\t\t-\t\tq28\t\tL");
                        posCabezal--;
                        estado = "q28";
                    } else if (caracter.equals("u")) {
                        cadena.set(posCabezal, "u");
                        System.out.println("\t\t\tq28\t\tu\t\tu\t\tq19\t\tR");
                        posCabezal++;
                        estado = "q19";
                    } else {
                        rechazarCadena(estado);
                    }
                    break;
                case "q29":
                    System.out.println(toString());
                    if (caracter.matches("[0-9]")) {
                        int a = Integer.parseInt(caracter);
                        cadena.set(posCabezal, a + "");
                        System.out.println("\t\t\tq29\t\t" + a + "\t\t" + a + "\t\tq30\t\tL");
                        posCabezal--;
                        estado = "q30";
                    } else if (caracter.equals("-")) {
                        cadena.set(posCabezal, "-");
                        System.out.println("\t\t\tq29\t\t-\t\t-\t\tq30\t\tL");
                        posCabezal--;
                        estado = "q30";
                    } else if (caracter.equals("u")) {
                        cadena.set(posCabezal, "1");
                        System.out.println("\t\t\tq29\t\tu\t\t1\t\tq30\t\tL");
                        posCabezal--;
                        estado = "q30";
                    } else if (caracter.equals("x")) {
                        cadena.set(posCabezal, "1");
                        System.out.println("\t\t\tq29\t\tx\t\t1\t\tq30\t\tL");
                        posCabezal--;
                        estado = "q30";
                    } else if (caracter.equals(c)) {
                        cadena.set(posCabezal, "0");
                        System.out.println("\t\t\tq29\t\t" + c + "\t\t0\t\tq32\t\tL");
                        posCabezal--;
                        estado = "q32";
                    } else {
                        rechazarCadena(estado);
                    }
                    break;
                case "q30":
                    System.out.println(toString());
                    if (caracter.matches("[0-9]")) {
                        int a = Integer.parseInt(caracter);
                        cadena.set(posCabezal, a + "");
                        System.out.println("\t\t\tq30\t\t" + a + "\t\t" + a + "\t\tq30\t\tL");
                        posCabezal--;
                        estado = "q30";
                    } else if (caracter.equals("-")) {
                        cadena.set(posCabezal, "-");
                        System.out.println("\t\t\tq30\t\t-\t\t-\t\tq30\t\tL");
                        posCabezal--;
                        estado = "q30";
                    } else if (caracter.equals("u")) {
                        cadena.set(posCabezal, "1");
                        System.out.println("\t\t\tq30\t\tu\t\t1\t\tq30\t\tL");
                        posCabezal--;
                        estado = "q30";
                    } else if (caracter.equals("x")) {
                        cadena.set(posCabezal, "1");
                        System.out.println("\t\t\tq30\t\tx\t\t1\t\tq30\t\tL");
                        posCabezal--;
                        estado = "q30";
                    } else if (caracter.equals("=")) {
                        cadena.set(posCabezal, "=");
                        System.out.println("\t\t\tq30\t\t=\t\t=\t\tq30\t\tL");
                        posCabezal--;
                        estado = "q30";
                    } else if (caracter.equals(c)) {
                        cadena.set(posCabezal, c);
                        System.out.println("\t\t\tq30\t\t" + c + "\t\t" + c + "\t\tq31\t\tR");
                        posCabezal++;
                        estado = "q31";
                    } else {
                        rechazarCadena(estado);
                    }
                    break;
                case "q31":
                    System.out.println(toString());
                    System.out.println("\t\t\tq31\t\t" + cadena.get(posCabezal) + "\t\t" + cadena.get(posCabezal) + "\t\tq31\t\t");
                    aceptarCadena(estado);
                    break;
                case "q32":
                    System.out.println(toString());
                    if (caracter.equals("=")) {
                        cadena.set(posCabezal, "=");
                        System.out.println("\t\t\tq32\t\t=\t\t=\t\tq30\t\tL");
                        posCabezal--;
                        estado = "q30";
                    } else {
                        rechazarCadena(estado);
                    }
                    break;
                case "q33":
                    break;
                case "q34":
                    break;
                case "q35":
                    break;
                case "q36":
                    break;
                case "q37":
                    break;
                case "q38":
                    break;
                case "q39":
                    break;
                case "q40":
                    break;
                case "q41":
                    break;
                case "q42":
                    break;
                case "q43":
                    break;
                case "q44":
                    break;
                case "q45":
                    break;
                case "q46":
                    break;
                case "q47":
                    switch (caracter) {
                        case "1":
                            System.out.println(toString());
                            cadena.set(posCabezal, "1");
                            System.out.println("q47\t\t\t1\t\t\t1\t\t\tq49\t\t\tR");
                            posCabezal++;
                            estado = "q49";
                            break;
                        case "0":
                            System.out.println(toString());
                            cadena.set(posCabezal, "0");
                            System.out.println("q47\t\t\t0\t\t\t0\t\t\tq48\t\t\tR");
                            posCabezal++;
                            estado = "q48";
                            break;
                        default:
                            rechazarCadena(estado);
                            break;
                    }
                    break;
                case "q48":
                    switch (caracter) {
                        case "1":
                            System.out.println(toString());
                            cadena.set(posCabezal, "1");
                            System.out.println("q48\t\t\t1\t\t\t1\t\t\tq49\t\t\tR");
                            posCabezal++;
                            estado = "q49";
                            break;
                        case "0":
                            System.out.println(toString());
                            cadena.set(posCabezal, "0");
                            System.out.println("q48\t\t\t0\t\t\t0\t\t\tq48\t\t\tR");
                            posCabezal++;
                            estado = "q48";
                            break;
                        case "*":
                            System.out.println(toString());
                            cadena.set(posCabezal, "*");
                            System.out.println("q48\t\t\t*\t\t\t*\t\t\tq54\t\t\tR");
                            posCabezal++;
                            estado = "q54";
                            break;
                        default:
                            rechazarCadena(estado);
                            break;
                    }
                    break;
                case "q49":
                    switch (caracter) {
                        case "1":
                            System.out.println(toString());
                            cadena.set(posCabezal, "1");
                            System.out.println("q49\t\t\t1\t\t\t1\t\t\tq49\t\t\tR");
                            posCabezal++;
                            estado = "q49";
                            break;
                        case "0":
                            System.out.println(toString());
                            cadena.set(posCabezal, "0");
                            System.out.println("q49\t\t\t0\t\t\t0\t\t\tq49\t\t\tR");
                            posCabezal++;
                            estado = "q49";
                            break;
                        case "*":
                            System.out.println(toString());
                            cadena.set(posCabezal, "*");
                            System.out.println("q49\t\t\t*\t\t\t*\t\t\tq50\t\t\tR");
                            posCabezal++;
                            estado = "q50";
                            break;
                        default:
                            rechazarCadena(estado);
                            break;
                    }
                    break;
                case "q50":
                    switch (caracter) {
                        case "0":
                            System.out.println(toString());
                            cadena.set(posCabezal, "0");
                            System.out.println("q50\t\t\t0\t\t\t0\t\t\tq51\t\t\tR");
                            posCabezal++;
                            estado = "q51";
                            break;
                        case "1":
                        case "2":
                        case "3":
                        case "4":
                        case "5":
                        case "6":
                        case "7":
                        case "8":
                        case "9":
                            System.out.println(toString());
                            cadena.set(posCabezal, caracter);
                            System.out.println("q50\t\t\t" + caracter + "\t\t\t" + caracter + "\t\t\tq52\t\t\tR");
                            posCabezal++;
                            estado = "q52";
                            break;
                        default:
                            rechazarCadena(estado);
                            break;
                    }
                    break;
                case "q51":
                    switch (caracter) {
                        case "1":
                        case "2":
                        case "3":
                        case "4":
                        case "5":
                        case "6":
                        case "7":
                        case "8":
                        case "9":
                            System.out.println(toString());
                            cadena.set(posCabezal, caracter);
                            System.out.println("q51\t\t\t" + caracter + "\t\t\t" + caracter + "\t\t\tq76\t\t\tR");
                            posCabezal++;
                            estado = "q76";
                            break;
                        case "0":
                            System.out.println(toString());
                            cadena.set(posCabezal, "0");
                            System.out.println("q51\t\t\t0\t\t\t0\t\t\tq57\t\t\tR");
                            posCabezal++;
                            estado = "q57";
                            break;
                        default:
                            rechazarCadena(estado);
                            break;
                    }
                    break;
                case "q52":
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
                            System.out.println(toString());
                            cadena.set(posCabezal, caracter);
                            System.out.println("q52\t\t\t" + caracter + "\t\t\t" + caracter + "\t\t\tq76\t\t\tR");
                            posCabezal++;
                            estado = "q76";
                            break;
                        default:
                            rechazarCadena(estado);
                            break;
                    }
                    break;
                case "q53":
                    switch (caracter) {
                        case "◻":
                            System.out.println(toString());
                            cadena.set(posCabezal, "◻");
                            System.out.println("q53\t\t\t◻\t\t\t◻\t\t\tq60\t\t\tL");
                            posCabezal--;
                            estado = "q60";
                            break;
                        default:
                            rechazarCadena(estado);
                            break;
                    }
                    break;
                case "q54":
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
                            System.out.println(toString());
                            cadena.set(posCabezal, caracter);
                            System.out.println("q54\t\t\t" + caracter + "\t\t\t" + caracter + "\t\t\tq55\t\t\tR");
                            posCabezal++;
                            estado = "q55";
                            break;
                        default:
                            rechazarCadena(estado);
                            break;
                    }
                    break;
                case "q55":
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
                            System.out.println(toString());
                            cadena.set(posCabezal, caracter);
                            System.out.println("q55\t\t\t" + caracter + "\t\t\t" + caracter + "\t\t\tq56\t\t\tR");
                            posCabezal++;
                            estado = "q56";
                            break;
                        default:
                            rechazarCadena(estado);
                            break;
                    }
                    break;
                case "q56":
                    switch (caracter) {
                        case "=":
                            System.out.println(toString());
                            cadena.set(posCabezal, "=");
                            System.out.println("q56\t\t\t=\t\t\t=\t\t\tq58\t\t\tR");
                            posCabezal++;
                            estado = "q58";
                            break;
                        default:
                            rechazarCadena(estado);
                            break;
                    }
                    break;
                case "q57":
                    switch (caracter) {
                        case "=":
                            System.out.println(toString());
                            cadena.set(posCabezal, "=");
                            System.out.println("q57\t\t\t=\t\t\t=\t\t\tq58\t\t\tR");
                            posCabezal++;
                            estado = "q58";
                            break;
                        default:
                            rechazarCadena(estado);
                            break;
                    }
                    break;
                case "q58":
                    switch (caracter) {
                        case "◻":
                            System.out.println(toString());
                            cadena.set(posCabezal, "◻");
                            System.out.println("q58\t\t\t=\t\t\t=\t\t\tq59\t\t\tS");
                            //No se aumenta cabezal.
                            estado = "q59";
                            break;
                        default:
                            rechazarCadena(estado);
                            break;
                    }
                    break;
                case "q59":
                    switch (caracter) {
                        case "◻":
                            System.out.println(toString());
                            cadena.set(posCabezal, "0");
                            System.out.println("q62\t\t\t◻\t\t\t0\t\t\t\t\t\t\tS");
                            //ESTADO FINAL
                            estado = "q62";
                            break;
                        default:
                            rechazarCadena(estado);
                            break;
                    }
                    break;
                case "q60":
                    switch (caracter) {
                        case "◻":
                            System.out.println(toString());
                            cadena.set(posCabezal, "◻");
                            System.out.println("q60\t\t\t◻\t\t\t◻\t\t\tq61\t\t\tR");
                            posCabezal++;
                            estado = "q61";
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
                        case "*":
                        case "=":
                            System.out.println(toString());
                            cadena.set(posCabezal, caracter);
                            System.out.println("q60\t\t\t" + caracter + "\t\t\t" + caracter + "\t\t\tq60\t\t\tL");
                            posCabezal--;
                            estado = "q60";
                            break;
                        default:
                            rechazarCadena(estado);
                            break;
                    }
                    break;
                case "q61":
                    switch (caracter) {
                        case "0":
                            System.out.println(toString());
                            cadena.set(posCabezal, "0");
                            System.out.println("q61\t\t\t0\t\t\t0\t\t\tq61\t\t\tR");
                            posCabezal++;
                            estado = "q61";
                            break;
                        case "1":
                            System.out.println(toString());
                            cadena.set(posCabezal, "x");
                            System.out.println("q61\t\t\t1\t\t\tx\t\t\tq63\t\t\tR");
                            posCabezal++;
                            estado = "q63";
                            break;
                        case "*":
                            System.out.println(toString());
                            cadena.set(posCabezal, "*");
                            System.out.println("q61\t\t\t*\t\t\t*\t\t\tq69\t\t\tR");
                            posCabezal++;
                            estado = "q69";
                            break;
                        default:
                            rechazarCadena(estado);
                            break;
                    }
                    break;
                case "q62":
                    System.out.print(toString());
                    System.out.println("q62");
                    aceptarCadena(estado);
                    break;
                case "q63":
                    switch (caracter) {
                        case "=":
                            System.out.println(toString());
                            cadena.set(posCabezal, "=");
                            System.out.println("q63\t\t\t=\t\t\t=\t\t\tq67\t\t\tR");
                            posCabezal++;
                            estado = "q67";
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
                        case "*":
                            System.out.println(toString());
                            cadena.set(posCabezal, caracter);
                            System.out.println("q63\t\t\t" + caracter + "\t\t\t" + caracter + "\t\t\tq63\t\t\tR");
                            posCabezal++;
                            estado = "q63";
                            break;
                        default:
                            rechazarCadena(estado);
                            break;
                    }
                    break;
                case "q64":
                    switch (caracter) {
                        case "◻":
                            System.out.println(toString());
                            cadena.set(posCabezal, "1");
                            System.out.println("q64\t\t\t◻\t\t\t\t1\t\t\tq66\t\t\tL");
                            posCabezal--;
                            estado = "q66";
                            break;
                        case "0":
                            System.out.println(toString());
                            cadena.set(posCabezal, "1");
                            System.out.println("q64\t\t\t0\t\t\t\t1\t\t\tq66\t\t\tL");
                            posCabezal--;
                            estado = "q66";
                            break;
                        case "1":
                            System.out.println(toString());
                            cadena.set(posCabezal, "2");
                            System.out.println("q64\t\t\t1\t\t\t\t2\t\t\tq66\t\t\tL");
                            posCabezal--;
                            estado = "q66";
                            break;
                        case "2":
                            System.out.println(toString());
                            cadena.set(posCabezal, "3");
                            System.out.println("q64\t\t\t2\t\t\t\t3\t\t\tq66\t\t\tL");
                            posCabezal--;
                            estado = "q66";
                            break;
                        case "3":
                            System.out.println(toString());
                            cadena.set(posCabezal, "4");
                            System.out.println("q64\t\t\t3\t\t\t\t4\t\t\tq66\t\t\tL");
                            posCabezal--;
                            estado = "q66";
                            break;
                        case "4":
                            System.out.println(toString());
                            cadena.set(posCabezal, "5");
                            System.out.println("q64\t\t\t4\t\t\t\t5\t\t\tq66\t\t\tL");
                            posCabezal--;
                            estado = "q66";
                            break;
                        case "5":
                            System.out.println(toString());
                            cadena.set(posCabezal, "6");
                            System.out.println("q64\t\t\t5\t\t\t\t6\t\t\tq66\t\t\tL");
                            posCabezal--;
                            estado = "q66";
                            break;
                        case "6":
                            System.out.println(toString());
                            cadena.set(posCabezal, "7");
                            System.out.println("q64\t\t\t6\t\t\t\t7\t\t\tq66\t\t\tL");
                            posCabezal--;
                            estado = "q66";
                            break;
                        case "7":
                            System.out.println(toString());
                            cadena.set(posCabezal, "8");
                            System.out.println("q64\t\t\t7\t\t\t\t8\t\t\tq66\t\t\tL");
                            posCabezal--;
                            estado = "q66";
                            break;
                        case "8":
                            System.out.println(toString());
                            cadena.set(posCabezal, "9");
                            System.out.println("q64\t\t\t8\t\t\t\t9\t\t\tq66\t\t\tL");
                            posCabezal--;
                            estado = "q66";
                            break;
                        default:
                            rechazarCadena(estado);
                            break;
                    }
                    break;
                case "q65":
                    switch (caracter) {
                        case "9":
                            System.out.println(toString());
                            cadena.set(posCabezal, "0");
                            System.out.println("q65\t\t\t9\t\t\t0\t\tq64\t\t\tL");
                            posCabezal--;
                            estado = "q64";
                            break;
                        case "0":
                            System.out.println(toString());
                            cadena.set(posCabezal, "1");
                            System.out.println("q65\t\t\t0\t\t\t1\t\tq66\t\t\tL");
                            posCabezal--;
                            estado = "q66";
                            break;
                        case "1":
                            System.out.println(toString());
                            cadena.set(posCabezal, "2");
                            System.out.println("q65\t\t\t1\t\t\t2\t\tq66\t\t\tL");
                            posCabezal--;
                            estado = "q66";
                            break;
                        case "2":
                            System.out.println(toString());
                            cadena.set(posCabezal, "3");
                            System.out.println("q65\t\t\t2\t\t\t3\t\tq66\t\t\tL");
                            posCabezal--;
                            estado = "q66";
                            break;
                        case "3":
                            System.out.println(toString());
                            cadena.set(posCabezal, "4");
                            System.out.println("q65\t\t\t3\t\t\t4\t\tq66\t\t\tL");
                            posCabezal--;
                            estado = "q66";
                            break;
                        case "4":
                            System.out.println(toString());
                            cadena.set(posCabezal, "5");
                            System.out.println("q65\t\t\t4\t\t\t5\t\tq66\t\t\tL");
                            posCabezal--;
                            estado = "q66";
                            break;
                        case "5":
                            System.out.println(toString());
                            cadena.set(posCabezal, "6");
                            System.out.println("q65\t\t\t5\t\t\t6\t\tq66\t\t\tL");
                            posCabezal--;
                            estado = "q66";
                            break;
                        case "6":
                            System.out.println(toString());
                            cadena.set(posCabezal, "7");
                            System.out.println("q65\t\t\t6\t\t\t7\t\tq66\t\t\tL");
                            posCabezal--;
                            estado = "q66";
                            break;
                        case "7":
                            System.out.println(toString());
                            cadena.set(posCabezal, "8");
                            System.out.println("q65\t\t\t7\t\t\t8\t\tq66\t\t\tL");
                            posCabezal--;
                            estado = "q66";
                            break;
                        case "8":
                            System.out.println(toString());
                            cadena.set(posCabezal, "9");
                            System.out.println("q65\t\t\t8\t\t\t9\t\tq66\t\t\tL");
                            posCabezal--;
                            estado = "q66";
                            break;
                        default:
                            rechazarCadena(estado);
                            break;
                    }
                    break;
                case "q66":
                    switch (caracter) {
                        case "=":
                            System.out.println(toString());
                            cadena.set(posCabezal, "=");
                            System.out.println("q66\t\t\t=\t\t\t=\t\t\tq68\t\t\tL");
                            posCabezal--;
                            estado = "q68";
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
                            System.out.println(toString());
                            cadena.set(posCabezal, caracter);
                            System.out.println("q66\t\t\t" + caracter + "\t\t\t" + caracter + "\t\t\tq66\t\t\tL");
                            posCabezal--;
                            estado = "q66";
                            break;
                        default:
                            rechazarCadena(estado);
                            break;
                    }
                    break;
                case "q67":
                    switch (caracter) {
                        case "◻":
                            System.out.println(toString());
                            cadena.set(posCabezal, "0");
                            System.out.println("q67\t\t\t◻\t\t\t\t0\t\t\tq64\t\t\tR");
                            posCabezal++;
                            estado = "q64";
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
                            System.out.println(toString());
                            cadena.set(posCabezal, caracter);
                            System.out.println("q67\t\t\t" + caracter + "\t\t\t" + caracter + "\t\t\tq65\t\t\tR");
                            posCabezal++;
                            estado = "q65";
                            break;
                        default:
                            rechazarCadena(estado);
                            break;
                    }
                    break;
                case "q68":
                    switch (caracter) {
                        case "x":
                            System.out.println(toString());
                            cadena.set(posCabezal, "x");
                            System.out.println("q68\t\t\tx\t\t\tx\t\t\tq61\t\t\tR");
                            posCabezal++;
                            estado = "q61";
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
                        case "*":
                            System.out.println(toString());
                            cadena.set(posCabezal, caracter);
                            System.out.println("q68\t\t\t" + caracter + "\t\t\t" + caracter + "\t\t\tq68\t\t\tL");
                            posCabezal--;
                            estado = "q68";
                            break;
                    }
                    break;
                case "q69":
                    switch (caracter) {
                        case "0":
                            System.out.println(toString());
                            cadena.set(posCabezal, "0");
                            System.out.println("q69\t\t\t0\t\t\t\t0\t\t\tq73\t\t\tR");
                            posCabezal++;
                            estado = "q73";
                            break;
                        case "1":
                        case "2":
                        case "3":
                        case "4":
                        case "5":
                        case "6":
                        case "7":
                        case "8":
                        case "9":
                            System.out.println(toString());
                            cadena.set(posCabezal, caracter);
                            System.out.println("q69\t\t\t" + caracter + "\t\t\t\t" + caracter + "\t\t\tq70\t\t\tR");
                            posCabezal++;
                            estado = "q70";
                            break;
                        default:
                            rechazarCadena(estado);
                            break;
                    }
                    break;
                case "q70":
                    switch (caracter) {
                        case "0":
                            System.out.println(toString());
                            cadena.set(posCabezal, "9");
                            System.out.println("q70\t\t\t0\t\t\t\t9\t\t\tq72\t\t\tL");
                            posCabezal--;
                            estado = "q72";
                            break;
                        case "9":
                            System.out.println(toString());
                            cadena.set(posCabezal, "8");
                            System.out.println("q70\t\t\t9\t\t\t\t8\t\t\tq71\t\t\tL");
                            posCabezal--;
                            estado = "q71";
                            break;
                        case "8":
                            System.out.println(toString());
                            cadena.set(posCabezal, "7");
                            System.out.println("q70\t\t\t8\t\t\t\t7\t\t\tq71\t\t\tL");
                            posCabezal--;
                            estado = "q71";
                            break;
                        case "7":
                            System.out.println(toString());
                            cadena.set(posCabezal, "6");
                            System.out.println("q70\t\t\t7\t\t\t\t6\t\t\tq71\t\t\tL");
                            posCabezal--;
                            estado = "q71";
                            break;
                        case "6":
                            System.out.println(toString());
                            cadena.set(posCabezal, "5");
                            System.out.println("q70\t\t\t6\t\t\t\t5\t\t\tq71\t\t\tL");
                            posCabezal--;
                            estado = "q71";
                            break;
                        case "5":
                            System.out.println(toString());
                            cadena.set(posCabezal, "4");
                            System.out.println("q70\t\t\t5\t\t\t\t4\t\t\tq71\t\t\tL");
                            posCabezal--;
                            estado = "q71";
                            break;
                        case "4":
                            System.out.println(toString());
                            cadena.set(posCabezal, "3");
                            System.out.println("q70\t\t\t4\t\t\t\t3\t\t\tq71\t\t\tL");
                            posCabezal--;
                            estado = "q71";
                            break;
                        case "3":
                            System.out.println(toString());
                            cadena.set(posCabezal, "2");
                            System.out.println("q70\t\t\t3\t\t\t\t2\t\t\tq71\t\t\tL");
                            posCabezal--;
                            estado = "q71";
                            break;
                        case "2":
                            System.out.println(toString());
                            cadena.set(posCabezal, "1");
                            System.out.println("q70\t\t\t2\t\t\t\t1\t\t\tq71\t\t\tL");
                            posCabezal--;
                            estado = "q71";
                            break;
                        case "1":
                            System.out.println(toString());
                            cadena.set(posCabezal, "0");
                            System.out.println("q70\t\t\t1\t\t\t\t0\t\t\tq71\t\t\tL");
                            posCabezal--;
                            estado = "q71";
                            break;
                        default:
                            rechazarCadena(estado);
                            break;
                    }
                    break;
                case "q71":
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
                        case "*":
                            System.out.println(toString());
                            cadena.set(posCabezal, caracter);
                            System.out.println("q71\t\t\t" + caracter + "\t\t\t\t" + caracter + "\t\t\tq71\t\t\tL");
                            posCabezal--;
                            estado = "q71";
                            break;
                        case "x":
                            System.out.println(toString());
                            cadena.set(posCabezal, "1");
                            System.out.println("q71\t\t\tx\t\t\t\t1\t\t\tq71\t\t\tL");
                            posCabezal--;
                            estado = "q71";
                            break;
                        case "◻":
                            System.out.println(toString());
                            cadena.set(posCabezal, "◻");
                            System.out.println("q71\t\t\t◻\t\t\t\t◻\t\t\tq61\t\t\tR");
                            posCabezal++;
                            estado = "q61";
                            break;
                        default:
                            rechazarCadena(estado);
                            break;
                    }
                    break;
                case "q72":
                    switch (caracter) {
                        case "9":
                            System.out.println(toString());
                            cadena.set(posCabezal, "8");
                            System.out.println("q72\t\t\t9\t\t\t\t8\t\t\tq71\t\t\tL");
                            posCabezal--;
                            estado = "q71";
                            break;
                        case "8":
                            System.out.println(toString());
                            cadena.set(posCabezal, "7");
                            System.out.println("q72\t\t\t8\t\t\t\t7\t\t\tq71\t\t\tL");
                            posCabezal--;
                            estado = "q71";
                            break;
                        case "7":
                            System.out.println(toString());
                            cadena.set(posCabezal, "6");
                            System.out.println("q72\t\t\t7\t\t\t\t6\t\t\tq71\t\t\tL");
                            posCabezal--;
                            estado = "q71";
                            break;
                        case "6":
                            System.out.println(toString());
                            cadena.set(posCabezal, "5");
                            System.out.println("q72\t\t\t6\t\t\t\t5\t\t\tq71\t\t\tL");
                            posCabezal--;
                            estado = "q71";
                            break;
                        case "5":
                            System.out.println(toString());
                            cadena.set(posCabezal, "4");
                            System.out.println("q72\t\t\t5\t\t\t\t4\t\t\tq71\t\t\tL");
                            posCabezal--;
                            estado = "q71";
                            break;
                        case "4":
                            System.out.println(toString());
                            cadena.set(posCabezal, "3");
                            System.out.println("q72\t\t\t4\t\t\t\t3\t\t\tq71\t\t\tL");
                            posCabezal--;
                            estado = "q71";
                            break;
                        case "3":
                            System.out.println(toString());
                            cadena.set(posCabezal, "2");
                            System.out.println("q72\t\t\t3\t\t\t\t2\t\t\tq71\t\t\tL");
                            posCabezal--;
                            estado = "q71";
                            break;
                        case "2":
                            System.out.println(toString());
                            cadena.set(posCabezal, "1");
                            System.out.println("q72\t\t\t2\t\t\t\t1\t\t\tq71\t\t\tL");
                            posCabezal--;
                            estado = "q71";
                            break;
                        case "1":
                            System.out.println(toString());
                            cadena.set(posCabezal, "0");
                            System.out.println("q72\t\t\t1\t\t\t\t0\t\t\tq71\t\t\tL");
                            posCabezal--;
                            estado = "q71";
                            break;
                        default:
                            rechazarCadena(estado);
                            break;
                    }
                    break;
                case "q73":
                    switch (caracter) {
                        case "1":
                            System.out.println(toString());
                            cadena.set(posCabezal, "0");
                            System.out.println("q73\t\t\t1\t\t\t\t0\t\t\tq74\t\t\tR");
                            posCabezal++;
                            estado = "q74";
                            break;
                        case "2":
                            System.out.println(toString());
                            cadena.set(posCabezal, "1");
                            System.out.println("q73\t\t\t2\t\t\t\t1\t\t\tq71\t\t\tL");
                            posCabezal--;
                            estado = "q71";
                            break;
                        case "3":
                            System.out.println(toString());
                            cadena.set(posCabezal, "2");
                            System.out.println("q73\t\t\t3\t\t\t\t2\t\t\tq71\t\t\tL");
                            posCabezal--;
                            estado = "q71";
                            break;
                        case "4":
                            System.out.println(toString());
                            cadena.set(posCabezal, "3");
                            System.out.println("q73\t\t\t4\t\t\t\t3\t\t\tq71\t\t\tL");
                            posCabezal--;
                            estado = "q71";
                            break;
                        case "5":
                            System.out.println(toString());
                            cadena.set(posCabezal, "4");
                            System.out.println("q73\t\t\t5\t\t\t\t4\t\t\tq71\t\t\tL");
                            posCabezal--;
                            estado = "q71";
                            break;
                        case "6":
                            System.out.println(toString());
                            cadena.set(posCabezal, "5");
                            System.out.println("q73\t\t\t6\t\t\t\t5\t\t\tq71\t\t\tL");
                            posCabezal--;
                            estado = "q71";
                            break;
                        case "7":
                            System.out.println(toString());
                            cadena.set(posCabezal, "6");
                            System.out.println("q73\t\t\t7\t\t\t\t6\t\t\tq71\t\t\tL");
                            posCabezal--;
                            estado = "q71";
                            break;
                        case "8":
                            System.out.println(toString());
                            cadena.set(posCabezal, "7");
                            System.out.println("q73\t\t\t8\t\t\t\t7\t\t\tq71\t\t\tL");
                            posCabezal--;
                            estado = "q71";
                            break;
                        case "9":
                            System.out.println(toString());
                            cadena.set(posCabezal, "8");
                            System.out.println("q73\t\t\t9\t\t\t\t8\t\t\tq71\t\t\tL");
                            posCabezal--;
                            estado = "q71";
                            break;
                        default:
                            rechazarCadena(estado);
                            break;
                    }
                    break;
                case "q74":
                    switch (caracter) {
                        case "=":
                            System.out.println(toString());
                            cadena.set(posCabezal, "=");
                            System.out.println("q74\t\t\t=\t\t\t\t=\t\t\tq75\t\t\tR");
                            posCabezal++;
                            estado = "q75";
                            break;
                        default:
                            rechazarCadena(estado);
                            break;
                    }
                    break;
                case "q75":
                    System.out.print(toString());
                    System.out.println("q75");
                    aceptarCadena(estado);
                    break;
                case "q76":
                    switch (caracter) {
                        case "=":
                            System.out.println(toString());
                            cadena.set(posCabezal, "=");
                            System.out.println("q76\t\t\t=\t\t\t\t=\t\t\tq53\t\t\tR");
                            posCabezal++;
                            estado = "q53";
                            break;
                        default:
                            rechazarCadena(estado);
                            break;
                    }
                    break;
                default:
                    break;
            }
        }
        /*Nota de Kevin:
        * Se supone que en esta parte se debería de validar que se llegó a
        * cada uno de los estados finales.
        * Lo que hice es que dentro del Switch ya puse los estados finales
        * y deben mostrar que se aceptó la cadena, sin embargo, queda la
        * validación pendiente para cuando algo raro pase y por cualquier
        * razón no salga bien, que justamente se debe considerar en esta parte.
        * */
        if (estado.equals("ALGO")) {
            System.out.print(toString());
            System.out.println("ALGO");
            System.out.println("\033[32mCADENA ACEPTADA\033[0m");
        }
    }

    public static void main(String[] args) {
        MTOperaciones caso1 = new MTOperaciones(JOptionPane.showInputDialog("Ingresa una operación."));
        /*MTOperaciones caso2= new MTOperaciones("110010-111111111111=");*/
    }
}
