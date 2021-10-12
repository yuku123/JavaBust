package com.zifang.ex.bust.charpter4.case3;

class Human{
    String sex;
    String age;
    {
        sex = "sex";
    }
    {
        sex = "dd";
    }
    Human(String sex, String age){
        this.sex = sex;
        this.age = age;
    }
    Human(String sex){
        this.sex = sex;
    }
    Human(){ }

    public static void main(String[] args) {
        Human human = new Human();
        System.out.println("--");
    }
}