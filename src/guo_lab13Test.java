import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class guo_lab13Test
{
	guo_lab13 lab;
	Integer[] expectedResult1;
	Integer[] expectedResult2;
	Integer[] expectedResult3;
	String inputFilename = "src/lab13_input_data.txt";
	String expectedResultsFilename = "src/lab13_expected_results.txt";

	@BeforeEach
	public void setUp() throws Exception 
	{
		// instantiate an instance of lab13
		lab = new guo_lab13();
		
		// read the input values and populate the ArrayList<Integer> in the lab13 class
		lab.readData(inputFilename);
		
		// testData.get(0) has the expected results for getResult1()
		// testData.get(1) has the expected results for getResult2()
		// testData.get(2) has the expected results for getResult3()
		ArrayList<ArrayList<Integer>> testData = new ArrayList<>();
		for( int i = 0; i < 3; i++ )
		{
			testData.add(new ArrayList<Integer>());
		}
		
		try
		{
			System.out.println("reading " + expectedResultsFilename);
			java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(expectedResultsFilename)));
			for( int i = 0; i < testData.size(); i++ )
			{
				ArrayList<Integer> currentTestData = testData.get(i); 
				String inn;
				input.readLine();
				while( (inn = input.readLine()) != null )
				{
					if( inn.length() > 0 )
					{
						currentTestData.add(Integer.valueOf(inn));
					}
					else
					{
						break;
					}
				}
				testData.set(i, currentTestData);
				System.out.println("testData.get(" + i + ").size() = " + testData.get(i).size());
			}
			input.close();
			
			// put code here to populate expectedResult1 with the values in testData.get(0)
			// so that you can use "assertArrayEquals" to verify expectedResult1 and lab.getResult1() are the same
            expectedResult1 = testData.get(0).toArray(new Integer[0]);
			
			
			// put code here to populate expectedResult2 with the values in testData.get(1)
			// so that you can use "assertArrayEquals" to verify expectedResult2 and lab.getResult2() are the same
            expectedResult2 = testData.get(1).toArray(new Integer[0]);
			
			
			// put code here to populate expectedResult3 with the values in testData.get(2)
			// so that you can use "assertArrayEquals" to verify expectedResult3 and lab.getResult3() are the same
            expectedResult3 = testData.get(2).toArray(new Integer[0]);
			
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			System.exit(0);
		}		
	}

    @Test
    void testGetTotalCount() {
        Assertions.assertEquals(1000, lab.getTotalCount());
    }

    @Test
    void testGetOddCount() {
        Assertions.assertEquals(507, lab.getOddCount());
    }

    @Test
    void testGetEvenCount() {
        Assertions.assertEquals(493, lab.getEvenCount());
    }

    @Test
    void testDistinctGreaterThanFiveCount() {
        Assertions.assertEquals(94, lab.getDistanceGreaterThanFiveCount());
    }

    @Test
    void testGetResult() {
        Assertions.assertArrayEquals(expectedResult1, lab.getResult());
    }

    @Test
    void testGetResult2() {
        Assertions.assertArrayEquals(expectedResult2, lab.getResult2());
    }

    @Test
    void testGetResult3() {
        Assertions.assertArrayEquals(expectedResult3, lab.getResult3());
    }

}
