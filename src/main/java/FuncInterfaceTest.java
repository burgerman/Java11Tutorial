import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FuncInterfaceTest {

    static String[] types = {"A", "B", "C"};
    private static List<String> typeList = new ArrayList<>(Arrays.asList(types));


    public String[] transformArray (int[] arr, IntToStringFunc func) {
        String[] transformedArray = new String[arr.length];
        for (int i = 0; i<arr.length; i++) {
            transformedArray[i] = func.applyAsString(arr[i]);
        }
        return transformedArray;
    }

    public String[] processProducts (String[] arr, ProductProcessFunc func) {
        String[] results = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            results[i] = func.processProduct(arr[i]);
        }
        return results;
    }

    public String getProduct (String type, ProductGetFunc func) {
        if(typeList.indexOf(type.toUpperCase()) >= 0 ) {
            return func.getProductInstance(type);
        }
        return null;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        String[] transformedArr = new FuncInterfaceTest().transformArray(arr, s-> String.valueOf(s));

        for (String s : transformedArr) {
            System.out.println(s);
        }

         String[] arr2 = {"1", "2", "3"};
         FuncInterfaceTest func = new FuncInterfaceTest();
         String[] resultsA = func.processProducts(arr2, s-> new StringBuilder().append("Processed product ").append(s).toString());

        for (String s : resultsA) {
            System.out.println(s);
        }


        String[] resultsB = func.processProducts(arr2, s-> "Processed "+s);
        for (String s : resultsB) {
            System.out.println(s);
        }


        String typeA = "A";
        String typeB = "B";
        String typeC = "C";
        FuncInterfaceTest func2 = new FuncInterfaceTest();
        String getTypeA = func2.getProduct(typeA, s-> "get product " + typeA);
        String getTypeB = func2.getProduct(typeB, s-> "get product " + typeB);
        String getTypeC = func2.getProduct(typeC, s-> "get product " + typeC);

        System.out.println(getTypeA);
        System.out.println(getTypeB);
        System.out.println(getTypeC);

        System.out.println(32&31);
        System.out.println(16&15);
    }

}
