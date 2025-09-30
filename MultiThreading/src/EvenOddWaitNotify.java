public class EvenOddWaitNotify {
    public static void main(String[] args) throws InterruptedException {

        EvenOdd evenOdd = new EvenOdd(100);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    evenOdd.printOdd();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    evenOdd.printEven();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread1.start();
        thread2.start();

    }
    public static class EvenOdd{
        public static int counter = 0;

        int limit;
        EvenOdd(int n){
            limit = n;
        }


        synchronized void incr(){
            counter++;
        }

        public synchronized void printOdd() throws InterruptedException {
            while(counter < limit) {
                if (counter % 2 == 0) {
                    wait();
                }
                System.out.println("Odd:" + counter);
                incr();
                notify();
            }
        }

        public synchronized void printEven() throws InterruptedException {
            while(counter < limit) {
                if (counter % 2 != 0) {
                    wait();
                }
                System.out.println("Even:" + counter);
                incr();
                notify();
            }
        }

    }
}
