% Generated by r6-generator-maven-plugin: do not edit by hand

\name{collider.more_feature_test}
\alias{collider.more_feature_test}
\title{no title}
\usage{collider.more_feature_test(
	message1,
	message2
)
}
\arguments{
	\if{html}{\out{<div class="arguments">}}
	\item{message1}{message1 - (java expects a RCharacter)}
	\item{message2}{message2 - (java expects a RCharacter)}
	\if{html}{\out{</div>}}
}
\value{
RCharacter: 

}
\description{
no description
}
\examples{
library(testthat)
tmp = collider.more_feature_test('should ','work')
expect_equal(tmp,'more feature test: should work')
}
\keyword{java api}


