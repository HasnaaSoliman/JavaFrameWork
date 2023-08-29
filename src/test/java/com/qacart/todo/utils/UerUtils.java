package com.qacart.todo.utils;

import com.github.javafaker.Faker;
import com.qacart.todo.objects.User;

public class UerUtils {
    public static User GenerateRandomUser(){
        String firstName=new Faker().name().firstName();
        String lastName=new Faker().name().lastName();
        String email= new Faker().internet().emailAddress();
        String password= new Faker().internet().password();


        User user=new User(email,firstName,lastName,password);
        return user;
    }
}
