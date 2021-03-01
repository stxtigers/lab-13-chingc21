import java.util.Arrays;
import java.io.*;
import java.util.Scanner;

public class Main 
{
  public static String[] insert(String s, int i, String[] a, int logicalSize)
  {
    if(logicalSize <= a.length)
    {
      return null;
    }
    else
    {
      String[] copy = new String[a.length + 1];
      int n = 0;
      while(n < i)
      {
        copy[n] = a[n];
        n++;
      }
      copy[i] = s;
      n = i + 1;
      while(n < a.length + 1)
      {
        copy[n] = a[n - 1];
        n++;
      }
      return copy;
    }
  }

  public static int[] delete(int target, int[] a, int logicalSize)
  {
    int[] copy = new int[a.length - 1];
    int i = 0;
    int location = -1;
    while(i < a.length)
    {
      if(a[i] == target)
      {
        location = i;
      }
      i++;
    }
    if(location == -1)
    {
      return null;
    }
    else
    {
      int n = 0;
      while(n < i)
      {
        copy[n] = a[n];
        n++;
      }
      while(n < copy.length)
      {
        copy[n] = a[n - 1];
        n++;
      }
      return copy;
    }
  }

  public static void stats(String filename) throws IOException
  {
    Scanner fileReader = new Scanner(new File(filename));
    double[] buffer = new double[5000];
    int count = 0;

    while(fileReader.hasNext())
    {
      buffer[count] = fileReader.nextInt();
      count++;
    }

    double[] numbers = Arrays.copyOf(buffer, count);
    buffer = null;

    double stdev = stdev(numbers);
    double mean = average(numbers);
    double median = findMedian(numbers);

    printArray(mean, median, stdev);
  }

  public static String[] removeNulls(String[] a)
  {
    int count = 0;
    int i = 0;
    while(i < a.length)
    {
      if(a[i].equals(null))
      {
        count++;
      }
      i++;
    }
    String[] copy = new String[a.length - count];
    int n = 0;
    int count2 = 0;
    while(n < copy.length)
    {
      if(a[n].equals(null))
      {
        count2++;
      }
      else
      {
        copy[n - count2] = a[n];
      }
      n++;
    }
    return copy;
  }

  public static double stdev(double[] a)
  {
    int i = 0;
    double sum = 0;
    while(i < a.length)
    {
      sum = sum + a[i];
      i++;
    }
    double mean = sum / a.length;
    int n = 0;
    double sum2 = 0;
    while(n < a.length)
    {
      sum2 = sum + (a[n] - mean) * (a[n] - mean);
    }
    return Math.sqrt(sum2 / (a.length - 1));
  }

  private static double average(double[] numbers)
  {
    //Write a for loop to sum numbers in numbers array
    double sum = 0;
    for(int i = 0; i < numbers.length; i++)
    {
      sum += numbers[i];
    }
    return sum/numbers.length;  //average is sum/number of things

  }

  private static double findMedian(double[] numbers)
  {
    double[] sortedList = sort(numbers);
    //if odd number of terms, take number of terms/2
    if(sortedList.length % 2 == 1)
    {
      return sortedList[sortedList.length/2];
    }
    else
    {
      //if even number of terms we avg middle 2
      // 0, 1, 2, 3, 4, 5
      double avg = sortedList[sortedList.length/2-1] + sortedList[sortedList.length/2];
      return avg;
    }
  }

  private static void printArray(double mean, double median, double stdev) throws IOException
  {
    //Open output.txt for writing
    PrintWriter writer = new PrintWriter(new File("output.txt"));
    
    writer.println("Mean: " + mean + "\t" + "Median: "+ median + "\t" + "Std. dev: " + stdev);

    writer.close();
  }

  private static double[] sort(double[] numbers)
  {
    double[] sortedArray = copyArray(numbers);
    //BUBBLE SORT
    for(int j = sortedArray.length - 1; j < 2; j--)
    {
      //Inner loop moves largest number to right
      for(int i = 0; i < j; i++)
      {
        if(sortedArray[i] > sortedArray[i+1])  //swap
        {
          double temp = sortedArray[i];
          sortedArray[i] = sortedArray[i+1];
          sortedArray[i+1] = temp;
        }
      }
    }
    return sortedArray;
  }

  private static double[] copyArray(double[] numbers)
  {
    double[] copy = new double[numbers.length];
    for(int i = 0; i < numbers.length; i++)
    {
      copy[i] = numbers[i];
    }
    return copy;
  }


}