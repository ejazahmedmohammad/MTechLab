interface PriorityQueue {

boolean is_empty();
void insert_with_priority(int v,int p);

int pull_highest_priority_element();
void print();
}

class Item {
  Item(int p, int v) {
    this.priority = p;
    this.value =v;
  }
  public int value;
  public int priority;
}
class PriorityQueueImpl implements PriorityQueue {
    Item[] que;
    int size;
    int index;
    PriorityQueueImpl(int size) {
      que=new Items[size];
      index=0;
      this.size = size;
    }
boolean is_empty() {
  return index == -1;
}
void insert_with_priority(int v,int p) {
  if(size == index ) return;
  if(index == 0) { Item[index++] = new Item(v,p);}
  int j= index + 1;
  for(;j>=1 && que[j-1].priority < p ;j--) {
      que[j] = que[j-1];
  }
  que[j] = new Item(v,p);
  index++;
}

int pull_highest_priority_element() {
    return que[index--];
}
void print() {
  for(int i=0;i<=index;i++){
    System.out.printlln(que[i].value);
  }
}
}

class Test {

  public static void main(String args[]){
PriorityQueue pq = new PriorityQueue(6);
pq.insert_with_priority(10,5);
pq.insert_with_priority(2,3);
pq.insert_with_priority(88,7);
pq.insert_with_priority(12,4);
    pq.print();

  }
}
