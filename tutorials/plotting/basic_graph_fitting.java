//#########################################################
//# Series of tutorials on how to use Twig Data
//#  Visualization Package. 
//#########################################################
// Author : Gavalian (Nov/2024)
//---------------------------------------------------------

double[] xv = {1.5,2.5,3.5,4.5,5.5,6.5,7.5};
double[] yv = {0.05,0.15,0.45,0.95,1.65,3.25,6.55};
double[] xe = {0.0,0.0,0.0,0.0,0.0,0.0,0.0};
double[] ye = {0.05,0.10,0.25,0.45,0.80,1.25,2.25};

Graph graph = new Graph("graph2",xv,yv,xe,ye);

graph.attr().setFillColor(164);
graph.attr().setMarkerSize(11);
graph.attr().setMarkerColor(4);
graph.attr().setLineColor(4);
graph.attr().setLineWidth(3);

F1D func = new F1D("func","[a]+[b]*x+[c]*x*x+[d]*x*x*x",1.0,8.0);
func.setParameters(1.0,2.0,3.0);
func.attr().setLineWidth(2);
func.attr().setLineStyle(5);

func.fit(graph);
func.show();
TGCanvas c = new TGCanvas("myTwig",400,400);

c.cd(0).draw(graph).draw(func,"same");
c.view().export("figure_basic_graph_fitting.png"); // to save to PDF change the extention to .pdf
