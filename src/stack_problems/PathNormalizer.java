package stack_problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class PathNormalizer {

    public static void main(String[] args) {

        System.out.println(normalizePath("/a//b/./c/../d/"));

    }

    public static String normalizePath(String path) {

        path = path.replaceAll("//","/");

        String[] parts = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for(String part : parts){

            if(part.isEmpty() || part.equalsIgnoreCase(".")){
                continue;
            }

            if(part.equals("..")){
                if(stack.isEmpty()){
                    throw new IllegalArgumentException("Operation is not allowed");
                }
                stack.pop();
            }else {
                stack.push(part);
            }
        }

        StringBuilder result = new StringBuilder();

        for(String dir : stack){
            result.insert(0,"/"+ dir);
        }
        return result.toString();
    }
}
