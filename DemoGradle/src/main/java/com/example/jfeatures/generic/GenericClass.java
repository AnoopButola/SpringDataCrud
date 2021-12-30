package com.example.jfeatures.generic;


//Generics work only with Reference Types:
//When we declare an instance of a generic type, the type argument passed to the type parameter must be a reference type. We cannot use primitive data types like int, char.


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Advantages of Generics:
/*
1. Code Reuse: We can write a method/class/interface once and use it for any type we want.

2. Type Safety: Generics make errors to appear compile time than at run time (It’s always better to know problems in your code at compile time rather than making your code fail at run time).
 Suppose you want to create an ArrayList that store name of students and if by mistake programmer adds an integer object instead of a string, the compiler allows it. But, when we retrieve this data from ArrayList, it causes problems at runtime.

3. Individual Type Casting is not needed: If we do not use generics, then, in the above example every time we retrieve data from ArrayList, we have to typecast it. Typecasting at every retrieval operation is a big headache.
If we already know that our list only holds string data then we need not typecast it every time.

4. Generics promotes code reusability.
5. Implementing generic algorithms: By using generics,
we can implement algorithms that work on different types of objects and at the same, they are type safe too.

 */
public class GenericClass<T> {
    T obj;
    GenericClass(T t){
        this.obj=t;
    }

    public void display(){
        System.out.println("Display default content::"+this.obj);
    }

    public  T getObjectType(){
          //System.out.println(this.obj.getClass().getName());
          return this.obj;
    }


    public <T> List<T> fromArrayToList(T[] a) {

       List list= new ArrayList<T>();
        for(int i=0;i<a.length;i++){
            list.add(a[i]);
        }
        return list;
    }

}


class Driver{
    public static void main(String args[]){
        GenericClass stringVersionObj= new GenericClass<String>("String version of generic class");
        stringVersionObj.display();
        stringVersionObj.getObjectType();

        GenericClass integerVersionObj=new GenericClass<Integer>(new Integer(20));
        integerVersionObj.display();
        integerVersionObj.getObjectType();

        GenericClass obj=new GenericClass(10);
        obj.display();

        System.out.println(obj.getObjectType());

        Integer array[]={2,3,4,5,6};
        String stringArray[]={"Ram","Shyam","radha"};
        System.out.println(obj.fromArrayToList(array));
        System.out.println(obj.fromArrayToList(stringArray));

        List<String> list= Arrays.asList("Ram","Shyam","Karan");

        list.stream().filter(element->element.startsWith("K")).collect(Collectors.toList()).forEach(element->System.out.println(element));
       // list.forEach(element->System.out.println(element));
    }
}