import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EasterShopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        List<String> shops = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            shops.add(input[i]);
        }

        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            String[]  temp = scanner.nextLine().split(" ");
            String firstCommand = temp[0];

            if (firstCommand.equals("Include")) {
                shops.add(temp[1]);
            }

            if (firstCommand.equals("Visit")) {
                if (Integer.parseInt(temp[2]) < shops.size() && Integer.parseInt(temp[2]) >= 0) {
                    if (temp[1].equals("first")) {
                        for (int j = 0; j < Integer.parseInt(temp[2]); j++) {
                            shops.remove(0);
                        }
                    } else if (temp[1].equals("last")) {
                        for (int j = Integer.parseInt(temp[2]); j > 0; j--) {
                            shops.remove(shops.size() - 1);
                        }
                    }
                }
            }

            if (firstCommand.equals("Prefer")) {
                if (Integer.parseInt(temp[1]) >= 0 && Integer.parseInt(temp[1]) < shops.size() && Integer.parseInt(temp[2]) >= 0 && Integer.parseInt(temp[2]) < shops.size()) {
                    String firstWord = shops.get(Integer.parseInt(temp[1]));
                    String secondWord = shops.get(Integer.parseInt(temp[2]));
                    shops.set(Integer.parseInt(temp[1]), secondWord);
                    shops.set(Integer.parseInt(temp[2]), firstWord);
                }
            }

            if (firstCommand.equals("Place")) {
                if (Integer.parseInt(temp[2]) >= 0 && Integer.parseInt(temp[2]) <= shops.size()) {
                    shops.add(Integer.parseInt(temp[2]) + 1, temp[1]);
                }
            }

        }
        System.out.println("Shops left: ");
        for (String shop : shops) {
            System.out.print(shop + " ");
        }

    }
}
