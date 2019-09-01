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
      que=new Item[size];
      index=0;
      this.size = size;
    }
public boolean is_empty() {
  return index == -1;
}
public void insert_with_priority(int v,int p) {
  if(size == index ) return;
  if(index == 0) { que[index++] = new Item(p,v);}
  else {
  int j= index;
System.out.println("For inserting " + v+" "+p+ " " +j);
  for(;j>0 && que[j-1].priority > p ;j--) {
      que[j] = que[j-1];
  }
  que[j] = new Item(p,v);
  index++;
  }
  
  
}

public int pull_highest_priority_element() {
	
    return que[--index].value;
}


public void print() {
	int i=0;
  for(;i<index-1;i++){
    System.out.print(que[i].value+" ");
  }
  if(index > 0){
  System.out.println(que[index-1].value);}
}
}

class Test {

  public static void main(String args[]){
PriorityQueue pq = new PriorityQueueImpl(6);
pq.insert_with_priority(10,5);
pq.insert_with_priority(2,3);
pq.insert_with_priority(88,7);
pq.insert_with_priority(12,4);

    pq.print();

System.out.println(pq.pull_highest_priority_element());
  
System.out.println(pq.pull_highest_priority_element());

System.out.println(pq.pull_highest_priority_element());
  }
}
