package AutomataFDFecha;

public class Kevin_EZ_U3AFDFecha {
    String entrada;
    int index;

    public Kevin_EZ_U3AFDFecha(String entrada) {
        this.entrada = entrada;
        this.index = 0;
        System.out.println("Entrada: " + entrada);
        q0();
    }

    public boolean verificarCadena() {
        return index >= entrada.length();
    }

    public void rechazarCadena(String estado) {
        System.out.println("Cadena rechazada en: " + estado);
    }

    public void q0() {
        if (verificarCadena()) {
            rechazarCadena("q0");
            return;
        }
        String caracter = entrada.substring(index, index + 1);
        if (caracter.equals("0")) {
            System.out.println("q0\t" + caracter + "\tq1");
            index++;
            q1();
        } else if (caracter.matches("[1-2]")) {
            System.out.println("q0\t" + caracter + "\tq2");
            index++;
            q2();
        } else if (caracter.equals("3")) {
            System.out.println("q0\t" + caracter + "\tq3");
            index++;
            q3();
        } else {
            rechazarCadena("q0");
        }
    }

    public void q1() {
        if (verificarCadena()) {
            rechazarCadena("q1");
            return;
        }
        String caracter = entrada.substring(index, index + 1);
        if (caracter.matches("[1-9]")) {
            System.out.println("q1\t" + caracter + "\tq4");
            index++;
            q4();
        } else {
            rechazarCadena("q1");
        }
    }

    public void q2() {
        if (verificarCadena()) {
            rechazarCadena("q1");
            return;
        }
        String caracter = entrada.substring(index, index + 1);
        if (caracter.matches("[0-8]")) {
            System.out.println("q2\t" + caracter + "\tq4");
            index++;
            q4();
        } else if (caracter.equals("9")) {
            System.out.println("q2\t" + caracter + "\tq5");
            index++;
            q5();
        } else {
            rechazarCadena("q2");
        }
    }

    public void q3() {
        if (verificarCadena()) {
            rechazarCadena("q3");
            return;
        }
        String caracter = entrada.substring(index, index + 1);
        if (caracter.equals("0")) {
            System.out.println("q3\t" + caracter + "\tq6");
            index++;
            q6();
        } else if (caracter.equals("1")) {
            System.out.println("q3\t" + caracter + "\tq7");
            index++;
            q7();
        } else {
            rechazarCadena("q3");
        }
    }

    public void q4() {
        if (verificarCadena()) {
            rechazarCadena("q4");
            return;
        }
        String caracter = entrada.substring(index, index + 1);
        if (caracter.equals("/FEB")) {
            System.out.println("q4\t" + caracter + "\tq11");
            index++;
            q11();
        } else if (caracter.equals("/")) {
            System.out.println("q4\t" + caracter + "\tq8");
            index++;
            q8();
        } else {
            rechazarCadena("q4");
        }
    }

    public void q5() {
        if (verificarCadena()) {
            rechazarCadena("q5");
            return;
        }
        String caracter = entrada.substring(index, index + 1);
        if (caracter.equals("/")) {
            System.out.println("q5\t" + caracter + "\tq8");
            index++;
            q8();
        } else {
            rechazarCadena("q5");
        }
    }

    public void q6() {
        if (verificarCadena()) {
            rechazarCadena("q6");
            return;
        }
        String caracter = entrada.substring(index, index + 1);
        if (caracter.equals("/")) {
            System.out.println("q6\t" + caracter + "\tq8");
            index++;
            q8();
        } else {
            rechazarCadena("q6");
        }
    }

    public void q7() {
        if(verificarCadena()){
            rechazarCadena("q7");
            return;
        }
        String caracter = entrada.substring(index, index + 1);
        if (caracter.equals("/")) {
            System.out.println("q7\t" + caracter + "\tq8");
            index++;
            q8();
        }else{
            rechazarCadena("q7");
        }
    }

