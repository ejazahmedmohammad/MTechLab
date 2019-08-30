class TowerOfHanoi {

int diskSize;

TowerOfHanoi(int diskSize){
diskSize =diskSize;
}

public void Solver(int n,char from,char to,char aux) {
  if(n == 1) {
    System.out.println("Move disk 1 from " + from + " to " + to );
  }
  else{
    Solver(n-1,from,aux,to);
    System.out.println("Move disk " + n + " from " + from + " to " + to );
    Solver(n-1,aux,to,from);
  }
}

public static void main(String [] args){
  TowerOfHanoi dz = new TowerOfHanoi(4);
  dz.Solver(3,'A','C','B');
}

}
