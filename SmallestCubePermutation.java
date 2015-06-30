import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

public class SmallestCubePermutation {
	
	/* to avoid finding the cube root every time, I'll find the range of numbers which have the same length.
	 * 
	 * Find the smallest cube for which exactly N permutations of its digits are cube.
	 * @param requirePermNumber, The length of the cube number is required to have.
	 * @return LinkedList of permutations with ascending order
	*/
	public static LinkedList<Long> findPermutationsOfCube(int requirePermNumber){
		LinkedHashMap<String,LinkedList<Long>> permsMap = new LinkedHashMap<String,LinkedList<Long>>();
		int length = 0;
		while(true){
			++length;
			long min = (long) Math.ceil( Math.pow(Math.pow(10, length - 1), 1.0 / 3.0));
	        long max = (long) Math.floor( Math.pow(Math.pow(10, length) - 1, 1.0 / 3.0));
	        for (long i = min; i < max; ++i ){
	            long cube = i * i * i;
	            final char[] chars = Long.toString(cube).toCharArray();
	            Arrays.sort(chars);
	            final String key = new String(chars);

	            // Add the cube to the hash map.
	            if (permsMap.containsKey(key)){
	            	permsMap.get(key).addLast(cube);
	            }
	            else{
	                final LinkedList<Long> values;
	                values = new LinkedList<Long>();
	                values.add(cube);
	                permsMap.put(key,values);
	            }
	        }
	        
	        for (final Entry<String, LinkedList<Long>> entry : permsMap.entrySet()){
	        	LinkedList<Long> tempCubes = entry.getValue();
	            if (tempCubes.size() == requirePermNumber){
	                return tempCubes;
	            }
	        }
	        
		}
	}
	// you can test the result other than 5.
	public static final void main( String[] args ){
        System.out.println(
                findPermutationsOfCube(5));
    }
}
