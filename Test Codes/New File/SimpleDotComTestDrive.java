class SimpleDotCom{
    int [] locationCells;
    int numOfHits;

    String checkYourself(String guess){
        return null;
    }

    void setLocationCells(int [] loc)
    {

    }
}

public class SimpleDotComTestDrive{

    public static void main(String[] args) {
        SimpleDotCom dot = new SimpleDotCom();

        int location[] = {2,3,4};
        dot.setLocationCells(location);
        
        String userGuess = "2";
        String result = dot.checkYourself(userGuess);
        String testResult = "failed";
        if(result.equals("hit"))
        {
            testResult = "passed";
        }
        System.out.println(testResult);
    }
}
