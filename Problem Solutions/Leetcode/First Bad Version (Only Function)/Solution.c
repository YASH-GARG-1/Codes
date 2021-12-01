//Written Only Function
#include<stdbool.h>

int firstBadVersion(int n)
{

    int l = 1, h = n, las, mid;
    while (l <= h)
    {
        mid = l + (h - l) / 2;
        if (isBadVersion(mid) == true)
        {
            las = mid;
            h = mid - 1;
        }
        else
        {
            if (isBadVersion(mid) == false)
                l = mid + 1;
        }
    }
    return las;
}
