//#########################################################
//# Series of tutorials on how to use Twig Data
//#  Visualization Package. 
//#########################################################
// Author : Gavalian (Nov/2024)
//---------------------------------------------------------

Random r = new Random();
H1F h = new H1F("h100","random+gaus;x-axis;count",120,0.0,1.0);

for(int i = 0; i < 3600; i++){
    h.fill(r.nextGaussian()*0.075+0.4);
    for(int j = 0; j < 20;j++) h.fill((r.nextDouble()+r.nextDouble())*2);
}

h.attr().set("mc=3,ms=8,lc=3,lw=2");

F1D func = new F1D("func","[a]+[b]*x+[c]*x*x+[amp]*gaus(x,[mean],[sigma])",.0,1.0);
func.setParameters(1.0,2.0,3.0,200,0.45,0.2);

func.attr().setLineWidth(3);
func.attr().setLineStyle(6);
func.attr().setLineColor(2);
func.parameter(0).setLabel("#alpha");
func.parameter(1).setLabel("#beta");
func.parameter(2).setLabel("#gamma");
func.parameter(4).setLabel("#mu");
func.parameter(5).setLabel("#sigma");

func.attr().setLegend("gaussian with background");
func.fit(h);
func.show();

PaveText text = new PaveText("Random Gaussian",0.35,0.2);
text.addLine("Generated with Java Random");

TGCanvas c = new TGCanvas("myTwig",700,700);
c.draw(h,"EP").draw(func,"same");
c.region().showLegend(0.05,0.95);
c.region().showStats(1.01,1.01);
c.draw(text);
/*
c.cd(0).draw(graph).draw(func,"same");
c.region(0).showLegend(0.05,0.95);
c.region(0).showStats(0.60,0.75);
c.view().export("figure_advanced_graph_fitting.png"); // to save to PDF change the extention to .pdf
*/
