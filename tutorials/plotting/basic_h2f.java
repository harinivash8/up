//#########################################################
//# Series of tutorials on how to use Twig Data
//#  Visualization Package. 
//#########################################################
// Author : Gavalian (Nov/2024)
//---------------------------------------------------------

Random r = new Random();

H2F h2  = new H2F("H200",50,-1.0,1.0, 50, -1.0,1.0);

//--- another way to set titles
h2.attr().setTitleX("X-Value");
h2.attr().setTitleY("Y-Value");

for(int k = 0; k < 81920; k++){
    double x = r.nextGaussian()*0.4-0.5;
    double y = r.nextGaussian()*0.4+0.5;
    h2.fill(x,y);
    if(k%4==0){
	h2.fill(r.nextGaussian()*0.2+0.7,
		r.nextGaussian()*0.2-0.7);
    }
}

TGCanvas c = new TGCanvas("myTwig-2D",550,550);

c.draw(h2);
c.view().export("figure_basic_h2f.png"); // to save to PDF change the extention to .pdf
