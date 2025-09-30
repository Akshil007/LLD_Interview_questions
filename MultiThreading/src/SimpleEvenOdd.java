
public class SimpleEvenOdd {
    public static void main(String[] args) {

        Thread thread1 = new Thread(new EvenOdd(true));
        Thread thread2 = new Thread(new EvenOdd(false));

        thread1.start();
        thread2.start();

    }
    public static class EvenOdd implements Runnable{
        Boolean isEven = null;
        public EvenOdd(boolean flag){
            isEven = flag;
        }
        @Override
        public void run() {
            int start = 1;
            int limit = 20;
            for(int i=start;i<=limit;i++){
                if(isEven && i%2==0){
                    System.out.println(i);
                }
                if(!isEven && i%2!=0)
                {
                    System.out.println(i);
                }
            }
        }
    }
}