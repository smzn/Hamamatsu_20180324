package hamamatsu_20180324;

import java.util.Arrays;

public class Hamamatsu_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double data[][] = new double[15][5];
		
		//MySQL mysql = new MySQL(); //データベース接続時
		MySQL mysql = new MySQL(1); //csv取り込み
		//data = mysql.selectData();
		data = mysql.getCSV("csv/hama05.csv", 15, 6);
		System.out.println("selectData = "+Arrays.deepToString(data));
		Hamamatsu_lib hlib = new Hamamatsu_lib(data);
		//MySQL ここまで
		
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
	}

}
