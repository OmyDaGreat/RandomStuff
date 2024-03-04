package org.example.math;

import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math3.analysis.solvers.LaguerreSolver;
import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;

public class PolynomialSolver {

  private PolynomialSolver() {
    throw new IllegalStateException("Utility class");
  }

  public static Complex[] solvePolynomial(double[] coefficients)
    throws NullArgumentException, NoDataException, TooManyEvaluationsException {
    return new LaguerreSolver()
      .solveAllComplex(
        new PolynomialFunction(coefficients).getCoefficients(),
        0
      );
  }
}
