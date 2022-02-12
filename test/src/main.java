public class main {

    public static void main(String args[]) {
        String word = "Walid Soussi";
        String out ="";
        char[] Voyels = {'a', 'e', 'i', 'o', 'u','y','A','E','I','O','U','Y'};
        for (char cc: word.toCharArray()) {
            if(Arrays.stream(Voyels).anyMatch(c::equals)) out += "av"+c;
            else out+=c;
        }

        System.out.println(out);
    }

}