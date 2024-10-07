/**
 * Assignment 3 for CS 1410
 * This program determines if points are contained within circles or rectangles.
 */
public class Inside {
    /**
     * This is the primary driver code to test the "inside" capabilities of the
     * various functions.
     */
    public static void main(String[] args) {

     /* Declaration of variables/arrays */
        double[] ptX = {1, 2, 3, 4};
        double[] ptY = {1, 2, 3, 4};
        double[] circleX = {0, 5};
        double[] circleY = {0, 5};
        double[] circleRadius = {3, 3};
        double[] rectLeft = {-2.5, -2.5};
        double[] rectTop = {2.5, 5.0};
        double[] rectWidth = {6.0, 5.0};
        double[] rectHeight = {5.0, 2.5};

        /* We start by reporting points and circles */
        System.out.println("--- Report of Points and Circles ---\n");

        /* For every variation of the circle... */
        for (int i = 0; i <= 1; i++) {
            /* For every point to test */
            for (int j = 0; j <= 3; j++) {
                /* Report the point, append to whether it's inside/outside, then report the dimensions of the circle */
                reportPoint(ptX[j], ptY[j]);
                if (isPointInsideCircle(ptX[j], ptY[j], circleX[i], circleY[i], circleRadius[i])) {
                    System.out.print(" is inside ");
                }
                else {
                    System.out.print(" is outside ");
                }
                reportCircle(circleX[i], circleY[i], circleRadius[i]);
                System.out.println();
            }
        }

        /* Onto the rectangles */
        System.out.println("\n--- Report of Points and Rectangles ---\n");

        /* For every rectangle variation */
        for (int i = 0; i <= 1; i++) {
            /* For every point */
            for (int j = 0; j <= 3; j++) {
                /* Report the point, append to whether it's inside/outside, then report the dimensions of the rectangle */
                reportPoint(ptX[j], ptY[j]);
                if (isPointInsideRectangle(ptX[j], ptY[j], rectLeft[i], rectTop[i], rectWidth[i], rectHeight[i])) {
                    System.out.print(" is inside ");
                }
                else {
                    System.out.print(" is outside ");
                }
                reportRectangle(rectLeft[i], rectTop[i], rectWidth[i], rectHeight[i]);
                System.out.println();
            }
        }
    }

    /* Prints point */
    public static void reportPoint(double x, double y) {
        System.out.printf("Point(%.1f, %.1f)", x, y);
    }

    /* Prints info about circle dimensions */
    public static void reportCircle(double x, double y, double r) {
        System.out.printf("Circle(%.1f, %.1f) Radius: %.1f", x, y, r);
    }

    /* Prints infor about rectangle dimensions */
    public static void reportRectangle(double left, double top, double width, double height) {
        double right = left + width;
        double bottom = top - height;
        System.out.printf("Rectangle(%.1f, %.1f, %.1f, %.1f)", left, top, right, bottom);
    }

    /* Tests if the difference between the point and the center is greater than the radius, using Pythagorean Theorem */
    public static boolean isPointInsideCircle(double ptX, double ptY, double circleX, double circleY, double circleRadius) {
        return Math.pow(circleRadius, 2) >= Math.pow(ptX - circleX, 2) + Math.pow(ptY - circleY, 2);
    }

    /* Tests if the coordinates extend beyond the top/bottom or left/right sides of the rectangle */
    public static boolean isPointInsideRectangle(double ptX, double ptY, double rLeft, double rTop, double rWidth, double rHeight) {
        boolean xInside = false;
        boolean yInside = false;
        if (ptX >= rLeft && ptX <= rLeft + rWidth) {
            xInside = true;
        }
        if (ptY <= rTop && ptY >= rTop - rHeight) {
            yInside = true;
        }
        return xInside && yInside;
    }
}
