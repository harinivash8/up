//#########################################################
//# Series of tutorials on how to use Twig Data
//#  Visualization Package. 
//#########################################################
// Author : Gavalian (Nov/2024)
//---------------------------------------------------------

Random r = new Random();

H1F h1 = new H1F("H100",120,0.0,1.0);
H1F h2 = new H1F("H200",120,0.0,1.0);
H1F h3 = new H1F("H300",120,0.0,1.0);

TDirectory dir = new TDirectory();

dir.add("data/random",h1);
dir.add("data/tests",Arrays.asList(h2,h3));

dir.write("histos.twig"); // write current state to the file

//--------- snapshot funcionality
for(int i = 0; i < 4; i++){
    for(int k = 0; k < 120; k++){
	h1.fill(r.nextDouble());
	h2.fill(r.nextGaussian());
	h3.fill(r.nextDouble()+r.nextDouble());
    }
    System.out.println("wait 2 seconds\n"); Thread.sleep(2000);
    dir.snapshot("histos_snap.twig");
}

