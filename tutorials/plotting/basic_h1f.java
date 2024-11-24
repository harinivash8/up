//#########################################################
//# Series of tutorials on how to use Twig Data
//#  Visualization Package. 
//#########################################################
// Author : Gavalian (Nov/2024)
//---------------------------------------------------------

Random r = new Random();

H1F h1  = new H1F("H100","title;x label; y label",120,-1.0,1.0);
H1F h1c = new H1F("H100","title;x label; y label",120,-1.0,1.0);
H1F h2  = new H1F("H200",120,-1.0,1.0);

//--- another way to set titles
h2.attr().setTitleX("random flat");
h2.attr().setTitleY("counts");

for(int k = 0; k < 12000; k++){
    h1.fill(r.nextGaussian()*0.5);
    if(k%3==0) h1c.fill(r.nextGaussian()*0.5);
    h2.fill(r.nextDouble()*2.0-1);
}

TGCanvas c = new TGCanvas("myTwig",1100,550);
c.view().divide(2,1); // create two plotting regions
c.cd(0).draw(h1).draw(h1c,"sameEP"); // second histogram drawn on top
c.cd(1).draw(h2);
c.view().export("figure_basic_h1f.png"); // to save to PDF change the extention to .pdf
