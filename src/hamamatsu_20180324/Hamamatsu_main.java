package hamamatsu_20180324;

import java.util.Arrays;

public class Hamamatsu_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double data[][] = new double[15][5];
		
		//MySQLから取り込み
		MySQL mysql = new MySQL();
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
	}

}