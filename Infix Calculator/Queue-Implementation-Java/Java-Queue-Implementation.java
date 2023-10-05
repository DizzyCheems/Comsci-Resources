
public class Main {
int SIZE = 5;
int front, rear;
int queue[] = new int[SIZE];

Main() 
{
front = -1;
rear = -1;
}

boolean isFullQueue() {
if (front == 0 && rear == SIZE - 1) {
return true;
}
if (front == rear + 1) {
return true;
}
return false;
}
// Check if the queue is empty or not
boolean isEmptyQueue() {
if (front == -1)
return true;
else
return false;
}

// Adding an element in the queue
void enQueue(int value) {
if (isFullQueue()) {
System.out.println("Sorry !! Queue is full.. No more elements could be inserted in it");
}
else {
if (front == -1)
front = 0;
rear = (rear + 1) % SIZE;
queue[rear] = value;
System.out.println("Element " + value + " is inserted successfully");
}
}
void deQueue() {
int value;
if (isEmptyQueue()) {
System.out.println("Sorry !!The Queue is empty.. ");
} else {
value = queue[front];
if (front == rear) {
front = -1;
rear = -1;
}
else {
front = (front + 1) % SIZE;
}
}
}

void displayQueue() {
int i;
if (isEmptyQueue()) {
System.out.println("Sorry!! The Queue is Empty");
} else {
System.out.println("Position of Front:  " + front);
System.out.println("Below given are the elements of the Queue");
for (i = front; i != rear; i = (i + 1) % SIZE)
System.out.print(queue[i] + " ");
System.out.println(queue[i]);
System.out.println("Position of Rear: " + rear);
}
}

public static void main(String[] args) {
Main que = new Main();
que.deQueue();
que.enQueue(10);
que.enQueue(24);
que.enQueue(33);
que.enQueue(67);
que.enQueue(22);
que.displayQueue();
que.deQueue();
que.displayQueue();
que.enQueue(900);
que.displayQueue();
que.enQueue(867);
que.deQueue();
que.displayQueue();
}
}