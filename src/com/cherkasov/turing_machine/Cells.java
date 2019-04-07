package com.cherkasov.turing_machine;

import java.util.ArrayList;
import java.util.Scanner;

public class Cells {
    ArrayList<Character> list=new ArrayList<Character>();
    ArrayList<Character> alphabet=new ArrayList<Character>();
    static int current_place;
    Scanner in=new Scanner(System.in);
    Cells(){
        current_place=0;
    }

    public void inputList() {
        int n;
        boolean belongs;
        System.out.println("initial length of the tape: ");
        n=in.nextInt();
        for(int i=0;i<n;i++){
            list.add(in.next().charAt(0));
            belongs=false;
            while (!belongs){
            for(int j=0;j<alphabet.size();j++) {

                 if(list.get(i)==alphabet.get(j)){
                     belongs=true;
                     break;
                    }
                }
                if(!belongs){
                    System.out.println("The symbol being inputed doesn't belong to the alphabet");
                    in.nextLine();
                    list.set(i,in.next().charAt(0));
                }
            }
        }
    }

    public void setAlphabet(){
        alphabet.add('1');
        alphabet.add('0');
        alphabet.add('#');
    }

    public boolean operate(Condition first,char a,Condition second,char b,char move) {
        if (first == second) {
            while (true) {
                if (list.get(first.getPoint_at()) != a) {
                    return false;
                }
                if (first.getPoint_at() != current_place) {
                    current_place = first.getPoint_at();

                }
                if (move == 'L') {
                    if (current_place == 0) {
                        list.add(current_place, '#');
                        list.set(current_place + 1, b);
                    } else {
                        list.set(current_place, b);
                        --current_place;
                    }
                    second.setPoint_at(current_place);
                }

                if (move == 'R') {
                    if (current_place == list.size() - 1) {
                        list.add('#');
                        list.set(current_place, b);
                    } else {
                        list.set(current_place, b);
                    }
                    ++current_place;
                    second.setPoint_at(current_place);
                }

                if (move == 'P') {
                    list.set(current_place, b);
                    second.setPoint_at(current_place);
                }
                this.print();
                operate(first,a,second,b,move);
                return true;

            }
        }
        else{

            if (list.get(first.getPoint_at()) != a) {
                return false;
            }

            if (first.getPoint_at() != current_place) {
                current_place = first.getPoint_at();

            }

            if (move == 'L') {
                if (current_place == 0) {
                    list.add(current_place, '#');
                    list.set(current_place + 1, b);
                } else {
                    list.set(current_place, b);
                    --current_place;
                }
                second.setPoint_at(current_place);
            }

            if (move == 'R') {
                if (current_place == list.size() - 1) {
                    list.add('#');
                    list.set(current_place, b);
                } else {
                    list.set(current_place, b);
                }
                ++current_place;
                second.setPoint_at(current_place);
            }

            if (move == 'P') {
                list.set(current_place, b);
                second.setPoint_at(current_place);
            }

            this.print();
            return true;
        }
    }

    public void print(){
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println(" ");
    }
}
