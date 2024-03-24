public class Iris {
    private double sepalLength;
    private double sepalWidth;
    private double petalLength;
    private double petalWidth;
    private int klasa;


    public Iris(double sepalLength, double sepalWidth, double petalLength, double petalWidth, String species) {
        this.sepalLength = sepalLength;
        this.sepalWidth = sepalWidth;
        this.petalLength = petalLength;
        this.petalWidth = petalWidth;
        if (species.equals("Iris-setosa")) {
            this.klasa = 1;
        }else {
            this.klasa = 0;
        }
    }

    //getters and setters
    public double getSepalLength() {
        return sepalLength;
    }
    public double getSepalWidth() {
        return sepalWidth;
    }
    public double getPetalLength() {
        return petalLength;
    }
    public double getPetalWidth() {
        return petalWidth;
    }
    public int getKlasa() {
        return klasa;
    }
    public String toString() {
        return "Iris{" +
                "sepalLength=" + sepalLength +
                ", sepalWidth=" + sepalWidth +
                ", petalLength=" + petalLength +
                ", petalWidth=" + petalWidth +
                ", klasa='" + klasa + '\'' +
                '}';

    }
    public double[] getvector(){
        double[] vector = new double[4];
        vector[0] = sepalLength;
        vector[1] = sepalWidth;
        vector[2] = petalLength;
        vector[3] = petalWidth;
        return vector;
    }


}