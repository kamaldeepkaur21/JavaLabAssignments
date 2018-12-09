public class ProducerConsumerTest {
   public static void main(String[] args) {
      addcontents c = new addcontents(); //class to add contents
      Producer p1 = new Producer(c, 1); //producer for adding things
      Consumer c1 = new Consumer(c, 1); //consumer to consumer things
      p1.start(); 
      c1.start();
   }
}
class addcontents {
   private int contents; 
   private boolean available = false; // variable to determine if item is available or not
   
   // method to consume an object
   public synchronized int get() {
	  // if object is not avaialble then wait
      while (available == false) {
         try {
            wait();
         } catch (InterruptedException e) {}
      }
      available = false;
      notifyAll();
      return contents;
   }
   
   //method to produce an object
   public synchronized void put(int value) {
	  //if object is available no then wait
      while (available == true) {
         try {
            wait();
         } catch (InterruptedException e) { } 
      }
      contents = value;
      available = true;
      notifyAll();
   }
}

//consumer class consuming an object using threads
class Consumer extends Thread {
   private addcontents addcontents;
   private int number;
   
   public Consumer(addcontents c, int number) {
      addcontents = c;
      this.number = number;
   }
   public void run() {
      int value = 0;
      for (int i = 0; i < 10; i++) {
         value = addcontents.get();
         System.out.println("Consumer #" + this.number + " got: " + value);
      }
   }
}

//producer class producing an object using threads
class Producer extends Thread {
   private addcontents cubbyhole;
   private int number;
   public Producer(addcontents c, int number) {
      cubbyhole = c;
      this.number = number;
   } 
   public void run() {
      for (int i = 0; i < 10; i++) {
         cubbyhole.put(i);
         System.out.println("Producer #" + this.number + " put: " + i);
         try {
            sleep((int)(Math.random() * 100));
         } catch (InterruptedException e) { }
      } 
   }
} 
