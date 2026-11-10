public class SafeCounterDemo {

    static class ProgressCounter {
        private int total = 0;

        public synchronized void increment() {
            total++;
        }

        public synchronized int getTotal() {
            return total;
        }
    }

    static class TaskWorker implements Runnable {
        private final String workerName;
        private final ProgressCounter counter;

        public TaskWorker(String workerName, ProgressCounter counter) {
            this.workerName = workerName;
            this.counter = counter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                counter.increment();

                System.out.println(
                        workerName + " updated counter to "
                                + counter.getTotal()
                );

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println(workerName + " was interrupted.");
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        ProgressCounter sharedCounter = new ProgressCounter();

        Thread workerA = new Thread(
                new TaskWorker("Worker A", sharedCounter)
        );

        Thread workerB = new Thread(
                new TaskWorker("Worker B", sharedCounter)
        );

        workerA.start();
        workerB.start();

        try {
            workerA.join();
            workerB.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Main thread was interrupted.");
        }

        System.out.println("Final total: " + sharedCounter.getTotal());
    }
}