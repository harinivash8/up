TStyle.getInstance().getPalette().palette2d().setPalette(TPalette2D.PaletteName.kFall);
TGCanvas c = new TGCanvas("confusion_matrix",550,500);
H2F h = new H2F("h2",3,-0.5,2.5, 3, -0.5,2.5);
h.attr().setTitleX("True Class");
h.attr().setTitleY("Predicted Class");

h.setBinContent(0, 0, 0.114);
h.setBinContent(0, 1, 0.064);
h.setBinContent(0, 2, 0.823);
//-------
h.setBinContent(1, 0, 0.241);
h.setBinContent(1, 1, 0.654);
h.setBinContent(1, 2, 0.183);
//-------
h.setBinContent(2, 0, 0.921);
h.setBinContent(2, 1, 0.045);
h.setBinContent(2, 2, 0.036);

c.draw(h,"FSZ"); // F - fill background, S - write bin content, Z - log scale color palette
c.region().getAxisFrame().getAxisX().getAttributes().setAxisTicksString(Arrays.asList("False","Positive","Negative"));
c.region().getAxisFrame().getAxisX().getAttributes().setAxisTicksPosition(Arrays.asList(0.0,1.0,2.0));
c.region().getAxisFrame().getAxisY().getAttributes().setAxisTicksString(Arrays.asList("False","Positive","Negative"));
c.region().getAxisFrame().getAxisY().getAttributes().setAxisTicksPosition(Arrays.asList(0.0,1.0,2.0));
c.region().set("ml=150"); // Sets the left margin of the pad to 150
c.repaint();
c.view().export("figure_confusion_matrix.png");
