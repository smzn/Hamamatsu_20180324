package hamamatsu_20180324;

import java.util.Arrays;

public class Hamamatsu_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double data[][] = new double[15][5];
		double dataall[][] = new double[831][19];
		double data_neural[][] = new double[719][7];
		
		//MySQL mysql = new MySQL(); //データベース接続時
		MySQL mysql = new MySQL(1); //csv取り込み
		//data = mysql.selectData();
		data = mysql.getCSV("csv/hama05.csv", 15, 6);
		dataall = mysql.getCSV("csv/hama05all.csv", 831, 19);
		data_neural = mysql.getCSV("csv/neural00.csv", 719, 10);
		//System.out.println("selectData = "+Arrays.deepToString(data));
		//System.out.println("selectDataall = "+Arrays.deepToString(dataall));
		//System.out.println("selectDataneural = "+Arrays.deepToString(data_neural));
		Hamamatsu_lib hlib = new Hamamatsu_lib(data);
		Hamamatsu_lib hliball = new Hamamatsu_lib(dataall);
		Hamamatsu_lib hlibneural = new Hamamatsu_lib(data_neural);
		//MySQL ここまで
		
		int targets[][] = new int[719][4];
		for(int i = 0; i < data_neural.length; i++) {
			for(int j = 0; j < 4; j++) targets[i][j] = (int) data_neural[i][6 + j];
		}
		System.out.println("targets = "+Arrays.deepToString(targets));
		double [][] neural_y = hlibneural.getNeural(targets);
		System.out.println("NeuralNetwork = "+Arrays.deepToString(neural_y));
		
		double [] var_value = hlib.getVar();
		System.out.println("Variance = "+Arrays.toString(var_value));
		double [][] cov_value = hlib.getCov();
		System.out.println("Covariance = "+Arrays.deepToString(cov_value));
		double [] std_value = hlib.getStd();
		System.out.println("Standard Deviation = "+Arrays.toString(std_value));
		hlib.getBoxplot();
		hlib.getHistogram();
		double [][] cor_value = hlib.getCor();
		System.out.println("Corrlation = "+Arrays.deepToString(cor_value));
		double [][] pca_value = hlib.getPCA();
		System.out.println("PCA = "+Arrays.deepToString(pca_value));
		hlib.getCluster();
		double [] perceptron_y = hlib.getPerceptronOR();
		System.out.println("PerceptronOR = "+Arrays.toString(perceptron_y));
		hliball.getSOM();
		
		
	}

}
