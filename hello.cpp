#include<iostream>
using namespace std;
int main()
{//本程序在原始程序的基础上增加了一个计算0到9连续相加总和，并在输出hello的基础上输出和sum的值
	int sum=0;
	for(int i=0;i<10;i++){
		sum=sum+i;
	}//利用for循环计算sum
	cout << "Hello World!" << endl;//输出Hello World!
	cout << "The sum is :"<<sum << endl;//输出sum
	return 0;
}