    public void q8() {
        if (verificarCadena()) {
            rechazarCadena("q8");
            return;
        }
        String caracter = entrada.substring(index, index + 3);
        if (caracter.equals("ENE") || caracter.equals("MAR") || caracter.equals("MAY") ||
                caracter.equals("JUL") || caracter.equals("AGO") || caracter.equals("OCT") ||
                caracter.equals("DIC")) {
            System.out.println("q8\t" + caracter + "\tq9");
            index += 3;
            q9();
        } else if (caracter.equals("ABR") || caracter.equals("JUN") ||
                caracter.equals("SEP") || caracter.equals("NOV")) {
            System.out.println("q8\t" + caracter + "\tq10");
            index += 3;
            q10();
        } else if (caracter.equals("FEB")) {
            System.out.println("q8\t" + caracter + "\tq11");
            index += 3;
            q11();
        } else {
            rechazarCadena("q8");
        }
    }

    public void q9() {
        if(verificarCadena()){
            rechazarCadena("q9");
            return;
        }
        String caracter = entrada.substring(index, index + 1);
        if (caracter.equals("/")) {
            System.out.println("q9\t" + caracter + "\tq12");
            index++;
            q12();
        }else{
            rechazarCadena("q9");
        }
    }

    public void q10() {
        if(verificarCadena()){
            rechazarCadena("q10");
            return;
        }
        String caracter = entrada.substring(index, index + 1);
        if (caracter.equals("/")) {
            System.out.println("q10\t" + caracter + "\tq12");
            index++;
            q12();
        }else{
            rechazarCadena("q10");
        }
    }

    public void q11() {
        if(verificarCadena()){
            rechazarCadena("q11");
            return;
        }
        String caracter = entrada.substring(index, index + 1);
        if (caracter.equals("/")) {
            System.out.println("q11\t" + caracter + "\tq12");
            index++;
            q12();
        }else{
            rechazarCadena("q11");
        }
    }

    public void q12() {
        if(verificarCadena()){
            rechazarCadena("q12");
            return;
        }
        String caracter = entrada.substring(index, index + 1);
        if (caracter.equals("0")) {
            System.out.println("q12\t" + caracter + "\tq13");
            index++;
            q13();
        } else if (caracter.equals("1")) {
            System.out.println("q12\t" + caracter + "\tq21");
            index++;
            q21();
        } else if(entrada.substring(index, index + 2).equals("20")) {
            System.out.println("q12\t" + caracter + "\tq26");
            index+=2;
            q26();
        }else{
            rechazarCadena("q12");
        }
    }

    public void q13() {
        if(verificarCadena()){
            rechazarCadena("q13");
            return;
        }
        String caracter = entrada.substring(index, index + 1);
        if(caracter.equals("0")) {
            System.out.println("q13\t" + caracter + "\tq14");
            index++;
            q14();
        } else if (caracter.matches("[1-9]")) {
            System.out.println("q13\t" + caracter + "\tq19");
            index++;
            q19();
        } else {
            rechazarCadena("q13");
        }
    }

    public void q14() {
        if(verificarCadena()){
            rechazarCadena("q14");
            return;
        }
        String caracter = entrada.substring(index, index + 1);
        if (caracter.equals("0")) {
            System.out.println("q14\t" + caracter + "\tq15");
            index++;
            q15();
        } else if (caracter.matches("[1-9]")) {
            System.out.println("q14\t" + caracter + "\tq17");
            index++;
            q17();
        } else {
            rechazarCadena("q14");
        }
    }

    public void q15() {
        if(verificarCadena()){
            rechazarCadena("q15");
            return;
        }
        String caracter = entrada.substring(index, index + 1);
        if(caracter.matches("[1-9]")) {

        } else if (caracter.matches("[0-9]")) {

        } else{
            rechazarCadena("q15");
        }
    }

    public void q16() {
        //revisar que hasta aqui llega la cadena recibida, si no excede el indice se imprime "CADENA RECIBIDA", si no, "CADENA RECHAZADA".
    }

    public void q17() {
        if(verificarCadena()){
            rechazarCadena("q17");
            return;
        }
        String caracter = entrada.substring(index, index + 1);
        if (caracter.matches("[0-9]")) {

            q18();
        }else{
            rechazarCadena("q17");
        }
    }

