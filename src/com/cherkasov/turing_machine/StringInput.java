package com.cherkasov.turing_machine;

import java.util.ArrayList;
import java.util.Scanner;

public class StringInput {

   private ArrayList<String> commands=new ArrayList<>();
   private ArrayList<Condition> conditions=new ArrayList<>();


    StringInput() {
        Scanner in=new Scanner(System.in);
        Cells cells = new Cells();
        cells.setAlphabet();
        cells.inputList();
        String temp;
do {
    temp = in.nextLine();
    commands.add(temp);
}while(!temp.equals("stop"));


        Condition first = new Condition();
        Condition second = new Condition();
        first.setName("q1");
        second.setName("q2");
        cells.operate(first, commands.get(0).charAt(2), second, commands.get(0).charAt(7), commands.get(0).charAt(8));
        conditions.add(first);
        conditions.add(second);
        boolean Is_operated = false;
        boolean Current_operated;
        do {
            for (int i = 1; i < commands.size() - 2; i++) {
                boolean exist2=false;
                for (int j = 0; j < conditions.size(); j++) {
                    if (conditions.get(j).getName().equals( commands.get(i).substring(0, 2))) {
                        first = conditions.get(j);
                        break;
                    }
                }



                for (int j = 0; j < conditions.size(); j++) {
                    if (conditions.get(j).getName().equals(commands.get(i).substring(5, 7))) {
                        exist2 = true;
                        second = conditions.get(j);
                        break;
                    }
                }

              if(!exist2){
                  conditions.add(new Condition());
                  conditions.get(conditions.size() - 1).setName(commands.get(i).substring(5, 7));
                  second = conditions.get(conditions.size() - 1);
                }

                Current_operated = cells.operate(first, commands.get(i).charAt(2), second, commands.get(i).charAt(7), commands.get(i).charAt(8));

              if(Current_operated){
                  Is_operated=true;
              }
            }

        } while(Is_operated);
        second = new Condition();
        second.setName("q0");
        for (int j = 0; j < conditions.size(); j++) {
            if (conditions.get(j).getName().equals(commands.get(commands.size() - 2).substring(4, 6))) {
                first = conditions.get(j);
                break;
            }
        }

                cells.operate(first, commands.get(commands.size() - 2).charAt(2), second,
                commands.get(commands.size() - 2).charAt(7), commands.get(commands.size() - 2).charAt(8));
    }
}
