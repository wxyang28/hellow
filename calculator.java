import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class TestOperate {

	/*
	 * @param numerator 操作数分子栈
	 * @param denominator 操作数分母栈
	 * @param ChaStack 操作符栈
	 */
	Stack<Integer> numerator = new Stack<Integer>();//分子
	Stack<Integer> denominator = new Stack<Integer>();//分母
	Stack<Character> ChaStack = new Stack<Character>();	
	
	public boolean IsNumber(String temp) {
		return temp.matches("[0-9]");
	}
	
	public String caculate(StringBuffer string2) {
		
		String temp,result;//用来存放读取的字符
		StringBuffer tempnum = new StringBuffer();//记录当前数值
		StringBuffer string = new StringBuffer().append(string2);
		
		while(string.length()!=0)
		{
			temp = string.substring(0, 1);
			string.delete(0, 1);
			if(!IsNumber(temp))
			{
				//将得到的数送入运算数栈中
				if(!("").equals(tempnum.toString()))//("").equals(string)在string为null的时候返回false 
				{
					int num = Integer.parseInt(tempnum.toString());
					numerator.push(num);
					denominator.push(1);
					tempnum.delete(0, tempnum.length());
				}
				//若运算符栈非空且temp的优先级高于栈顶元素优先级
				while(!ChaStack.empty()&&!Compare(temp.charAt(0)))
				{
					int x2 = numerator.pop().intValue();
					int y2 = denominator.pop().intValue();
					int x1 = numerator.pop().intValue();
					int y1 = denominator.pop().intValue();
				
					int maxcom,numresult,denresult;//maxcom最大公约数,numresult分数计算结果，denresult分母计算结果
					int mincom = Minfunc(y1,y2);//最小公倍数
					x1 = mincom/y1*x1;
					x2 = mincom/y2*x2;
					y1 = mincom;
					y2 = mincom;
					char opt = ChaStack.pop();
					switch(opt)
					{
					case '+':
						{
							numresult = x1+x2;
							denresult = mincom;
							maxcom = Maxfunc(numresult,denresult);
							numresult = numresult/maxcom;
							denresult = denresult/maxcom;
							numerator.push(numresult);
							denominator.push(denresult);
							break;
						}
					case '-':
						{
							numresult = x1-x2;
							denresult = mincom;
							maxcom = Maxfunc(numresult,denresult);
							numresult = numresult/maxcom;
							denresult = denresult/maxcom;
							numerator.push(numresult);
							denominator.push(denresult);
							break;
						}
					case '*':
						{
							numresult = x1*x2;
							denresult = y1*y2;
							maxcom = Maxfunc(numresult,denresult);
							numresult = numresult/maxcom;
							denresult = denresult/maxcom;
							numerator.push(numresult);
							denominator.push(denresult);
							break;
						}
					case '/': 
						{
							numresult = x1*y2;
							denresult = y1*x2;
							maxcom = Maxfunc(numresult,denresult);
							numresult = numresult/maxcom;
							denresult = denresult/maxcom;
							numerator.push(numresult);
							denominator.push(denresult);
							break;
						}
					}
				}
				if(temp.charAt(0)!='#')
				{
					ChaStack.push(new Character(temp.charAt(0)));
					if(ChaStack.peek()==')') 
					{
						ChaStack.pop();
						ChaStack.pop();
					}
				}
			}else
			tempnum = tempnum.append(temp);
		}
		int x = numerator.pop();
		int y = denominator.pop();
		int a;
		if(x%y == 0)
		{
			a = x/y;
			result = String.valueOf(a);
		}
		else  result = String.valueOf(x) + '/' + String.valueOf(y);
		return result;
	}
	private int Maxfunc(int a, int b) {//分子分母最大公约数
		// TODO Auto-generated method stub
		while(b != 0) 
		{
			int temp = a%b;
			a = b;
			b = temp;
		}
		return a;
	}

	private int Minfunc(int a, int b) {//分母的最小公倍数，通分
		// TODO Auto-generated method stub
		return a * b / Maxfunc(a, b);
	}

	public boolean Compare(char opt) {//opt高于栈顶操作符等级返回真
		if(ChaStack.empty()) return true;
		char tag = (char)ChaStack.peek();
		if(tag=='(') return true;
		switch(opt)
		{
		case '#':return false;
		case '(':return true;
		case ')':return false;
		case '+':return false;
		case '-':return false;
		case '*':
			if(tag=='+'||tag=='-')
				return true;
			else return false;
		case '/':
			if(tag=='+'||tag=='-')
				return true;
			else return false;
		}
		return true;
	}
	
	 String Divide()//分数的生成
	 {
		 int i=(int)(Math.random()*10);
		 int j=(int)(Math.random()*10);
		 if(i>=j)
		 {
			 int temp=i;
			 i=j;
			 j=temp;
		 }
		 return("("+i+"/"+j+")");
	}
	
	public static void main(String[] args) {
	  	  
		TestOperate operate = new TestOperate();
		File tesfile = new File("F:/CacTest/test.txt");
		File ansfile = new File("F:/CacTest/answer.txt");
		try 
		{   
			FileWriter fw5 = new FileWriter(tesfile);
			BufferedWriter bw1 = new BufferedWriter(fw5);
			bw1.write("");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		try 
		{   
			FileWriter fw = new FileWriter(ansfile);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		String x,y;
		int k;
		for(int n=0;n<10;n++)
		{
			String ats = null;
			x=operate.Divide();
			y=operate.Divide();
			int i=(int)(Math.random()*100);
			int j=(int)(Math.random()*100);
			switch((int)(Math.random()*4))
			{
			case 0:
				k=(int)(Math.random()*3);
				if(k==0)
					ats = i+"+"+j;
				else if(k==1)
					ats = x+"+"+j;
				else if(k==2)
					ats = y+"+"+x;
				break;
			case 1:
				k=(int)(Math.random()*3);
				if(i<j)
				{
					int temp=i;
					i=j;
					j=temp;
				}
				if(k==0)
					ats = i+"-"+j;
				else if(k==1)
					ats = j+"-"+x;
				else if(k==2)
					ats = x+"-"+y;
				break;
			case 2:
				k=(int)(Math.random()*3);
				if(k==0)
					ats = i+"*"+j;
				else if(k==1)
					ats = x+"*"+j;
				else if(k==2)
					ats = x+"*"+y;
				break;
			case 3:
				while(j==0)
					j= (int)(Math.random()*100);
				ats = i+"/"+j;
				break;
			}
			try{
				FileOutputStream out = new FileOutputStream(tesfile,true);
				DataOutputStream ds = new DataOutputStream(out);
				ats += "="+"\r\n";
				int b=ats.length();
				ds.write(ats.getBytes(),0,b); 
				ds.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		String str = null;
		try{
			BufferedReader br = new BufferedReader(new FileReader("F:/CacTest/test.txt"));
			while((str = br.readLine())!=null){
				StringBuffer string = new StringBuffer().append(str);
				int len = string.length();
				string.delete(len-1, len);
				string.append('#');
				String t = operate.caculate(string);

				try{
					FileOutputStream out1 = new FileOutputStream(ansfile,true);
					DataOutputStream ds1 = new DataOutputStream(out1);
					t += "\r\n";
					int b=t.length();
					ds1.write(t.getBytes(),0,b); 
					ds1.close();
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}
			br.close();
		}catch(FileNotFoundException e2){
			e2.printStackTrace();
		}catch(IOException e3){
			e3.printStackTrace();
		}
		try{
			BufferedReader br = new BufferedReader(new FileReader("F:/CacTest/test.txt"));
			while((str = br.readLine())!=null){
				StringBuffer string = new StringBuffer().append(str);
				int len = string.length();
				int flag;
				string.delete(len-1, len);
				string.append('#');
				String t = operate.caculate(string);
				System.out.println(str);
				System.out.println("请输入答案：");
				Scanner sc = new Scanner(System.in);
				String StuResult = null;
				StuResult = sc.nextLine();
				if(t.equals(StuResult))
				{
					System.out.println("恭喜你答对了！");
					System.out.println("是否进行下一题，是输入1，否输入2。");
					flag = sc.nextInt();
					if(flag == 2) break;
				}
				else
				{
					System.out.println("答错啦，请再接再厉，正确答案为：" + t);
					System.out.println("是否进行下一题，是输入1，否输入2。");
					flag = sc.nextInt();
					if(flag == 2) break;
				}
				sc.close();
			}
			br.close();
		}catch(FileNotFoundException e2){
			e2.printStackTrace();
		}catch(IOException e3){
			e3.printStackTrace();
		}
	}
}