    public void q18() {
        //revisar que hasta aqui llega la cadena recibida, si no excede el indice se imprime "CADENA RECIBIDA", si no, "CADENA RECHAZADA".
    }

    public void q19() {
        if(verificarCadena()){
            rechazarCadena("q19");
            return;
        }
        String caracter = entrada.substring(index, index + 1);
        if (caracter.matches("[0-9]")) {

            q20();
        }else{
            rechazarCadena("q19");
        }
    }

    public void q20() {
        if(verificarCadena()){
            rechazarCadena("q20");
            return;
        }
        String caracter = entrada.substring(index, index + 1);
        if (caracter.matches("[0-9]")) {

            q23();
        }else{
            rechazarCadena("q20");
        }
    }

    public void q21(){
        if(verificarCadena()){
            rechazarCadena("q21");
            return;
        }
        String caracter = entrada.substring(index, index + 1);
        if (caracter.matches("[0-9]")) {

            q22();
        }else {
            rechazarCadena("q21");
        }
    }
    public void q22() {
        if(verificarCadena()){
            rechazarCadena("q24");
            return;
        }
        String caracter = entrada.substring(index, index + 1);
        if (caracter.matches("[0-9]")) {

            q24();
        }else{
            rechazarCadena("q22");
        }
    }

    public void q23() {
        //revisar que hasta aqui llega la cadena recibida, si no excede el indice se imprime "CADENA RECIBIDA", si no, "CADENA RECHAZADA".
    }
    public void q24() {
        if(verificarCadena()){
            rechazarCadena("q24");
            return;
        }
        String caracter = entrada.substring(index, index + 1);
        if (caracter.matches("[0-9]")) {

            q25();
        }else{
            rechazarCadena("q24");
        }
    }
    public void q25() {
        //revisar que hasta aqui llega la cadena recibida, si no excede el indice se imprime "CADENA RECIBIDA", si no, "CADENA RECHAZADA".
    }
    public void q26() {
        if(verificarCadena()){
            rechazarCadena("q26");
            return;
        }
        String caracter = entrada.substring(index, index + 1);
        if(caracter.matches("[0-1]")) {

            q27();
        }else if(caracter.equals("2")) {

            q28();
        }else{
            rechazarCadena("q26");
        }
    }
    public void q27() {
        if(verificarCadena()){
            rechazarCadena("q27");
            return;
        }
        String caracter = entrada.substring(index, index + 1);
        if(caracter.matches("[0-9]")) {

            q29();
        }else{
            rechazarCadena("q27");
        }
    }
    public void q28() {
        if(verificarCadena()){
            rechazarCadena("q28");
            return;
        }
        String caracter = entrada.substring(index, index + 1);
        if(caracter.matches("[0-5]")){

            q29();
        }else{
            rechazarCadena("q28");
        }
    }
    public void q29() {
        //revisar que hasta aqui llega la cadena recibida, si no excede el indice se imprime "CADENA RECIBIDA", si no, "CADENA RECHAZADA".
    }

    public static void main(String[] args) {
        Kevin_EZ_U3AFDFecha si1 = new Kevin_EZ_U3AFDFecha("01/ENE/2025");
        System.out.println("-\t-\t-");
        Kevin_EZ_U3AFDFecha si2 = new Kevin_EZ_U3AFDFecha("29/FEB/0020");
        System.out.println("-\t-\t-");
        Kevin_EZ_U3AFDFecha si3 = new Kevin_EZ_U3AFDFecha("15/MAR/1999");
        System.out.println("-\t-\t-");
        Kevin_EZ_U3AFDFecha si4 = new Kevin_EZ_U3AFDFecha("30/ABR/1013");
        System.out.println("-\t-\t-");
        Kevin_EZ_U3AFDFecha si5 = new Kevin_EZ_U3AFDFecha("31/DIC/0005");
        System.out.println("-\t-\t-");
    }
}
