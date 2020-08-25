/** Tyler Stamp
 * July 15, 2020
 * CS 3010
 * Project 1 **/

import java.util.Scanner;
public class Main {

    //Roots: x = 0.365, 1.922, 3.563
    //Root: x = 126.632
    public static void main(String args[]){
        Scanner kb = new Scanner(System.in);

        System.out.println("1. Bisection \n" + "2. Newton-Raphson \n" +
                "3. Secant \n" + "4. False-Position \n" + "5. Modified Secant \n");
        System.out.print("Pick your preferred method: ");

        int method = kb.nextInt();

        switch(method){
            case 1:
                Bisection();
                break;
            case 2:
                NewtonRaphson();
                break;
            case 3:
                Secant();
                break;
            case 4:
                FalsePosition();
                break;
            case 5:
                ModifiedSecant();
                break;
        }

    }

    static void Bisection(){
        double a1 = 0.0; // left interval 1
        double m = 0.0; // current midpoint
        double b1 = 0.5; // right interval 1
        double a2 = 1.9; // left interval 2
        double b2 = 2.0; // right interval 2
        double a3 = 3.0; // left interval 3
        double b3 = 3.6; // right interval 3
        double a4 = 126.0; // left interval 4
        double b4 = 127.0; // right interval 4
        double error = 0.001; //given error
        double er = 0.0; //current error

        int rootCount1 = 0; //number of roots found for first function
        int rootCount2 = 0; //number of roots found for second function
        double[] roots1 = new double[3];
        double[] roots2 = new double[3];


        /**Problem (A) Root 1**/
        for(int i = 0; i < 100; i++){

            //keep track of iterations
            System.out.print("Iteration #" + (i + 1));

            m = (a1+b1)/2;
            er = Math.abs((a1 - (a1+b1)/2)/Math.abs((a1+b1)/2));

            // insert a, b, and m into f(x) = 2x^3 - 11.7x^2 + 17.7x - 5
            double fm = Function1(m);

            System.out.println("  Root: " + m + "   Current Error: " + er);

            if(fm == 0 || er < error){
                break;
            }
            else if(fm < 0){
                a1 = m;
            }
            else{
                b1 = m;
            }
        }

        /**Root 2**/
        for(int i = 0; i < 100; i++){

            //keep track of iterations
            System.out.print("Iteration #" + (i + 1));

            m = (a2+b2)/2;
            er = Math.abs((a2 - (a2+b2)/2)/Math.abs((a2+b2)/2));


            // insert a, b, and m into f(x) = 2x^3 - 11.7x^2 + 17.7x - 5
            double fm = Function1(m);

            System.out.println("  Root: " + m + "   Current Error: " + er);

            if(fm == 0 || er < error){
                break;
            }
            else if(fm < 0){
                a2 = m;
            }
            else{
                b2 = m;
            }
        }

        /**Root 3**/
        for(int i = 0; i < 100; i++){

            //keep track of iterations
            System.out.print("Iteration #" + (i + 1));

            m = (a3+b3)/2;
            er = Math.abs((a3 - (a3+b3)/2)/Math.abs((a3+b3)/2));

            // insert a, b, and m into f(x) = 2x^3 - 11.7x^2 + 17.7x - 5
            double fm = Function1(m);

            System.out.println("  Root: " + m + "   Current Error: " + er);

            if(fm == 0 || er < error){
                break;
            }
            else if(fm < 0){
                a3 = m;
            }
            else{
                b3 = m;
            }
        }


        /**Problem (B)**/
        for(int i = 0; i < 100; i++){

            //keep track of iterations
            System.out.print("Iteration #" + (i + 1));

            m = (a4+b4)/2;

            er = Math.abs((a4 - (a4+b4)/2)/Math.abs((a4+b4)/2));
            // insert a, b, and m into f(x) = x + 10 - xcosh(50/x)
            double fm = Function2(m);

            System.out.println("  Root: " + m + "   Current Error: " + er);


            if(fm == 0 || er < error){
                break;
            }
            else if(fm < 0){
                b4 = m;
            }
            else{
                a4 = m;
            }
        }


    }

