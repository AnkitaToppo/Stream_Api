import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//import static java.util.stream.Nodes.collect;

public class StreamApis {


        // 1. Write a Java program to calculate the square of each number in a list
        // using Java Streams.
        // {2,4,3,5,6,7}

        public void squareOfEachNumbers(List<Integer> l1){
            Stream<Integer> s1=l1.stream();
            List<Integer> newL=s1.map(e->e*e).collect(Collectors.toList());
            System.out.println(newL);
        }
        //2. Write a Java program to filter strings from a list based on a minimum
        // length using Java Streams.
        // ("apple", "banana", "orange", "grape", "kiwi")

        public void minimumLength(List<String> l2) {

            Stream<String> s=l2.stream();
            int minLength = 5;
            List<String> newl2 = s.filter(e -> e.length() <= minLength).collect(Collectors.toList());
            System.out.println(newl2);

            Stream<String> s2 =l2.stream();
            String min= s2.min((str1,str2)->Integer.compare(str1.length(),str2.length())).orElse(null);
            System.out.println(min);

        }

    // 3. Write a Java program to group strings from a list by their lengths using
    // Java Streams.
    // ("apple", "banana", "orange", "grape", "kiwi")

    public void groupStringsByLengths(List<String> l){
            Stream<String> ste=l.stream();
            Map<Integer,List<String>> grp=ste.collect(Collectors.groupingBy(String::length));
            System.out.println(grp);

    }

    // 4. Write a Java program to convert all strings in a list to uppercase using
    // Java Streams.
    // ("apple", "banana", "orange", "grape", "kiwi")
    public void stringsToUppercase(List<String> l){
            Stream<String> str=l.stream();
            List<String> list=str.map(String::toUpperCase).collect(Collectors.toList());
            System.out.println(list);
            System.out.println("******");

        Stream<String> s = l.stream();
        s.map(String::toUpperCase).forEach(System.out::println);
    }

    // 5. Write a Java program to remove duplicate elements from a list using Java
    // Streams.
    // {1, 2, 3, 2, 4, 5, 3, 6, 7, 8, 1}
    public void removeDuplicates(List<Integer> l){
            Stream<Integer> s= l.stream();
            s.distinct().forEach(System.out::println);

    }
    // 6. Write a Java program to combine two lists into a single list using Java
    // Streams.
    // {1,2,3} {6,7,8}
    public void twoListToSingleList(List<Integer> l1,List<Integer> l2){

           List<Integer> conc= Stream.concat(l1.stream(),l2.stream()).collect(Collectors.toList());
            System.out.println(conc);

    }

    // 7. Write a Java program to find the longest string from a list of strings
    // using Java Streams.
    // ("apple", "banana", "orange", "grape", "kiwi")
    public void longestString(List<String> l){
            Stream<String>str=l.stream();
            String s=str.max((s1,s2)->Integer.compare(s1.length(),s2.length())).orElse(null);
            System.out.println(s);
    }

    // 8. Write a Java program to merge two maps into a single map using Java
    // Streams. Assume no common keys between the maps.
    // Consider an example of yours
    public  void mergedMap(){
            Map<String,Integer> m1=new HashMap<>();
            m1.put("apple",10);
            m1.put("banana",20);

         Map<String,Integer> m2=new HashMap<>();
        m2.put("kiwi",30);
        m2.put("orange",10);
        Map<String,Integer> merged =Stream.concat(m1.entrySet().stream(),m2.entrySet().stream())
                    .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
        System.out.println(merged);

    }

    // 9. Write a Java program to remove null values from a list of strings using
    // Java Streams.
    // ("apple",null, "banana",null, "orange", "grape", "kiwi", null)
    public void removeNullFromList(List<String> l){
            Stream<String> s=l.stream();
            s.filter(Objects::nonNull).forEach(System.out::println);

    }
    // 10. Implement a method to find all pairs of number in a list that sum upto
    // given target using java streams
    // {2,3,4,5,7,8,9} , target - 7
    public void findPairs(List<Integer> l){

            int target=7;
            Set<Integer> setTraverse=new HashSet<>();
            List<List<Integer>> listPairs=new ArrayList<>();

            for(Integer num:l){
                int compliment=target-num;
                if(setTraverse.contains(compliment)){
                    listPairs.add(Arrays.asList(compliment,num));
                }
                setTraverse.add(num);
            }
            System.out.println(listPairs);
    }

    public static void main(String[] args){
        StreamApis app=new StreamApis();
        List<Integer> input =Arrays.asList(1,2,3);
        List<Integer> input1 =Arrays.asList(6,7,8);
        List<String> input3=Arrays.asList("apple",null, "banana",null, "orange", "grape", "kiwi", null);
        List<String> input2 =Arrays.asList("apple", "banana", "orange", "grape", "kiwi");
        List<Integer> input4 =Arrays.asList(2,3,4,5,7,8,9);

        app.longestString(input2);
        app.mergedMap();
        app.removeNullFromList(input3);
        app.findPairs(input4);


    }





    }



//}
