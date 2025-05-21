/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project_1;

import java.util.Scanner;

/**
 *
 * @author emreyazici
 */
public class Project_1 {

    public static void main(String[] args) {
        char[][] labirent = {
            {'#', '!', '.', '.', 'R', '.', '.', '.', '.', '.', '.', '#', '.', '.', '.'},
            {'.', '.', '#', '.', '.', '.', '#', '.', 'H', '.', '.', '.', '.', '.', '!'},
            {'F', '.', '.', '.', '#', '.', '!', '.', '.', 'R', '.', '.', '#', '#', '.'},
            {'.', '.', '#', '.', '.', '#', '.', '.', '.', '.', 'F', '.', '.', '.', '.'},
            {'.', '!', '.', '.', '#', '.', '#', '.', '#', '.', '.', '#', '.', '.', '.'},
            {'.', '.', 'H', '.', '.', '!', '.', '.', 'H', '.', '.', 'F', '.', '.', 'R'},
            {'#', '#', '#', '#', '.', '.', '#', '.', '.', '.', 'T', '.', '.', '.', 'E'},
            {'.', '.', '#', '.', 'F', '.', '#', '#', '.', '#', '#', '#', '#', '.', '.'},
            {'.', '#', '.', '.', '.', '.', '!', '.', '#', '.', '.', '.', '#', '.', '.'},
            {'.', 'T', 'T', '.', '#', '#', '.', '.', '.', '.', 'T', '.', '.', '.', 'R'},
            {'.', '.', '.', '#', '.', '.', '.', '#', '.', '#', '.', '#', '.', 'T', '.'},
            {'B', '.', '#', '.', '.', '!', '.', '!', '.', '.', '.', '.', '.', '.', '#'},
            {'.', '.', '.', 'F', '!', '.', '.', '.', 'H', '.', '.', 'R', '.', '.', '.'},
            {'.', '.', 'H', '.', '.', '.', '!', '.', '.', '.', '#', '.', '.', '#', '.'},
            {'.', '.', '.', '#', '.', '.', '#', '.', '#', '.', '#', '.', '.', '#', '#'}
        };
        int[] konum = baslangic_bitis(labirent);
        int[] T = {0}, H = {0}, R = {0}, F = {0};
        int[] adimSayisi = {0}, hamleSayisi = {0};
        boolean[] kontrol = {true};
        char a = ' ';
        System.out.println("Bulundugunuz Konum (" + konum[0] + "," + konum[1] + ")");
        while (kontrol[0]) {
            yeniharita(hamleSayisi, labirent, konum, a);
            System.out.println("Adim Sayisi: " + adimSayisi[0]);
            System.out.println("W, A, S, D karakterlerinden birini giriniz ya da bonus kullanmak için +\n"
                    + "karakterine basınız. Çıkış için “exit” yazınız.");
            Scanner input = new Scanner(System.in);
            String hareket = input.nextLine().toUpperCase();

            if (hareket.length() == 1 && !hareket.equals("") && !hareket.equals("\n")) {
                a = hareket.charAt(0);
            }
            konum(labirent, konum, a, hareket, adimSayisi, T, H, R, F, kontrol, hamleSayisi);
            koordinat(labirent, konum, T, H, R, F, a, adimSayisi, kontrol);
            System.out.println(hamleSayisi[0]);
        }
    }

