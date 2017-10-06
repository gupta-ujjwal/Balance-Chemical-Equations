package com.example.ujjwalgupta.chem;

class chemical
{
    static String elements[] =new String[10];
    static int count_row,count_col;

    static int matrix[][] ;
    static void chemical()
    {
        count_row=0;
        count_col=0;
    }

    static void row(String LHS, int L1)
    {
        int i,j;
        char c;
        String str;
        out:
        for(i=0;i<L1;i++)
        {
            c=LHS.charAt(i);
            if((c=='+')||(Character.isDigit(c)))
                continue out;
            if(i<(L1-1)&&(Character.isLowerCase(LHS.charAt(i+1))))
            {
                str=LHS.substring(i,i+2);
                for(j=0;j<count_row;j++)
                {
                    if(str.compareTo(elements[j])==0)
                        continue out;
                }
                elements[count_row]=str;
                count_row++;
                i++;
            }
            else
            {
                for(j=i-1;j>0;j--)
                {
                    if(c==LHS.charAt(j))
                        continue out;
                }
                elements[count_row]=String.valueOf(c);
                count_row++;
            }
        }

    }

    static void col(String str,int L)
    {
        int i,j;
        char c;
        for(i=0;i<(L-2);i++)
        {
            c=str.charAt(i);
            if((c=='+'))
            {	count_col++;
                for(j=i+1;j<L;j++)
                {
                    if((str.charAt(j)=='+'))
                        continue;
                    else
                        break;
                }
                i=j;
            }
        }
    }

    int find1(String str, String c )
    {
        int i,l,count=0;
        String S;
        l=str.length();
        for(i=0;i<l;i++)
        {
            S=String.valueOf(str.charAt(i));
            if(S.compareTo(c)==0)
            {
                if(i<(l-1))
                {
                    if(Character.isDigit(str.charAt(i+1)))
                    {
                        count=(int)str.charAt(i+1);
                        count-=48;
                    }
                    else
                        count=1;
                }
                else
                    count=1;
            }
        }
        return count;
    }

    int find2(String str, String c )
    {
        int i,l,count=0;
        String S;
        l=str.length();

        for(i=0;i<(l-1);i++)
        {
            S=str.substring(i,i+2);
            if(S.compareTo(c)==0)
            {   i++;
                if(i<(l-1))
                {
                    if(Character.isDigit(str.charAt(i+1)))
                    {
                        count=(int)str.charAt(i+1);
                        count-=48;
                    }
                    else
                        count=1;
                }
                else
                    count=1;
            }
        }
        return count;
    }



    public static void chem(String LHS,String RHS)
    {
        chemical ob =new chemical();
        String str,comp,EQ;
        int i,j,L1,L2,q,L;
        char c;
        L1=LHS.length();
        L2=RHS.length();
        row(LHS, L1);
        col(LHS,L1);
        col(RHS,L2);
        count_col+=2;
        matrix=new int[count_row][count_col];
        EQ=LHS+"+"+RHS;
        L=EQ.length();
        for(i=0;i<count_row;i++)
        {q=0;
            str=elements[i];
            for(j=0;j<count_col;j++)
            {
                comp="";
                while((EQ.charAt(q)!='+'))
                {
                    comp=comp+EQ.charAt(q);
                    if(q<(L-1))
                        q++;
                    else
                        break;

                }

                if(str.length()==2)
                    matrix[i][j]=ob.find2(comp,str);
                else
                    matrix[i][j]=ob.find1(comp,str);
                if(q>L1)
                    matrix[i][j]=-matrix[i][j];
                while((EQ.charAt(q)=='+'))
                {q++;
                }
            }

        }

    }
}


