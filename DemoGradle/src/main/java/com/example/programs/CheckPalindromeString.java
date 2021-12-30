package com.example.programs;

public class CheckPalindromeString {

    public static void main(String args[]){

        String str="abba";
        System.out.println(isPalindrome(str,0,str.length()-1));

    }

    public static boolean isPalindrome(String str, int leftIndex, int rightIndex){
        if(leftIndex>=rightIndex) {
            return true;
        }
        if(str.charAt(leftIndex)!=(str.charAt(rightIndex))){
            return false;
        }
        return isPalindrome(str,leftIndex+1,rightIndex-1);
    }
}
