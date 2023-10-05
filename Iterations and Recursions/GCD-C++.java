#include <iostream>
using namespace std;
int n;
int m;
int funcgcd(int m, int n)
{
     int p = m;
     int q = n;
     while (p%q !=0)
     {
          int r = p%q;
          p=q;
          q=r;
     }
    return q;
}
void display()
{
    int result;
    cout<<"Enter Value of m"<<endl;
    cin>>m;
    cout<<"Enter Value of n"<<endl;
    cin>>n;
}
void output()
{
   display();
   int result = funcgcd(m,n);
   cout<<"The GCD of the values is:"<<result<<endl;
}
int main()
{
    output();
    return 0;
}




