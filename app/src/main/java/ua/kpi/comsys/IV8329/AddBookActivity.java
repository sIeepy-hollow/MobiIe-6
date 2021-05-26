package ua.kpi.comsys.IV8329;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class AddBookActivity extends AppCompatActivity {

    ImageButton backButton;
    Button addButton;
    TextInputEditText inputTitle;
    TextInputEditText inputSubtitle;
    TextInputEditText inputISBN;
    TextInputEditText inputPrice;
    TextView errorMsg;
    BooksItem fragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
        backButton = findViewById(R.id.back_btn);
        addButton = findViewById(R.id.addBookAction);
        inputTitle = findViewById(R.id.input_title);
        inputSubtitle = findViewById(R.id.input_subtitle);
        inputISBN = findViewById(R.id.input_isbn);
        inputPrice = findViewById(R.id.input_price);
        errorMsg = findViewById(R.id.errorMsg);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cancelIntent = new Intent();
                setResult(Activity.RESULT_CANCELED, cancelIntent);
                finish();
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                errorMsg.setText("");
                boolean success = true;
                String title = inputTitle.getText().toString();
                String subtitle = inputSubtitle.getText().toString();
                String isbn = inputISBN.getText().toString();
                String price = inputPrice.getText().toString();
                if (title.isEmpty()) {
                    errorMsg.setText(getResources().getString(R.string.noTitle));
                    success = false;
                }
                if (success && !isbn.isEmpty() && isbn.length() != 13) {
                    errorMsg.setText(getResources().getString(R.string.invalidISBN));
                    success = false;
                } else if (success && !isbn.isEmpty()) {
                    try {
                        Long.parseLong(isbn);
                    } catch (Exception e) {
                        errorMsg.setText(getResources().getString(R.string.invalidISBN));
                        success = false;
                    }
                }
                if (success && !price.isEmpty() && (!price.contains(".") || !(price.indexOf(".") == price.length() - 3))) {
                    errorMsg.setText(getResources().getString(R.string.priceNAN));
                    success = false;
                } else if (success && !price.isEmpty()) {
                    try {
                        Double.parseDouble(price);
                        price = "$" + price;
                    } catch (Exception e) {
                        errorMsg.setText(getResources().getString(R.string.priceNAN));
                        success = false;
                    }
                }
                if (success) {
                    Book newBook =  new Book();
                    newBook.setTitle(title);
                    newBook.setSubtitle(subtitle);
                    newBook.setIsbn13(isbn);
                    newBook.setPrice(price);
                    Intent bookIntent =  new Intent();
                    bookIntent.putExtra("book", newBook);
                    setResult(Activity.RESULT_OK, bookIntent);
                    finish();
                }
            }
        });
    }

}
