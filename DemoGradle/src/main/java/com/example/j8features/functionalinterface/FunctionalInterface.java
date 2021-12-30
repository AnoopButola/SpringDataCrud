package com.example.j8features.functionalinterface;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;

@java.lang.FunctionalInterface
public interface FunctionalInterface {
    public void abstractMethod(Integer a,Integer b);
    public static void staticMethod1(){
        System.out.println("F Interface  can have n number of staticMethod");
    }

    public static void staticMethod2(){
        System.out.println("F Interface  can have n number of staticMethod");
    }

    public default void defaultMethod1(){
        System.out.println("Functional Interface can have n number of default methods and these were introduced for backward compatibility in " +
                "Like when something common need to be included in future we can easily do that by making change in one location and all implementation can get that.");
    }


    public default void defaultMethod2(){
        System.out.println("Functional Interface can have n number of default methods and these were introduced for backward compatibility in " +
                "Like when something common need to be included in future we can easily do that by making change in one location and all implementation can get that.");
    }


}

@java.lang.FunctionalInterface
 interface FunctionalInterface2{
     public Integer sum(Integer a, Integer b);

}



@java.lang.FunctionalInterface
 interface FunctionalInterface3 {
     public Integer subtract(Integer first, Integer second);
    //public Integer subtract2(Integer first, Integer second);

}

@java.lang.FunctionalInterface
interface CustomPredicate extends java.util.function.Predicate {

}

@java.lang.FunctionalInterface
interface CustomBinaryOperator extends java.util.function.BinaryOperator {

}

@java.lang.FunctionalInterface
interface CustomFunction extends java.util.function.Function{

}


interface CustomUnaryOperator extends UnaryOperator{

}


interface CustomSupplier extends Supplier{
 //this is like Factory interface whrein we can supply anthing without depending on any inout
}


 class DriverClass{
    public static void main(String[] args){
        DriverClass obj=  new DriverClass();
        FunctionalInterface obj1 =( a, b)-> System.out.println(a+b);
        obj1.abstractMethod(4,6);


        FunctionalInterface2 obj2=(a, b)-> {return a+b;};
        System.out.println(obj2.sum(3,4));


        FunctionalInterface3 obj3=(first,second)-> {return first-second;};
        System.out.println(obj3.subtract(10,7));

        CustomPredicate customPredicate =(number)->{
            if((Integer)number>0)
                return true;
            else
                return false;
            };

        if(customPredicate.test(10)){
            System.out.println("Number is positive");
        }else{
            System.out.println("Number is negative");
        }

        //if both number are positive return positive 1  and if both are negative return negative number  -1.
        CustomBinaryOperator binaryOperatorObj=(firstNumber,secondNumber)-> {
            Integer a=(Integer)firstNumber;
            Integer b=(Integer)secondNumber;
            if (a > 0 && b > 0) {
                return 1;
            } else if (a < 0 && b < 0) {
                return -1;
            } else {
                return 0;
            }
        };

       Integer result =(Integer) binaryOperatorObj.apply(10,20);
       System.out.println(result);

    }
}