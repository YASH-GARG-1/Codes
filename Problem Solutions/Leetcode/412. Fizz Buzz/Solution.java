class Solution {
    public List<String> fizzBuzz(int n) {
        int div3 = 0, div5 = 0;
        List<String> ansArr = new ArrayList<>();
        for(int i = 1; i <= n; i++)
        {
            boolean div = false;
            String ans = "";
            div3++;
            div5++;
            if(div3 == 3)
            {
                ans = "Fizz";
                div3 = 0;
                div = true;
            }
            if(div5 == 5)
            {
                ans = ans + "Buzz";
                div5 = 0;
                div = true;
            }
            if(!div)
            {
                ans = ""+i;
            }
            ansArr.add(ans);
        }
        return ansArr;
    }
}