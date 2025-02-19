public class StringStringBuilderStringBuffer {
    public void strings() {

        String a = "";
        for (int i = 0; i < (Math.pow(10, 3)); i++) {
            a = a + i;
        }
        System.out.println("completed with string concatenation");
    }

    public void stringBuilder() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < (Math.pow(10, 3)); i++) {
            str.append(i);
        }
        System.out.println("completed with stringbuilder");
    }

    public void stringBuffer() {
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < (Math.pow(10, 3)); i++) {
            str.append(i);
        }
        System.out.println("completed with stringbuilder");
    }

    public static void main(String[] args) {
        StringStringBuilderStringBuffer s = new StringStringBuilderStringBuffer();

        long startTime1 = System.currentTimeMillis();
        s.strings();
        long endTime1 = System.currentTimeMillis();
        System.out.println("Execution time for String: " + (endTime1 - startTime1) + " milliseconds");

        long startTime2 = System.currentTimeMillis();
        s.strings();
        long endTime2 = System.currentTimeMillis();
        System.out.println("Execution time for StringBuilder: " + (endTime2 - startTime2) + " milliseconds");

        long startTime3 = System.currentTimeMillis();
        s.strings();
        long endTime3 = System.currentTimeMillis();
        System.out.println("Execution time for StringBuffer: " + (endTime3 - startTime3) + " milliseconds");
    }
}
