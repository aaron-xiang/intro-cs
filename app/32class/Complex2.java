/******************************************************************************
 *  Compilation:  javac Complex2.java
 *  Execution:    java Complex2
 *
 *  Data type for complex numbers.
 *
 *  The data type is "immutable" so once you create and initialize
 *  a Complex2 object, you cannot change it. The "final" keyword
 *  when declaring re and im enforces this rule, making it a
 *  compile-time error to change the .re or .im instance variables after
 *  they've been initialized.
 *
 *  % java Complex2
 *  a            = 5.0 + 6.0i
 *  b            = -3.0 + 4.0i
 *  Re(a)        = 5.0
 *  Im(a)        = 6.0
 *  b + a        = 2.0 + 10.0i
 *  a - b        = 8.0 + 2.0i
 *  a * b        = -39.0 + 2.0i
 *  b * a        = -39.0 + 2.0i
 *  a / b        = 0.36 - 1.52i
 *  (a / b) * b  = 5.0 + 6.0i
 *  conj(a)      = 5.0 - 6.0i
 *  |a|          = 7.810249675906654
 *  tan(a)       = -6.685231390246571E-6 + 1.0000103108981198i
 *
 ******************************************************************************/

import java.util.Objects;

public class Complex2 {
    private final double re;   // the real part
    private final double im;   // the imaginary part

    // create a new object with the given real and imaginary parts
    public Complex2(double real, double imag) {
        re = real;
        im = imag;
    }

    // return a string representation of the invoking Complex2 object
    public String toString() {
        if (im == 0) return re + "";
        if (re == 0) return im + "i";
        if (im <  0) return re + " - " + (-im) + "i";
        return re + " + " + im + "i";
    }

    // return abs/modulus/magnitude
    public double abs() {
        return Math.hypot(re, im);
    }

    // return angle/phase/argument, normalized to be between -pi and pi
    public double phase() {
        return Math.atan2(im, re);
    }

    // return a new Complex2 object whose value is (this + b)
    public Complex2 plus(Complex2 b) {
        Complex2 a = this;             // invoking object
        double real = a.re + b.re;
        double imag = a.im + b.im;
        return new Complex2(real, imag);
    }

    // return a new Complex2 object whose value is (this - b)
    public Complex2 minus(Complex2 b) {
        Complex2 a = this;
        double real = a.re - b.re;
        double imag = a.im - b.im;
        return new Complex2(real, imag);
    }

    // return a new Complex2 object whose value is (this * b)
    public Complex2 times(Complex2 b) {
        Complex2 a = this;
        double real = a.re * b.re - a.im * b.im;
        double imag = a.re * b.im + a.im * b.re;
        return new Complex2(real, imag);
    }

    // return a new object whose value is (this * alpha)
    public Complex2 scale(double alpha) {
        return new Complex2(alpha * re, alpha * im);
    }

    // return a new Complex2 object whose value is the conjugate of this
    public Complex2 conjugate() {
        return new Complex2(re, -im);
    }

    // return a new Complex2 object whose value is the reciprocal of this
    public Complex2 reciprocal() {
        double scale = re*re + im*im;
        return new Complex2(re / scale, -im / scale);
    }

    // return the real or imaginary part
    public double re() { return re; }
    public double im() { return im; }

    // return a / b
    public Complex2 divides(Complex2 b) {
        Complex2 a = this;
        return a.times(b.reciprocal());
    }

    // return a new Complex2 object whose value is the complex exponential of this
    public Complex2 exp() {
        return new Complex2(Math.exp(re) * Math.cos(im), Math.exp(re) * Math.sin(im));
    }

    // return a new Complex2 object whose value is the complex sine of this
    public Complex2 sin() {
        return new Complex2(Math.sin(re) * Math.cosh(im), Math.cos(re) * Math.sinh(im));
    }

    // return a new Complex2 object whose value is the complex cosine of this
    public Complex2 cos() {
        return new Complex2(Math.cos(re) * Math.cosh(im), -Math.sin(re) * Math.sinh(im));
    }

    // return a new Complex2 object whose value is the complex tangent of this
    public Complex2 tan() {
        return sin().divides(cos());
    }
    


    // a static version of plus
    public static Complex2 plus(Complex2 a, Complex2 b) {
        double real = a.re + b.re;
        double imag = a.im + b.im;
        Complex2 sum = new Complex2(real, imag);
        return sum;
    }

    // See Section 3.3.
    public boolean equals(Object x) {
        if (x == null) return false;
        if (this.getClass() != x.getClass()) return false;
        Complex2 that = (Complex2) x;
        return (this.re == that.re) && (this.im == that.im);
    }

    // See Section 3.3.
    public int hashCode() {
        return Objects.hash(re, im);
    }

    // sample client for testing
    public static void main(String[] args) {
        Complex2 a = new Complex2(5.0, 6.0);
        Complex2 b = new Complex2(-3.0, 4.0);

        StdOut.println("a            = " + a);
        StdOut.println("b            = " + b);
        StdOut.println("Re(a)        = " + a.re());
        StdOut.println("Im(a)        = " + a.im());
        StdOut.println("b + a        = " + b.plus(a));
        StdOut.println("a - b        = " + a.minus(b));
        StdOut.println("a * b        = " + a.times(b));
        StdOut.println("b * a        = " + b.times(a));
        StdOut.println("a / b        = " + a.divides(b));
        StdOut.println("(a / b) * b  = " + a.divides(b).times(b));
        StdOut.println("conj(a)      = " + a.conjugate());
        StdOut.println("|a|          = " + a.abs());
        StdOut.println("tan(a)       = " + a.tan());
    }

}
