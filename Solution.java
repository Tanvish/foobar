import java.util.Arrays; 

public class Main {
    public static String multiply(String a, String b){
    String n1 = new StringBuilder(a).reverse().toString();
    String n2 = new StringBuilder(b).reverse().toString();
 
    int[] d = new int[a.length()+b.length()];
 
    for(int i=0; i<n1.length(); i++){
        for(int j=0; j<n2.length(); j++){
            d[i+j] += (n1.charAt(i)-'0') * (n2.charAt(j)-'0');
        }
    }
 
    StringBuilder sb = new StringBuilder();
 
    for(int i=0; i<d.length; i++){
        int mod = d[i]%10;
        int carry = d[i]/10;
        if(i+1<d.length){
            d[i+1] += carry;
        }
        sb.insert(0, mod);
    }
 
    while(sb.charAt(0) == '0' && sb.length()> 1){
        sb.deleteCharAt(0);
    }
 
    return sb.toString();
    }
    public static String solution(int[] xs) {
        // Your code here
    String strArray[] = new String[xs.length];

		if(xs.length ==1){
        return String.valueOf(xs[0]);
    }
    int neg_counter=0;
    String product ="1";
    Arrays.sort(xs);
    for(int i =0; i<xs.length;i++){
      if(xs[i]<0){
        neg_counter++;
      }
    }  
   if(neg_counter%2!=0){
   int flag = xs.length-1;
    while(xs[flag]>=0){
      flag--;
    }
    xs[flag]=0;
   }
    for (int i = 0; i < xs.length; i++){
      if(xs[i]<0) xs[i]*=-1;
    }

    for (int i = 0; i < xs.length; i++){
			strArray[i] = String.valueOf(xs[i]);
    }
    int sum =0;
    for(int i =0; i<xs.length;i++){
      sum +=xs[i];
    }
    if(sum==0)
    return "0";
    for(int i=0; i<strArray.length;i++){
      if(xs[i]!=0){
        product = multiply(product, strArray[i]);
      }
    }
    System.out.println(product);
    return product;
    }
    public static void main(String[] args) {
    int[] arr = {1};
    System.out.println(solution(arr));
  }
}
