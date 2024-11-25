import java.awt.Font;

TStyle.getInstance().getPalette().setColorScheme("gold10");
TStyle.getInstance().setDefaultPaveTextFont( new Font("Arial",Font.PLAIN,18));
TStyle.getInstance().setDefaultAxisLabelFont(new Font("Arial",Font.PLAIN,18));
TStyle.getInstance().setDefaultAxisTitleFont(new Font("Arial",Font.PLAIN,20));

BarChartBuilder b = new BarChartBuilder();
b.addEntry("ROOT TTree read, C++",3.9121,5.17,5.17);
b.addEntry("ROOT RNTuple read, C++",8.92,9.31,10.8);
b.addEntry("HIPO Lib read, C++", 2.33,3.15,3.23);
b.addEntry("HIPO Read, Java", 3.75,5.59,5.10);
b.setTitleY("Time (sec)");
b.setColors(new int[]{92,10,6,93});
b.setLabels(new String[]{"Apple M1","Intel","AMD"});

DataGroup group = b.build();

System.out.println("size = " + group.getData().size());
TGCanvas c = new TGCanvas(600,600);
//for(DataSet ds : group.getData()) c.draw(ds, "same");
c.view().region().draw(group);//.showLegend(0.05, 0.95);
c.view().region().showLegend(0.05, 0.95);
c.repaint();
c.view().export("advanced_bar_chart.png","png");
