//Given an array of integers, every element appears twice except for one. Find that single one.

//Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?


//Expected solution 
public class Solution {
	// DO NOT MODIFY THE LIST
	public int singleNumber(final List<Integer> a) {
	    int r=0;
	    HashSet<Integer> h = new HashSet<Integer>();
	    for(int i=0;i<a.size();i++ ){
	        if(h.isEmpty() ){
	            h.add(a.get(i) );
	        }else{
	            int as=a.get(i);
	            if(h.contains(as)){
	                h.remove(as);
	            }else{
	                h.add(as);
	            }
	            
	        }
	    }
	    for(Integer o: h){
           r=o;
        }
	    return r;
	    
	}
}

///Hard solution 
public int singleNumber(final List<Integer> a) {
 int result=0;
 for(int i=0;i<a.size();i++ ){
  result=result^a.get(i);
 
 }
 return result;
 }
