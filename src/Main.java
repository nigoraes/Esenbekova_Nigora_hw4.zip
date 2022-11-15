public class Main {
    public static int bossHealth = 700;
    public static int bossDamage = 50;
    public  static String bossDefenceType;
    public static int[] heroesHealth = {280,270,250,200};
    public static int [] heroesDamage = {10,15,20,0};
    public  static String[] heroAttackType = {"physical","magical","kinetic","medic"};

    public  static int roundNumber;

    public  static void main(String [] args) {
       printStatistics();


       while (!isGameFinished()){
           round();
       }



    }



        public static void printStatistics(){
            System.out.println("round:" + roundNumber + "---------------------");
            System.out.println("Boss health: " +  bossHealth  + "   damage:" + bossDamage);
            for (int i = 0; i < heroesHealth.length; i++) {
                System.out.println(heroAttackType[i] + "  health:"  +  heroesHealth[i]  + "  damage: " + heroesDamage[i]);



            }
        }

        public static boolean isGameFinished(){
        if (bossHealth <= 0 ){
            System.out.println("Heroes won");
            return true;
        }
        if (heroesHealth[0] <= 0 && heroesHealth[1] <= 0 && heroesHealth[2] <= 0){
                    System.out.println("boss won");
                    return  true;
            }
        return  false;
        }
        public static void  bossHit() {
            for (int i = 0; i < heroesHealth.length; i++) {
                if (heroesHealth[i] >0) {
                    if (heroesHealth[i] -  bossHealth<0){
                        heroesHealth[i] = 0;
                        } else{
                    heroesHealth[i] = heroesHealth[i] - bossDamage;
                }}
            }
        }
            public static void  heroesHit() {
                for (int i = 0; i < heroesDamage.length; i++) {
                    if (heroesHealth[i] >0 && bossHealth>0){
                        if (bossHealth - heroesDamage[i]<0) {
                        } else{
                        }
                    bossHealth = bossHealth - heroesDamage[i];
                }
                }
            }
                public static void round() {
                roundNumber++;
                bossHit();
                heroesHit();
                printStatistics();
                medic();

            }

    private static void medic() {
        for (int i = 0; i < heroesHealth.length; i++)       {
            if  (i==3)    {
            continue;
            }
            if (heroesHealth[i]>0 && heroesHealth[i]<100 && heroesHealth[i]>0) {
                heroesHealth[i]+=50;

            }
             System.out.println("isworking" + heroAttackType[i]);
            break;
        }

    }


}



