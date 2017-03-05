import java.io.*;
import java.util.Arrays;
import java.util.Scanner; 
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities;


public class complexity extends ApplicationFrame {
	private static long duration11;
	private static long duration12;
	private static long duration13;
	private static long duration21;
	private static long duration22;
	private static long duration23;
	private static long duration31;
	private static long duration32;
	private static long duration33;
	public static void main(String[] args){
		
		int value=1000;
		//Reverse list
		System.out.println("Reverse list");
		int[] data = readfiles("reverse_list.txt");		
		long startTime1 = System.nanoTime();
		int[] sdata1 = sortup(data);
		long endTime1 = System.nanoTime();
		duration11 = (endTime1 - startTime1)/value;
		data = readfiles("reverse_list.txt");		
		long startTime2 = System.nanoTime();
		int[] sdata2 = Msort(data);
		long endTime2 = System.nanoTime();
		duration21 = (endTime2 - startTime2)/value;
		data = readfiles("reverse_list.txt");		
		long startTime3 = System.nanoTime();
		int[] sdata3 = Qsort(data);
		long endTime3 = System.nanoTime();
		duration31 = (endTime3 - startTime3)/value;
		
		//Random list
		System.out.println("Random list");
		data = readfiles("random_list.txt");
		startTime1 = System.nanoTime();
		sdata1 = sortup(data);
		endTime1 = System.nanoTime();
		duration12 = (endTime1 - startTime1)/value;
		data = readfiles("random_list.txt");
		startTime2 = System.nanoTime();
		sdata2 = Msort(data);
		endTime2 = System.nanoTime();
		duration22 = (endTime2 - startTime2)/value;
		data = readfiles("random_list.txt");
		startTime3 = System.nanoTime();
		sdata3 = Qsort(data);
		endTime3 = System.nanoTime();
		duration32 = (endTime3 - startTime3)/value;
		//System.out.println(Arrays.toString(sdata));
		
		//Sorted list
		System.out.println("Sorted list");
		data = readfiles("sorted_list.txt");
		startTime1 = System.nanoTime();
		sdata1 = sortup(data);
		endTime1 = System.nanoTime();
		duration13 = (endTime1 - startTime1)/value;
		data = readfiles("sorted_list.txt");
		startTime2 = System.nanoTime();
		sdata2 = Msort(data);
		endTime2 = System.nanoTime();
		duration23 = (endTime2 - startTime2)/value;
		data = readfiles("sorted_list.txt");
		startTime3 = System.nanoTime();
		sdata3 = Qsort(data);
		endTime3 = System.nanoTime();
		duration33 = (endTime3 - startTime3)/value;
		//System.out.println(Arrays.toString(sdata));		
		
		
		
		//Chart call
		complexity chart = new complexity("Sorting algorithm comparison", "Algorithm Complexity");
			      chart.pack( );        
			      RefineryUtilities.centerFrameOnScreen( chart );        
			      chart.setVisible( true ); 
			   
		
	}
	public static int[] readfiles(String file)
	{
		try{
			File f = new File(file);
			Scanner s = new Scanner(f);
			int ctr = 0;
			while (s.hasNextInt()){
				ctr++;
				s.nextInt();
			}
			
				int[] inp = new int[ctr];
				Scanner s1 = new Scanner(f);
				for(int i=0;i<inp.length;i++)
				{
					inp[i] = s1.nextInt();
				}
				s.close();
				s1.close();							
				return inp;
				
			}catch(Exception e){
				System.out.println("Error occured");
				return null;
		}
		
	}
	
	public static int[] sortup(int[] inp)	{
		for (int i=1; i<inp.length;i++)
		{
			int key = inp[i];
			int j = i;
			while(j>0 && inp[j-1]>key)
			{
				inp[j] = inp[j-1];
				j--;
			}
			inp[j] = key;
			
		}
		return inp;
	}
	public static int[] Msort(int[] inp)	{
		 if (inp.length <= 1) {
	            return inp;
	        }
	        
	        // Split the array in half
	        int[] first = new int[inp.length / 2];
	        int[] second = new int[inp.length - first.length];
	        System.arraycopy(inp, 0, first, 0, first.length);
	        System.arraycopy(inp, first.length, second, 0, second.length);
	        
	        // Sort each half
	        Msort(first);
	        Msort(second);
	        
	        // Merge the halves together, overwriting the original array
	        merge(first, second, inp);
	        return inp;	
	}
	private static void merge(int[] first, int[] second, int [] result) {
        
        int iFirst = 0;   
        int iSecond = 0;       
        int j = 0;
        
        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst] < second[iSecond]) {
                result[j] = first[iFirst];
                iFirst++;
                } else {
                result[j] = second[iSecond];
                iSecond++;
            }
            j++;
        }
       
        System.arraycopy(first, iFirst, result, j, first.length - iFirst);
        System.arraycopy(second, iSecond, result, j, second.length - iSecond);
    }
	public static int[] Qsort(int[] inp)	{
		Quicksort(inp, 0, inp.length-1);
		return inp;
	}
	public static int partition(int A[], int f, int l)
	   {
	      int pivot = A[f];
	      while (f < l)
	      {
	         while (A[f] < pivot) f++;
	         while (A[l] > pivot) l--;
	         swap (A, f, l);
	      }
	      return f;
	   }
	 public static void swap (int A[], int x, int y)
	   {
	      int temp = A[x];
	      A[x] = A[y];
	      A[y] = temp;
	   }

	   public static void Quicksort(int A[], int f, int l)
	   {
	      if (f >= l) return;
	      int pivot_index = partition(A, f, l);
	      Quicksort(A, f, pivot_index);
	      Quicksort(A, pivot_index+1, l);
	   }

	public complexity( String applicationTitle , String chartTitle )
	   {
	      super(applicationTitle);        
	      JFreeChart barChart = ChartFactory.createBarChart(
	         chartTitle,           
	         "Algorithm",            
	         "Time",            
	         createDataset(),          
	         PlotOrientation.VERTICAL,           
	         true, true, false);
	         
	      ChartPanel chartPanel = new ChartPanel( barChart );        
	      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
	      setContentPane( chartPanel ); 
	   }
	   private CategoryDataset createDataset( )
	   {
	      final String Isort = "Insertion sort";        
	      final String Msort = "Merge sort";        
	      final String Qsort = "Quick sort";        
	      final String WCase = "Worst Case";        
	      final String ACase = "Average Case";        
	      final String BCase = "Best Case";	            
	      final DefaultCategoryDataset dataset = 
	      new DefaultCategoryDataset( );  

	      dataset.addValue( duration11 , Isort , WCase );
	      dataset.addValue( duration12 , Isort , ACase );
	      dataset.addValue( duration13 , Isort , BCase );
	      
	      dataset.addValue( duration21 , Msort , WCase ); 
	      dataset.addValue( duration22 , Msort , ACase );
	      dataset.addValue( duration23 , Msort , BCase );
	      
	      dataset.addValue( duration31 , Qsort , WCase );        
	      dataset.addValue( duration32 , Qsort,  ACase );
	      dataset.addValue( duration33 , Qsort,  BCase );   

	      return dataset; 
	   }
}