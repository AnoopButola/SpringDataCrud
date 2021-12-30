package com.example.programs;

public class PowerSet {

    public static void main(String args[]){
       String s="abc";
        powerSet(s,0,"");
    }


    public static void powerSet(String s,int i, String result){
        if(i==s.length()){
            System.out.println(s);
            return;
        }

        powerSet(s,i+1,result+s.charAt(i));
        powerSet(s,i+1,result);
    }

}


/*
      abc

   a                        ""

ab          a             b          ""

abc  ab     ac   a       bc     b     c   ""



 */