    static void NewtonRaphson(){
        double g1 = 0.5; // guess 1
        double g2 = 2.0; // guess 2
        double g3 = 3.0; // guess 3
        double g4 = 126.0; // guess 4
        double error = 0.001; //given error
        double er = 0.0; // current error


        /**Problem (A) Root 1**/
        for(int i = 0; i < 100; i++){

            //keep track of iterations
            System.out.print("Iteration #" + (i + 1));

            // formula = x(i+1) = x(i) - f(x)/f'(x)
            double fm = g1 - (Function1(g1))/(Function1Deriv(g1));
            er = (fm - g1)/fm;
            g1 = fm;

            System.out.println("  Root: " + g1 + "   Current Error: " + er);

            if(Math.abs(er) < error){
                break;
            }

        }

        /**Problem (A) Root 2**/
        for(int i = 0; i < 100; i++){

            //keep track of iterations
            System.out.print("Iteration #" + (i + 1));

            // formula = x(i+1) = x(i) - f(x)/f'(x)
            double fm = g2 - (Function1(g2))/(Function1Deriv(g2));
            er = (fm - g2)/fm;
            g2 = fm;

            System.out.println("  Root: " + g2 + "   Current Error: " + er);

            if(Math.abs(er) < error){
                break;
            }

        }

        /**Problem (A) Root 3**/
        for(int i = 0; i < 100; i++){

            //keep track of iterations
            System.out.print("Iteration #" + (i + 1));

            // formula = x(i+1) = x(i) - f(x)/f'(x)
            double fm = g3 - (Function1(g3))/(Function1Deriv(g3));
            er = (fm - g3)/fm;
            g3 = fm;

            System.out.println("  Root: " + g3 + "   Current Error: " + er);

            if(Math.abs(er) < error){
                break;
            }

        }

        /**Problem (B)**/
        for(int i = 0; i < 100; i++){

            //keep track of iterations
            System.out.print("Iteration #" + (i + 1));

            // formula = x(i+1) = x(i) - f(x)/f'(x)
            double fm = g4 - (Function2(g4))/(Function2Deriv(g4));
            er = (fm - g4)/fm;
            g4 = fm;

            System.out.println("  Root: " + g4 + "   Current Error: " + er);

            if(Math.abs(er) < error){
                break;
            }

        }

    }

