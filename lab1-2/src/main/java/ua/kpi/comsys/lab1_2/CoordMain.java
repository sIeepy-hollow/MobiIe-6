package ua.kpi.comsys.lab1_2;

public class CoordMain {

    public static void main(String[] args) {

        CoordinateTD cNS0 = new CoordinateTD(Direction.LATITUDE);
        CoordinateTD cEW0 = new CoordinateTD(Direction.LONGITUDE);

        try {

            CoordinateTD cNS1 = new CoordinateTD(Direction.LATITUDE, -75, 43, 12);
            CoordinateTD cNS2 = new CoordinateTD(Direction.LATITUDE, 44, 32, 57);
            CoordinateTD cEW1 = new CoordinateTD(Direction.LONGITUDE, -12, 30, 40);
            CoordinateTD cEW2 = new CoordinateTD(Direction.LONGITUDE, -2, 30, 40);

            System.out.println("Zero coordinate N-S: " + cNS0.degreeStr() + " = " + cNS0.decimalString());
            System.out.println("Zero coordinate E-W: " + cEW0.degreeStr() + " = " + cEW0.decimalString());
            System.out.println("Coordinate 1 N-S: " + cNS1.degreeStr() + " = " + cNS1.decimalString());
            System.out.println("Coordinate 2 N-S: " + cNS2.degreeStr() + " = " + cNS2.decimalString());
            System.out.println("Coordinate 1 E-W: " + cEW1.degreeStr() + " = " + cEW1.decimalString());
            System.out.println("Coordinate 2 E-W: " + cEW2.degreeStr() + " = " + cEW2.decimalString());

            CoordinateTD res;
            System.out.println("\nAttempt to calculate middle between 0 and coordinate 1 N-S with exemplar method...");
            res = cNS0.middleWith(cNS1);
            if (res == null) System.out.println("Attempt failed.");
            else System.out.println("Success! Result is: " + res.degreeStr() + " = " + res.decimalString());
            System.out.println("\nAttempt to calculate middle between 0 and coordinate 1 N-S with class method...");
            res = CoordinateTD.middleTwo(cNS0, cNS1);
            if (res == null) System.out.println("Attempt failed.");
            else System.out.println("Success! Result is: " + res.degreeStr() + " = " + res.decimalString());
            System.out.println("\nAttempt to calculate middle between 0 and coordinate 2 E-W with exemplar method...");
            res = cEW0.middleWith(cEW2);
            if (res == null) System.out.println("Attempt failed.");
            else System.out.println("Success! Result is: " + res.degreeStr() + " = " + res.decimalString());
            System.out.println("\nAttempt to calculate middle between coordinates 1 and 2 N-S with class method...");
            res = CoordinateTD.middleTwo(cNS1, cNS2);
            if (res == null) System.out.println("Attempt failed.");
            else System.out.println("Success! Result is: " + res.degreeStr() + " = " + res.decimalString());
            System.out.println("\nAttempt to calculate middle between coordinates 1 and 2 W-E with class method...");
            res = CoordinateTD.middleTwo(cEW1, cEW2);
            if (res == null) System.out.println("Attempt failed.");
            else System.out.println("Success! Result is: " + res.degreeStr() + " = " + res.decimalString());
            System.out.println("\nAttempt to calculate middle between coordinate 1 N-S and coordinate 2 E-W with exemplar method...");
            res = cNS1.middleWith(cEW2);
            if (res == null) System.out.println("Attempt failed.");
            else System.out.println("Success! Result is: " + res.degreeStr() + " = " + res.decimalString());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
