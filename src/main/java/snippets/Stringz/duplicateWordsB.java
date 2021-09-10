package snippets.Stringz;

import org.apache.commons.lang.StringUtils;

public class duplicateWordsB {
//    Goodbye bye bye world world world
//    Sam went went to to to his business
//    Reya is is the the best player in eye eye game
//    in inthe
//    Hello hello Ab aB

    public static void main(String[] args) {

        String s = "Goodbyebyebyeworldworldworld";
        String norep = "";
        String[] x = s.split("");

        for(int i =0; i< x.length; i++){

            norep = x[i];

            if(StringUtils.countMatches(s, x[i])>1){
//                System.out.println(word);

            }
//            System.out.println(word);


        }

    }

}
