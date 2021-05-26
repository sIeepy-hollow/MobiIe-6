package ua.kpi.comsys.IV8329;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {

    private String title;
    private String subtitle;
    private String isbn13;
    private String price;
    private String image = null;

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String authors;
    private String publisher;
    private String pages;
    private String year;
    private String rating;
    private String description;



    public Book(String Ntitle, String Nsubtitle, String Nisbn13, String Nprice, String Nimage) {
        this.title = Ntitle;
        this.subtitle = Nsubtitle;
        this.isbn13 = Nisbn13;
        this.price = Nprice;
        if (!Nimage.isEmpty()) {
            this.image = Nimage;
        }
    }

    public Book() { }

    protected Book(Parcel in) {
        title = in.readString();
        subtitle = in.readString();
        isbn13 = in.readString();
        price = in.readString();
        image = in.readString();
        authors = in.readString();
        publisher = in.readString();
        pages = in.readString();
        year = in.readString();
        rating = in.readString();
        description = in.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        if (!image.isEmpty()) {
            this.image = image;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(subtitle);
        dest.writeString(isbn13);
        dest.writeString(price);
        dest.writeString(image);
        dest.writeString(authors);
        dest.writeString(publisher);
        dest.writeString(pages);
        dest.writeString(year);
        dest.writeString(rating);
        dest.writeString(description);
    }
}
