#include <stdio.h>
#include <stdlib.h>

//One of the fastest methods to convert a roman to integer value.

int romanToInt(char *s)
{
    int sum = 0, i = 0;
    while (s[i] == 'M')
    {
        sum += 1000;
        i++;
    }
    if (s[i] == 'C' && s[i + 1] == 'M')
    {
        sum += 900;
        i += 2;
    }
    while (s[i] == 'D')
    {
        sum += 500;
        i++;
    }
    if (s[i] == 'C' && s[i + 1] == 'D')
    {
        sum += 400;
        i += 2;
    }
    while (s[i] == 'C')
    {
        sum += 100;
        i++;
    }
    if (s[i] == 'X' && s[i + 1] == 'C')
    {
        sum += 90;
        i += 2;
    }
    while (s[i] == 'L')
    {
        sum += 50;
        i++;
    }
    if (s[i] == 'X' && s[i + 1] == 'L')
    {
        sum += 40;
        i += 2;
    }
    while (s[i] == 'X')
    {
        sum += 10;
        i++;
    }
    if (s[i] == 'I' && s[i + 1] == 'X')
    {
        sum += 9;
        i += 2;
    }
    while (s[i] == 'V')
    {
        sum += 5;
        i++;
    }
    if (s[i] == 'I' && s[i + 1] == 'V')
    {
        sum += 4;
        i += 2;
    }
    while (s[i] == 'I')
    {
        sum += 1;
        i++;
    }
    return sum;
}

int main(){
    
    int sum = 0;
    char str[20];
    printf("Enter the Roman Value : ");
    scanf("%[^\n]%*c", str);
    sum = romanToInt(str);
    printf("The Integer value of the Roman Number is : %d\n",sum);
    return 0;
}