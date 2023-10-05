#include <iostream>

using namespace std;
     
  
class JustineStack
{
 
    int top;
    int capacity;
    int size;
    int* arr;
    public: JustineStack(){
        cout<<"Enter Stack size: ";
        cin>>size;
        top = -1;
        arr = new int[size];
        capacity = size;
        
    }
    int menu();
    bool isEmpty();
    bool isFull();
    void push(int x);
    int pop();
    int peek();
    int sizes();
    int clear();
    void display();
};

int JustineStack::menu()
{
    
     /***************************************************/
        cout<< "++++++++++++++++++++++++\n"<<endl;
        cout<<"Select Options"<<endl;
        cout<<"1 - To Put value inside the stack"<<endl;
        cout<<"2 - Pop Value from the stack"<<endl;
        cout<<"3 - To Peek inside the stack"<<endl;
        cout<<"4 - To delete entire stack"<<endl;
        cout<<"5 - Check stack size"<<endl;
        cout<<"6 - Display Stack"<<endl;
        cout<<"7 - Check if Empty"<<endl;
        cout<<"8 - Check if Full"<<endl;
        cout<<"9 - Terminate program"<<endl;
       cout<< "++++++++++++++++++++++++"<<endl;
        int choice;
        cin>>choice;
        return choice;    
}


bool JustineStack::isEmpty(){
    return top == -1;
}
bool JustineStack::isFull(){
    return top == capacity -1;
}
void JustineStack::push(int x){
    if(isFull()){
        cout<<"\nOverFlow\nProgram Terminated";
        exit(1);
    }
    else{
        cout<<"\nInserting "<<x<<" top = "<<top+1<<endl;
        arr[++top]=x;
    }
}
int JustineStack::pop(){
    if(isEmpty()){
        cout<<"\nUnderFlow\nProgram Terminated";
        exit(1);
    }
    else{
        cout<<"\nRemoving "<<peek()<<" top = "<<top-1<<endl;
        return arr[top--];
    }
}
int JustineStack::peek(){
    if(!isEmpty()){
        return arr[top];
    }
    else{
        exit(1);
    return -1;
    }
}
int JustineStack::sizes(){
    return top +1;
}
void JustineStack::display(){
    cout<<"\nPrinting stack elements: "<<endl;
    for(int i =0; i<=top;i++){
        cout<<arr[i]<<" ";
    }
    cout<<"\ntop = "<<top<<endl;
}
int JustineStack::clear(){
    top = -1;
    return top;
}
int main()
{
    JustineStack mystack;
    int n;
    bool key;
    int menu = 0;
    while(key != true)
    {
          int select = mystack.menu();
        switch(select)
        {
            case 1:
            cout<<"Enter an Element: ";
            cin>>n;
            
            mystack.push(n);
            break;
            
            case 2:
            mystack.pop();
            break;
            
            case 3:
            cout<<"\nShowing: "<<n<<endl;
            break;
            
            case 4:
            cout<<"\nAll Stack Elements Removed";
            mystack.clear();
            break;
            
            case 5:
            cout<<"\n The Size is "<<mystack.sizes()<<endl;
            break;
            
            case 6:
            mystack.display();
            break;
            
            case 7:
               if(mystack.isEmpty()){
                cout<<"\nThe Stack is Empty"<<endl;
            }
            else{
                cout<<"\nThe Stack is NOT Empty"<<endl;
            }
            break;
            
            case 8:
            if(mystack.isFull()){
                cout<<"\nThe Stack is Full"<<endl;
            }
            else{
                cout<<"\nThe Stack is NOT Full"<<endl;
            }
            break;
        }
    }


    return 0;
}