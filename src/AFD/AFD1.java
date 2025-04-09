package AFD;

public class AFD1 {

    private String entrada;
    private int index;

    public AFD1(String entrada) {
        this.entrada = entrada;
        this.index = 0;
        q8();//Estado inicial
    }

    public boolean verificarCadena() {
        return index >= entrada.length();
    }

    public void rechazarCadena(String estado) {
        if (!verificarCadena()) {
            System.out.println(estado + "\t" + entrada.substring(index, index + 1) + "\tqX");
        }
        System.out.println("Cadena rechazada en " + estado + ".");
    }

    public void q8() {
        if (verificarCadena()) {
            rechazarCadena("q8");
            return;
        }
        String caracter = entrada.substring(index, index + 1);
        if (caracter.matches("[a-z]")) {
            System.out.println("q8\t" + caracter + "\tq9");
            this.index++;
            q9();
        } else if (caracter.matches("[0-9]")) {
            System.out.println("q8\t" + caracter + "\tq13");
            index++;
            q13();
        } else if (caracter.matches("A")) {
            System.out.println("q8\t" + caracter + "\tq10");
            index++;
            if(index == entrada.length()){
                System.out.println("Cadena aceptada.");
            }else{
                q10();
            }
        } else {
            rechazarCadena("q8");
        }
    }

    public void q9() {
        if (verificarCadena()) {
            rechazarCadena("q9");
            return;
        }
        String caracter = entrada.substring(index, index + 1);
        if (caracter.matches("P")) {
            System.out.println("q9\t" + caracter + "\tq10");
            this.index++;
            q10();
        } else {
            rechazarCadena("q9");
        }
    }

    public void q10() {
        if (verificarCadena()) {
            rechazarCadena("q10");
            return;
        }
        String caracter = entrada.substring(index, index + 1);
        if (caracter.equals("P")) {
            System.out.println("q10\t" + caracter + "\tq11");
            index++;
            q11();
        } else {
            rechazarCadena("q10");
        }
    }

    public void q11() {
        if (verificarCadena()) {
            rechazarCadena("q11");
            return;
        }
        String caracter = entrada.substring(index, index + 1);
        if (caracter.equals("P")) {
            System.out.println("q11\t" + caracter + "\tq11");
            index++;
            if(index == entrada.length()){
                System.out.println("Cadena aceptada.");
            }else{
                q11(); //Recursividad
            }
        } else if (entrada.length() >= index + 2 && entrada.substring(index, index + 2).equals("@@")) {
            System.out.println("q11\t @@ \tq15");
            index += 2;
            if (verificarCadena()) {
                System.out.println("Cadena aceptada.");
            } else {
                q15();
            }
        } else {
            rechazarCadena("q11");
        }
    }

    public void q12() {
//        if(verificarCadena()){
//            rechazarCadena("q12");
//            return;
//        }
        System.out.println("Cadena aceptada.");
    }

    public void q13() {
        if (verificarCadena()) {
            rechazarCadena("q13");
            return;
        }
        String caracter = entrada.substring(index, index + 1);
        if (caracter.equals("P")) {
            System.out.println("q13\t" + caracter + "\tq10");
            index++;
            q10();
        } else {
            rechazarCadena("q13");
        }
    }

    public void q14() {
//        if(verificarCadena()){
//            rechazarCadena("q14");
//            return;
//        }
        System.out.println("Cadena aceptada.");
    }

    public void q15() {
        if (verificarCadena()) {
            rechazarCadena("q15");
            return;
        }
        String caracter = entrada.substring(index, index + 1);
        if (caracter.equals("@")) {
            System.out.println("q15\t" + caracter + "\tq15");
            index++;
            q15(); //REcur
        } else if (entrada.length() >= index + 2 && entrada.substring(index, index + 2).equals("NO")) {
            System.out.println("q15\t NO \tq12");
            index += 2;
            q12(); //sout("Cadena aceptada.");
        } else if (entrada.length() >= index + 2 && entrada.substring(index, index + 2).equals("SI")) {
            System.out.println("q15\t SI \tq14");
            index += 2;
            q14(); //sout("Cadena aceptada.");
        } else {
            rechazarCadena("q15");
        }
    }

    public static void main(String[] args) {
        AFD1 obj1 = new AFD1("aPP@@NO");
        System.out.println("-------------------");
        AFD1 obj2 = new AFD1("3PPSI");
        System.out.println("-------------------");
        AFD1 obj3 = new AFD1("APP");
        System.out.println("-------------------");
        AFD1 obj4 = new AFD1("");
        System.out.println("Es una cadena vacia, esto es un comentario forzado");
        System.out.println("-------------------");
        AFD1 obj5 = new AFD1("3PP@@");
    }
}
