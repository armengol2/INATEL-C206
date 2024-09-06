public class Calculadora {
    static double pi = 3.14; // varievl de pi

    //retornando area da circunferencia
    public static double circunferencia(double raio) {
        return 2*pi*raio;
    }

    //retornando volume da esfera
    public static double volumeEsfera(double raio) {
        return (4/3)*pi*Math.pow(raio, 3);
    }

    //retornando volume do cilindro
    public static double volumeCilindro(double raio, double altura) {
        return pi*Math.pow(raio, 2)*altura;
    }
}