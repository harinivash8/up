# twig
# Data Visualization and Analysis Software

Twig library is evolution of groot, which was initially developped 
for small data visualization while developing data reconstruction codes,
and since became very improtant part of CLAS12 online and offline software.

Some new features, requested by users, required fresh look at the library 
structure, and new iteration was born with better implementation of graphics
components, making it easier to implement new data visualization plot styles.

# Example of creating tuple from text file

We start from file that constains events each presented in two lines

```
awk '{print $2,$5,$6,$7}' extractedDataPred2.txt > epip_hb.txt
```

this command takes two lines from the input and joins them into one line

```
paste - - < epip_hb.txt > epip_hb_joined.txt
```
