package ass01;



public class Prime {

	public static void main(String[] args) {
		
		int flag = 0;
		
		int n=4;
		
		int m =n/2;
		
		if(n == 0 || n == 1)
			
		{
			System.out.println("Not a prime");
		}
		
		else
		{
			for(int i=2;i<=m;i++)
			{
				if(n%i==0) {
					System.out.println("not a prime");
					flag=1;
					break;
				}
			}
			if (flag==0)
			{
				System.out.println("It is prime");
			}
		}

	}

}
