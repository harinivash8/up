/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package twig.demo;

import java.awt.Font;
import java.util.Arrays;
import java.util.Random;
import twig.config.TPalette2D;
import twig.config.TStyle;
import twig.data.GraphErrors;
import twig.data.H1F;
import twig.data.H2F;
import twig.data.TDataFactory;
import twig.graphics.TGCanvas;
import twig.graphics.TGH2Node3D;
import twig.math.F1D;
import twig.widgets.LatexText;
import twig.widgets.Legend;

/**
 *
 * @author gavalian
 */
public class RunDemo {
    
    public static H1F createHistogram(int sample, int maxStat){
        H1F h = new H1F("h100","Random Histogram",100,0.0,1.0);
        Random rand = new Random();
        for(int i = 0; i < maxStat; i++){
            h.fill(rand.nextFloat());
            h.fill(rand.nextGaussian()*0.2+0.5);
        }
        h.attr().setTitleX("Random Histogram");
        h.attr().setLegend(String.format("random (n=%d)",maxStat));
        return h;
    }
    
    public static void main(String[] args){
        TStyle.getInstance().getPalette().palette2d().setPalette(TPalette2D.PaletteName.kBird);
        TStyle.getInstance().getAxisAttrX().setAxisLabelFont(new Font("Arial",Font.PLAIN,18));
        TStyle.getInstance().getAxisAttrY().setAxisLabelFont(new Font("Arial",Font.PLAIN,18));
        TStyle.getInstance().getAxisAttrZ().setAxisLabelFont(new Font("Arial",Font.PLAIN,18));
        
        TStyle.getInstance().getAxisAttrX().setAxisTitleFont(new Font("Arial",Font.PLAIN,22));
        TStyle.getInstance().getAxisAttrY().setAxisTitleFont(new Font("Arial",Font.PLAIN,22));
        TStyle.getInstance().getAxisAttrZ().setAxisTitleFont(new Font("Arial",Font.PLAIN,22));
        
        TStyle.getInstance().setDefaultPaveTextFont(new Font("Arial",Font.PLAIN,18));
                       
        //TGCanvas c = new TGCanvas("Demo Canvas",500,500);
        TGCanvas c = new TGCanvas("twig - demo 0.04",1100,750);
        c.view().divide(new double[][]{{0.7,0.3},{0.4,0.6}});
        
        //LegendNode2D legend = new LegendNode2D(200,30);
        Legend legend = new Legend(0.5,0.5);
        
        for(int i = 0; i <= 8; i++){
            GraphErrors graph = new GraphErrors();
            //for(int p = 0; p <= 10; p++){
            graph.addPoint(1.0, 3.0 + i*2.2 , 0.0, 1.6);
            graph.addPoint(2.0, 2.0 + i*2.2 , 0.0, 1.2);
            graph.addPoint(3.0, 1.5 + i*2.2 , 0.0, 0.8);
            graph.addPoint(4.0, 1.2 + i*2.2 , 0.0, 0.9);
            graph.addPoint(5.0, 1.0 + i*2.2 , 0.0, 1.1);
            //}
            
            graph.attr().setMarkerColor(i+2);
            graph.attr().setLineColor(i+2);
            graph.attr().setMarkerSize(16);
            graph.attr().setLineWidth(2);
            int style = i%7 + 1;
            //if(i<7){
                int color = i+1;
                legend.add(graph, String.format("color=%d, style=%d", color ,style));
            //}
            graph.attr().setMarkerStyle(style);
            c.cd(0).draw(graph, "samePLE");
            //c1.getDataCanvas().cd(2).draw(graph, "samePLS");
            //c1.getDataCanvas().cd(3).draw(graph, "samePLS");            
        }
        //c.draw(legend);
        c.region().showLegend(0.55,0.95);
        ((Legend) c.cd(0).region().getAxisFrame().getWidgets().get(0)).drawBox = true;
        ((Legend) c.cd(0).region().getAxisFrame().getWidgets().get(0)).fillBox = true;
        ((Legend) c.cd(0).region().getAxisFrame().getWidgets().get(0)).setAlign(LatexText.TextAlign.TOP_RIGHT);
        //((TLegend)(c.region().getAxisFrame().getWidgets().get(0))
       //------------- HISTOGRAMS  
        H1F h10 = RunDemo.createHistogram(0,10000);
        H1F h11 = RunDemo.createHistogram(0,6000);
        
        h10.attr().setLineColor(1);
        h10.attr().setFillColor(84);
        h11.attr().setLineColor(1);
        h11.attr().setFillColor(82);
        
        c.cd(1).draw(h10, "").draw(h11, "same");
        c.region().getInsets().top(0);
        c.cd(1).region().showLegend(0.01, 1.0);
        ((Legend) c.cd(1).region().getAxisFrame().getWidgets().get(0)).setFont(new Font("Arial",Font.PLAIN,16));
        
        
        c.region().getAxisFrame().getAxisX().getAttributes().setAxisBoxDraw(false);
        c.region().getAxisFrame().getAxisY().getAttributes().setAxisBoxDraw(false);
        
        //------------- HISTOGRAMS  
        F1D f1 = new F1D("f1","[a]*sin(x)",0.0,Math.PI*4);
        f1.setParameter(0, 2);
        f1.attr().set("lc=7,ls=1,lw=3");//setLineColor(7);
        f1.attr().setTitleX("X");
        f1.attr().setTitleY("amplitude");
        F1D f2 = new F1D("f1","[a]*sin(x)",0.0,Math.PI*4);
        f2.setParameter(0, 1);
        f2.attr().set("lc=3,ls=2,lw=3");
        
        
        F1D f3 = new F1D("f1","[a]*sin(x)",0.0,Math.PI*4);
        f3.setParameter(0, 0.5);
        f3.attr().set("lc=5,ls=3,lw=3");
                
        F1D f4 = new F1D("f1","[a]*cos(x)",0.0,Math.PI*4);
        f4.setParameter(0, 1.5);
        f4.attr().set("lc=2,ls=0,lw=3");
        
        c.cd(2).draw(f1).draw(f2,"same").draw(f3,"same").draw(f4,"same");
        c.cd(2).region().axisLimitsY(-2.75, 2.75);
        c.region().getInsets().bottom(20);
        
        H2F h2 = TDataFactory.createH2F(1200000, 40,40);
        TGH2Node3D node4 = new TGH2Node3D(h2,"W");
        c.view().region(3).replace(node4);
        c.view().region(3).getInsets().set(0, 0, 40, 0);
        //c2.view().initTimer(300);
        c.repaint();        
        //c.view().export("twig_showcase.png", "png");
    }
}
