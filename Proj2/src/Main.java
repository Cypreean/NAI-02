import java.io.*;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("czy chcesz wprowadzic wlasne dane? (t/n)");
        Scanner scanner2 = new Scanner(System.in);
        String input2 = scanner2.nextLine();
        boolean fromKeyboard2 = input2.equals("t");
        File test = null;
        if (fromKeyboard2){
             test = new File("wlasne.txt");
        }
        else {
            test = new File("iris-test.txt");
        }

        File train = new File("iris-train.txt");
        BufferedReader tempreader = new BufferedReader(new FileReader(test));
        BufferedReader testreader = new BufferedReader(new FileReader(test));
        BufferedReader trainreader = new BufferedReader(new FileReader(train));
        Iris[] trainingData = new Iris[120];

        //calculate testing data size
        double size = 0;
        while (tempreader.readLine() != null){
            size++;
        }

        Iris[] testingData = new Iris[(int) (size-1)];
        try {
            trainreader.readLine();
            for (int i = 0; i < 119; i++) {
                String line = trainreader.readLine();
                String[] row = line.split(",");
                double sepalLength = Double.parseDouble(row[0]);
                double sepalWidth = Double.parseDouble(row[1]);
                double petalLength = Double.parseDouble(row[2]);
                double petalWidth = Double.parseDouble(row[3]);
                String species = row[4];
                trainingData[i] = new Iris(sepalLength, sepalWidth, petalLength, petalWidth, species);
            }
            testreader.readLine();
            for (int i = 0; i < size-1; i++) {
                String line = testreader.readLine();
                String[] row = line.split(",");
                double sepalLength = Double.parseDouble(row[0]);
                double sepalWidth = Double.parseDouble(row[1]);
                double petalLength = Double.parseDouble(row[2]);
                double petalWidth = Double.parseDouble(row[3]);
                String species = row[4];
                testingData[i] = new Iris(sepalLength, sepalWidth, petalLength, petalWidth, species);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Perceptron perceptron = new Perceptron(4, 0.001);
        for (int i = 0; i < 119; i++) {
            double[] vector = trainingData[i].getvector();
            int klasa = trainingData[i].getKlasa();
            if (!(perceptron.classify(vector) == klasa)){
                for (int j = 0; j < 5000; j++) {
                    perceptron.train(vector, klasa);
                    if (perceptron.classify(vector) == klasa) {
                        i = 0;
                        break;
                    }
                }
            }
        }

        int poprawne = 0;
        for (int i = 0; i < size-1; i++) {
            double[] vector = testingData[i].getvector();
            int klasa = testingData[i].getKlasa();

            if (perceptron.classify(vector)==klasa){
                poprawne++;
            }
        }

        System.out.println("Poprawne: " + poprawne + " z "+size+" czyli " + (poprawne/ size)*100 + "%");
    }
}