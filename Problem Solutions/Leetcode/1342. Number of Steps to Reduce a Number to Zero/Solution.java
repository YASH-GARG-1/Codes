// class Solution {
//     public int numberOfSteps(int num) {
//         int steps = 0;
//         while(num > 0)
//         {
//             if(num%2 == 0)
//             {
//                 num = num/2;
//             }
//             else
//             {
//                 num = num - 1;
//             }
//             steps++;
//         }
//         return steps;
//     }
// }

class Solution
{
    public int numberOfSteps(int num)
    {
        if(num == 0)
        {
            return 0;
        }
        int steps = 0;
        while(num > 0)
        {
            if((num & 1) == 1)
            {
                steps += 2;
            }
            else
            {
                steps += 1;
            }
            num = num>>1;
        }
        return steps-1;
    }
}