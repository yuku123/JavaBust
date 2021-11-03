package com.zifang.ex.bust.charpter4.case4;

class Human7 {
    void handle(int... d){
        for (int dd : d){
            System.out.println(dd);
        }
    }

    public static void main(String[] args) {
        Human7 human = new Human7();
        human.handle(1,2,3,4);
    }
}
