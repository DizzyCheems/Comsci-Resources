#include<iostream>
using namespace std;

int fib (int n)
{
    if (n==0)
    {
        return 0;
    }
    if (n == 1 || n==2)
    {
        return 1;
    }
    return fib(n-2) + fib(n-1);
}
void result()
{
    int maxNumber;
    cout<<"Enter number of terms for your series"<<endl;
    cin>>maxNumber;
    cout<<"Your series of"<<" "<<maxNumber<<" "<<"terms is:";
 	for(int i = 0; i < maxNumber; i++)
	{
		cout<<fib(i)<< " ";
	}    
}
int main()
{
    result();
    return 0;
}