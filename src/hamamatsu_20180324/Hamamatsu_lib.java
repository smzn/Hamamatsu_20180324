package hamamatsu_20180324;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.mathworks.engine.EngineException;
import com.mathworks.engine.MatlabEngine;
import com.mathworks.engine.MatlabExecutionException;
import com.mathworks.engine.MatlabSyntaxException;

public class Hamamatsu_lib {
	Future<MatlabEngine> eng;
	MatlabEngine ml;
	double data[][];
	
	public Hamamatsu_lib(double[][] data) { //MySQLから取り込み
		this.eng = MatlabEngine.startMatlabAsync();
		this.data = data;
		try {
			ml = eng.get();
			ml.putVariableAsync("data", data);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//https://jp.mathworks.com/help/matlab/ref/var.html#responsive_offcanvas
	public double[] getVar() {
		double[] var_value = null;
		try {
			ml.putVariableAsync("var_value", var_value);
			ml.eval("var_value = var(data);");
			Future<double[]> futureEval_var_value = ml.getVariableAsync("var_value");
			var_value = futureEval_var_value.get();
			
		} catch (MatlabExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MatlabSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CancellationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EngineException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return var_value;
	}

	//https://jp.mathworks.com/help/matlab/ref/cov.html
	public double[][] getCov() {
		double[][] var_value = null;
		try {
			ml.putVariableAsync("var_value", var_value);
			ml.eval("var_value = cov(data);");
			Future<double[][]> futureEval_var_value = ml.getVariableAsync("var_value");
			var_value = futureEval_var_value.get();
			
			//Future<double[]> futureEval_x = ml.getVariableAsync("x");
		} catch (MatlabExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MatlabSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CancellationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EngineException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return var_value;
	}

	//https://jp.mathworks.com/help/matlab/ref/std.html
	public double[] getStd() {
		double[] var_value = null;
		try {
			ml.putVariableAsync("var_value", var_value);
			ml.eval("var_value = std(data);");
			Future<double[]> futureEval_var_value = ml.getVariableAsync("var_value");
			var_value = futureEval_var_value.get();
			
		} catch (MatlabExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MatlabSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CancellationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EngineException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return var_value;
	}

	//Statistics and Machine Learning Toolboxを利用
	//https://jp.mathworks.com/help/stats/boxplot.html
	public void getBoxplot() {
		try {
			ml.eval("boxplot(data);");
			ml.eval("xlabel('Generation');");
			ml.eval("ylabel('Population');");
			ml.eval("title('Population for generation')");
			ml.eval("pause(5);");
			ml.eval("saveas(gcf,'boxplot.png')");
		} catch (MatlabExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MatlabSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CancellationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EngineException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//https://jp.mathworks.com/help/matlab/ref/histogram.histogram.html
	public void getHistogram() {
		try {
			ml.eval("histogram(data);");
			ml.eval("xlabel('Generation');");
			ml.eval("ylabel('Population');");
			ml.eval("title('Population for generation')");
			ml.eval("pause(5);");
			ml.eval("saveas(gcf,'histogram.png')");
		} catch (MatlabExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MatlabSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CancellationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EngineException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//https://jp.mathworks.com/help/matlab/ref/corrcoef.html
	public double[][] getCor() {
		double[][] var_value = null;
		try {
			ml.putVariableAsync("var_value", var_value);
			ml.eval("var_value = corrcoef(data);");
			Future<double[][]> futureEval_var_value = ml.getVariableAsync("var_value");
			var_value = futureEval_var_value.get();
			
		} catch (MatlabExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MatlabSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CancellationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EngineException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return var_value;
	}

	
}
