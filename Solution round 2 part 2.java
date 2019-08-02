public class Main {
    public static int[] solution(int[] pegs) {
     
    int first_gear=-pegs[0];
    int den = 1, temp = 1, radius =0, fix_radius = 0;
    int [] returns = {-1,-1};
    int x;
    for(int i = 1;i<pegs.length-1;i++){
    first_gear += 2*pegs[i]*temp;
    temp *= -1;
    }
    first_gear += pegs[pegs.length-1] * temp;
    first_gear *= 2;
    if(pegs.length%2 == 0){
      if(first_gear%3==0)
      first_gear = first_gear/3;
      else den = 3;
    }
    for(int i =0;i<pegs.length;i++)
      pegs[i]*=den;
      radius = first_gear;
      for(int i = 0; i < pegs.length - 2; i++) {
           x = pegs[i+1] - pegs[i];
            if(radius < 0 || radius > (x-1)) {
            return returns;}
            radius = x - radius;
        }
    int[] returns_right = {first_gear, den};
    return returns_right;
    }
    public static void main(String[] args) {
    int[] pegs = {99,999};
    solution(pegs);
    }
}