    public static int[] baslangic_bitis(char[][] baslangic) {
        int[] konum = new int[4]; //0-1 Başlangıç  2-3 Bitiş noktası
        for (int i = 0; i < baslangic.length; i++) {
            for (int j = 0; j < baslangic[i].length; j++) {
                if (baslangic[i][j] == 'B') {
                    konum[0] = i;
                    konum[1] = j;
                    break;
                }
            }
        }
        for (int i = 0; i < baslangic.length; i++) {
            for (int j = 0; j < baslangic[i].length; j++) {
                if (baslangic[i][j] == 'E') {
                    konum[2] = i;
                    konum[3] = j;
                    break;
                }
            }
        }
        return konum;
    }
    public static void yeniharita(int[] hamleSayisi, char[][] lab, int konum[], char aa) {
        int[] t = t_sayim(lab);
        int[] h = h_sayim(lab);
        int[] r = r_sayim(lab);
        int[] f = f_sayim(lab);
        int[] mayin_sayisi = mayin_sayim(lab);
        int a = 0;
        int b = 0;

        if (hamleSayisi[0] == 5) {
            bonus_mayin_silme(lab);
            for (int i = t[0]; i > 0; i--) {
                a = (int) (Math.random() * 15);
                b = (int) (Math.random() * 15);
                if (lab[a][b] != '!' && lab[a][b] != '#' && lab[a][b] != 'X') {
                    lab[a][b] = 'T';
                } else {
                    i++;
                }
            }
            for (int i = h[0]; i > 0; i--) {
                a = (int) (Math.random() * 15);
                b = (int) (Math.random() * 15);
                if (lab[a][b] != '!' && lab[a][b] != '#' && lab[a][b] != 'T' && lab[a][b] != 'E' && lab[a][b] != 'X') {
                    lab[a][b] = 'H';
                } else {
                    i++;
                }
            }
            for (int i = r[0]; i > 0; i--) {
                a = (int) (Math.random() * 15);
                b = (int) (Math.random() * 15);
                if (lab[a][b] != '!' && lab[a][b] != '#' && lab[a][b] != 'T' && lab[a][b] != 'H' && lab[a][b] != 'E' && lab[a][b] != 'X') {
                    lab[a][b] = 'R';
                } else {
                    i++;
                }
            }
            for (int i = f[0]; i > 0; i--) {
                a = (int) (Math.random() * 15);
                b = (int) (Math.random() * 15);
                if (lab[a][b] != '!' && lab[a][b] != '#' && lab[a][b] != 'T' && lab[a][b] != 'H' && lab[a][b] != 'R' && lab[a][b] != 'E' && lab[a][b] != 'X') {
                    lab[a][b] = 'F';
                } else {
                    i++;
                }
            }
            for (int i = mayin_sayisi[0]; i > 0; i--) {
                a = (int) (Math.random() * 15);
                b = (int) (Math.random() * 15);
                if (lab[a][b] != '#' && lab[a][b] != 'T' && lab[a][b] != 'H' && lab[a][b] != 'R' && lab[a][b] != 'F' && lab[a][b] != 'E' && lab[a][b] != 'X') {
                    lab[a][b] = '!';
                } else {
                    i++;
                }
            }

            System.out.println("5 hamle yaptiginiz icin haritaniz degisti");
            for (int i = 0; i < lab.length; i++) {
                for (int j = 0; j < lab[i].length; j++) {
                    if (i == konum[0] && j == konum[1]) {
                        System.out.print("X ");
                    } else {
                        System.out.print(lab[i][j] + " ");
                    }
                }
                System.out.println();
            }
            hamleSayisi[0] = 0;
        } else {
            for (int i = 0; i < lab.length; i++) {
                for (int j = 0; j < lab[i].length; j++) {
                    if (i == konum[0] && j == konum[1]) {
                        System.out.print("X ");
                    } else {
                        System.out.print(lab[i][j] + " ");
                    }
                }
                System.out.println();
            }
        }
    }

    public static void bonus_mayin_silme(char[][] lab) {
        for (int i = 0; i < lab.length; i++) {
            for (int j = 0; j < lab[i].length; j++) {
                if (lab[i][j] == 'T' || lab[i][j] == 'H' || lab[i][j] == 'R' || lab[i][j] == 'F' || lab[i][j] == '!') {
                    lab[i][j] = '.';
                }
            }
        }
    }

    public static int[] t_sayim(char[][] lab) {
        int[] t_sayisi = {0};
        for (int i = 0; i < lab.length; i++) {
            for (int j = 0; j < lab[i].length; j++) {
                if (lab[i][j] == 'T') {
                    t_sayisi[0]++;
                }
            }
        }
        return t_sayisi;
    }

    public static int[] h_sayim(char[][] lab) {
        int[] h_sayisi = {0};
        for (int i = 0; i < lab.length; i++) {
            for (int j = 0; j < lab[i].length; j++) {
                if (lab[i][j] == 'H') {
                    h_sayisi[0]++;
                }
            }
        }
        return h_sayisi;
    }

    public static int[] r_sayim(char[][] lab) {
        int[] r_sayisi = {0};
        for (int i = 0; i < lab.length; i++) {
            for (int j = 0; j < lab[i].length; j++) {
                if (lab[i][j] == 'R') {
                    r_sayisi[0]++;
                }
            }
        }
        return r_sayisi;
    }

