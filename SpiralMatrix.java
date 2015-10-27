package com.cci;

import java.util.Arrays;

/**
 * [a,b,c,d,e]
 * [j,o,n,m,l]
 * [k,f,g,h,i]
 */
public class SpiralMatrix 
{
	public static void main (String args[]){
		char[][] mat = { {'a', 'b', 'c', 'd', 'e'},
						 {'f', 'g', 'h', 'i', 'j'},
						 {'k', 'l', 'm', 'n', 'o'}};
		
		StringBuilder sb = new StringBuilder(); //using the StringBuilder so that the result could be printed in a spiral matrix
		int i,
		rows=mat.length,
		cols=mat[0].length,
		r=cols-1,
		q=rows-1;
		
		char[][] spmat = new char[rows][cols]; //the resulting spiral matrix 
		
		while(q>0 && r>0)
		{
			for(i=cols-1-r ; i<=r; i++)
			{
				sb.append(mat[cols-1-r][i]);
				System.out.print(mat[cols-1-r][i] + " ");
			}
			for(i=rows-1-q+1 ; i<=q ; i++)
			{
				sb.append(mat[i][r]);
				System.out.print(mat[i][r]+ " ");
			}
			for(i=r-1 ; i>=cols-1-r && q>1 ; i--)
			{
				sb.append(mat[q][i]);
				System.out.print(mat[q][i]+ " ");
			}
			for(i=q-1 ; i>=rows-1-q+1 && r>1 ; i--)
			{
				sb.append(mat[i][rows-1-q]);
				System.out.print(mat[i][rows-1-q] + " ");
			}
			q--;
			r--;
		}
		
		int counter=0;
		for(int k=0; k<rows; k++)
			{
				for (int j=0; j<cols;j++)
				{	
				spmat[k][j]=sb.charAt(counter);
				counter++;
				}
			}
		System.out.println("\n");
		System.out.println(Arrays.deepToString(spmat));
		
	}

}
