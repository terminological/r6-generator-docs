# r6-generator-docs

[![R-CMD-check](https://github.com/terminological/r6-generator-docs/workflows/R-CMD-check/badge.svg)](https://github.com/terminological/r6-generator-docs/actions)

[![DOI](https://zenodo.org/badge/503699096.svg)](https://zenodo.org/badge/latestdoi/503699096)

This test project demonstrates some of the major features of the maven plugin by creating a minimal R plugin from a set of annotated java classes.

```R
library(devtools)
# assuming you have cloned this repository locally:
load_all("~/Git/r6-generator-docs")

# install_github("terminological/r6-generator-docs")

# a basic smoke test
J <- testRapi::JavaApi$get()

# exploring the API using autocomplete in RStudio
# is a matter of typing J$<ctrl-space> 

tmp = J$FeatureTest$new()
tmp$doHelloWorld()

# generated documentation available

?testRapi-package
?testRapi::JavaApi
?testRapi::MinimalExample
?testRapi::FeatureTest
?testRapi::MoreFeatureTest
?testRapi::BounceTest
?testRapi::FactoryTest

```

Checkout the [features](https://terminological.github.io/r6-generator-docs/docs/articles/R6-generator-features.html)

see the [full docs](https://terminological.github.io/r6-generator-docs/)

see the [r package docs](https://terminological.github.io/r6-generator-docs/docs/)

see the [javadoc](https://terminological.github.io/r6-generator-docs/docs/javadoc/)

