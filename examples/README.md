# Running Examples

The examples presented here are using the TWIG data visualization
package which is distributed as part of the j4np package.
To run the examples the j4np can be downloaded from:

```
https://userweb.jlab.org/~gavalian/software/j4np/
```

For current version use:

```
> wget https://userweb.jlab.org/~gavalian/software/j4np/j4np-1.0.5.tar.gz
> tar -zxvf j4np-1.0.5.tar.gz
> cd j4np-1.0.5
> ./bin/jshell.sh example.jsh
```

# Using twig in your projects

The Twig is distributed as part of j4np and can be linked to through maven.
Add the following to your POM file.

```
<repositories>
   <repository>
     <id>j4np</id>
     <url>https://clasweb.jlab.org/clas12maven/j4np/maven</url>
   </repository>
</repositories>
```
and for the package:

```
 <dependency>
    <groupId>j4np</groupId>
    <artifactId>j4np-ui</artifactId>
    <version>1.0.5</version>
 </dependency>
```
