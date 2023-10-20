package FirstProgram;

import java.util.Scanner;

public class percabangan {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String password = prompt("Enter password :");
        String validPassword = "Password";

        //jka benar  maka selamat datang tuan
        //jika salah (else)) maka eror
        if(password.equals(validPassword)) {
            System.out.println("selamat datang bos!");
        } else {
            System.out.println("password salah, coba lagi!");
        }
        System.out.println("terima kasih sudah menggunakan aplikasi kami");

}
    private static String prompt(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }
}