    static void Secant(){

        double a1 = 0.0;
        double a2 = 0.5;
        double b1 = 1.0;
        double b2 = 2.0;
        double c1 = 3.0;
        double c2 = 4.0;
        double d1 = 120.0;
        double d2 = 130.0;
        double error = 0.01;
        double er = 0.0;

        /**Problem (A) Root 1**/

        for(int i = 0; i < 100; i++){

            //keep track of iterations
            System.out.print("Iteration #" + (i + 1));

            //x2 = x1 - [(x1 - x0)/(f(x1) - f(x0))]*f(x1)
            //x2 = x1 - ((x1 - x0) * functionOne(x1)) / (functionOne(x1) - functionOne(x0));
            double x2 = a2 - ((a2 - a1)*Function1(a2)) / (Function1(a2) - Function1(a1));

            er = Math.abs((a1 - (a1+a2)/2)/Math.abs((a1+a2)/2));
            a1 = a2;
            a2 = x2;

            System.out.println("  Root: " + x2 + "   Current Error: " + er);

            if(er < error){
                break;
            }

        }

        /**Root 2**/

        for(int i = 0; i < 100; i++){

            //keep track of iterations
            System.out.print("Iteration #" + (i + 1));

            //x2 = x1 - [(x1 - x0)/(f(x1) - f(x0))]*f(x1)
            double x2 = b2 - ((b2 - b1)*Function1(b2))/(Function1(b2)-Function1(b1));

            er = Math.abs((b1 - (b1+b2)/2)/Math.abs((b1+b2)/2));
            b1 = b2;
            b2 = x2;

            System.out.println("  Root: " + x2 + "   Current Error: " + er);

            if(Math.abs(er) < error){
                break;
            }

        }

        /**Root 3**/

        for(int i = 0; i < 100; i++){

            //keep track of iterations
            System.out.print("Iteration #" + (i + 1));

            //x2 = x1 - [(x1 - x0)/(f(x1) - f(x0))]*f(x1)
            double x2 = c2 - ((c2 - c1)*Function1(c2))/(Function1(c2)-Function1(c1));

            er = Math.abs((c1 - (c1+c2)/2)/Math.abs((c1+c2)/2));
            c1 = c2;
            c2 = x2;

            System.out.println("  Root: " + x2 + "   Current Error: " + er);

            if(Math.abs(er) < error){
                break;
            }

        }

        /**Problem (B)**/

        for(int i = 0; i < 100; i++){

            //keep track of iterations
            System.out.print("Iteration #" + (i + 1));

            //x2 = x1 - [(x1 - x0)/(f(x1) - f(x0))]*f(x1)
            double x2 = d2 - (d2 - d1)*Function2(d2)/(Function2(d2)-Function2(d1));

            er = Math.abs((d1 - (d1+d2)/2)/Math.abs((d1+d2)/2));
            d1 = d2;
            d2 = x2;

            System.out.println("  Root: " + x2 + "   Current Error: " + er);

            if(Math.abs(er) < error){
                break;
            }

        }

    }

    static void FalsePosition(){

        double a1 = 0.0; // left interval 1
        double b1 = 0.5; // right interval 1
        double a2 = 1.0; // left interval 2
        double b2 = 2.0; // right interval 2
        double a3 = 3.0; // left interval 3
        double b3 = 4.0; // right interval 3
        double a4 = 125.0; // left interval 4
        double b4 = 127.0; // right interval 4
        double error = 0.001; //given error
        double er = 0.0; //current error

        /**Problem (A) Root 1**/

        for(int i = 0; i < 100; i++){

            //keep track of iterations
            System.out.print("Iteration #" + (i + 1));

            //c = b - f(b)[(a-b)/(f(a)-f(b))]
            double x2 = b1 - Function1(b1)*((a1-b1)/(Function1(a1) - Function1(b1)));

            er = Math.abs((a1 - (a1+b1)/2)/Math.abs((a1+b1)/2));
            a1 = b1;
            b1 = x2;

            System.out.println("  Root: " + x2 + "   Current Error: " + er);

            if(Math.abs(er) < error){
                break;
            }

        }

        /**Root 2**/

        for(int i = 0; i < 100; i++){

            //keep track of iterations
            System.out.print("Iteration #" + (i + 1));

            //c = b - f(b)[(a-b)/(f(a)-f(b))]
            double x2 = b2 - Function1(b2)*((a2-b2)/(Function1(a2) - Function1(b2)));

            er = Math.abs((a2 - (a2+b2)/2)/Math.abs((a2+b2)/2));
            a2 = b2;
            b2 = x2;

            System.out.println("  Root: " + x2 + "   Current Error: " + er);

            if(Math.abs(er) < error){
                break;
            }
        }

        /**Root 3**/

        for(int i = 0; i < 100; i++){

            //keep track of iterations
            System.out.print("Iteration #" + (i + 1));

            //c = b - f(b)[(a-b)/(f(a)-f(b))]
            double x2 = b3 - Function1(b3)*((a3-b3)/(Function1(a3) - Function1(b3)));

            er = Math.abs((a3 - (a3+b3)/2)/Math.abs((a3+b3)/2));
            a3 = b3;
            b3 = x2;

            System.out.println("  Root: " + x2 + "   Current Error: " + er);

            if(Math.abs(er) < error){
                break;
            }
        }

        /**Problem (B)**/

        for(int i = 0; i < 100; i++){

            //keep track of iterations
            System.out.print("Iteration #" + (i + 1));

            //c = b - f(b)[(a-b)/(f(a)-f(b))]
            double x2 = b4 - Function2(b4)*((a4-b4)/(Function2(a4) - Function2(b4)));

            er = Math.abs((a4 - (a4+b4)/2)/Math.abs((a4+b4)/2));
            a4 = b4;
            b4 = x2;

            System.out.println("  Root: " + x2 + "   Current Error: " + er);

            if(Math.abs(er) < error){
                break;
            }
        }

    }

