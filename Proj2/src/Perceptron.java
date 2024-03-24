public class Perceptron {
    private double[] weights;
    private double learningRate;
    private  double activationrate;

    public Perceptron(int n, double learningRate) {
        this.weights = new double[n];
        this.learningRate = learningRate;
        for (int i = 0; i < n; i++) {
            this.weights[i] = Math.random()*2-1;
        }
        this.activationrate = Math.random(); // miedzy 0 a 1
    }
    public int classify(double[] input) {
        double sum = 0;
        for (int i = 0; i < input.length; i++) {
            sum += input[i] * weights[i];
        }
        return sum > activationrate ? 1 : 0;
    }
    public void train(double[] input, int target) {
        int guess = classify(input);
        double error = target - guess;
        for (int i = 0; i < weights.length; i++) {
            weights[i] += error * input[i] * learningRate;
        }
        activationrate += error * learningRate;
    }
}
