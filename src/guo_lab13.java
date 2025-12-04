import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

class guo_lab13
{
    private ArrayList<Integer> arrayList = new ArrayList<>();

    public void readData(String filename) {
        try
        {
            BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));

            String inn;
            while( (inn = input.readLine()) != null )
            {
                arrayList.add(parseInt(inn));

            }
            input.close();

        }
        catch(Exception exception)
        {
            System.out.println(exception.toString());
            System.exit(0);
        }
    }

    public long getTotalCount() {
        return arrayList.stream().count();
    }

    public long getOddCount() {
        return arrayList.stream().filter(x -> x % 2 == 1).count();
    }

    public long getEvenCount() {
        return arrayList.stream().filter(x -> x % 2 == 0).count();
    }

    public long getDistanceGreaterThanFiveCount() {
        return arrayList.stream().distinct().filter(x -> x > 5).count();
    }

    public Integer[] getResult() {
        return arrayList.stream().filter(x -> x % 2 == 0 && x > 5 && x < 50).sorted().toArray(Integer[]::new);
    }

    public Integer[] getResult2() {
        return arrayList.stream().map(x -> x * x).map(x -> x * 3).limit(50).toArray(Integer[]::new);
    }

    public Integer[] getResult3() {
        return arrayList.stream().filter(x -> x % 2 == 1).map(x -> x * 2).sorted().skip(20).distinct().toArray(Integer[]::new);
    }
}