    static void ModifiedSecant(){

        double g1 = 0.5; // guess 1
        double g2 = 2.0; // guess 2
        double g3 = 3.0; // guess 3
        double g4 = 127.0; // guess 4
        double error = 0.01; //given error
        double er = 0.0; // current error

        /**Problem (A) Root 1**/


        for(int i = 0; i < 100; i++){

            //keep track of iterations
            System.out.print("Iteration #" + (i + 1));

            //x1 = x0 - f(x0)*[(error*x0)/(f(x0+error*x0)-f(x0)
            double x1 = g1 - Function1(g1)*((error*g1)/(Function1(g1+error*g1)-Function1(g1)));

            er = (x1 - g1)/x1;
            g1 = x1;

            System.out.println("  Root: " + x1 + "   Current Error: " + Math.abs(er));

            if(Math.abs(er) < error){
                break;
            }

        }

        /**Root 2**/

        for(int i = 0; i < 100; i++){

            //keep track of iterations
            System.out.print("Iteration #" + (i + 1));

            //x1 = x0 - f(x0)*[(error*x0)/(f(x0+error*x0)-f(x0)
            double x1 = g2 - Function1(g2)*((error*g2)/(Function1(g2+error*g2)-Function1(g2)));

            er = (x1 - g2)/x1;
            g2 = x1;

            System.out.println("  Root: " + x1 + "   Current Error: " + Math.abs(er));

            if(Math.abs(er) < error){
                break;
            }

        }

        /**Root 3**/

        for(int i = 0; i < 100; i++){

            //keep track of iterations
            System.out.print("Iteration #" + (i + 1));

            //x1 = x0 - f(x0)*[(error*x0)/(f(x0+error*x0)-f(x0)
            double x1 = g3 - Function1(g3)*((error*g3)/(Function1(g3+error*g3)-Function1(g3)));

            er = (x1 - g3)/x1;
            g3 = x1;

            System.out.println("  Root: " + x1 + "   Current Error: " + Math.abs(er));

            if(Math.abs(er) < error){
                break;
            }
        }

        /**Problem (B)**/

        for(int i = 0; i < 100; i++){

            //keep track of iterations
            System.out.print("Iteration #" + (i + 1));

            //x1 = x0 - f(x0)*[(error*x0)/(f(x0+error*x0)-f(x0)
            double x1 = g4 - Function2(g4)*((error*g4)/(Function2(g4+error*g4)-Function2(g4)));

            er = (x1 - g4)/x1;
            g4 = x1;

            System.out.println("  Root: " + x1 + "   Current Error: " + Math.abs(er));

            if(Math.abs(er) < error){
                break;
            }
        }

    }

    static double Function1(double m){
        return 2*(m*m*m) - 11.7*(m*m) + 17.7*(m) - 5;
    }

    static double Function1Deriv(double m){
        return 6*(m*m) - 23.4*m + 17.7;
    }

    static double Function2(double m){
        return m + 10 - (m*(Math.cosh(50/m)));
    }

    static double Function2Deriv(double m){
        return (((50*Math.sinh(50/m))/m) - Math.cosh(50/m) +1);
    }

}
