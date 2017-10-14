import java.util.Random;
import java.lang.*;
import java.util.*;
/**
 *
 * @author Orhan Demirel
 */
public class Perceptron {

     enum depend{CLASS,MAIN(),STATIC,SYSTEMPRINT};
    double[] weights;
    double threshold;
    //static count=0;
    //int cap= cap=Math.pow(2,n);
    public void Train(double[][] inputs,int[] outputs, double lrate, int epoch)
    {
        //this.threshold = threshold;
        int n = inputs[0].length;
        //cap=Math.pow(2,n);
        int p = outputs.length;
        weights = new double[n];
        Random r = new Random();
        
        //initialize weights
        for(int i=0;i<n;i++)
        {
            weights[i] = r.nextDouble();
            //System.out.println(weights[i]);
        }
        //System.out.println("==================");

        for(int i=0;i<epoch;i++)
        {
            int totalError = 0;
            for(int j =0;j<p;j++)
            {
                int output = Output(inputs[j]);
                int error = outputs[j] - output;
                
                totalError +=error;
               
                for(int k = 0;k<n;k++)
                {
                    double delta =  lrate*inputs[j][k] * error;
                    weights[k] += delta;
                   // System.out.println(delta);
                }

                
                
            }
            if(totalError == 0)
                break;
      }
        
    }

    public int Output(double[] input)
    {
        /*int k=0;
        double[][] b1={};int[] out1={};
        for(int i=0;i<b.length;i++)
        {
            if(b[i]!=input)
             k++;
            b1[i]=b[i];
            out1[i]=out[i];
            System.out.println("hello");
         }
         if(k==b.length)
         {
           b1[b1.length]=input;
          }*/
        double sum = 0.0;
        for(int i=0;i<input.length;i++)
        {
            sum += weights[i]*input[i];
        }

        double fk=1/(1+Math.pow(2.718,-sum));
        if(fk>0.5)
        return 1;
        else
        return 0;
    }
   public void Out1(double k[][],int len,double[][] arr,int[] r,int req)
   {
          double[][] a=new double[len+k.length][arr[0].length];
          int[] k1=new int[len+k.length];
          for(int i=0;i<len;i++)
          {
           for(int j=0;j<arr[0].length;j++)
           {
              a[i][j]=arr[i][j];
              //System.out.println(a[i][j]);
           }
          k1[i]=r[i];
         }
        for(int i=0;i<k.length;i++)
        {
          double g[]=k[i];
          for(int j=0;j<arr[0].length;j++)
          a[len+i][j]=g[j];
          k1[len+i]=Output(a[len+i]);
         }
        System.out.println("output array");
        for(int i=0;i<len+k.length;i++)
        System.out.print(k1[i]+" ");
        System.out.println();
        /* for(int i=0;i<len+k.length;i++)
        {
           for(int j=0;j<3;j++)
           System.out.print(a[i][j]+" ");
           System.out.println(" ");
        }*/ 

        //Train(a,k1,0.2,0.1,200);
        //public enum depend(CLASS,BRACES,MAIN(),STATIC,SYSTEMPRINT);
        for(int i=0;i<len+k.length;i++)
        {
             if(req==k1[i])
             {
              for(int j=0;j<arr[0].length;j++)
               {
                //System.out.print(a[i][j]+" ");
                 if(a[i][j]==1)
                 System.out.println(depend.values()[j]+" "+"weights:"+weights[j]);
                }
               }
             System.out.println();
        }
        System.out.println("==================");
       /* for(int i=0;i<len+k.length;i++)
        {
           for(int j=0;j<3;j++)
           System.out.print(a[i][j]+" ");
           System.out.println(" ");
        }*/ 
    }
   public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Perceptron p = new Perceptron();
        double inputs[][] = {{0,0,0,0},{1,1,0,1},{1,0,1,1},{0,1,1,1},{0,0,0,1},{0,0,1,0},{0,0,1,1},{0,1,0,1},{0,1,1,1},{0,0,0,1},{0,0,1,0},{0,0,1,1},{0,1,0,1},{0,1,1,0},{0,1,1,1},{1,0,0,0},{1,0,0,1},{1,1,0,0},{1,1,1,1}};
        int outputs[]= {0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        //double thres=(Math.pow(2.718,1))/(1+(Math.pow(2.718,1)));
        //System.out.println(thres);
       p.Train(inputs, outputs, 0.1, 200);
       // System.out.println(p.Output(new double[]{0,0}));
       // System.out.println(p.Output(new double[]{1,0}));
       // System.out.println(p.Output(new double[]{0,1}));
       double[][] l={{0,1,0,1},{0,0,0,1},{0,1,0,0}};
       //int op=p.Output(l);
      // System.out.println(op);
      int g;
      System.out.println("enter choice of output 1 for hello world ");
      g=sc.nextInt();
       p.Out1(l,inputs.length,inputs,outputs,g);

    }


}

