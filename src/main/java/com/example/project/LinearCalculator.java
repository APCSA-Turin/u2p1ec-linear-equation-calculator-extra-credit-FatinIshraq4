//Fatin Ishraq
//AP CSA PD5
package com.example.project;
public class LinearCalculator{
    //FOR EXTRA CREDIT 

    //INSTANCE VARIABLES
    //4 INTEGER variables representing x and y values of two coordinates
    int x1;
    int x2;
    int y1;
    int y2;


    //CONSTRUCTOR
    //1 constructor with 2 String parameters. Each parameter represents a coordinate.
    // ex: find numbers from (-1,2)
    //I learned how to parse strings from https://www.javatpoint.com/java-string-to-int
    public LinearCalculator(String coord1, String coord2){ // <--2 string parameters in constructor


        coord1 = coord1.substring(1, coord1.length() - 1); // removing parenthesis ()
        coord2 = coord2.substring(1, coord2.length() - 1);
        int x = coord1.indexOf(",");
        int y = coord2.indexOf(",");


        x1 = Integer.parseInt(coord1.substring(0,x)); //seperating based on position of the comma so negatives are included
        y1 = Integer.parseInt(coord1.substring(x+1));
        x2 = Integer.parseInt(coord2.substring(0,y));
        y2 = Integer.parseInt(coord2.substring(y+1));
    }



    //METHODS
    //getters and setters for the 4 instance variables
    public int getX1(){return x1;}
    public int getY1(){return y1;}
    public int getX2(){return x2;}
    public int getY2(){return y2;}
    public void setX1(int val){x1=val;}
    public void setY1(int val){y1=val;}
    public void setX2(int val){x2=val;}
    public void setY2(int val){y2=val;}

     
    //calculates the distance between the two points to the nearest HUNDREDTH and returns a double
    public double distance(){
        double dist = Math.sqrt((Math.pow(x2-x1,2)+Math.pow(y2-y1,2)));
        dist = Math.round(dist * 100.0) / 100.0;
        return dist;
    }


    //yInt() -> returns a double.
    //calculates the y intercept of the equation and returns the value to the nearest HUNDREDTH
    //if y-int if undefined, should return -999.99
    public double yInt(){
        if (slope()==-999.99) {
            return -999.99;
        } else {
        double y = y1;
        double x = x1;
        double m = slope();
        double b = y - (x*m);
        b = Math.round(b * 100.0) / 100.0;
        return b;
        }
       
    }

    //slope() -> returns a double.
    //calculates the slope of the equation
    public double slope(){
        if (x2-x1==0) { //if slope is undefined when the bottom is 0 it will return -999.99
            return -999.99;
        } else {
            double yChange = y2-y1;
            double xChange = x2-x1;
            double slope = yChange/xChange;
            return (Math.round(slope * 100.0) / 100.0); //rounds slope to nearest hundred before returning
        }
    }

    //equations() -> returns a String.
    //calculates the final equation in y=mx+b form and returns the string
    //if the equation has no slope, the equation should return -> "undefined"
    public String equation() {
        if (yInt()<0) { //to account for negative y-intercepts
            if (slope()==-999.99) {
                return "undefined";
            } else {
                if (slope()==0) {
                    return "y=" + yInt();
                } else {
                    if (yInt()==0) {
                    return "y=" + slope() + "x";
                } else {
                    return "y=" + slope() + "x" + yInt();
                }
                }
               
               
            }
        } else {
            if (slope()==-999.99) {
                return "undefined";
            } else {
                if (slope()==0) {
                    return "y=" + yInt();
                } else {
                    if (yInt()==0) {
                    return "y=" + slope() + "x";
                } else {
                    return "y=" + slope() + "x+" + yInt();
                }
                }
               
               
            }
        }


    }


    //roundedToHundredth(double x)-> returns double
    //calculates the input to the nearest hundredth and returns that value
    public double roundedToHundredth(double x){
        return (Math.round(x * 100.0) / 100.0);
    }



     
    
    public String printInfo(){
        String str = "The two points are: " + "(" + x1 + "," + y1 + ")";
        str += " and " + "(" + x2 + "," + y2 + ")";
        str += "\nThe equation of the line between these points is: " + equation();
        str += "\nThe slope of this line is: " + slope();
        str += "\nThe y-intercept of the line is: " + yInt();
        str += "\nThe distance between the two points is: " + distance();
        str += "\n" + findSymmetry(); //results from findSymmetry are added
        str += "\n" + Midpoint(); //results from Midpoint are added
        return str;
    }


    //findSymmetry()-> returns a string 
    //the method determines if there is symmetry between the two points
    // there are 4 return statements 
    // return "Symmetric about the x-axis";
    // return "Symmetric about the y-axis";
    //return "Symmetric about the origin";
    //return "No symmetry";
    public String findSymmetry(){
        if (y2==(-y1) && x2==(-x1)) { //if both x and y values are opposites
            return "Symmetric about the origin";
        }
        if (y2==(-y1)) { //if the y values are opposite of each other
            return "Symmetric about the x-axis";
        }
        if (x2==(-x1)) { //if the x values are opposite of each other
            return "Symmetric about the y-axis";
        }
        return "No symmetry";
    
    }

    //Midpoint()->return a string 
    //this method calculates the midpoint between the two points
    //it returnx "The midpoint of this line is: (0,0)";
    public String Midpoint(){
        double yDiff = y2-y1; //first the difference is found 
        double xDiff = x2-x1;
        xDiff = xDiff/2;
        yDiff = yDiff/2;
        double xMid = x1 + xDiff; //then the differences are added to one pair of points
        double yMid = y1 + yDiff;
        String midpoint = "(" + xMid + "," + yMid + ")";
        return "The midpoint of this line is: " + midpoint;
    }

}



