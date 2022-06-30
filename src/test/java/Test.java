public class Test {

    public static void main(String[] args) {

        Integer[] arr = new Integer[3];
        Object[] objs = (Object[]) arr;
        objs[0] = 1L;

        System.out.println(objs[0]);
    }
}
