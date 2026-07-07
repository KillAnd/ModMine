public class Main {
    public static void main(String[] args) {
        for (int i = 0; i <= 1000; i++) {
            if (i%3 == 0 && i%5 != 0 && String.valueOf(i).chars().map(Character::getNumericValue).sum() < 10){
                System.out.println(i);
            }
        }
    }
}