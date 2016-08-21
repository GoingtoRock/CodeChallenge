package orderalphabet;

import java.util.*;


/* Rearranging alphabet */
public class Alphabet {

	public static String printAlphabet (String str) {

        /* From A to Z */
        int alphabetNum = 26;
        int[] a1 = new int[alphabetNum];

        /* 65 is A in ASCII code */
        int asciiA = 65;

        String finalString = "";
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        /* count the number of occurrences for each alphabet */
        for(int i = 0; i < str.length(); i++) {
            a1[str.charAt(i) - asciiA]++;
        }

        /* and put the alphabet / its number of appearances in a map */
        for(int i = 0; i < alphabetNum; i++) {
            if(a1[i] > 0)
                map.put(i + asciiA, a1[i]);
        }

        /* first, sort the map by key to make sure that the alphabetical order applies
        for tie-breaking
         */
        Map<Integer, Integer> treeMap = new TreeMap<Integer, Integer>(map);

        /* then, sort the map by values (number of appearances) */
        Object[] a = treeMap.entrySet().toArray();
        Arrays.sort(a, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Map.Entry<Integer, Integer>) o1).getValue().compareTo(
                        ((Map.Entry<Integer, Integer>) o2).getValue());
            }
        });

        /* print out the sorted alphabets */
        for (Object e : a) {
            for(int i = 0; i < ((Map.Entry<Integer, Integer>) e).getValue(); i++) {
                int asciiAlphabet = ((Map.Entry<Integer, Integer>) e).getKey();
                finalString += String.valueOf(Character.toChars(asciiAlphabet));
            }
        }
        
        return finalString;
	}
	
    public static void main(String[] args) {

        Scanner sc  = new Scanner(System.in);
        String str = sc.nextLine();

        String fs = printAlphabet(str);
        System.out.println(fs);
    }

}
