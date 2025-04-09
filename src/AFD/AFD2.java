package AFD;

public class AFD2 {
    String entrada;
    int index;

    public AFD2(String entrada) {
        this.entrada = entrada;
        this.index = 0;
        q0();
    }

    public boolean verificarCadena() {
        return index >= entrada.length();
    }

    public void rechazarCadena(String estado) {
        System.out.println("Cadena rechazada en " + estado);
    }

    public void q0() {
        if (verificarCadena()) {
            rechazarCadena("q0");
            return;
        }
        String caracter = entrada.substring(index, index + 1);
        if (caracter.matches("[a-c]")) {
            System.out.println("q0\t " + caracter + "\tq1");
            index++;
            q1();
        } else if (caracter.matches("[x-z]")) {
            System.out.println("q0\t " + caracter + "\tq2");
            index++;
            q2();
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
        if (caracter.equals("#")) {
            System.out.println("q1\t " + caracter + "\tq3");
            index++;
            q3();
        } else {
            rechazarCadena("q1");
        }
    }

    public void q2() {
        if (verificarCadena()) {
            rechazarCadena("q2");
            return;
        }
        String caracter = entrada.substring(index, index + 1);
        if (caracter.equals("#")) {
            System.out.println("q2\t " + caracter + "\tq3");
            index++;
            q3();
        } else {
            rechazarCadena("q2");
        }
    }

    public void q3() { // pendiente
        if (verificarCadena()) {
            rechazarCadena("q3");
            return;
        }
        String caracter = entrada.substring(index, index + 1);
        if (caracter.equals("#")) {
            if (!verificarCadena()) {
                index++;
                System.out.println("q3\t " + caracter + "\tq3");
                q3();
            } else {
                rechazarCadena("q3");
            }
        } else if (caracter.equals("N")) {
            System.out.println("q3\t " + caracter + "\tq4");
            index++;
            q4();
        } else {
            rechazarCadena("q3");
        }
    }

    public void q4() { //pendiente
        if (index == entrada.length()) {
            System.out.println("Cadena aceptada.");
            return;
        }
        if (verificarCadena()) {
            rechazarCadena("q4");
            return;
        }
        String caracter = entrada.substring(index, index + 1);
        if (caracter.equals("N")) {
            index++;
            System.out.println("q4\t " + caracter + "\tq6");
            q6();
        } else if (caracter.equals("Q")) {
            index++;
            System.out.println("q4\t " + caracter + "\tq7");
            q7();
        } else {
            rechazarCadena("q4");
        }
    }

    public void q5() { //pendiente
        if (index == entrada.length()) {
            System.out.println("Cadena aceptada.");
            return;
        }
        if (verificarCadena()) {
            rechazarCadena("q5");
            return;
        }
        String caracter = entrada.substring(index, index + 1);
        if (caracter.equals("Q")) {
            index++;
            System.out.println("q5\t " + caracter + "\tq7");
            q7();
        } else {
            rechazarCadena("q5");
        }
    }

    public void q6() { //pendiente
        if (index == entrada.length()) {
            System.out.println("Cadena aceptada.");
            return;
        }
        if (verificarCadena()) {
            rechazarCadena("q4");
            return;
        }
        String caracter = entrada.substring(index, index + 1);
        if (caracter.equals("N")) {
            index++;
            System.out.println("q6\t " + caracter + "\tq5");
            q5();
        } else if (caracter.equals("Q")) {
            index++;
            System.out.println("q6\t " + caracter + "\tq7");
            q7();
        } else if (caracter.equals("3") || caracter.equals("9")) {
            index++;
            System.out.println("q6\t " + caracter + "\tq7");
            q7();
        } else {
            rechazarCadena("q6");
        }
    }

    public void q7() {
        if (index == entrada.length()) {
            System.out.println("Cadena aceptada.");
            return;
        }
        if (verificarCadena()) {
            rechazarCadena("q7");
            return;
        }
        String caracter = entrada.substring(index, index + 1);
        if (caracter.equals("3") || caracter.equals("9")) {
            index++;
            System.out.println("q7\t " + caracter + "\tq7");
            q7();
        } else {
            rechazarCadena("q7");
        }
    }

    public static void main(String[] args) {
        AFD2 ej1 = new AFD2("a##NQ3");
        System.out.println("-\t-\t-");
        AFD2 ej2 = new AFD2("y#NNQ393");
        System.out.println("-\t-\t-");
        AFD2 ej3 = new AFD2("c#####N3");
        System.out.println("-\t-\t-");
        AFD2 ej4 = new AFD2("z##NQ");
        System.out.println("-\t-\t-");
    }

}
