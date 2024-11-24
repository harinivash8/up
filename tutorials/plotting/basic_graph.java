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

Graph gr1 = new Graph("graph1",xv,yv);
Graph gr2 = new Graph("graph2",xv,yv,xe,ye);
Graph gr3 = new Graph("graph3",xv,yv,xe,ye);

gr2.attr().setFillColor(172);

gr3.attr().setFillColor(164);
gr3.attr().setMarkerSize(8);
gr3.attr().setMarkerColor(4);
gr3.attr().setLineColor(4);
gr3.attr().setLineWidth(2);

TGCanvas c = new TGCanvas("myTwig",800,800);
c.view().divide(2,3); // create two plotting regions
c.cd(0).draw(gr1);
c.cd(1).draw(gr1,"PL"); // draw points (P) and lines connecting them (L)

c.cd(2).draw(gr2,"F"); // draw filled area
c.cd(3).draw(gr2,"PEL"); // draw filled area
c.cd(4).draw(gr3,"F").draw(gr3,"PEsame"); // PE- draw points (P) and error lines (E)
c.cd(5).draw(gr3,"F").draw(gr3,"Lsame"); // L - draw line
c.view().export("figure_basic_graph.png"); // to save to PDF change the extention to .pdf
