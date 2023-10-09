//Rastgele sayılar oluşturur.
import java.util.Random;
//Metin dosyalarını okur.
import java.io.BufferedReader;
//Dosya okumak için kullanılır.BufferedReader ile ortak kullanılır.Dosyanın içini karakter karakter okur.
import java.io.FileReader;
//Dosya okuma/yazma işlemlerinde hata yakalamak için kullanılır.
import java.io.IOException;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class AdamAsmacaOyunu {
    public static void main(String[] args) {
        System.out.println("Adam Asmaca Oyununa Hoşgeldiniz...");

        String[] stages = {
                "  +---+\n" +
                        "  |   |\n" +
                        "  O   |\n" +
                        " /|\\  |\n" +
                        " / \\  |\n" +
                        "      |\n" +
                        "=========\n",

                "  +---+\n" +
                        "  |   |\n" +
                        "  O   |\n" +
                        " /|\\  |\n" +
                        " /    |\n" +
                        "      |\n" +
                        "=========\n",

                "  +---+\n" +
                        "  |   |\n" +
                        "  O   |\n" +
                        " /|\\  |\n" +
                        "      |\n" +
                        "      |\n" +
                        "=========\n",

                "  +---+\n" +
                        "  |   |\n" +
                        "  O   |\n" +
                        " /|   |\n" +
                        "      |\n" +
                        "      |\n" +
                        "=========\n",

                "  +---+\n" +
                        "  |   |\n" +
                        "  O   |\n" +
                        "  |   |\n" +
                        "      |\n" +
                        "      |\n" +
                        "=========\n",

                "  +---+\n" +
                        "  |   |\n" +
                        "  O   |\n" +
                        "      |\n" +
                        "      |\n" +
                        "      |\n" +
                        "=========\n",

                "  +---+\n" +
                        "  |   |\n" +
                        "      |\n" +
                        "      |\n" +
                        "      |\n" +
                        "      |\n" +
                        "=========\n"
        };

        List<String> wordList= readWordListFromFile("C:\\Users\\LENOVO\\Documents\\kelimeler.txt");
        if(wordList.isEmpty()){
            System.out.println("Kelime listesi boş veya okunamıyor.");
            return;
        }

        Random random=new Random();
        String selectedWord=wordList.get(random.nextInt(wordList.size())); // Rastgele kelime seç

        char[] display=new char[selectedWord.length()];
        for (int i=0;i<selectedWord.length();i++){

            //Seçilen kelime kadar satır koyar.(length();)
            display[i]='_';
        }

        //Kullanıcı ilk başta 5 cana sahiptir ve her yanlış bildiğinde bir can kaybeder.
        int lives=5;
        boolean gameEnd=false;

        //Oyun bu döngü içinde çalışır.
        while(!gameEnd){
            Scanner scanner=new Scanner(System.in);
            System.out.print("Lütfen bir harf giriniz: ");
            //Kullanıcıdan bir harf istenir ve seçilen harf küçük harf'e çevrilir.
            String guess=scanner.nextLine().toLowerCase();
            char guessChar=guess.charAt(0);
            boolean guessed=false;

            for(int i=0;i<selectedWord.length();i++){

                if(selectedWord.charAt(i)==guessChar){
                    // '_' yerine doğru harfi atar.
                    display[i]=guessChar;
                    guessed=true;
                }
            }

            if(!guessed){
                lives--;
                if(lives==0){
                //Eğer can kalmadıysa oyun biter.
                gameEnd= true;
                System.out.println("KAYBETTİN!");
                System.out.println("Doğru Cevap: "+selectedWord);
                }
            }

            System.out.println(display);

            //display adlı karakter dizisini (String) bir karakter dizisine dönüştürür
            if(!String.valueOf(display).contains("_")){
                gameEnd=true;
                System.out.println("KAZANDIN!!");
            }
            System.out.println(stages[lives]);
        }
    }

    //Dosya okuma methodu
    private static List<String> readWordListFromFile(String kelimeler) {
        List<String> wordList=new ArrayList<>();
        try(BufferedReader reader=new BufferedReader(new FileReader(kelimeler))){
            String line;
            while((line=reader.readLine())!=null){
                wordList.add(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return wordList;
    }
}