    public static int[] f_sayim(char[][] lab) {
        int[] f_sayisi = {0};
        for (int i = 0; i < lab.length; i++) {
            for (int j = 0; j < lab[i].length; j++) {
                if (lab[i][j] == 'F') {
                    f_sayisi[0]++;
                }
            }
        }
        return f_sayisi;
    }

    public static int[] mayin_sayim(char[][] lab) {
        int[] mayin_sayisi = {0};
        for (int i = 0; i < lab.length; i++) {
            for (int j = 0; j < lab[i].length; j++) {
                if (lab[i][j] == '!') {
                    mayin_sayisi[0]++;
                }
            }
        }
        return mayin_sayisi;
    }

    public static void konum(char[][] labirent, int[] konum, char hareket, String cikis, int[] adimSayisi, int[] T, int[] H, int[] R, int[] F, boolean[] bitis_kontrol, int[] hamleSayisi) {
        boolean kontrol = true;
        while (kontrol) {
            if (cikis.equals("exit")) {
                System.out.println("Cikis yaptınız,oyun sona erdi.");
                break;
            } else if (!cikis.equals("exit") && cikis.length() > 1) {
                System.out.println("Yanlis karakter girdiniz");
                break;
            } else if (cikis.equals("")) {
                System.out.println("Yanlis karakter girdiniz");
                break;
            }
            if (hareket == 'W') {
                if (konum[0] != 0) {
                    konum[0]--;
                    adimSayisi[0]++;
                    hamleSayisi[0]++;
                    break;
                } else {
                    System.out.println("En üst kisimdasiniz,lütfen baska bir yöne gidiniz ");
                }
            } else if (hareket == 'S') {
                if (konum[0] != labirent.length) {
                    konum[0]++;
                    hamleSayisi[0]++;
                    adimSayisi[0]++;
                } else {
                    System.out.println("En alt kisimdasiniz,lütfen baska bir yöne gidiniz ");
                }
            } else if (hareket == 'A') {
                if (konum[1] != 0) {
                    konum[1]--;
                    hamleSayisi[0]++;
                    adimSayisi[0]++;
                } else {
                    System.out.println("En sol kisimdasiniz,lütfen baska bir yöne gidiniz ");
                }
            } else if (hareket == 'D') {
                if (konum[1] < labirent[0].length - 1) {
                    adimSayisi[0]++;
                    konum[1]++;
                    hamleSayisi[0]++;
                } else if (konum[1] == labirent[0].length - 1) {
                    System.out.println("En sag kisimdasiniz,lütfen baska bir yöne gidiniz ");
                }
            } else if (hareket == '+') {
                System.out.println("Lutfen kullanmak istediginiz bonusu seciniz (T, H, R, F)");
                bonus(labirent, konum, adimSayisi, T, H, R, F, bitis_kontrol);
                break;
            } else {
                System.out.println("Lutfen Gecerli bir karakter giriniz");
                break;
            }
            kontrol = false;
        }
    }

    public static void koordinat(char[][] labirent, int[] konum, int[] T, int[] H, int[] R, int[] F, char a, int[] adim, boolean[] kontrol) {
        if (labirent[konum[0]][konum[1]] == 'T') {
            labirent[konum[0]][konum[1]] = '.';
            System.out.print("T bonusu aldınız ");
            System.out.println("ve yeni konumunuz (" + konum[0] + "," + konum[1] + ")");
            T[0]++;
        } else if (labirent[konum[0]][konum[1]] == 'H') {
            labirent[konum[0]][konum[1]] = '.';
            System.out.print("H bonusu aldınız ");
            System.out.println("ve yeni konumunuz (" + konum[0] + "," + konum[1] + ")");
            H[0]++;
        } else if (labirent[konum[0]][konum[1]] == 'R') {
            labirent[konum[0]][konum[1]] = '.';
            System.out.print("R bonusu aldınız ");
            System.out.println("ve yeni konumunuz (" + konum[0] + "," + konum[1] + ")");
            R[0]++;
        } else if (labirent[konum[0]][konum[1]] == 'F') {
            labirent[konum[0]][konum[1]] = '.';
            System.out.print("F bonusu aldınız ");
            System.out.println("ve yeni konumunuz (" + konum[0] + "," + konum[1] + ")");
            F[0]++;
        } else if (labirent[konum[0]][konum[1]] == '.') {
            System.out.println("Yeni konumunuz (" + konum[0] + "," + konum[1] + ")");
        } else if (labirent[konum[0]][konum[1]] == '#') {
            System.out.println("Duvara Geldiniz");
            r_bonusu(labirent, konum, R, T, H, F, a);
        } else if (labirent[konum[0]][konum[1]] == '!') {
            System.out.println("Mayına Geldiniz");
            f_bonusu(labirent, konum, F, R, T, H, a, adim);
        } else if (labirent[konum[0]][konum[1]] == 'E') {
            System.out.println("Tebrikler");
            kontrol[0] = false;
        }
    }

