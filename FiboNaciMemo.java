public class FiboNaciMemo {
    private static Map<Integer, Integer> memo = new HashMap<>();

    public static int fib(int n) {
        if(memo.containsKey(n)){
            return memo.get(n);
        }

        if(n ==0){
            return 0;

        } else if (n ==1){
            return 1;
        }

        int result = fib(n -1) + fib(n -2);
        memo.put(n, result);

        return result;
    }

    public static void main(String[] args){
        int n = 10;
        System.out.println("fibonaci of " + n + " is "+  fib(n));
    }
}
