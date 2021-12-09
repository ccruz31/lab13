package cruz_lab13;

public class cruz_lab13 {

	java.util.ArrayList<Integer> arr = new java.util.ArrayList<Integer>();
	
	public void readData(String filename)
	{
		try
		{
			java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(filename)));
			String str;
			
			// loop to read the input file
			while((str = input.readLine()) != null )
			{
				java.util.StringTokenizer st = new java.util.StringTokenizer(str);
				while(st.hasMoreTokens())
				{
					String token = st.nextToken();
					int j = Integer.parseInt(token);
					arr.add(j);
				}
			}
			input.close();
		}
		catch(Exception e)
		{
			// output the exception if there is one and exit
			System.out.println(e.toString());
			System.exit(0);
		}
	}
	
	public long getTotalCount()
	{
		return arr.stream().count();

	}
	
	public long getOddCount()
	{
		return arr.stream().filter(x -> x%2 != 0).count();
	}
	
	public long getEvenCount()
	{
		return arr.stream().filter(x -> x%2 == 0).count();
	}
	
	public long getDistinctGreaterThanFiveCount()
	{
		return arr.stream().distinct().filter(x -> x>5).count();
	}
	
	public Integer[] getResult1() {
		return arr.stream().filter(x -> x%2 == 0).filter(x -> x>5).filter(x -> x<50).sorted().toArray(Integer[]::new);
	}
	
	public Integer[] getResult2() {
		return arr.stream().map(x -> x*x).map(x -> x*3).limit(50).toArray(Integer[]::new);
	}
	
	public Integer[] getResult3() {
		return arr.stream().filter(x -> x%2 != 0).map(x -> x*2).sorted().skip(20).distinct().toArray(Integer[]::new);

	}

}
