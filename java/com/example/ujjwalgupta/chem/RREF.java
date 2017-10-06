package com.example.ujjwalgupta.chem;

public class RREF extends chemical
{

    chemical ob1 =new chemical();
    void rep(float a[][],int row,int col,int c)
    {
        int i,j;
        float b;
        for(i=c+1;i<row;i++)
        {
            if(a[i][c]!=0)
                break;
        }
        if(i!=row)
        {
            for(j=0;j<=col;j++)
            {
                b=a[c][j];
                a[c][j]=a[i][j];
                a[i][j]=b;
            }}
    }

    void mark(float a[][],int row,int col, int c)
    {
        int i;
        for(i=c;i<row;i++)
        {
            if(a[i][c]==0)
                a[i][col]=0;
            else
                a[i][col]=1;
        }
    }

    void div(float a[][], int row,int col,int c)
    {
        int i,j;
        float num;
        for(i=c;i<row;i++)
        {
            if(a[i][col]==1)
            {
                num=a[i][c];
                for(j=c;j<col;j++)
                {
                    a[i][j]=a[i][j]/num;
                }
            }
        }
    }

    void sub(float a[][], int row ,int col,int c)
    {
        int i,j;
        for(i=c+1;i<row;i++)
        {
            if(a[i][col]==1)
            {
                for(j=c;j<col;j++)
                    a[i][j]=a[i][j]-a[c][j];
            }
        }
    }
    float add(float a[][],float el[],int row,int col,int c)
    {
        float sum=0;
        int  i,j;
        for(i=c+1;i<col;i++)
        {
            sum=sum-a[c][i]*el[i];
        }
        return sum;
    }

    int check(float a,int c)
    {
        float x,y,p,q;
        a=a*c;
        p=(float)Math.round(a);
        q=(float)Math.ceil(a);
        if(q>(a+0.9))
            q--;
        x=(float)(q-0.1);
        y=(float)(q+0.1);

        if((a>=x)&&(a<=y))
            return 1;
        else
            return 0;
    }

    public static String SOLVE(String LHS,String RHS)
    {
        RREF ob =new RREF();
        int row,col,i,j,k,l;
        String str;
        float sum;
        chem(LHS,RHS);
        row=count_row;
        col=count_col;

        float el[] =new float[col];
        float a[][]=new float[row][col+1];
        str=LHS+"++"+RHS;
        l=str.length();
        for(i=0;i<row;i++)
        {
            for(j=0;j<col;j++)
                a[i][j]=matrix[i][j];
        }

        System.out.println();
        i=0;
        if(a[0][0]==0)
            ob.rep(a,row,col,i);
        for(i=0;i<col-1;i++)
        {
            if(i>=row)
                break;
            if(a[i][i]==0)
            {
                ob.rep(a,row,col,i);
            }
            ob.mark(a,row,col,i);
            ob.div(a,row,col,i);
            ob.sub(a,row,col,i);
        }

        i=row-1;
        while(a[i][col-1]==0||a[i][col-2]==0)
            i--;
        k=i;
        el[col-1]=1;
        for(i=k;i>=0;i--)
        {
            el[i]=ob.add(a,el,row,col,i);
        }

        for(i=0;i<row;i++)
        {
            for(j=0;j<col;j++)
                System.out.print(a[i][j]+"            ");

            System.out.println();
        }

        k=0;
        for(i=1;i<20;i++)
        {
            for(j=0;j<col;j++)
            {
                k=ob.check(el[j],i);
                if(k==0)
                    break;
            }
            if(j==col)
            {
                for(j=0;j<col;j++)
                    el[j]=el[j]*i;
                break;

            }

        }

        for(j=0;j<col;j++)
        {
            el[j]=Math.round(el[j]);
        }

        String s="";
        String p="";
        char q;
        i=0;
        for(k=0;k<col;k++)
        {
            s=s+String.valueOf((int)el[k]);
            q=str.charAt(i);
            while((q!='+')&&(i<l-1))
            {
                p=p+q;
                i++;
                q=str.charAt(i);
            }
            s=s+p;
            p="";
            if(++i<l)
            {
                q=str.charAt(i);
                if(q=='+')
                {
                    s=s+" --> ";
                    i++;
                }
                else
                    s=s+" + ";
            }
        }

        return (s+str.charAt(l-1));


    }
}