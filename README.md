# twig
# Data Visualization and Analysis Software

Twig library is evolution of groot, which was initially developped 
for small data visualization while developing data reconstruction codes,
and since became very improtant part of CLAS12 online and offline software.

# Visualization

<img src="https://github.com/gavalian/twig/blob/main/tutorials/images/twig-demo-0.0.4.png" width="900">


# Usage

Include twig project in your pom using:

```html
 <!-- github repository for TWIG Library -->
 <repositories>
    <repository>
      <id>twig-github</id>
      <url>https://maven.pkg.github.com/gavalian/twig</url>
    </repository>
 </repositories>
<!-- TWIG Library (Java Data Visualization and Analysis) -->
<dependency>
  <groupId>j4np</groupId>
  <artifactId>twig</artifactId>
  <version>0.0.4</version>
</dependency>
```

Check out the distribution site for newer versions: (click on "Packages" on the right menu bar)


# Gallery

<table class="center" width="100%">
    <tr>
        <td width="50%">
            <figure>
                <a href="https://github.com/gavalian/twig/blob/main/tutorials/images/figure_advanced_graph_fitting.png">
                 <img src="https://github.com/gavalian/twig/blob/main/tutorials/images/figure_advanced_graph_fitting.png" alt=""></a>
                <figcaption><h2></h2></figcaption>
            </figure>
        </td>
        <td width="50%">
             <a href="https://github.com/gavalian/twig/blob/main/tutorials/images/figure_advanced_bar_chart.png">
              <img src="https://github.com/gavalian/twig/blob/main/tutorials/images/figure_advanced_bar_chart.png" alt=""></a>
                <figcaption><h2></h2></figcaption>
        </td>
    </tr>
 <tr>       
   <td width="50%">
            <figure>
                <a href="https://github.com/gavalian/twig/blob/main/tutorials/images/figure_confusion_matrix.png">
                 <img src="https://github.com/gavalian/twig/blob/main/tutorials/images/figure_confusion_matrix.png" alt=""></a>
                <figcaption><h2></h2></figcaption>
            </figure>
        </td>
        <td width="50%">
             <a href="https://github.com/gavalian/twig/blob/main/tutorials/images/figure_slice_graph_3d.png">
              <img src="https://github.com/gavalian/twig/blob/main/tutorials/images/figure_slice_graph_3d.png" alt=""></a>
                <figcaption><h2></h2></figcaption>
        </td>
    </tr>
</table>

# Tutorials

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

# Distribution

The distribution of current package containing twig package can be obtained here:

```
https://userweb.jlab.org/~gavalian/software/j4np/
```

The latest j4np package should be used.
