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


	//coeff = pca(X) は、n 行 p 列のデータ行列 X の主成分係数 (負荷量とも呼ばれます) を返します。X の行は観測値に対応し、列は変数に対応します。
	//この係数行列は p 行 p 列です。coeff の列ごとに 1 つの主成分の係数が含まれ、これらの列は成分分散の降順で並びます。既定では pca がデータをセンタリングし、特異値分解 (SVD) アルゴリズムを使用します。
	public double[][] getPCA() {
		double[][] var_value = null;
		double[] explained = null;
		double[] grp = null;
		try {
			ml.putVariableAsync("var_value", var_value);
			ml.putVariableAsync("explained", explained);
			ml.putVariableAsync("grp", grp);
			ml.eval("[coeff,score,latent,~,explained] = pca(zscore(data));");
			Future<double[][]> futureEval_var_value = ml.getVariableAsync("coeff");
			var_value = futureEval_var_value.get();
			Future<double[]> futureEval_explained = ml.getVariableAsync("explained");
			explained = futureEval_explained.get();
			System.out.println("Explained = "+Arrays.toString(explained));
			ml.eval("pareto(explained);");
			ml.eval("pause(5);");
			ml.eval("saveas(gcf,'pareto.png')");
			
			ml.eval("biplot(coeff(:,1:2),'scores',score(:,1:2),'varlabels',{'v1','v2','v3','v4','v5','v6'});");
			ml.eval("xlabel('1st Principal Component');");
			ml.eval("ylabel('2st Principal Component');");
			ml.eval("pause(5);");
			ml.eval("saveas(gcf,'biplot.png')");
			
			ml.eval("scatter3(score(:,1),score(:,2),score(:,3))");
			ml.eval("axis equal;");
			ml.eval("xlabel('1st Principal Component');");
			ml.eval("ylabel('2st Principal Component');");
			ml.eval("zlabel('3st Principal Component');");
			ml.eval("pause(5);");
			ml.eval("saveas(gcf,'scatter3_pca.png')");
			
			ml.eval("grp = kmeans(zscore(data),6,'Replicates',5);");
			Future<double[]> futureEval_kmeans = ml.getVariableAsync("grp");
			grp = futureEval_kmeans.get();
			System.out.println("grp = "+Arrays.toString(grp));
			ml.eval("scatter3(score(:,1),score(:,2),score(:,3),10,grp);");
			ml.eval("xlabel('1st Principal Component');");
			ml.eval("ylabel('2st Principal Component');");
			ml.eval("zlabel('3st Principal Component');");
			ml.eval("pause(5);");
			ml.eval("saveas(gcf,'scatter3_kmeans.png')");
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
	
	//https://jp.mathworks.com/help/stats/cluster.html
	public void getCluster() {
		try {
			ml.eval("Z = linkage(data,'ward','euclidean');");
			ml.eval("dendrogram(Z);");
			//ml.eval("xlabel('Generation');");
			//ml.eval("ylabel('Population');");
			ml.eval("title('Population for generation')");
			ml.eval("pause(5);");
			ml.eval("saveas(gcf,'cluster.png')");
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

	//https://jp.mathworks.com/help/nnet/ref/perceptron.html
	public double[] getPerceptronOR() {
		double[] y = null;
		try {
			ml.putVariableAsync("y", y);
			ml.eval("x = [0 0 1 1; 0 1 0 1];");
			ml.eval("t = [0 1 1 1];");
			ml.eval("net = perceptron;");
			ml.eval("net = train(net,x,t);");
			ml.eval("view(net);");
			ml.eval("pause(5);");
			ml.eval("y = net(x);");
			Future<double[]> futureEval_y = ml.getVariableAsync("y");
			y = futureEval_y.get();
			
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
		return y;

	}

	public void getSOM() {
		try {
			ml.putVariableAsync("data", data);
			ml.eval("inputs = data';");
			ml.eval("dimension1 = 10;");
			ml.eval("dimension2 = 10;");
			ml.eval("net = selforgmap([dimension1 dimension2]);");
			ml.eval("[net,tr] = train(net,inputs);");
			ml.eval("outputs = net(inputs);");
			ml.eval("view(net)");
			ml.eval("plotsomtop(net);");
			ml.eval("pause(5);");
			ml.eval("saveas(gcf,'plotsomtop.png')");
			ml.eval("plotsomnc(net);");
			ml.eval("pause(5);");
			ml.eval("saveas(gcf,'plotsomnc.png')");
			ml.eval("plotsomnd(net);");
			ml.eval("pause(5);");
			ml.eval("saveas(gcf,'plotsomnd.png')");
			ml.eval("plotsomplanes(net);");
			ml.eval("pause(5);");
			ml.eval("saveas(gcf,'plotsomplanes.png')");
			ml.eval("plotsomhits(net,inputs);");
			ml.eval("pause(5);");
			ml.eval("saveas(gcf,'plotsomhits.png')");
			ml.eval("plotsompos(net,inputs);");
			ml.eval("pause(5);");
			ml.eval("saveas(gcf,'plotsompos.png')");
			
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

}
