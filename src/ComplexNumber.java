import java.util.Objects;

public final class ComplexNumber {
    private final double re;
    private final double im;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComplexNumber that = (ComplexNumber) o;
        return Double.compare(that.re, re) == 0 && Double.compare(that.im, im) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(re, im);
    }

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }
    public static void main(String[] args) {
        ComplexNumber cn1 = new ComplexNumber(2.3412,7.2434);
        ComplexNumber cn2 = new ComplexNumber(2.3412,7.2434);
        ComplexNumber cn3 = new ComplexNumber(3.23124,1435.23);
        System.out.println("equals cn1 & cn2 true // " + cn1.equals(cn2));
        System.out.println("equals cn2 & cn1 true // " + cn2.equals(cn1));
        System.out.println("equals cn2 & cn3 false // " + cn2.equals(cn3));
        System.out.println("equals cn3 & cn1 false // " + cn3.equals(cn1));
        System.out.println("hash cn1 & cn2 true // " + (cn1.hashCode() == cn2.hashCode()));
        System.out.println("hash cn2 & cn1 true // " + (cn2.hashCode() == cn1.hashCode()));
        System.out.println("hash cn3 & cn1 false // " + (cn3.hashCode() == cn1.hashCode()));
        System.out.println("hash cn3 & cn2 false // " + (cn3.hashCode() == cn2.hashCode()));

        System.out.println(cn1.equals(cn2));
        System.out.println(cn1.equals(cn3));
        System.out.println(cn2.equals(cn1));
        System.out.println(cn2.equals(cn3));
        System.out.println(cn3.equals(cn1));
        System.out.println(cn3.equals(cn2));

        System.out.println(cn1.hashCode());
        System.out.println(cn2.hashCode());
        System.out.println(cn3.hashCode());

    }
}

