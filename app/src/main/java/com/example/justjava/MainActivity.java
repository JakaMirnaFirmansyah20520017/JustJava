package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
int quantity = 0;
EditText namaEditText;
String nama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void increment(View view) {
        quantity = quantity + 1;
        display(quantity);
    }
    public void decrement (View view) {
        if (quantity > 0) {
            quantity = quantity - 1;
            display(quantity);
        }
    }
    public void submitOrder(View view) {
        CheckBox wiphedCreamCheckbox = (CheckBox) findViewById(R.id.whipped_checkbox);
        CheckBox chocoCheckbox  = (CheckBox) findViewById(R.id.chocolate_checkbox);
        namaEditText = (EditText) findViewById(R.id.name_field);

        boolean hasWiphedCream = wiphedCreamCheckbox.isChecked();
        boolean hasChocolate    = chocoCheckbox.isChecked();
        nama = namaEditText.getText().toString();

        int price = calculatePrice(hasWiphedCream, hasChocolate);

        String priceMessage = "Jumlah pembelian " + quantity + "cangkir" +
                "\nWhipped Cream: " + hasWiphedCream +
                "\nChocolate: " + hasChocolate +
                "\nTotal Pembelian Rp " + price +
                "\nSuwun bro " + nama;
        displayMessage(priceMessage);
    }

    private int calculatePrice(boolean addWiphedCream, boolean addChocolate) {
        int basePrice = 5000;
        int price = 0;
        if(addWiphedCream) {
            basePrice = basePrice + 1000;
        }
        if (addChocolate) {
            basePrice = basePrice + 2000;
        }

        return price = quantity * basePrice;
    }

    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

}