    public static void bonus(char[][] labirent, int[] konum, int[] adim, int[] T, int[] H, int[] R, int[] F, boolean[] bitis_kontrol) {
        boolean kontrol = true;
        Scanner input = new Scanner(System.in);
        while (kontrol) {
            String hangi_bonus = input.nextLine();
            if (hangi_bonus.length() != 1) {
                System.out.println("Lütfen T,H,R,F şeklinde karakter giriniz");
            } else {
                if (hangi_bonus.equals("T") && T[0] != 0) {
                    t_bonusu(labirent, konum, T, bitis_kontrol);
                    break;
                } else if (hangi_bonus.equals("T") && T[0] == 0) {
                    System.out.println("T bonusunuz bulunmamaktadır");
                    break;
                }
                if (hangi_bonus.equals("H") && H[0] != 0) {
                    h_bonusu(labirent, adim, H);
                    break;
                } else if (hangi_bonus.equals("H") && H[0] == 0) {
                    System.out.println("H bonusunuz bulunmamaktadır");
                    break;
                } else {
                    System.out.println("Lütfen T,H,R,F şeklinde karakter giriniz ");
                }
            }
        }
    }

    public static void t_bonusu(char[][] labirent, int konum[], int[] T, boolean[] bitis_kontrol) {
        Scanner input = new Scanner(System.in);
        boolean kontrol = true;
        while (kontrol) {
            System.out.println("Gitmek istediginiz Y koordinatını giriniz");
            int a1 = input.nextInt();
            System.out.println("Gitmek istediginiz X koordinatını giriniz");
            int b1 = input.nextInt();
            if (a1 < 0 || b1 < 0 || a1 >= labirent.length || b1 >= labirent[0].length) {
                System.out.println("Lütfen geçerli x ve y değerleri giriniz");
            }
            if (a1 >= 0 && a1 < labirent.length && b1 >= 0 && b1 < labirent[0].length) {
                if (a1 == konum[3] && b1 == konum[4]) {
                    System.out.println("Cikisa isinlandiniz ve oyunu kazandiniz,tebrikler");
                    bitis_kontrol[0] = false;
                } else {
                    if (labirent[a1][b1] == '!' || labirent[a1][b1] == '#') {
                        System.out.println("Duvar ya da mayina isinlanamazsiniz.Tekrar x ve y degerlerini giriniz");
                    } else {
                        konum[0] = a1;
                        konum[1] = b1;
                        T[0]--;
                        break;
                    }
                }
            }
        }
    }

    public static void h_bonusu(char[][] labirent, int[] adim, int[] H) {
        if (adim[0] >= 2) {
            adim[0] -= 2;
            System.out.println("Yeni Adim sayiniz " + adim[0]);
            H[0]--;
        } else {
            System.out.println("Adim sayiniz 2 den büyük olmali");
            adim[0]--;
        }
    }

