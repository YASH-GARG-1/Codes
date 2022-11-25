public class Test {

    public static class GameCharacter
    {
    private int power;
    private String type;
    private String[] weapons;

    public GameCharacter(int p, String t, String[] w)
    {
        power = p;
        type = t;
        weapons = w;
    }

    public int getPower()
    {
        return power;
    } 
    public String getType()
    {
        return type;
    }
    // public String getWeapons()
    // {
    //     String weaponsList = "";
    //     for(String ele : weapons)
    //     {
    //         weaponsList += ele + " ";
    //     }
    //     return weaponsList;
    // }
    public String[] getWeapons()
    {
        String[] retStr = new String[weapons.length];
        int idx = 0;
        for(String ele : weapons)
        {
            retStr[idx++] = ele;
        }
        return retStr;
    }
    }
    public static void main(String[] args) {
        GameCharacter gc = new GameCharacter(50, "ELF", new String[] {"sword", "dust"});
        System.out.println(gc.getPower());
        System.out.println(gc.getType());
        String[] str = gc.getWeapons();
        for(String ele : str)
        {
            System.out.print(ele + " ");
        }
        str[0] = "changed";
        System.out.print("\n");
        str = gc.getWeapons();
        for(String ele : str)
        {
            System.out.print(ele + " ");
        }
        // System.out.println(gc.getWeapons());
    }    
}
