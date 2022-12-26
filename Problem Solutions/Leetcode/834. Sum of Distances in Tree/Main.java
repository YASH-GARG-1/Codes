import java.util.*;

public class Main{
    public static void main(String args[])
    {
        
    }
    
    static ArrayList<Long> ans;
    static HashMap<Long, Long> hm;
    static HashMap<Long, Long> countHm;
    static ArrayList<Long> arr;
    static int maxNum = -1;
    static int count = 0;
    static int[] solve(int N, int Q, int [][] operations)
    {
        maxNum = N;
        ans = new ArrayList<>();
        arr = new ArrayList<>();
        hm = new HashMap<>();
        for(int i = 0; i < Q; i++)
        {
            int op = operations[i][0];
            long key = operations[i][1];
            long value = operations[i][2];
            if(op == 1)
            {
                if(hm.containsKey(key))
                {
                    ans.add(hm.get(key));
                }
                else
                {
                    long temp = -1;
                    ans.add(temp);
                }
            }
            else
            {
                hm.put(key, value);
                insertElement(key);
            }
        }
        
        int len = ans.size(); // should I check for 0 length??
        int finalAns[] = new int[len];
        for(int i = 0; i < len; i++)
        {
            long temp = ans.get(i);
            finalAns[i] = (int)temp;
        }
        return finalAns;
    }
    
    public static void insertElement(long ele)
    {
        int len = arr.size();
        long freq = 1;
        if(countHm.containsKey(ele))
        {
            freq = countHm.get(ele) + 1;
            len--;
            arr.remove(ele);
        }
        else if(count < maxNum)
        {
            count++;
        }
        else 
        {
            len--;
            countHm.remove(arr.get(0));
            arr.remove(0);
        }
        countHm.put(ele, freq);
        if(len == 0)
        {
            arr.add(ele);
            return;
        }
        if(ele <= arr.get(0) && freq <= countHm.get(arr.get(0)))
        {
            arr.add(0, ele);
            return;
        }
        else if(ele >= arr.get(len-1) && freq >= countHm.get(arr.get(len-1)))
        {
            arr.add(len, ele);
            return;
        }
        else
        {
            int start = 0; 
            int end = len-1;
            while(start <= end)
            {
                int mid = (start + (end-start)/2);
                long midEle = arr.get(mid);
                long freqMid = countHm.get(midEle);
                if(freqMid <= freq)
                {
                    // yeah part implement ker ra hu
                    if(freq < countHm.get(arr.get(mid+1)))
                    {
                        if(freqMid < freq)
                        {
                            arr.add(mid+1,ele);
                            return;
                        }
                        else if(midEle <= ele)
                        {
                            arr.add(mid+1,ele);
                            return;
                        }
                        else
                        {
                            end = mid-1;
                        }
                    }
                    else if(freq == countHm.get(arr.get(mid+1)))
                    {
                        if(freqMid == freq)
                        {
                            if(ele >= arr.get(mid) && ele <= arr.get(mid+1))
                            {
                                arr.add(mid+1, ele);
                                break;
                            }
                            else if(ele > arr.get(mid+1))
                            {
                                start = mid+1;
                            }
                            else
                            {
                                end = mid-1;
                            }
                        }
                        else
                        {
                            if(ele <= arr.get(mid+1))
                            {
                                arr.add(mid+1,ele);
                                break;
                            }
                            else
                            {
                                start = mid+1;
                            }
                        }
                    }
                    else
                    {
                        start = mid+1;
                    }
                }
                else if(freqMid < freq)
                {
                    start = mid+1;
                }
                else
                {
                    end = mid-1;
                }
            }
        }
    }
}