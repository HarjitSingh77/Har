
import java.util.*; 
public class scheduling{ 

	
	static int totalOperations(String str, int len) 
	{ 

		
		HashMap<Character, Integer> h = new HashMap<Character, Integer>(); 
		for (int i = 0; i < len; i++) { 

			
			if (h.containsKey(str.charAt(i))) 
				h.put(str.charAt(i), h.get(str.charAt(i)) + 1); 

			
			else
				h.put(str.charAt(i), 1); 
		} 

		Set<Map.Entry<Character, Integer> > set = h.entrySet(); 

		HashSet<Integer> hs = new HashSet<Integer>(); 

		for (Map.Entry<Character, Integer> me : set) 
			hs.add(me.getValue()); 

		return hs.size(); 
	} 

	 
	public static void main(String[] args) 
	{ 
                Scanner sc=new Scanner(System.in);
		String str = sc.next(); 
		int len = str.length(); 
		System.out.println(totalOperations(str, len)); 
	} 
} 

