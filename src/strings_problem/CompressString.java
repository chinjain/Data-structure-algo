package strings_problem;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class CompressString {

    public static void main(String[] args) {

        String input = "jksandfkj38298rh4r=";

        int count = 1;
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < input.length(); i++){
            if(input.charAt(i) == input.charAt(i - 1)){
                count++;
            }else {
                sb.append(input.charAt(i - 1)).append(count);
                count = 1;
            }
        }

        sb.append(input.charAt(input.length() - 1)).append(count);
        System.out.println(sb.toString());
        compress(input);

    }

    private static void compress(String input) {

        StringBuilder res = new StringBuilder();
        AtomicInteger count = new AtomicInteger();

        IntStream.range(0,input.length())
                .forEach(i -> {

                    if(i > 0 && input.charAt(i) == input.charAt(i - 1)){
                        count.incrementAndGet();
                    }else{
                        if(i > 0){
                            res.append(input.charAt(i - 1)).append(count);
                        }

                        count.set(1);
                    }
                });

        res.append(input.charAt(input.length() - 1)).append(count);

        System.out.println(res.toString());

    }
}
