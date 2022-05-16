
import twig.data.*;
import twig.math.*;
import twig.graphics.*;

H1F h1  = TDataFactory.createH1F(800,100,0.,1.,0.4,0.08);
H1F h2  = TDataFactory.createH1F(900,100,0.,1.,0.7,0.15);

h2.attr().setFillStyle(1);
h2.attr().setFillColor(4);
h2.attr().setTitleX("random with Gauss");

h1.attr().setMarkerSize(8);
h1.attr().setMarkerColor(2);
h1.attr().setLineColor(2);

F1D func = new F1D("func","[p0]+[p1]*x+[amp]*gaus(x,[mean],[sigma])",0.02,0.98);
func.setParameters(1.0,1.0,50,0.35,0.1);
func.attr().setLineStyle(2);
func.attr().setLineWidth(2);

func.fit(h1,"N");

h1.attr().setLegend("random #mu=0.7, #sigma=0.15");
h2.attr().setLegend("random #mu=0.4, #sigma=0.08");
func.attr().setLegend(String.format("fir amp=%.2f, #mu=%.3f, #sigma=%.4f",
     func.getParameter(2),func.getParameter(3),func.getParameter(4)));

TGCanvas c = new TGCanvas(650,550);
c.view().region().draw(h2).draw(h1,"EPsame").draw(func,"same");
c.view().region().showLegend(0.5,0.98);
c.repaint();
c.view().export("images/figure_legends.pdf","pdf");
