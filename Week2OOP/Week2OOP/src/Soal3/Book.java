package Soal3;

public class Book {
    
    private String []title = new String[3];
    private String []writer = new String[3];
    private int []year = new int[3];    
    private int jumlah, biaya, harga, uang, day;

    public void initialize(){
    title[0] = "Bumi";
    title[1] = "Laskar Pelangi";
    title[2] = "Rich Dad, Poor Dad";
    writer[0] = "Tere Liye";
    writer[1] = "Andrea Hirata";
    writer[2] = "Robert Kiyosaki";
    year[0] = 2014;
    year[1] = 2005;
    year[2] = 1997;
    }

    public String getBookTitle(int input){
        return title[input];
    }
    public String getWriter(int input){
        return writer[input];
    }
    public int getPublishedYear(int input){
        return year[input];
    }

    public String setBookTitle(String bookTitle, int input){
        return title[input] = bookTitle;
    }
    public String setWriter(String writer, int input){
        return this.writer[input] = writer;
    }
    public int setPublishedYear(int publishedYear, int input){
        return year[input] = publishedYear;
    }
}
