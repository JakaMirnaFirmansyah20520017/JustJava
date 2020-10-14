package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
int quantity = 0;
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
        quantity = quantity - 1;
        if (quantity < 0) {
            System.out.println("Tidak Boleh Kurang dari Nol!");
        }
        System.out.println("Terima kasih.");
        display(quantity);
    }
    public void submitOrder(View view) {
        int price = quantity * 5000;
        String priceMessage = "Total pembelian Rp. " + price;
        priceMessage = priceMessage + "\nSuwun Luurrr. ";
        displayMessage(priceMessage);
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