    public static void r_bonusu(char[][] labirent, int[] konum, int[] R, int[] T, int[] H, int[] F, char a) {
        boolean kont = true, kont2 = true;
        Scanner input = new Scanner(System.in);
        switch (a) {
            case 'W':
                konum[0]++;
                break;
            case 'S':
                konum[0]--;
                break;
            case 'A':
                konum[1]++;
                break;
            case 'D':
                konum[1]--;
                break;
        }
        while (kont) {
            System.out.println("Bonus dizinizi gormek icin + tusuna basiniz.Bonus kullanmak istemiyorsaniz - tusuna basiniz.");
            String karar = input.nextLine();
            if (karar.equals("-")) {
                System.out.println("R bonusunu kullanamdiniz ve konumunuz (" + konum[0] + "," + konum[1] + ")");
                break;
            } else if (karar.equals("+")) {
                System.out.println("T bonusu: " + T[0]);
                System.out.println("H bonusu: " + H[0]);
                System.out.println("R bonusu: " + R[0]);
                System.out.println("F bonusu: " + F[0]);
                System.out.println("Kullanmak için R, çıkmak için - ye basınız");
                while (kont2) {
                    String karar2 = input.nextLine();
                    if (karar2.equals("-")) {
                        System.out.println("R bonusunu kullanamdiniz ve konumunuz (" + konum[0] + "," + konum[1] + ")");
                        break;
                    } else if (karar2.equals("R")) {
                        if (R[0] == 0) {
                            System.out.println("R bonusunuz bulunmamaktadır ve konumunuz (" + konum[0] + "," + konum[1] + ")");
                            break;
                        } else {
                            switch (a) {
                                case 'W':
                                    konum[0]--;
                                    break;
                                case 'S':
                                    konum[0]++;
                                    break;
                                case 'A':
                                    konum[1]--;
                                    break;
                                case 'D':
                                    konum[1]++;
                                    break;
                            }
                            System.out.println("Duvar engeli kaldırıldı ve konumunuz (" + konum[0] + "," + konum[1] + ")");
                            break;
                        }
                    } else {
                        System.out.println("Tekrar girdi giriniz");

                    }
                    kont = false;
                }
            } else {
                System.out.println("Tekrar girdi giriniz");
            }
        }
    }

    public static void f_bonusu(char[][] labirent, int[] konum, int[] F, int[] R, int[] T, int[] H, char a, int[] adim) {
        boolean kont = true, kont2 = true;
        Scanner input = new Scanner(System.in);
        labirent[konum[0]][konum[1]] = '.';
        switch (a) {
            case 'W':
                konum[0]++;
                break;
            case 'S':
                konum[0]--;
                break;
            case 'A':
                konum[1]++;
                break;
            case 'D':
                konum[1]--;
                break;
        }
        while (kont) {
            System.out.println("Bonus dizinizi gormek icin + tusuna basiniz.Bonus kullanmak istemiyorsaniz - tusuna basiniz.");
            String karar = input.nextLine();
            if (karar.equals("-")) {
                System.out.println("F bonusu kullanmadiginiz icin mayin patladi ve adim sayiniz 5 artti.");
                adim[0] += 5;
                System.out.println("Konumunuz (" + konum[0] + "," + konum[1] + ")");
                break;
            } else if (karar.equals("+")) {
                System.out.println("T bonusu: " + T[0]);
                System.out.println("H bonusu: " + H[0]);
                System.out.println("R bonusu: " + R[0]);
                System.out.println("F bonusu: " + F[0]);
                System.out.println("Kullanmak için F, çıkmak için - ye basınız");
                karar = input.nextLine();
                while (kont2) {
                    if (karar.equals("-")) {
                        System.out.println("F bonusu kullanmadiginiz icin mayin patladi ve adim sayiniz 5 artti.");
                        adim[0] += 5;
                        System.out.println("Konumunuz (" + konum[0] + "," + konum[1] + ")");
                        break;
                    } else if (karar.equals("F")) {
                        if (F[0] == 0) {
                            System.out.println("F bonusu bulunmadigi icin mayin patladi ve adim sayiniz 5 artti.");
                            adim[0] += 5;
                            System.out.println("Konumunuz (" + konum[0] + "," + konum[1] + ")");
                            break;
                        } else {
                            System.out.print("F bonusunu kullandiniz, mayin tehlikesi kaldirildi");
                            switch (a) {
                                case 'W':
                                    konum[0]--;
                                    break;
                                case 'S':
                                    konum[0]++;
                                    break;
                                case 'A':
                                    konum[1]--;
                                    break;
                                case 'D':
                                    konum[1]++;
                                    break;
                            }
                            System.out.println(" ve konumunuz (" + konum[0] + "," + konum[1] + ")");
                            System.out.println();
                            F[0]--;
                            break;
                        }
                    } else {
                        System.out.println("Lütfen F ya da - giriniz");
                        karar = input.nextLine();
                    }
                }
                kont = false;
            } else {
                System.out.println("Yanlış girdi girdiniz,Tekrar girdi giriniz");
            }

        }
    }
}
