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

	//https://jp.mathworks.com/help/nnet/gs/cluster-data-with-a-self-organizing-map.html
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
	
	//https://jp.mathworks.com/help/nnet/gs/classify-patterns-with-a-neural-network.html
	//https://jp.mathworks.com/help/nnet/examples/wine-classification.html
	public double[][] getNeural(int [][]targets) {
		double[][] outputs = null;
		try {
			ml.putVariableAsync("data", data);
			ml.putVariableAsync("outputs", outputs);
			ml.putVariableAsync("targets", targets);
			ml.eval("inputs = data(:,1:6);");
			ml.eval("inputs = inputs';");
			ml.eval("targets = targets';");
			ml.eval("hiddenLayerSize = 15;");
			ml.eval("net = patternnet(hiddenLayerSize);");
			ml.eval("net.divideParam.trainRatio = 70/100;");
			ml.eval("net.divideParam.valRatio = 15/100;");
			ml.eval("net.divideParam.testRatio = 15/100;");
			ml.eval("[net,tr] = train(net,inputs,targets);");
			ml.eval("nntraintool;");
			ml.eval("outputs = net(inputs);");
			//ml.eval("errors = gsubtract(targets,outputs);");
			//ml.eval("performance = perform(net,targets,outputs)");
			ml.eval("view(net);");
			ml.eval("plotperform(tr)");
			ml.eval("saveas(gcf,'plotperform(tr).png');");
			ml.eval("pause(5);");
			ml.eval("plottrainstate(tr)");
			ml.eval("saveas(gcf,'plottrainstate(tr).png');");
			ml.eval("pause(5);");
			ml.eval("plotconfusion(targets,outputs);");
			ml.eval("saveas(gcf,'plotconfusion(targets,outputs).png');");
			ml.eval("pause(5);");
			ml.eval("[c,cm] = confusion(targets,outputs)");
			ml.eval("fprintf('Percentage Correct Classification   : %f%%\\n', 100*(1-c));");
			ml.eval("fprintf('Percentage Incorrect Classification : %f%%\\n', 100*c);");
			ml.eval("plotroc(targets,outputs)");
			//ml.eval("ploterrhist(errors);");
			//ml.eval("saveas(gcf,'ploterrhist(errors).png')");
			//ml.eval("pause(5);");
			Future<double[][]> futureEval_outputs = ml.getVariableAsync("outputs");
			outputs = futureEval_outputs.get();
			
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
		return outputs;
	}

	//https://jp.mathworks.com/help/matlab/ref/mpower.html
	//https://jp.mathworks.com/help/econ/create-and-modify-markov-chain-model-objects.html
	//https://jp.mathworks.com/help/econ/visualize-markov-chain-structure-and-evolution.html
	public double [][] getTransition(double n) {
		double[][] outputs = null;
		try {
			ml.putVariableAsync("data", data);
			ml.putVariableAsync("n", n);
			ml.eval("c = data ^ n;");
			//推移確率行列の可視化(有向グラフ)
			ml.eval("mc = dtmc(c);");
			ml.eval("graphplot(mc,'ColorEdges',true);");
			ml.eval("saveas(gcf,'graphplot(dtmc).png');");
			ml.eval("pause(5);");
			//推移確率行列の可視化(Heat Map)
			ml.eval("imagesc(c);");
			ml.eval("colormap(jet);");
			ml.eval("colorbar;");
			ml.eval("axis square");
			ml.eval("h = gca;");
			ml.eval("h.XTick = 1:9;");
			ml.eval("h.YTick = 1:9;");
			ml.eval("title 'Transition Matrix Heatmap';");
			ml.eval("saveas(gcf,'imagesc(c).png');");
			ml.eval("pause(5);");
			//定常分布のシミュレーション
			ml.eval("mc0 = dtmc(data);");
			ml.eval("numSteps = 10;");
			ml.eval("pi0 = [0.2 0.1 0.1 0.1 0.1 0.1 0.1 0.1 0.1];");
			ml.eval("pi_n = redistribute(mc0,numSteps,'X0',pi0);");
			ml.eval("distplot(mc0,pi_n);");
			ml.eval("saveas(gcf,'distplot(mc0).png');");
			ml.eval("pause(5);");
			//定常分布
			ml.eval("distplot(mc0,pi_n,'Type','histogram','FrameRate',1);");
			ml.eval("saveas(gcf,'framerate.png');");
			ml.eval("pause(5);");
			Future<double[][]> futureEval_power = ml.getVariableAsync("c");
			outputs = futureEval_power.get();
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
		return outputs;
	}

	

}
